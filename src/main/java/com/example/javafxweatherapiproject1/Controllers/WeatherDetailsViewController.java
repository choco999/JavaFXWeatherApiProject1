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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            loadWeatherDetails("1850144");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void loadWeatherDetails(String cityName) throws IOException, InterruptedException {

        WeatherDetails weatherDetail = null;

        weatherDetail = APIUtility.getWeatherDetails(cityName);

        //cityNameLabel.setText(cityName + "'s Weather Details");
        cityNameLabel.setText(weatherDetail.getName() + "'s Weather Details");

        // create weather
        ArrayList<Weather> weather = weatherDetail.getWeather();

        // description
        String description = weather.get(0).getDescription();
        //System.out.println(description);
        descriptionLabel.setText(description);

        // temp
        float temp = weatherDetail.getMain().getTemp();
        //System.out.println(temp);
        tempLabel.setText((temp - 273.15)+ "°");

        // feels like
        float feelsLike = weatherDetail.getMain().getFeelsLike();
        //System.out.println(feelsLike);
        feelsLikeLabel.setText((feelsLike - 273.15)+ "°");

        // humidity
        int humidity = weatherDetail.getMain().getHumidity();
        humidityLabel.setText(humidity + "%");

        // cloudiness
        int cloudiness = weatherDetail.getClouds().getAll();
        cloudinessLabel.setText(cloudiness + "%");

        // icon
        String icon = weather.get(0).getIcon();
        weatherImageView.setImage(new Image("http://openweathermap.org/img/wn/" + icon + "@2x.png"));
    }

    @FXML
    void backToSearch(ActionEvent event) {

    }
}
