package com.example.test1.Model;



import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum  implements Parcelable {

@SerializedName("full_name")
@Expose
private String fullName;
@SerializedName("profile_img")
@Expose
private String profileImg;
@SerializedName("user_mobnum")
@Expose
private String userMobnum;
@SerializedName("viewType")
@Expose
private String viewType;

    protected Datum(Parcel in) {
        fullName = in.readString();
        profileImg = in.readString();
        userMobnum = in.readString();
        viewType = in.readString();
    }

    public static final Creator<Datum> CREATOR = new Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };

    public String getFullName() {
return fullName;
}

public void setFullName(String fullName) {
this.fullName = fullName;
}

public String getProfileImg() {
return profileImg;
}

public void setProfileImg(String profileImg) {
this.profileImg = profileImg;
}

public String getUserMobnum() {
return userMobnum;
}

public void setUserMobnum(String userMobnum) {
this.userMobnum = userMobnum;
}

public String getViewType() {
return viewType;
}

public void setViewType(String viewType) {
this.viewType = viewType;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(profileImg);
        dest.writeString(userMobnum);
        dest.writeString(viewType);
    }
}



