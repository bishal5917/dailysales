package com.example.dailysales.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.dailysales.databinding.ActivityAddSaleBinding;
import com.example.dailysales.utils.CustomToast;
import com.example.dailysales.utils.DateUtil;
import com.example.dailysales.viewmodel.MainViewModel;
import com.example.dailysales.database.entities.SaleRecord;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddSaleActivity extends AppCompatActivity {

    @Inject
    MainViewModel mainViewModel;

    private ActivityAddSaleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout using Data Binding
        binding = ActivityAddSaleBinding.inflate(getLayoutInflater());
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setContentView(binding.getRoot());

        // Set the toolbar
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Add your sale for today");
        }
        binding.tvTodaysDate.setText(DateUtil.getDate());
        binding.btnSave.setOnClickListener(v->{
            addSalesToDatabase();
        });
    }

    private void addSalesToDatabase(){
        if (binding.etSalesAmt.getText().toString().isEmpty()){
            CustomToast.error(this,"Amount cannot be empty");
            return;
        }
        // get the value from the textfield
        SaleRecord saleRecord = new SaleRecord();
        saleRecord.setTimestamp(DateUtil.getDateOnlyTimestamp());
        saleRecord.setDay(DateUtil.getDay());
        saleRecord.setMonth(DateUtil.getMonth());
        saleRecord.setYear(DateUtil.getYear());
        saleRecord.setTotalSalesAmount(Double.valueOf(binding.etSalesAmt.getText().toString()));
        //deleting sales for that day if already present
        //so that if user enters twice,the latest data will be saved
        mainViewModel.deleteDataForDay(DateUtil.getDateOnlyTimestamp());
        mainViewModel.insertSalesData(saleRecord);
        CustomToast.success(this,"Sales record added for today");
        finish();
    }
}