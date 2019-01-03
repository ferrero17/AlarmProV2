package com.example.dani.alarmprov2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.avast.android.dialogs.fragment.SimpleDialogFragment;
import com.bumptech.glide.Glide;

public class MiniGame2Activity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    private ImageView ImageViewShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game2);

        mediaPlayer = MediaPlayer.create(this, R.raw.campanas);
        mediaPlayer.start();

        ImageViewShake = (ImageView) findViewById(R.id.ShakeImageView);
        Glide.with(MiniGame2Activity.this).load(R.drawable.agitarmovil).into(ImageViewShake);


        Button btnSaltar = (Button) findViewById(R.id.botonPulsame3);

        btnSaltar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(), "LO ENCONTRASTE!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                mediaPlayer.stop();
                Intent intent = new Intent(MiniGame2Activity.this, MainActivity.class);
                startActivity(intent);

                return false;
            }
        });


        Button btnFake = (Button) findViewById(R.id.botonPulsame2);
        btnFake.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                SimpleDialogFragment.createBuilder(v.getContext(), getSupportFragmentManager()).setTitle("OOOPS!").setMessage("Sigue probando :)").show();
                return false;
            }
        });

        Button btnFake2 = (Button) findViewById(R.id.botonPulsame);
        btnFake2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                SimpleDialogFragment.createBuilder(v.getContext(), getSupportFragmentManager()).setTitle("CAAAASI").setMessage("LEVANTA CAMPEÓN!").show();
                return false;
            }
        });

        Button btnFake3 = (Button) findViewById(R.id.botonTap1);
        btnFake3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDialogFragment.createBuilder(v.getContext(), getSupportFragmentManager()).setTitle("UNLUCKYY").setMessage("Good Morning :)").show();

            }
        });


    }
}
