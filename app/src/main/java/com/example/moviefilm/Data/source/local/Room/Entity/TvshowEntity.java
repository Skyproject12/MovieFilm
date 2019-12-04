package com.example.moviefilm.Data.source.local.Room.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tvshow")
public class TvshowEntity implements Parcelable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvshowId")
    int id;

    @ColumnInfo(name = "image")
    String image;

    @ColumnInfo(name = "judul")
    String judul;

    @ColumnInfo(name = "deskripsi")
    String deskripsi;

    @ColumnInfo(name = "tanggalRilis")
    String tanggalRilis;

    @ColumnInfo(name = "favorite")
    private boolean favorite = false;

    public TvshowEntity() {

    }

    public TvshowEntity(int id, String image, String judul, String deskripsi, String tanggalRilis, Boolean favorite) {
        this.id = id;
        this.image = image;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalRilis = tanggalRilis;
        if (favorite != null) {
            this.favorite = favorite;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggalRilis() {
        return tanggalRilis;
    }

    public void setTanggalRilis(String tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.image);
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.tanggalRilis);
        dest.writeByte(this.favorite ? (byte) 1 : (byte) 0);
    }

    protected TvshowEntity(Parcel in) {
        this.id = in.readInt();
        this.image = in.readString();
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.tanggalRilis = in.readString();
        this.favorite = in.readByte() != 0;
    }

    public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel source) {
            return new MovieEntity(source);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };
}
