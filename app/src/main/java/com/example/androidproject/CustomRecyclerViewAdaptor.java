package com.example.androidproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerViewAdaptor extends RecyclerView.Adapter<CustomRecyclerViewAdaptor.CustomViewHolder> {

    private ArrayList<credit> credits;
    public CustomRecyclerViewAdaptor(ArrayList<credit> credits){
        this.credits = credits;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recycle_display,null);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        credit credit = credits.get(position);
        holder.name.setText(credit.getName());
        holder.description.setText(credit.getDefination());
        holder.imageView.setImageResource(credit.getImage());
    }

    @Override
    public int getItemCount() {
        if (credits != null){
            return credits.size();
        }
        return 0;
    }
    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView description;
        protected ImageView imageView;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.itemDescription);
            this.imageView = itemView.findViewById(R.id.recycleImage);

        }
    }
}