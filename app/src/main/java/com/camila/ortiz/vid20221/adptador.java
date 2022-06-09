package com.camila.ortiz.vid20221;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class adptador extends RecyclerView.Adapter<adptador.viewHolder> {

    List<animeClass> list;

    public adptador(List<animeClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.animelista, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        animeClass animeClass = list.get(position);
        holder.setdata(list.get(position));
        holder.onClik(animeClass);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        ImageView estrella;
        TextView titulo;
        TextView descripcion;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen);
            estrella = itemView.findViewById(R.id.estrella);
            titulo = itemView.findViewById(R.id.titulo);
            descripcion = itemView.findViewById(R.id.descripcion);
        }

        void onClik(animeClass animeClass) {


        }

        void setdata(animeClass animeClass) {
            Picasso
                    .get()
                    .load(animeClass.getImagen())
                    .into(imagen);
            titulo.setText(animeClass.getTitulo());
            descripcion.setText(animeClass.getDescripcion());

            estrella.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (animeClass.isEstrella() == false) {
                        estrella.setImageResource(R.drawable.ic__star_blanco);
                        animeClass.setEstrella(true);
                    } else {
                        estrella.setImageResource(R.drawable.ic__star_negro);
                        animeClass.setEstrella(false);
                    }
                }
            });
        }
    }
}
