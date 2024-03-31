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

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText locationEditText;
    private EditText phoneEditText;
    private EditText descriptionEditText;
    private SeekBar ratingSeekBar;
    private TextView ratingLabel;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        locationEditText = findViewById(R.id.locationEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        ratingSeekBar = findViewById(R.id.ratingSeekBar);
        ratingLabel = findViewById(R.id.ratingLabel);
        registerButton = findViewById(R.id.registerButton);

        // Set listener for ratingSeekBar to update ratingLabel
        ratingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ratingLabel.setText("Rating: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Set listener for registerButton to handle registration
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerRestaurant();
            }
        });
    }

    private void registerRestaurant() {
        // Get input values
        String name = nameEditText.getText().toString().trim();
        String location = locationEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        int rating = ratingSeekBar.getProgress();

        // Validate input
        if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create new Restaurant object
        Restaurant restaurant = new Restaurant(name, location, phone, description, rating);
        Dbhandler.getRestaurantDatabase().restaurantDao().insert(restaurant);
        // Pass the restaurant object back to Screen1Activity
        Intent resultIntent = new Intent();
        resultIntent.putExtra("restaurant", restaurant);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
