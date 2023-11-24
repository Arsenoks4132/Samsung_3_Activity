package com.example.intent1811;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent1811.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        Bundle past_name = getIntent().getExtras();

        String name = "none";

        try {
            name = past_name.getString("name");
        } catch (Exception e) {}

        binding.actB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "From activity A to B", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", "A");
                startActivity(intent);
            }
        });
        binding.actC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "From activity A to C ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("name", "A");
                startActivity(intent);
            }
        });
        String finalName = name;
        binding.Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalName != "none") {
                    Toast.makeText(MainActivity.this, "Back from A to " + finalName, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Back to Desctop", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}