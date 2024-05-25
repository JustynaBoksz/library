package com.library.library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class HelloController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField genreField;
    @FXML
    private ListView<Book> bookListView;

    private BookDAO bookDAO;
    private ObservableList<Book> bookList;

    @FXML
    public void initialize() {
        bookDAO = new BookDAO();
        bookList = FXCollections.observableArrayList(bookDAO.getAllBooks());
        bookListView.setItems(bookList);
    }

    @FXML
    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        int year = Integer.parseInt(yearField.getText());
        String genre = genreField.getText();

        Book newBook = new Book(title, author, year, genre);
        bookDAO.addBook(newBook);
        bookList.add(newBook);

        clearFields();
    }

    @FXML
    private void removeBook() {
        Book selectedBook = bookListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            bookDAO.removeBook(selectedBook);
            bookList.remove(selectedBook);
        }
    }

    @FXML
    private void searchBooks() {
        String title = titleField.getText();
        String author = authorField.getText();
        int year = yearField.getText().isEmpty() ? -1 : Integer.parseInt(yearField.getText());
        String genre = genreField.getText();

        List<Book> result = bookDAO.searchBooks(title, author, year, genre);
        bookList.setAll(result);
    }

    @FXML
    private void clearFields() {
        titleField.clear();
        authorField.clear();
        yearField.clear();
        genreField.clear();
    }
}
