package com.example.dani.alarmprov2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    public void setList(List<Alarma> alarmas){

        list = alarmas;


    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView alarmName;
        private TextView alarmTimePick;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

          // alarmName = itemView.findViewById(R.id.alarm_name);
           // alarmTimePick = itemView.findViewById(R.id.alarm_timePick);

        }
    }


}
