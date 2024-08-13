package com.example.dailysales.viewmodel.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.dailysales.viewmodel.database.entities.SaleRecord;

@Database(entities = {SaleRecord.class}, version = 2)
@TypeConverters({TypeConvertors.class}) // Specify your converters here
public abstract class SalesDatabase extends RoomDatabase {
    public abstract AppDao appDao();
}

