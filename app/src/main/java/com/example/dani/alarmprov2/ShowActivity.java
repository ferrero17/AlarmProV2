package com.example.dani.alarmprov2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);



        findViewById(R.id.botonMinigame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowActivity.this, MiniGame2Activity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.botonMathProblems).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowActivity.this, MathProblemsActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.botonAdivinaNumero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowActivity.this, AdivinarNumeroActivity.class);
                startActivity(intent);
            }
        });


    }
}
