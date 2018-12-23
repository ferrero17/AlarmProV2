package com.example.dani.alarmprov2;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);


        findViewById(R.id.botonAñadirAlarma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);
                String alarmaDada = editText.getText().toString();

                Alarma alarma = new Alarma();
                alarma.name = alarmaDada;

                AlarmaViewModel alarmaViewModel = ViewModelProviders.of(NewAlarmActivity.this).get(AlarmaViewModel.class);
                alarmaViewModel.insertAlarma(alarma);

                finish();

            }
        });



    }
}
