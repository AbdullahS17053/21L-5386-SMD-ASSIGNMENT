package com.example.smdassignment2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import java.util.ArrayList;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.annotation.Nullable;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


public class Screen1Activity extends AppCompatActivity {
    private RestaurantDatabase restaurantDatabase;

    private RecyclerView recyclerView;
    private RestaurantAdapter adapter;
    private List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_screen1);


        recyclerView = findViewById(R.id.recyclerView);
        restaurantList = new ArrayList<>();
        adapter = new RestaurantAdapter(restaurantList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void openRegisterPage(View view) {
        Intent intent = new Intent(this, Screen2Activity.class);
        startActivityForResult(intent, 1);
    }

    // Called when data is returned from Screen2
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                // Retrieve restaurant object from Screen2
                Restaurant restaurant = (Restaurant) data.getSerializableExtra("restaurant");
                // Add restaurant to the list and update RecyclerView
                //restaurantList = Dbhandler.getRestaurantDatabase().restaurantDao().getAllRestaurants();

                restaurantList.add(restaurant);
                adapter.notifyDataSetChanged();
            }
        }
    }
}

