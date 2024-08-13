package com.example.dailysales.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.dailysales.databinding.ActivityMainBinding;
import com.example.dailysales.utils.DateUtil;
import com.example.dailysales.utils.GlobalUtil;
import com.example.dailysales.viewmodel.MainViewModel;

import java.util.Date;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel mainViewModel;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using Data Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setContentView(binding.getRoot());

        //load sales of day and month
        mainViewModel.loadSaleOfMonth();
        mainViewModel.loadSaleOfDay();
        mainViewModel.loadPastFiveDaySales();
        // Set the toolbar
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Daily Sales");
        }
        binding.tvMonthInfo.setText("Month of " + DateUtil.getMonth());
        binding.tvGreeting.setText(DateUtil.getGreetingMessage());
        gotoAddSalesScreen();
        observe();
        //refresh
        binding.btnRefresh.setOnClickListener(v->{
            mainViewModel.loadSaleOfMonth();
        });
    }

    private void gotoAddSalesScreen() {
        binding.btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddSaleActivity.class);
            startActivity(intent);
        });
    }

    private void observe(){
        mainViewModel.getTotalMonthlySale().observe(this, s -> {
            if (s!=null){
                binding.tvSalesAmt.setText("Rs. "+ GlobalUtil.roundOff2Decimal(s));
            }else{
                binding.tvSalesAmt.setText("Rs. "+0);
            }
        });
        mainViewModel.getSaleOfDay().observe(this, s -> {
            if (s!=null){
                binding.tvSalesOfToday.setText("Your sale for today is Rs. "+GlobalUtil.roundOff2Decimal(s));
            }else{
                binding.tvSalesOfToday.setText("Your sale for today is Rs. "+0);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // reload again on onResume
        mainViewModel.loadSaleOfDay();
        mainViewModel.loadSaleOfMonth();
    }
}
