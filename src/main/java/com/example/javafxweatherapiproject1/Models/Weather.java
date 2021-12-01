package com.example.javafxweatherapiproject1.Models;

public class Weather {
//    id	804
//    main	"Clouds"
//    description	"overcast clouds"
//    icon	"04n"

    private int id;

    private String main;

    private String description;

    private String icon;

    public Weather(int id, String main, String description, String icon) {
        setId(id);
        setMain(main);
        setDescription(description);
        setIcon(icon);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
