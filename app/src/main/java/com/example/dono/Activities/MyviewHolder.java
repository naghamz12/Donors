package com.example.dono.Activities;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dono.R;



public class MyviewHolder extends RecyclerView.ViewHolder {
    public TextView projectname, projectdetails;


    public MyviewHolder(@NonNull View itemView) {
        super(itemView);
        projectname= itemView.findViewById(R.id.projectname);
        projectdetails =itemView.findViewById(R.id.projectdetails);
    }
}
