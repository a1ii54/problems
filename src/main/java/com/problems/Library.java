package com.problems;

import com.problems.model.Book;
import com.problems.repositories.books.MySQLBooksDataInterface;

import java.util.UUID;

public class Library {

    public static void main(String[] args) {
        MySQLBooksDataInterface mySQLBooksDataInterface = new MySQLBooksDataInterface();

        String title = "My First Book";
        String author = "Me";
        String isbn = UUID.randomUUID().toString();
        Book book = new Book(isbn, title, author, false, false);
        mySQLBooksDataInterface.createBook(book);

        Book book2 = mySQLBooksDataInterface.findBookByISBN(isbn);
        System.out.println(book2);
        System.out.println("Book == book2 -> " + book.equals(book2));

        String title1 = "My Second Book";
        String isbn1 = UUID.randomUUID().toString();
        Book book3 = new Book(isbn1, title1, author, true, false);
        mySQLBooksDataInterface.createBook(book3);

        book2.setRented(true);
        mySQLBooksDataInterface.updateBook(book2);

        Book book4 = mySQLBooksDataInterface.findBookByISBN(isbn);
        System.out.println(book4);
        System.out.println("Book == book4 -> " + book2.equals(book4));

        mySQLBooksDataInterface.deleteBook(isbn1);

        Book book5 = mySQLBooksDataInterface.findBookByISBN(isbn1);
        System.out.println(book5);
        System.out.println("Book == book5 -> " + book2.equals(book5));
    }

}
