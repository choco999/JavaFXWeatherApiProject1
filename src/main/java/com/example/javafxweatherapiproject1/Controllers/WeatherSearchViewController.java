package com.example.javafxweatherapiproject1.Controllers;

import com.example.javafxweatherapiproject1.APIUtility;
import com.example.javafxweatherapiproject1.ApiResponse;
import com.example.javafxweatherapiproject1.Models.Weather;
import com.example.javafxweatherapiproject1.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Label cityLabel;

    @FXML
    private Label currentWeatherLabel;

    @FXML
    private Label weatherLabel;

    @FXML
    private ImageView weatherImageView;

    @FXML
    private Button checkDetailsButton;

    @FXML
    void getSearchResults(ActionEvent event) throws IOException, InterruptedException {
        // get the city name user typed
        ApiResponse apiResponse = APIUtility.getWeatherFromOpenWeatherAPI(cityNameSearchTextField.getText());

        if(apiResponse.getWeather() != null)
        {
            String cityName = apiResponse.getName();
            ArrayList<Weather> weather = apiResponse.getWeather();

            setVisibleBySearchResult(true, true);

            cityLabel.setText(cityName);

            weatherLabel.setText(weather.get(0).getMain());

            String icon = weather.get(0).getIcon();
            weatherImageView.setImage(new Image("http://openweathermap.org/img/wn/" + icon + "@2x.png"));
        }
        else
        {
            setVisibleBySearchResult(true, false);
            cityLabel.setText("Invalid City Name");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setVisibleBySearchResult(false, false);
    }

    /**
     * This method will turn cityLabel, weatherLabel, and weatherImageView
     * to be visible or non-visible depending on the state of searching
     */
    private void setVisibleBySearchResult(boolean cityFound, boolean weatherDisplayed)
    {
        cityLabel.setVisible(cityFound);
        weatherLabel.setVisible(weatherDisplayed);
        weatherImageView.setVisible(weatherDisplayed);
        checkDetailsButton.setVisible(weatherDisplayed);
    }

    @FXML
    void checkWeatherDetails(ActionEvent event) throws IOException, InterruptedException {
        //String cityName = cityLabel.getText();
        String cityName = cityLabel.getText();
        System.out.println(cityName);
        SceneChanger.changeScenes(event, "weather-details-view.fxml", cityName);
    }
}

