package com.edisondeveloper.petagram.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edisondeveloper.petagram.Model.PerfilMascota;
import com.edisondeveloper.petagram.R;

import java.util.ArrayList;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder> {

    private ArrayList<PerfilMascota> listPhotos;
    private Context context;

    public PerfilAdapter(Context context, ArrayList<PerfilMascota> list){
        listPhotos = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.foto_perfil, parent, false);
        return new PerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder holder, int position) {
        PerfilMascota perfil = listPhotos.get(position);
        holder.imagen.setImageResource(perfil.getImage());
        holder.puntuacion.setText(String.valueOf(perfil.getPuntaje()));
    }

    @Override
    public int getItemCount() {
        return listPhotos.size();
    }

    public class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView puntuacion;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.image_view);
            puntuacion = itemView.findViewById(R.id.calificacion);
        }

    }

}
