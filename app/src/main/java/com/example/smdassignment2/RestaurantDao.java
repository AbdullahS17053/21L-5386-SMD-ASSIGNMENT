package com.example.smdassignment2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RestaurantDao {
    @Insert
    void insert(Restaurant restaurant);

    @Query("SELECT * FROM restaurants")
    List<Restaurant> getAllRestaurants();
}

