package com.example.dailysales.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import java.util.Date;

@Entity(tableName = "sale_record")
public class SaleRecord {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "totalSalesAmount")
    private double totalSalesAmount;

    // Getters and Setters
    public double getTotalPrice() {
        return totalSalesAmount;
    }

    public void setTotalPrice(double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

