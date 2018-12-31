package com.example.dani.alarmprov2;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

import com.bumptech.glide.Glide;

import java.util.Calendar;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Alarma> list;

    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";

    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la hora hora
    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemAlarma = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_alarma, viewGroup, false);
        return new MyViewHolder(itemAlarma);


    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        Alarma alarma = list.get(i);

        myViewHolder.alarmName.setText(alarma.name);

        //myViewHolder.alarmTimePick.setText(alarma.timePick);

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

        //Declaro los botones que usare en el switchCase para el OnClick Manual
        Button btnConfiguracionAlarma;
        Button btnModificarHora;
        CardView cardView;
       // EditText PickTime;
        //
        Button btnEliminarAlarma;

        //contexto
        Context context;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

             context = itemView.getContext();

             alarmName= itemView.findViewById(R.id.switchNewAlarm);
             alarmTimePick =  itemView.findViewById(R.id.botonHoraAlarmaItem);

             btnConfiguracionAlarma = (Button) itemView.findViewById(R.id.configuracionAlarma);
             btnModificarHora = (Button) itemView.findViewById(R.id.botonHoraAlarmaItem);
             //
             cardView = (CardView) itemView.findViewById(R.id.CardView);


        }

        void setOnClickListeners() {

            btnConfiguracionAlarma.setOnClickListener(this);
            btnModificarHora.setOnClickListener(this);
            cardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.configuracionAlarma:
                    Intent intent = new Intent(context, ConfiguracionAlarmaActivity.class);
                    context.startActivity(intent);
                    break;

                case R.id.botonHoraAlarmaItem:
                  //  Intent intent1 = new Intent(context,MainActivity.class);
                    obtenerHora();

                    //context.startActivity(intent1);
                    break;

                case R.id.CardView:
                    Intent intent1 = new Intent(context,ShowActivity.class);
                    context.startActivity(intent1);

            }

        }
        private void obtenerHora(){
            TimePickerDialog recogerHora = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    //Formateo el hora obtenido: antepone el 0 si son menores de 10
                    String horaFormateada =  (hourOfDay < 10)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);
                    //Formateo el minuto obtenido: antepone el 0 si son menores de 10
                    String minutoFormateado = (minute < 10)? String.valueOf(CERO + minute):String.valueOf(minute);
                    //Obtengo el valor a.m. o p.m., dependiendo de la selección del usuario
                    String AM_PM;
                    if(hourOfDay < 12) {
                        AM_PM = "a.m.";
                    } else {
                        AM_PM = "p.m.";
                    }
                    //Muestro la hora con el formato deseado

                    //AQUI ASIGNO LA HORA AL BOTON QUE QUIERO
                    alarmTimePick.setText(horaFormateada + DOS_PUNTOS + minutoFormateado /*+ " " + AM_PM*/);
                }
                //Estos valores deben ir en ese orden
                //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
                //Pero el sistema devuelve la hora en formato 24 horas

                //Modifiacado el booleano para probar el formato de 24 horas.
            }, hora, minuto, true);

            recogerHora.show();
        }


    }

}

