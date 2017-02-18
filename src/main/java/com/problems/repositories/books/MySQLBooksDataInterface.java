package com.problems.repositories.books;

import com.problems.model.Book;

import java.sql.*;

public class MySQLBooksDataInterface implements BookDataInterface {

    private String INSERT = "INSERT INTO books VALUES(?,?,?,?,?);";
    private String SELECT = "SELECT * FROM books WHERE ISBN = ?;";
    private String UPDATE = "UPDATE books SET rented = ?, overdue = ? WHERE ISBN = ?;";
    private String DELETE = "DELETE FROM books WHERE ISBN = ?;";

    private PreparedStatement preparedInsert;
    private PreparedStatement preparedSelect;
    private PreparedStatement preparedUpdate;
    private PreparedStatement preparedDelete;

    public MySQLBooksDataInterface() {

    }

    private Connection getDBConnection(){

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3311/library?" +
                    "user=root&password=root");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void createBook(Book book) {

        Connection conn = getDBConnection();

        try {
            preparedInsert = conn.prepareStatement(INSERT);
            preparedInsert.setString(1, book.getISBN());
            preparedInsert.setString(2, book.getTitle());
            preparedInsert.setString(3, book.getAuthor());
            preparedInsert.setBoolean(4, book.getRented());
            preparedInsert.setBoolean(5, book.getOverdue());
            preparedInsert.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, preparedInsert);
        }

    }

    public Book findBookByISBN(String ISBN) {

        Book book = null;
        Connection conn = getDBConnection();

        try {
            preparedSelect = conn.prepareStatement(SELECT);
            preparedSelect.setString(1, ISBN);
            ResultSet resultSet = preparedSelect.executeQuery();
            if(resultSet != null && resultSet.next() !=  false){
                book = new Book();
                book.setISBN(resultSet.getString("ISBN"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setRented(resultSet.getBoolean("rented"));
                book.setOverdue(resultSet.getBoolean("overdue"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, preparedSelect);

            return book;
        }
    }

    private void close(Connection conn, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {

        Connection conn = getDBConnection();
        try {
            preparedUpdate = conn.prepareStatement(UPDATE);
            preparedUpdate.setBoolean(1, book.getRented());
            preparedUpdate.setBoolean(2, book.getOverdue());
            preparedUpdate.setString(3, book.getISBN());

            preparedUpdate.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, preparedUpdate);
        }

    }

    public void deleteBook(String ISBN) {

        Connection conn = getDBConnection();
        try {
            preparedDelete = conn.prepareStatement(DELETE);
            preparedDelete.setString(1, ISBN);
            preparedDelete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, preparedDelete);
        }
    }
}
