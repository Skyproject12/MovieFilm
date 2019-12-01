package com.example.moviefilm.Ui.Main.Fragment.Favorite.MovieFavorite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.Ui.Detail.DetailActivity;
import com.squareup.picasso.Picasso;

public class MovieFavoriteAdapter extends PagedListAdapter<MovieEntity, MovieFavoriteAdapter.ViewHolder> {

    protected MovieFavoriteAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MovieEntity movieEntity = getItem(position);
        if (movieEntity != null) {
            holder.textJudul.setText(movieEntity.getJudul());
            Picasso.get().load(movieEntity.getImage()).into(holder.image);
            holder.textDeskripsi.setText(movieEntity.getDeskripsi());
        }
        holder.image.setOnClickListener(listener -> {
            Context context = holder.itemView.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("film", movieEntity);
            context.startActivity(intent);
        });
    }

    private static DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK = new DiffUtil.ItemCallback<MovieEntity>() {
        @Override
        public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
            return oldItem == newItem;

        }
    };

    MovieEntity getItemById(int swipePosition) {
        return getItem(swipePosition);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textJudul;
        ImageView image;
        TextView textDeskripsi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_movie);
            textJudul = itemView.findViewById(R.id.text_judul);
            textDeskripsi = itemView.findViewById(R.id.text_deskripsi);

        }
    }
}
