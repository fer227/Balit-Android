package com.app.balit.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.app.balit.LineaDetail;
import com.app.balit.R;
import com.app.balit.models.Linea;
import com.google.android.material.chip.Chip;

import java.util.List;

public class ListAdapterTags extends RecyclerView.Adapter<ListAdapterTags.ViewHolder>{
    private List<String> datos;
    private LayoutInflater inflador;
    private Context context;

    public ListAdapterTags(List<String> datos, Context context){
        this.inflador = LayoutInflater.from(context);
        this.context = context;
        this.datos = datos;
    }

    @Override
    public int getItemCount(){
        return datos.size();
    }

    @Override
    public ListAdapterTags.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflador.inflate(R.layout.chip, null);
        return new ListAdapterTags.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapterTags.ViewHolder holder, int position){
        holder.bindData(datos.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        Chip tag;

        ViewHolder(View itemView){
            super(itemView);
            tag = itemView.findViewById(R.id.chip_name);
        }

        void bindData(final String str){
            tag.setText(str);
        }
    }
}
