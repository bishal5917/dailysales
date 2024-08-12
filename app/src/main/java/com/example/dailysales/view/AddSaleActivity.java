package com.example.dailysales.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.dailysales.R;
import com.example.dailysales.databinding.ActivityAddSaleBinding;
import com.example.dailysales.databinding.ActivityMainBinding;
import com.example.dailysales.utils.DateUtil;

public class AddSaleActivity extends AppCompatActivity {

    private ActivityAddSaleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout using Data Binding
        binding = ActivityAddSaleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set the toolbar
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Add your sale for today");
        }
        binding.tvTodaysDate.setText(DateUtil.getDate());
    }
}