package com.example.intent1811;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent1811.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        Bundle past_name = getIntent().getExtras();

        binding.actA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ThirdActivity.this, "From activity C to A", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                intent.putExtra("name", "C");
                startActivity(intent);
            }
        });
        binding.actB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ThirdActivity.this, "From activity C to B", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                intent.putExtra("name", "C");
                startActivity(intent);
            }
        });
        binding.Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Back from C to " + past_name.getString("name"), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            Toast.makeText(this, "Back from " + name + " to C", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}