package com.example.intent1811;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.intent1811.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        String str = getIntent().getStringExtra(MainActivity.KEY);

        binding.txt.setText(str);
    }
}