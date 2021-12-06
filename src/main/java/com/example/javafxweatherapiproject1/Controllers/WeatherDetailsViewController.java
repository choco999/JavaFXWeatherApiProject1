package com.example.javafxweatherapiproject1.Controllers;

import com.example.javafxweatherapiproject1.APIUtility;
import com.example.javafxweatherapiproject1.Models.Weather;
import com.example.javafxweatherapiproject1.Models.WeatherDetails;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WeatherDetailsViewController implements Initializable {

    @FXML
    private Label cityNameLabel;

    @FXML
    private ImageView weatherImageView;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label tempLabel;

    @FXML
    private Label feelsLikeLabel;

    @FXML
    private Label humidityLabel;

    @FXML
    private Label cloudinessLabel;

    @FXML
    void backToSearch(ActionEvent event) {

    }

    public void loadWeatherDetails(String cityName) throws IOException, InterruptedException {

        WeatherDetails weatherDetail = APIUtility.getWeatherDetails(cityName);

        cityNameLabel.setText(cityName + "'s Weather Details");

        ArrayList<Weather> weather = weatherDetail.getWeather();
        descriptionLabel.setText(weather.get(0).getDescription());

        tempLabel.setText((weatherDetail.getMain().getTemp() - 273.15)+ "°");
        feelsLikeLabel.setText((weatherDetail.getMain().getFeelsLike() - 273.15)+ "°");
        humidityLabel.setText(weatherDetail.getMain().getHumidity() + "%");
        cloudinessLabel.setText(weatherDetail.getClouds().getAll() + "%");

        String icon = weather.get(0).getIcon();
        weatherImageView.setImage(new Image("http://openweathermap.org/img/wn/" + icon + "@2x.png"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadWeatherDetails("Tokyo");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
