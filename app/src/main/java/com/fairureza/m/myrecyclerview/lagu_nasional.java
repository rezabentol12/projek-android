package com.fairureza.m.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class lagu_nasional implements Parcelable {

    private String name;
    private String from;
    private String photo;

    public String getName() {
        return name;
    }

    public String getFrom() {
        return from;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.from);
        dest.writeString(this.photo);
    }

    public lagu_nasional() {
    }

    protected lagu_nasional(Parcel in) {
        this.name = in.readString();
        this.from = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<lagu_nasional> CREATOR = new Parcelable.Creator<lagu_nasional>() {
        @Override
        public lagu_nasional createFromParcel(Parcel source) {
            return new lagu_nasional(source);
        }

        @Override
        public lagu_nasional[] newArray(int size) {
            return new lagu_nasional[size];
        }
    };
}
