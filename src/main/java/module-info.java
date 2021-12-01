module com.example.javafxweatherapiproject1 {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires  java.net.http;


    opens com.example.javafxweatherapiproject1 to javafx.fxml, com.google.gson;
    exports com.example.javafxweatherapiproject1;
    exports com.example.javafxweatherapiproject1.Models;
    opens com.example.javafxweatherapiproject1.Models;

    exports com.example.javafxweatherapiproject1.Controllers;
    opens com.example.javafxweatherapiproject1.Controllers to com.google.gson, javafx.fxml;
}