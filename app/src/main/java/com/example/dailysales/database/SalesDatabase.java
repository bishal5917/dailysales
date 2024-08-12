package com.example.dailysales.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.dailysales.database.entities.SaleRecord;

@Database(entities = {SaleRecord.class}, version = 1)
public abstract class SalesDatabase extends RoomDatabase {
    public abstract AppDao appDao();
}

