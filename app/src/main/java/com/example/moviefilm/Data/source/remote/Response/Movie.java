package com.example.moviefilm.Data.source.remote.Response;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    int id;
    int image;
    String judul;
    String deskripsi;
    String tanggalRilis;
    String pembuat;

    public Movie(int id, int image, String judul, String deskripsi, String tanggalRilis, String pembuat) {
        this.id = id;
        this.image = image;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalRilis = tanggalRilis;
        this.pembuat = pembuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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

    public String getPembuat() {
        return pembuat;
    }

    public void setPembuat(String pembuat) {
        this.pembuat = pembuat;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.image);
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.tanggalRilis);
        dest.writeString(this.pembuat);
    }

    protected Movie(Parcel in) {
        this.id = in.readInt();
        this.image = in.readInt();
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.tanggalRilis = in.readString();
        this.pembuat = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
