package com.example.dani.alarmprov2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Alarma> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemAlarma = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_alarma, viewGroup, false);
        return new MyViewHolder(itemAlarma);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Alarma alarma = list.get(i);

       //  myViewHolder.alarmName.setText(alarma.name);
       // myViewHolder.alarmTimePick.setText(alarma.timePick);

        //Asignar eventos de los botones:
        myViewHolder.setOnClickListeners();



    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    public void setList(List<Alarma> alarmas){

        list = alarmas;


    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView alarmName;
        private TextView alarmTimePick;
        Button btnConfiguracionAlarma;

        //contexto
        Context context;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            context = itemView.getContext();

          // alarmName = itemView.findViewById(R.id.alarm_name);
           // alarmTimePick = itemView.findViewById(R.id.alarm_timePick);

            btnConfiguracionAlarma = (Button) itemView.findViewById(R.id.configuracionAlarma);


        }

        void setOnClickListeners(){

            btnConfiguracionAlarma.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, ConfiguracionAlarmaActivity.class);
            context.startActivity(intent);

        }
    }


}
