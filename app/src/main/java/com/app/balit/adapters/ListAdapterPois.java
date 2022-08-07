package com.app.balit.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.balit.LineaDetail;
import com.app.balit.R;
import com.app.balit.models.Linea;
import com.app.balit.models.POI;

import java.util.List;

public class ListAdapterPois extends RecyclerView.Adapter<ListAdapterPois.ViewHolder>{
    private Context context;
    private List<POI> datos;
    private LayoutInflater inflador;

    public ListAdapterPois(List<POI> datos, Context context){
        this.inflador = LayoutInflater.from(context);
        this.context = context;
        this.datos = datos;
    }

    @Override
    public int getItemCount(){
        return datos.size();
    }

    @Override
    public ListAdapterPois.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflador.inflate(R.layout.poi_list_element, null);
        return new ListAdapterPois.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapterPois.ViewHolder holder, int position){
        holder.bindData(datos.get(position));

        ListAdapterTags listAdapterTagst = new ListAdapterTags(datos.get(position).getTags(), context);
        holder.chipsPoi.setHasFixedSize(true);
        holder.chipsPoi.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.chipsPoi.setAdapter(listAdapterTagst);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagePoi;
        TextView tituloPoi;
        TextView descripcionPoi;
        RecyclerView chipsPoi;

        ViewHolder(View itemView){
            super(itemView);
            imagePoi = itemView.findViewById(R.id.image_poi);
            tituloPoi = itemView.findViewById(R.id.titulo_poi);
            descripcionPoi = itemView.findViewById(R.id.descripcion_poi);
            chipsPoi = itemView.findViewById(R.id.lista_tags_poi);
        }

        void bindData(final POI poi){
            tituloPoi.setText(poi.getNombre());
            descripcionPoi.setText(poi.getDescripcion());
            switch (poi.getNombre()){
                case "Catedral":
                    imagePoi.setBackground(context.getDrawable(R.drawable.catedral));
                    break;
                case "Estadio de la Juventud":
                    imagePoi.setBackground(context.getDrawable(R.drawable.estadio_juventud));
                    break;
                case "Paseo de los Tristes":
                    imagePoi.setBackground(context.getDrawable(R.drawable.paseo_tristes));
                    break;
                case "Parque de las Ciencias":
                    imagePoi.setBackground(context.getDrawable(R.drawable.parque_ciencias));
                    break;
                case "Estación de autobuses":
                    imagePoi.setBackground(context.getDrawable(R.drawable.estacion));
                    break;
            }
        }
    }
}
