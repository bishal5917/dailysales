package com.example.dailysales.viewmodel.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.dailysales.viewmodel.database.entities.SaleRecord;

import java.util.List;

/* for offline data storage */
@Dao
public interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSaleData(SaleRecord saleRecord);

    @Query("SELECT sum(totalSalesAmount) from sale_record where month=:month")
    LiveData<Double> getTotalMonthSales(String month);

    @Query("DELETE from sale_record where timestamp=:timestamp")
    void deleteRecord(long timestamp);

    //getting the record for the past five days
//    @Query("SELECT * FROM sale_record")
//    LiveData<List<SaleRecord>> getTotalMonthSales(long timestamp);
}