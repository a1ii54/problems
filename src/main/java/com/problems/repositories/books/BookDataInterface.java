package com.problems.repositories.books;


import com.problems.model.Book;

import java.sql.SQLException;

public interface BookDataInterface {

    public void createBook(Book book);

    public Book findBookByISBN(String ISBN);

    public void updateBook(Book book);

    public void deleteBook(String ISBN);
}
