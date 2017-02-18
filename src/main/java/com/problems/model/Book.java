package com.problems.model;


public class Book {

    private String ISBN;
    private String title;
    private String author;
    private Boolean rented;
    private Boolean overdue;

    public Book(String ISBN, String title, String author, Boolean rented, Boolean overdue) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.rented = rented;
        this.overdue = overdue;
    }

    public Book() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public Boolean getOverdue() {
        return overdue;
    }

    public void setOverdue(Boolean overdue) {
        this.overdue = overdue;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rented=" + rented +
                ", overdue=" + overdue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!ISBN.equals(book.ISBN)) return false;
        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        if (!rented.equals(book.rented)) return false;
        return overdue.equals(book.overdue);
    }

    @Override
    public int hashCode() {
        int result = ISBN.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + rented.hashCode();
        result = 31 * result + overdue.hashCode();
        return result;
    }
}
