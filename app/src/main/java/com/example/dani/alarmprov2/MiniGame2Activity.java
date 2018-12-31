package com.example.dani.alarmprov2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MiniGame2Activity extends AppCompatActivity {

    private ImageView ImageViewShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game2);

        ImageViewShake = (ImageView) findViewById(R.id.ShakeImageView);
        Glide.with(MiniGame2Activity.this).load(R.drawable.agitarmovil).into(ImageViewShake);

    }
}
