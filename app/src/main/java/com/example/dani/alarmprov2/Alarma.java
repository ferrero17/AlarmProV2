package com.example.dani.alarmprov2;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.concurrent.TimeUnit;

@Entity
    public class Alarma {
        @PrimaryKey(autoGenerate = true)
        public int id;
        public String name;
        public String timePick;
        public String dayRepeats;
        boolean activa;

    }



