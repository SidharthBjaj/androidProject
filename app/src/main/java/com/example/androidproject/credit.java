package com.example.androidproject;

public class credit {
    private  String name;
    private String defination;
    private int image;

    public credit(String name, String defination, int image) {
        this.name = name;
        this.defination = defination;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefination() {
        return defination;
    }

    public void setDefination(String defination) {
        this.defination = defination;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

