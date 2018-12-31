package com.example.dani.alarmprov2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MathProblemsActivity extends AppCompatActivity {

  MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_problems);


        mediaPlayer = MediaPlayer.create(this, R.raw.campanas);
        mediaPlayer.start();


        final EditText resultado = (EditText) findViewById(R.id.respuestaEditText);

        Button btnOK = (Button) findViewById(R.id.botonConfirmarOperacion);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (resultado.getText().toString().equals("76")){

                    Toast toast = Toast.makeText(getApplicationContext(), "CORRECTO!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    mediaPlayer.stop();
                    Intent intent = new Intent(MathProblemsActivity.this, MainActivity.class);
                    startActivity(intent);


                }else{

                    Toast toast = Toast.makeText(getApplicationContext(), "INCORRECTO, PRUEBA OTRA VEZ!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();

                }


            }
        });


    }
}
