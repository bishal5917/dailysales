package com.example.dailysales.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.dailysales.utils.DateUtil;
import com.example.dailysales.viewmodel.database.AppDao;
import com.example.dailysales.viewmodel.database.entities.SaleRecord;

import java.util.List;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainRepository extends ViewModel {

    private final AppDao dao;

    @Inject
    public MainRepository(AppDao dao) {
        this.dao = dao;
    }

    public void insertSales(SaleRecord saleRecord) {
        dao.insertSaleData(saleRecord);
    }

    public void deleteSales(long timestamp) {
        dao.deleteRecord(timestamp);
    }

    //getting sales of that month
    public LiveData<Double> getMonthlySales(String month) {
        return dao.getTotalMonthSales(month);
    }

    //getting added sales of the day
    public LiveData<Double> getSaleOfDay(long timestamp) {
        return dao.getSaleOfDay(timestamp);
    }

    //get data of five days ago
    public LiveData<List<SaleRecord>> getLastFiveDaySales() {
        return dao.getSalesInDateRange(DateUtil.getStartOfDayFiveDaysAgo(),DateUtil.getDateOnlyTimestamp());
    }
}
