package com.app.balit.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.balit.ParadaDetail;
import com.app.balit.R;
import com.app.balit.models.Conexion;
import com.app.balit.models.Linea;
import com.app.balit.models.Parada;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListAdapterParada extends RecyclerView.Adapter<ListAdapterParada.ViewHolder> {
    private List<Conexion> datos;
    private LayoutInflater inflador;
    private Context context;

    public ListAdapterParada(List<Conexion> datos, Context context){
        this.inflador = LayoutInflater.from(context);
        this.context = context;
        this.datos = datos;
    }

    @Override
    public int getItemCount(){
        return datos.size();
    }

    @Override
    public ListAdapterParada.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflador.inflate(R.layout.parada_time_list__element, null);
        return new ListAdapterParada.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapterParada.ViewHolder holder, int position){
        holder.bindData(datos.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconLinea;
        TextView descripcionLinea;
        TextView timeLinea;

        ViewHolder(View itemView){
            super(itemView);
            iconLinea = itemView.findViewById(R.id.image_linea_time);
            descripcionLinea = itemView.findViewById(R.id.descripcion_linea_time);
            timeLinea = itemView.findViewById(R.id.time_linea);
        }

        void bindData(final Conexion conexion){
            switch (conexion.getNombreLinea()){
                case "N3":
                    iconLinea.setBackground(context.getDrawable(R.drawable.n3));
                    break;
                case "C4":
                    iconLinea.setBackground(context.getDrawable(R.drawable.c4));
                    break;
                case "5":
                    iconLinea.setBackground(context.getDrawable(R.drawable.linea5));
                    break;
            }

            descripcionLinea.setText(conexion.getDescripcion());
            int randomNum = ThreadLocalRandom.current().nextInt(1, 17);
            timeLinea.setText(randomNum + " min");
        }
    }
}
