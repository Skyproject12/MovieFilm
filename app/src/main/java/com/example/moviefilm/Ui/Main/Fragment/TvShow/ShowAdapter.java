package com.example.moviefilm.Ui.Main.Fragment.TvShow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewMovie> {
    ArrayList<TvshowEntity> list= new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setList(ArrayList<TvshowEntity> mList) {
        if (list == null) return;
        this.list.clear();
        this.list.addAll(mList);

    }

    @NonNull
    @Override
    public ViewMovie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show, parent, false);
        return new ViewMovie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewMovie holder, final int position) {
        TvshowEntity movie = list.get(position);
        Picasso.get().load(movie.getImage()).into(holder.image);
        holder.textJudul.setText(movie.getJudul());
        holder.textTanggal.setText(movie.getTanggalRilis());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            image = itemView.findViewById(R.id.image_movie);
            textJudul = itemView.findViewById(R.id.text_judul);
            textTanggal = itemView.findViewById(R.id.text_tanggal);
        }
    }

    public interface OnItemClickCallback {
        void onItmCliked(TvshowEntity tvshowEntity);
    }
}