package com.library.library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public class BookDAO {
//    private Connection connection;
//
//    public BookDAO() {
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/book_management", "postgres", "admin123");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Book> getAllBooks() {
//        List<Book> books = new ArrayList<>();
//        String query = "SELECT * FROM books";
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//            while (rs.next()) {
//                books.add(new Book(rs.getString("title"), rs.getString("author"), rs.getInt("year"), rs.getString("genre")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return books;
//    }
//
//    public void addBook(Book book) {
//        String query = "INSERT INTO books (title, author, year, genre) VALUES (?, ?, ?, ?)";
//        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setString(1, book.getTitle());
//            pstmt.setString(2, book.getAuthor());
//            pstmt.setInt(3, book.getYear());
//            pstmt.setString(4, book.getGenre());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeBook(Book book) {
//        String query = "DELETE FROM books WHERE title = ? AND author = ? AND year = ? AND genre = ?";
//        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setString(1, book.getTitle());
//            pstmt.setString(2, book.getAuthor());
//            pstmt.setInt(3, book.getYear());
//            pstmt.setString(4, book.getGenre());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Book> searchBooks(String title, String author, int year, String genre) {
//        List<Book> books = new ArrayList<>();
//        StringBuilder query = new StringBuilder("SELECT * FROM books WHERE 1=1");
//
//        if (title != null && !title.isEmpty()) query.append(" AND title ILIKE ?");
//        if (author != null && !author.isEmpty()) query.append(" AND author ILIKE ?");
//        if (year != -1) query.append(" AND year = ?");
//        if (genre != null && !genre.isEmpty()) query.append(" AND genre ILIKE ?");
//
//        try (PreparedStatement pstmt = connection.prepareStatement(query.toString())) {
//            int paramIndex = 1;
//            if (title != null && !title.isEmpty()) pstmt.setString(paramIndex++, "%" + title + "%");
//            if (author != null && !author.isEmpty()) pstmt.setString(paramIndex++, "%" + author + "%");
//            if (year != -1) pstmt.setInt(paramIndex++, year);
//            if (genre != null && !genre.isEmpty()) pstmt.setString(paramIndex++, "%" + genre + "%");
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    books.add(new Book(rs.getString("title"), rs.getString("author"), rs.getInt("year"), rs.getString("genre")));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return books;
//    }
//}

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/book_management", "postgres", "admin123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                books.add(new Book(rs.getString("title"), rs.getString("author"), rs.getInt("year"), rs.getString("genre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void addBook(Book book) {
        String query = "INSERT INTO books (title, author, year, genre) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getYear());
            pstmt.setString(4, book.getGenre());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBook(Book book) {
        String query = "DELETE FROM books WHERE title = ? AND author = ? AND year = ? AND genre = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getYear());
            pstmt.setString(4, book.getGenre());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        String query = "UPDATE books SET title = ?, author = ?, year = ?, genre = ? WHERE title = ? AND author = ? AND year = ? AND genre = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getYear());
            pstmt.setString(4, book.getGenre());
            pstmt.setString(5, book.getTitle());
            pstmt.setString(6, book.getAuthor());
            pstmt.setInt(7, book.getYear());
            pstmt.setString(8, book.getGenre());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> searchBooks(String title, String author, int year, String genre) {
        List<Book> books = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM books WHERE 1=1");

        if (title != null && !title.isEmpty()) query.append(" AND title ILIKE ?");
        if (author != null && !author.isEmpty()) query.append(" AND author ILIKE ?");
        if (year != -1) query.append(" AND year = ?");
        if (genre != null && !genre.isEmpty()) query.append(" AND genre ILIKE ?");

        try (PreparedStatement pstmt = connection.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (title != null && !title.isEmpty()) pstmt.setString(paramIndex++, "%" + title + "%");
            if (author != null && !author.isEmpty()) pstmt.setString(paramIndex++, "%" + author + "%");
            if (year != -1) pstmt.setInt(paramIndex++, year);
            if (genre != null && !genre.isEmpty()) pstmt.setString(paramIndex++, "%" + genre + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    books.add(new Book(rs.getString("title"), rs.getString("author"), rs.getInt("year"), rs.getString("genre")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
