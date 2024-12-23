package com.example.midterm;
import java.io.Serializable;

public class Pizza implements Serializable {
    private String name;
    private int imageResourceId;

    public Pizza(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

