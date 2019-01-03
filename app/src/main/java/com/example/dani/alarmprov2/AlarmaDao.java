package com.example.dani.alarmprov2;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface AlarmaDao {
    @Insert
    void insert (Alarma alarma);

    @Query("SELECT * from Alarma")
    LiveData<List<Alarma>> getAlarmas();

    //Lo he creado yo para ver si sirve eliminar CardViews
    @Delete
    void delete (Alarma alarma);
    //
    @Query("UPDATE alarma SET timePick=:timePick WHERE name=:name")
    abstract void setTimePick(String name, String timePick);




}




