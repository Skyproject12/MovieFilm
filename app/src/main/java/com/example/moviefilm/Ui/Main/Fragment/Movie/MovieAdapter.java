package com.example.moviefilm.Ui.Main.Fragment.Movie;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewMovie> {
    ArrayList<Movie> list = new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setList(ArrayList<Movie> mList) {
        if (mList == null) return;
        this.list.clear();
        this.list.addAll(mList);
        Log.d("AdapterMovie", "setList: " + list.get(0).getJudul());
    }

    @NonNull
    @Override
    public ViewMovie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new ViewMovie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewMovie holder, final int position) {
        Movie movie = list.get(position);
        Picasso.get().load(movie.getImage()).into(holder.image);
        holder.textJudul.setText(movie.getJudul());
        holder.textDeskripsi.setText(movie.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // take the position for give onclick for your recycler
                onItemClickCallback.onItmCliked(list.get(holder.getAdapterPosition()));
            }
        });
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
            image = itemView.findViewById(R.id.image_movie);
            textJudul = itemView.findViewById(R.id.text_judul);
            textDeskripsi = itemView.findViewById(R.id.text_deskripsi);
        }
    }

    public interface OnItemClickCallback {
        void onItmCliked(Movie movie);
    }
}