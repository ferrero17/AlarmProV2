package com.example.dani.alarmprov2;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewAlarmActivity extends AppCompatActivity {

    public String alarmaDadaHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);

        findViewById(R.id.botonAñadirAlarma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //
                EditText editText1 = findViewById(R.id.NewAlarmName);
                String alarmaDadaNombre = editText1.getText().toString();

                Alarma alarma = new Alarma();

                    alarma.name = alarmaDadaNombre;

                AlarmaViewModel alarmaViewModel = ViewModelProviders.of(NewAlarmActivity.this).get(AlarmaViewModel.class);
                alarmaViewModel.insertAlarma(alarma);

                finish();

            }
        });


        findViewById(R.id.botonAjustesAlarma2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), SwipeActivity.class);
                startActivityForResult(intent,0);

            }
        });




    }
}
