package com.example.javafxweatherapiproject1;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {
    /**
     *  this method will read the 'jsonData1' file and
     *  create an ApiResponse object
     */
    public static ApiResponse getWeatherJsonFile()
    {
        //create a GSON object
        Gson gson = new Gson();
        ApiResponse response = null;

        try(
                FileReader fileReader = new FileReader("jsonData1");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            response = gson.fromJson(jsonReader, ApiResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * This method will call Open Weather API with the search term
     */
    public static ApiResponse getWeatherFromOpenWeatherAPI(String searchCityName) throws IOException, InterruptedException {
        searchCityName = searchCityName.trim().replace(" ", "%20");

        String uri = "https://api.openweathermap.org/data/2.5/weather?q=" + searchCityName + "&appid=6018d9fad9dc01a56c0b6fb4386c2073";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(httpRequest, HttpResponse
                .BodyHandlers
                .ofFile(Paths.get("jsonData1")));

        return getWeatherJsonFile();
    }
}
