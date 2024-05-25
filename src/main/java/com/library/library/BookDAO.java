package com.library.library;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private List<Book> books;

    public BookDAO() {
        books = new ArrayList<>();
        // Dodaj przykładowe książki
        books.add(new Book("Tytuł1", "Autor1", 2000, "Gatunek1"));
        books.add(new Book("Tytuł2", "Autor2", 2001, "Gatunek2"));
        // Dodaj więcej książek aż do 25
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchBooks(String title, String author, int year, String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            boolean matches = true;
            if (title != null && !book.getTitle().toLowerCase().contains(title.toLowerCase())) matches = false;
            if (author != null && !book.getAuthor().toLowerCase().contains(author.toLowerCase())) matches = false;
            if (year != -1 && book.getYear() != year) matches = false;
            if (genre != null && !book.getGenre().toLowerCase().contains(genre.toLowerCase())) matches = false;
            if (matches) result.add(book);
        }
        return result;
    }
}

