package com.example.smdassignment2;
import java.io.Serializable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;



    @Entity(tableName = "restaurants")
public class Restaurant implements Serializable {
        @PrimaryKey(autoGenerate = true)
        private String name;
    private String location;
    private String phone;
    private String description;
    private int rating;

    public Restaurant(String name, String location, String phone, String description, int rating) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.description = description;
        this.rating = rating;
    }
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
    // Constructor, getters, and setters
}
