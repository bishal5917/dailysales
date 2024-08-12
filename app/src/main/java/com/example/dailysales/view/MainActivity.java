package com.example.dailysales.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.dailysales.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using Data Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set the toolbar
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Daily Sales");
        }
        gotoAddSalesScreen();
    }

    public void gotoAddSalesScreen(){
        binding.btnAdd.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, AddSaleActivity.class);
            startActivity(intent);
        });
    }
}
