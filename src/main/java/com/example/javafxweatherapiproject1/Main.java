package com.example.javafxweatherapiproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("weather-search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Search Current Weather");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

//import java.io.IOException;
//
//public class Main {
//    public static void main(String[] args) {
//        ApiResponse result = null;
//        try {
//            result = APIUtility.getWeatherFromOpenWeatherAPI("Tokyo");
//            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}