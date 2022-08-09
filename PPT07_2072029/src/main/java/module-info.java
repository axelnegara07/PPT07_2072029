module com.example.ppt07_2072029 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ppt07_2072029 to javafx.fxml;
    exports com.example.ppt07_2072029;
    exports com.example.ppt07_2072029.controller;
    opens com.example.ppt07_2072029.controller to javafx.fxml;
}