package com.example.moviefilm.Priview.Main.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefilm.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewMovie> {
    Context context;
    ArrayList<Movie> list;

    public MovieAdapter(Context context, ArrayList<Movie> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewMovie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);
        return new ViewMovie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewMovie holder, int position) {
        Movie movie= list.get(position);
        holder.image.setImageResource(movie.getImage());
        holder.textJudul.setText(movie.getJudul());
        holder.textDeskripsi.setText(movie.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewMovie extends RecyclerView.ViewHolder {
        ImageView image;
        TextView textJudul;
        TextView textDeskripsi;
        public ViewMovie(@NonNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image_movie);
            textJudul= itemView.findViewById(R.id.text_judul);
            textDeskripsi= itemView.findViewById(R.id.text_deskripsi);
        }
    }
}