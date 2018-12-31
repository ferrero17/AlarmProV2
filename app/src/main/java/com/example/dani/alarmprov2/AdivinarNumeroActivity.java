package com.example.dani.alarmprov2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdivinarNumeroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivinar_numero);

        final int numeroAleatorio;
        final String numeroAleatorioString;
       // int numeroCasteado;

        numeroAleatorio = (int) (Math.random() * 100) +1;
        numeroAleatorioString = Integer.toString(numeroAleatorio);


        //Descomentar para ver el numero aleatorio rapido.
        /*Toast toast5 = Toast.makeText(getApplicationContext(), "NumAleatori: " + numeroAleatorio, Toast.LENGTH_SHORT);
        toast5.setGravity(Gravity.CENTER,0,0);
        toast5.show();*/




        Button btnConfirmarAdivinar = (Button) findViewById(R.id.botonConfirmarNumeroAdivinar);
        btnConfirmarAdivinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText numeroElegido = (EditText) findViewById(R.id.respuestaEditTextAdivinar);

                    int numeroCasteado = Integer.parseInt(numeroElegido.getText().toString());




                if (numeroAleatorioString.equals(numeroElegido.getText().toString())){


                    Toast toast = Toast.makeText(getApplicationContext(), "CORRECTO!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();

                    Intent intent = new Intent(AdivinarNumeroActivity.this, MainActivity.class);
                    startActivity(intent);

                }else{

                    Toast toastMayor = Toast.makeText(getApplicationContext(), "El número es MAYOR!", Toast.LENGTH_SHORT);
                    toastMayor.setGravity(Gravity.CENTER,0,0);

                    Toast toastMenor = Toast.makeText(getApplicationContext(), "El número es MENOR!", Toast.LENGTH_SHORT);
                    toastMenor.setGravity(Gravity.CENTER,0,0);

                    if (numeroAleatorio<numeroCasteado){

                        toastMenor.show();

                    }else {

                        toastMayor.show();
                    }


                }





            }
        });


    }
}
