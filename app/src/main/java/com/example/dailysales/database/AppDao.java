package com.example.dailysales.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.dailysales.database.entities.SaleRecord;

/* for offline data storage */
@Dao
public interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSaleData(SaleRecord saleRecord);
}