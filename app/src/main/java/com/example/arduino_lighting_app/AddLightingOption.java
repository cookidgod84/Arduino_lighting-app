package com.example.arduino_lighting_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddLightingOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lighting_option);

        ImageButton view_lighting_options = findViewById(R.id.cancel_button);

        view_lighting_options.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent addlightingoption = new Intent(AddLightingOption.this,HomeScreen.class);
                        startActivity(addlightingoption);
                    }
                });

    }
}