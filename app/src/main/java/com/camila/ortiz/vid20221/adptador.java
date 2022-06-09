package com.camila.ortiz.vid20221;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class adptador extends RecyclerView.Adapter<adptador.viewHolder> {

    List<animeClass> list;
    Context context;

    public adptador(List<animeClass> list,Context context) {
        this.list = list;
        this.context = context;
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

        Picasso.get()
                .load("https://rtvc-assets-radionica3.s3.amazonaws.com/s3fs-public/2022-02/animes.jpg")
                .into(holder.imagen);


        holder.relativeLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context,editarActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("anime",animeClass);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        //ImageView estrella;
        TextView titulo;
        TextView descripcion;
        RelativeLayout relativeLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen);
            //estrella = itemView.findViewById(R.id.estrella);
            titulo = itemView.findViewById(R.id.titulo);
            descripcion = itemView.findViewById(R.id.descripcion);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }



        void setdata(@NonNull animeClass animeClass) {
           /* Picasso
                    .get()
                    .load(animeClass.getImagen())
                    .into(imagen);
            titulo.setText(animeClass.getTitulo());*/
            descripcion.setText(animeClass.getDescripcion());
            titulo.setText(animeClass.getNombre());

            /*estrella.setOnClickListener(new View.OnClickListener() {
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
            });*/
        }
    }
}
