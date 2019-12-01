package com.example.moviefilm.Ui.Main.Fragment.Favorite.TvshowFavorite;

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

import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.Ui.Detail.DetailShowActivity;
import com.squareup.picasso.Picasso;

public class TvshowFavoriteAdapter extends PagedListAdapter<TvshowEntity, TvshowFavoriteAdapter.ViewHolder> {

    protected TvshowFavoriteAdapter() {
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
        final TvshowEntity movieEntity = getItem(position);
        if (movieEntity != null) {
            holder.textJudul.setText(movieEntity.getJudul());
            Picasso.get().load(movieEntity.getImage()).into(holder.image);
            holder.textDeskripsi.setText(movieEntity.getDeskripsi());
        }
        holder.image.setOnClickListener(listener -> {
            Context context = holder.itemView.getContext();
            Intent intent = new Intent(context, DetailShowActivity.class);

            intent.putExtra("tvshow", movieEntity);
            context.startActivity(intent);
        });
    }

    private static DiffUtil.ItemCallback<TvshowEntity> DIFF_CALLBACK = new DiffUtil.ItemCallback<TvshowEntity>() {
        @Override
        public boolean areItemsTheSame(@NonNull TvshowEntity oldItem, @NonNull TvshowEntity newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull TvshowEntity oldItem, @NonNull TvshowEntity newItem) {
            return oldItem == newItem;

        }
    };

    TvshowEntity getItemById(int swipePosition) {
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