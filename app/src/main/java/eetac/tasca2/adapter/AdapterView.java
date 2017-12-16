package eetac.tasca2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import eetac.tasca2.R;
import eetac.tasca2.modelo.Pelicula;

/**
 * Created by Alex Aguilera on 15/12/2017.
 */

public class AdapterView extends RecyclerView.Adapter<AdapterView.PelisHolder>{

    private List<Pelicula> pelis;
    private int rowLayout;
    private Context context;

    public AdapterView(List<Pelicula> pelis, int rowLayout, Context context) {
        this.pelis = pelis;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public AdapterView.PelisHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PelisHolder(view);
    }

    @Override
    public void onBindViewHolder(PelisHolder holder, int position) {
        holder.titulo.setText(pelis.get(position).getTitulo());
        holder.tituloO.setText(pelis.get(position).getOriginal_title());
        holder.path.setText(pelis.get(position).getPoster_path());
    }

    @Override
    public int getItemCount() {
        return pelis.size();
    }

    //A view holder inner class where we get reference to the views in the layout using their ID
    public static class PelisHolder extends RecyclerView.ViewHolder {
        LinearLayout pelis;
        TextView titulo;
        TextView tituloO;
        TextView path;

        public PelisHolder (View v) {
            super(v);
            pelis = (LinearLayout) v.findViewById(R.id.pelis);
            titulo = (TextView) v.findViewById(R.id.titulo);
            path = (TextView) v.findViewById(R.id.path);
            tituloO = (TextView) v.findViewById(R.id.tituloO);
        }
    }
}
