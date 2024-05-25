module com.library.library {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.library.library to javafx.fxml;
    exports com.library.library;
}