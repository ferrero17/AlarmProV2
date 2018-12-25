package com.example.dani.alarmprov2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

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

        myViewHolder.alarmName.setText(alarma.name);
        myViewHolder.alarmTimePick.setText(alarma.timePick);

        //Asignar eventos de los botones:
        myViewHolder.setOnClickListeners();


    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    public void setList(List<Alarma> alarmas) {

        list = alarmas;


    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Switch alarmName;
        private Button alarmTimePick;

        //Declaro los botones que usare en el switch para el OnClick Manual
        Button btnConfiguracionAlarma;
        Button btnModificarHora;

        //contexto
        Context context;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            context = itemView.getContext();

            alarmName= itemView.findViewById(R.id.switchNewAlarm);
            alarmTimePick = itemView.findViewById(R.id.botonHoraAlarma1);



             btnConfiguracionAlarma = (Button) itemView.findViewById(R.id.configuracionAlarma);
             btnModificarHora = (Button) itemView.findViewById(R.id.botonHoraAlarma1);

        }

        void setOnClickListeners() {

            btnConfiguracionAlarma.setOnClickListener(this);
            btnModificarHora.setOnClickListener(this);
           // btnPickTime.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.configuracionAlarma:
                    Intent intent = new Intent(context, ConfiguracionAlarmaActivity.class);
                    context.startActivity(intent);
                    break;

                case R.id.botonHoraAlarma1:
                    Intent intent1 = new Intent(context,PickersActivity.class);
                    context.startActivity(intent1);
                    break;

                case R.id.botonConfirmarHora:
                    Intent intent2 = new Intent(context, MainActivity.class);
                    //intent2.putExtra("hora", PickTime.getText().toString());
                    context.startActivity(intent2);
                    break;


            }

        }

    }
}

