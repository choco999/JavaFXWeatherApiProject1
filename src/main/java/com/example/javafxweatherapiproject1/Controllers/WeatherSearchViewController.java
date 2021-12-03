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
    private Label cityLabel;

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

        if(apiResponse.getWeather() != null)
        {
            String cityName = apiResponse.getName();
            ArrayList<Weather> weather = apiResponse.getWeather();

            setVisibleBySearchResult(true, true);

            cityLabel.setText(cityName + "'s Current Weather");

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
//        try {
//            Image img = new Image(new FileInputStream("C:\\Users\\chisa\\Downloads\\female_avatar.png"));
//            weatherImageView.setImage(img);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

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
    }
}

