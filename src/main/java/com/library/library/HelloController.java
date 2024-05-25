package com.library.library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

//public class HelloController {
//    @FXML
//    private TextField titleField;
//    @FXML
//    private TextField authorField;
//    @FXML
//    private TextField yearField;
//    @FXML
//    private TextField genreField;
//    @FXML
//    private TextField searchTitleField;
//    @FXML
//    private TextField searchAuthorField;
//    @FXML
//    private TextField searchYearField;
//    @FXML
//    private TextField searchGenreField;
//    @FXML
//    private TableView<Book> bookTableView;
//    @FXML
//    private TableColumn<Book, String> titleColumn;
//    @FXML
//    private TableColumn<Book, String> authorColumn;
//    @FXML
//    private TableColumn<Book, Integer> yearColumn;
//    @FXML
//    private TableColumn<Book, String> genreColumn;
//
//    private BookDAO bookDAO;
//    private ObservableList<Book> bookList;
//
//    @FXML
//    public void initialize() {
//        bookDAO = new BookDAO();
//        bookList = FXCollections.observableArrayList(bookDAO.getAllBooks());
//
//        // Ustawianie kolumn tabeli
//        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
//        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
//        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
//        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
//
//        bookTableView.setItems(bookList);
//    }
//
//    @FXML
//    private void addBook() {
//        String title = titleField.getText();
//        String author = authorField.getText();
//        int year = Integer.parseInt(yearField.getText());
//        String genre = genreField.getText();
//
//        Book newBook = new Book(title, author, year, genre);
//        bookDAO.addBook(newBook);
//        bookList.add(newBook);
//
//        clearFields();
//    }
//
//    @FXML
//    private void removeBook() {
//        Book selectedBook = bookTableView.getSelectionModel().getSelectedItem();
//        if (selectedBook != null) {
//            bookDAO.removeBook(selectedBook);
//            bookList.remove(selectedBook);
//        }
//    }
//
//    @FXML
//    private void searchBooks() {
//        String title = searchTitleField.getText();
//        String author = searchAuthorField.getText();
//        int year = searchYearField.getText().isEmpty() ? -1 : Integer.parseInt(searchYearField.getText());
//        String genre = searchGenreField.getText();
//
//        bookList.setAll(bookDAO.searchBooks(title, author, year, genre));
//    }
//
//    @FXML
//    private void clearFields() {
//        titleField.clear();
//        authorField.clear();
//        yearField.clear();
//        genreField.clear();
//    }
//}

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField searchTitleField;
    @FXML
    private TextField searchAuthorField;
    @FXML
    private TextField searchYearField;
    @FXML
    private TextField searchGenreField;
    @FXML
    private Button addButton;
    @FXML
    private Button saveButton;
    @FXML
    private TableView<Book> bookTableView;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, Integer> yearColumn;
    @FXML
    private TableColumn<Book, String> genreColumn;

    private BookDAO bookDAO;
    private ObservableList<Book> bookList;
    private Book selectedBook;

    @FXML
    public void initialize() {
        bookDAO = new BookDAO();
        bookList = FXCollections.observableArrayList(bookDAO.getAllBooks());

        // Ustawianie kolumn tabeli
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        bookTableView.setItems(bookList);
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
        Book selectedBook = bookTableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            bookDAO.removeBook(selectedBook);
            bookList.remove(selectedBook);
        }
    }

    @FXML
    private void editBook() {
        selectedBook = bookTableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            titleField.setText(selectedBook.getTitle());
            authorField.setText(selectedBook.getAuthor());
            yearField.setText(String.valueOf(selectedBook.getYear()));
            genreField.setText(selectedBook.getGenre());

            addButton.setVisible(false);
            saveButton.setVisible(true);
        }
    }

    @FXML
    private void updateBook() {
        if (selectedBook != null) {
            String newTitle = titleField.getText();
            String newAuthor = authorField.getText();
            int newYear = Integer.parseInt(yearField.getText());
            String newGenre = genreField.getText();

            selectedBook.setTitle(newTitle);
            selectedBook.setAuthor(newAuthor);
            selectedBook.setYear(newYear);
            selectedBook.setGenre(newGenre);

            bookDAO.updateBook(selectedBook);

            bookTableView.refresh();
            clearFields();
            addButton.setVisible(true);
            saveButton.setVisible(false);
        }
    }

    @FXML
    private void searchBooks() {
        String title = searchTitleField.getText();
        String author = searchAuthorField.getText();
        int year = searchYearField.getText().isEmpty() ? -1 : Integer.parseInt(searchYearField.getText());
        String genre = searchGenreField.getText();

        bookList.setAll(bookDAO.searchBooks(title, author, year, genre));
    }

    @FXML
    private void clearFields() {
        titleField.clear();
        authorField.clear();
        yearField.clear();
        genreField.clear();
        selectedBook = null;
    }
}
