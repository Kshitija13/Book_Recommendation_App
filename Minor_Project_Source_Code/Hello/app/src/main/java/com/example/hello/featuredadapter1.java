package com.example.hello;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import helper.homeadapter.FeaturedHelperClass;

public class featuredadapter1 extends RecyclerView.Adapter<featuredadapter1.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass>featuredLocations;
    Context context;

    public featuredadapter1(ArrayList<FeaturedHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
        this.context = context;
        //this.listener= this.listener;
    }

    //private Rvc listener;

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelperClass featuredHelperclass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelperclass.getImage());
        holder.title.setText(featuredHelperclass.getTitle());
        holder.desc.setText(featuredHelperclass.getDescription());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), descp.class);
                intent.putExtra("image", featuredHelperclass.getImage());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return featuredLocations.size();

    }

    public class FeaturedViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, desc;
        //View.OnClickListener listener;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
