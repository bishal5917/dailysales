package com.example.dailysales.di;

import android.content.Context;

import androidx.room.Room;

import com.example.dailysales.database.AppDao;
import com.example.dailysales.database.SalesDatabase;
import com.example.dailysales.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Singleton
    @Provides
    public SalesDatabase providesOfflineDatabase(
            @ApplicationContext Context context
    ) {
        return Room.databaseBuilder(context, SalesDatabase.class, Constants.DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

    @Singleton
    @Provides
    public AppDao providesDao(
            SalesDatabase database
    ) {
        return database.appDao();
    }
}

