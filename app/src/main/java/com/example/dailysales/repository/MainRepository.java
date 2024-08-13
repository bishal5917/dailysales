package com.example.dailysales.repository;

import androidx.lifecycle.ViewModel;
import com.example.dailysales.viewmodel.database.AppDao;
import com.example.dailysales.viewmodel.database.entities.SaleRecord;

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
}
