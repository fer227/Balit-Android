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
import com.app.balit.R;
import com.app.balit.models.Linea;
import com.app.balit.models.ParadaOrdenPair;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListAdapterLineas extends RecyclerView.Adapter<ListAdapterLineas.ViewHolder> {
    private List<Linea> datos;
    private LayoutInflater inflador;
    private Context context;

    public ListAdapterLineas(List<Linea> datos, Context context){
        this.inflador = LayoutInflater.from(context);
        this.context = context;
        this.datos = datos;
    }

    @Override
    public int getItemCount(){
        return datos.size();
    }

    @Override
    public ListAdapterLineas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflador.inflate(R.layout.linea_list_element, null);
        return new ListAdapterLineas.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapterLineas.ViewHolder holder, int position){
        holder.bindData(datos.get(position));
        View.OnClickListener clicListener  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LineaDetail.class);
                intent.putExtra("nombre", datos.get(position).getNombre());
                context.startActivity(intent);
            }
        };
        holder.itemView.setOnClickListener(clicListener);
        holder.infoLinea.setOnClickListener(clicListener);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descripcion;
        FloatingActionButton infoLinea;
        ImageView imageLinea;

        ViewHolder(View itemView){
            super(itemView);
            descripcion = itemView.findViewById(R.id.descripcion_linea);
            infoLinea = itemView.findViewById(R.id.button_info_linea);
            imageLinea = itemView.findViewById(R.id.image_linea);
        }

        void bindData(final Linea linea){
            descripcion.setText(linea.getDescripcion());
            switch (linea.getNombre()){
                case "N3":
                    imageLinea.setBackground(context.getDrawable(R.drawable.n3));
                    break;
                case "C4":
                    imageLinea.setBackground(context.getDrawable(R.drawable.c4));
                    break;
                case "5":
                    imageLinea.setBackground(context.getDrawable(R.drawable.linea5));
                    break;
            }
        }
    }
}
