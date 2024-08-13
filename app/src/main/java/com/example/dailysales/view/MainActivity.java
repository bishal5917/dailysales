package com.example.dailysales.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.dailysales.databinding.ActivityMainBinding;
import com.example.dailysales.utils.DateUtil;

import java.util.Date;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
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
        binding.tvMonthInfo.setText("Month of " + DateUtil.getMonth());
        binding.tvGreeting.setText(DateUtil.getGreetingMessage());
        gotoAddSalesScreen();
    }

    public void gotoAddSalesScreen() {
        binding.btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddSaleActivity.class);
            startActivity(intent);
        });
    }
}
