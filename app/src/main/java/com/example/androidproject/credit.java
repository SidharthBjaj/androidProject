package com.example.androidproject;

public class credit {
    private  String name;
    private String defination;


    public credit(String name, String defination) {
        this.name = name;
        this.defination = defination;

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

    @Override
    public String toString() {
        return this.name;
    }
}

