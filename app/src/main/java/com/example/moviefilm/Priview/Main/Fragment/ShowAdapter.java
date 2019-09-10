package com.example.moviefilm.Priview.Main.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefilm.Data.Request.Movie;
import com.example.moviefilm.R;

import java.util.ArrayList;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewMovie> {
    Context context;
    ArrayList<Movie> list;
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback= onItemClickCallback;
    }

    public ShowAdapter(Context context, ArrayList<Movie> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewMovie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_show, parent, false);
        return new ViewMovie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewMovie holder, final int position) {
        Movie movie= list.get(position);
        holder.image.setImageResource(movie.getImage());
        holder.textJudul.setText(movie.getJudul());
        holder.textTanggal.setText(movie.getTanggalRilis());
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
        TextView textTanggal;
        public ViewMovie(@NonNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image_movie);
            textJudul= itemView.findViewById(R.id.text_judul);
            textTanggal= itemView.findViewById(R.id.text_tanggal);
        }
    }
    public interface OnItemClickCallback{
        void onItmCliked(Movie movie);
    }
}