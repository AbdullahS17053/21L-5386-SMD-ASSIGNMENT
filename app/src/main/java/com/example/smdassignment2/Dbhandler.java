package com.example.smdassignment2;

import android.app.Application;

import androidx.room.Room;

public class Dbhandler extends Application {
    private static RestaurantDatabase restaurantDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        restaurantDatabase = Room.databaseBuilder(getApplicationContext(),
                RestaurantDatabase.class, "restaurant-db").build();
    }

    public static RestaurantDatabase getRestaurantDatabase() {
        return restaurantDatabase;
    }
}
