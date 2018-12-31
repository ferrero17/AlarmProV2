package com.example.dani.alarmprov2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class AjustesActivity extends AppCompatActivity {


    private RelativeLayout loPadre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        Button btnFaqs = (Button) findViewById(R.id.botonFAQs);
        btnFaqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), FaqsActivity.class);
                startActivityForResult(intent,0);
            }
        });



//Cambio de Color el fondo de un activity.

        loPadre = (RelativeLayout) findViewById(R.id.ActivityAjustesLayout);

        Button btncambiarAzul = (Button) findViewById(R.id.botonTemaAzul);
        btncambiarAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loPadre.setBackgroundColor(Color.CYAN);

            }
        });



    }
}