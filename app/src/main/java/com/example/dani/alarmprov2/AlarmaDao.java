package com.example.dani.alarmprov2;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AlarmaDao {
    @Insert
    void insert (Alarma alarma);

    @Query("SELECT * from Alarma")
    LiveData<List<Alarma>> getAlarmas();



}




