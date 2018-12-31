package com.example.dani.alarmprov2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Alarma.class}, version = 1, exportSchema = false)
public abstract class AlarmRoomDatabase extends RoomDatabase {

    public abstract AlarmaDao AlarmDAO();

    private static volatile AlarmRoomDatabase INSTANCE;

    static AlarmRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AlarmRoomDatabase.class){
                if (INSTANCE == null){

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AlarmRoomDatabase.class, "alarm_database").build();

                }
            }
        }

        return INSTANCE;
    }

}
