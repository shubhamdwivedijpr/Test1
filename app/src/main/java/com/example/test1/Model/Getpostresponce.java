package com.example.test1.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Getpostresponce implements Parcelable {



        @SerializedName("message")
        @Expose
        private Boolean message;
        @SerializedName("data")
        @Expose
        private ArrayList<Datum> data = null;

    protected Getpostresponce(Parcel in) {
        byte tmpMessage = in.readByte();
        message = tmpMessage == 0 ? null : tmpMessage == 1;
    }

    public static final Creator<Getpostresponce> CREATOR = new Creator<Getpostresponce>() {
        @Override
        public Getpostresponce createFromParcel(Parcel in) {
            return new Getpostresponce(in);
        }

        @Override
        public Getpostresponce[] newArray(int size) {
            return new Getpostresponce[size];
        }
    };

    public Boolean getMessage() {
            return message;
        }

        public void setMessage(Boolean message) {
            this.message = message;
        }

        public ArrayList<Datum> getData() {
            return data;
        }

        public void setData(ArrayList<Datum> data) {
            this.data = data;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (message == null ? 0 : message ? 1 : 2));
    }
}

