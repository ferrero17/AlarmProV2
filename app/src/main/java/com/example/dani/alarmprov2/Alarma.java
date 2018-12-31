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
        public boolean vibration;
        public boolean activa;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimePick() {
        return timePick;
    }

    public void setTimePick(String timePick) {
        this.timePick = timePick;
    }

    public String getDayRepeats() {
        return dayRepeats;
    }

    public void setDayRepeats(String dayRepeats) {
        this.dayRepeats = dayRepeats;
    }

    public boolean isVibration() {
        return vibration;
    }

    public void setVibration(boolean vibration) {
        this.vibration = vibration;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}



