package com.example.dono.fragments;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class projectdatA implements Parcelable {
   private String projectname;
    private String 	projectdeatails;

    public projectdatA() {
    }

    public projectdatA(String projectname, String projectdeatails) {
        this.projectname = projectname;
        this.projectdeatails = projectdeatails;
    }

    protected projectdatA(Parcel in) {
        projectname = in.readString();
        projectdeatails = in.readString();
    }

    public static final Creator<projectdatA> CREATOR = new Creator<projectdatA>() {
        @Override
        public projectdatA createFromParcel(Parcel in) {
            return new projectdatA(in);
        }

        @Override
        public projectdatA[] newArray(int size) {
            return new projectdatA[size];
        }
    };

    public String getNameproject() {

        return projectname;
    }

    public void setNameproject(String nameproject) {

        this.projectname = nameproject;
    }

    public String getDetailsproject() {

        return 	projectdeatails;
    }

    public void setDetailsproject(String detailsproject) {
        this.projectdeatails = detailsproject;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(projectname);
        dest.writeString(projectdeatails);
    }
}
