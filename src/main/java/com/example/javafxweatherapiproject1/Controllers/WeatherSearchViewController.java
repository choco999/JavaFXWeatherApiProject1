package com.example.javafxweatherapiproject1.Controllers;

import com.example.javafxweatherapiproject1.APIUtility;
import com.example.javafxweatherapiproject1.ApiResponse;
import com.example.javafxweatherapiproject1.Models.Weather;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WeatherSearchViewController implements Initializable {

    @FXML
    private TextField cityNameSearchTextField;

    @FXML
    private Label weatherLabel;

    @FXML
    private ImageView weatherImageView;

    @FXML
    void checkDetailsButton(ActionEvent event) {

    }

    @FXML
    void getSearchResults(ActionEvent event) throws IOException, InterruptedException {
        // get the city name user typed
        ApiResponse apiResponse = APIUtility.getWeatherFromOpenWeatherAPI(cityNameSearchTextField.getText());


        if(apiResponse != null)
        {
            String cityName = apiResponse.getName();
            ArrayList<Weather> weather = apiResponse.getWeather();

            weatherLabel.setText(cityName + "'s Current Weather: ");


            String icon = weather.get(0).getIcon();

            weatherImageView.setImage(new Image("http://openweathermap.org/img/wn/" + icon + "@2x.png"));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            Image img = new Image(new FileInputStream("C:\\Users\\chisa\\Downloads\\female_avatar.png"));
//            weatherImageView.setImage(img);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}

