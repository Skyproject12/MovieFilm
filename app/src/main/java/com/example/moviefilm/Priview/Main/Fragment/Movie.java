package com.example.moviefilm.Priview.Main.Fragment;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    int image;
    String judul;
    String deskripsi;
    String tanggalRilis;
    String pembuat;

    public Movie() {
    }

    public Movie(int image, String judul, String deskripsi, String tanggalRilis, String pembuat) {
        this.image = image;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalRilis = tanggalRilis;
        this.pembuat = pembuat;
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
        dest.writeInt(this.image);
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.tanggalRilis);
        dest.writeString(this.pembuat);
    }

    protected Movie(Parcel in) {
        this.image = in.readInt();
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.tanggalRilis = in.readString();
        this.pembuat = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
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
