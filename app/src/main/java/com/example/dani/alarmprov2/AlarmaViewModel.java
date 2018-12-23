package com.example.dani.alarmprov2;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class AlarmaViewModel extends AndroidViewModel {

    AlarmaRepository aRepository;


    public  AlarmaViewModel(@NonNull Application application){
        super(application);

        aRepository = new AlarmaRepository(application);


    }

    public void insertAlarma(Alarma alarma){

        aRepository.insert(alarma);

    }

    LiveData<List<Alarma>> getAlarmas(){

        return aRepository.getAlarmas();
    }


}
