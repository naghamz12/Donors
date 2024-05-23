package com.example.dono.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dono.Activities.MyviewHolder;
import com.example.dono.R;
import com.example.dono.fragments.projectdatA;



import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyviewHolder> {
    private  Context context ;
    private ArrayList<projectdatA> projects = new ArrayList<>();
    public MyAdapter(Context context, ArrayList<projectdatA> projects) {
        this.context = context;
        this.projects = projects;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyviewHolder(LayoutInflater.from(context).inflate(R.layout.project,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.projectname.setText("name poject: "+projects.get(position).getNameproject());
        holder.projectdetails.setText("details project : "+projects.get(position).getDetailsproject());
    }
    @Override
    public int getItemCount() {
        return projects.size();
    }

}

