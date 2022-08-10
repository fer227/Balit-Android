package com.app.balit.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.balit.LineaDetail;
import com.app.balit.ParadaDetail;
import com.app.balit.R;
import com.app.balit.models.Linea;
import com.app.balit.models.Parada;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListAdapterParadas extends RecyclerView.Adapter<ListAdapterParadas.ViewHolder>{
    private List<Parada> datos;
    private LayoutInflater inflador;
    private Context context;

    public ListAdapterParadas(List<Parada> datos, Context context){
        this.inflador = LayoutInflater.from(context);
        this.context = context;
        this.datos = datos;
    }

    @Override
    public int getItemCount(){
        return datos.size();
    }

    @Override
    public ListAdapterParadas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflador.inflate(R.layout.parada_list_element, null);
        return new ListAdapterParadas.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapterParadas.ViewHolder holder, int position){
        holder.bindData(datos.get(position));

        View.OnClickListener clicListener  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ParadaDetail.class);
                intent.putExtra("numero", datos.get(position).getNumero());
                intent.putExtra("nombreParada", datos.get(position).getNombre());
                intent.putExtra("latitud", datos.get(position).getLatitud());
                intent.putExtra("longitud", datos.get(position).getLongitud());
                context.startActivity(intent);
            }
        };

        holder.infoParada.setOnClickListener(clicListener);
        holder.itemView.setOnClickListener(clicListener);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tituloParada;
        FloatingActionButton infoParada;

        ViewHolder(View itemView){
            super(itemView);
            tituloParada = itemView.findViewById(R.id.titulo_parada);
            infoParada = itemView.findViewById(R.id.button_info_parada);
        }

        void bindData(final Parada parada){
            tituloParada.setText(parada.getNombre());
        }
    }
}
