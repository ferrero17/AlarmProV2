package com.example.dani.alarmprov2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfiguracionAlarmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_alarma);

        Button btnGuardar = (Button) findViewById(R.id.botonGuardarCambios);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText etName = findViewById(R.id.AlarmName);
                String nombreAlarma;
                nombreAlarma = etName.getText().toString();
                Intent intent1 = new Intent(ConfiguracionAlarmaActivity.this, MainActivity.class);
                intent1.putExtra("nombre", nombreAlarma);
                startActivity(intent1);
            }
        });

        Button button = (Button) findViewById(R.id.botonAjustesAlarma);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SwipeActivity.class);
                startActivityForResult(intent,0);
            }
        });


    }
}
