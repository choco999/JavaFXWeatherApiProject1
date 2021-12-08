package com.example.javafxweatherapiproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("weather-search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Search Current Weather");
        stage.setScene(scene);
        //stage.getIcons().add(new Image("https://pics.freeicons.io/uploads/icons/png/9607814611548329941-512.png"));
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/weather_icon.png"))));
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