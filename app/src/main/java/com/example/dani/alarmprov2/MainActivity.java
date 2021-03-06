package com.example.dani.alarmprov2;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.hudomju.swipe.OnItemClickListener;
import com.hudomju.swipe.SwipeToDismissTouchListener;
import com.hudomju.swipe.SwipeableItemClickListener;
import com.hudomju.swipe.adapter.ListViewAdapter;
import com.hudomju.swipe.adapter.RecyclerViewAdapter;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.alarm_List);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);


        findViewById(R.id.new_alarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewAlarmActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.ajustesBoton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AjustesActivity.class);
                startActivity(intent);
            }
        });


        AlarmaViewModel alarmaViewModel = ViewModelProviders.of(this).get(AlarmaViewModel.class);
        alarmaViewModel.getAlarmas().observe(this, new Observer<List<Alarma>>() {
            @Override
            public void onChanged(@Nullable final List<Alarma> alarmas) {
                myAdapter.setList(alarmas);
                myAdapter.notifyDataSetChanged();
            }
        });

    }


}
