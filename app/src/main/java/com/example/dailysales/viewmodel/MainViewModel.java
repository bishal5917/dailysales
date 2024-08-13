package com.example.dailysales.viewmodel;

import androidx.lifecycle.ViewModel;
import com.example.dailysales.repository.MainRepository;
import com.example.dailysales.viewmodel.database.entities.SaleRecord;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final MainRepository repository;

    @Inject
    public MainViewModel(MainRepository repository) {
        this.repository = repository;
    }

    public void insertSalesData(SaleRecord saleRecord){
        repository.insertSales(saleRecord);
    }

    public void deleteDataForDay(long timestamp){
        repository.deleteSales(timestamp);
    }
}
