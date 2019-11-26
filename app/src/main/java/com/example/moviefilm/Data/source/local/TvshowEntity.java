package com.example.moviefilm.Data.source.local;

import android.os.Parcel;
import android.os.Parcelable;

public class TvshowEntity implements Parcelable {
    int id;
    String image;
    String judul;
    String deskripsi;
    String tanggalRilis;

    public TvshowEntity(int id, String image, String judul, String deskripsi, String tanggalRilis) {
        this.id = id;
        this.image = image;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalRilis = tanggalRilis;
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

    public TvshowEntity() {
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
    }

    protected TvshowEntity(Parcel in) {
        this.id = in.readInt();
        this.image = in.readString();
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.tanggalRilis = in.readString();
    }

    public static final Creator<TvshowEntity> CREATOR = new Creator<TvshowEntity>() {
        @Override
        public TvshowEntity createFromParcel(Parcel source) {
            return new TvshowEntity(source);
        }

        @Override
        public TvshowEntity[] newArray(int size) {
            return new TvshowEntity[size];
        }
    };
}
