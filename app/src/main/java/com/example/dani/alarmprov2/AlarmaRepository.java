package com.example.dani.alarmprov2;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AlarmaRepository {

    AlarmaDao alarmaDao;


    AlarmaRepository(Application application){
        alarmaDao = AlarmRoomDatabase.getDatabase(application).AlarmDAO();
    }

    LiveData<List<Alarma>> getAlarmas(){


        return alarmaDao.getAlarmas();
    }

    public void insert(Alarma alarma){
        new insertAsyncTask (alarmaDao).execute(alarma);
    }

    public static class insertAsyncTask extends AsyncTask<Alarma, Void, Void>{

        private AlarmaDao mAsyncTaskDao;

        insertAsyncTask(AlarmaDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Alarma... params){

            mAsyncTaskDao.insert(params[0]);
            return null;

        }

    }







}
