package com.example.dailysales.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.dailysales.repository.MainRepository;
import com.example.dailysales.utils.DateUtil;
import com.example.dailysales.viewmodel.database.entities.SaleRecord;

import java.util.List;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final MutableLiveData<Double> totalMonthlySale;
    private final MutableLiveData<Double> saleOfDay;
    private final MutableLiveData<List<SaleRecord>> pastFiveSales;

    public LiveData<Double> getTotalMonthlySale() {
        return totalMonthlySale;
    }
    public LiveData<Double> getSaleOfDay() {
        return saleOfDay;
    }

    public LiveData<List<SaleRecord>> getPastFiveSales() {
        return pastFiveSales;
    }

    private final MainRepository repository;

    @Inject
    public MainViewModel(MainRepository repository) {
        this.repository = repository;
        this.totalMonthlySale = new MutableLiveData<>();
        this.saleOfDay = new MutableLiveData<>();
        this.pastFiveSales = new MutableLiveData<>();
    }

    public void insertSalesData(SaleRecord saleRecord){
        repository.insertSales(saleRecord);
    }

    public void deleteDataForDay(long timestamp){
        repository.deleteSales(timestamp);
    }

    public void loadSaleOfMonth() {
        repository.getMonthlySales(DateUtil.getMonth()).observeForever(totalMonthlySale::setValue);
    }

    public void loadSaleOfDay(){
        repository.getSaleOfDay(DateUtil.getDateOnlyTimestamp()).observeForever(saleOfDay::setValue);
    }

    public void loadPastFiveDaySales(){
        repository.getLastFiveDaySales().observeForever(pastFiveSales::setValue);
    }
}
