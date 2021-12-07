package com.example.javafxweatherapiproject1;

import com.example.javafxweatherapiproject1.Controllers.WeatherDetailsViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    public static void changeScenes(ActionEvent event, String fxmlFile, String cityName) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        WeatherDetailsViewController controller = fxmlLoader.getController();
        controller.loadWeatherDetails(cityName);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
