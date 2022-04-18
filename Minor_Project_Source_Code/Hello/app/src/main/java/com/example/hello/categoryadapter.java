package com.example.hello;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import helper.homeadapter.CategoryHelperClass;

public class categoryadapter extends RecyclerView.Adapter<categoryadapter.FeaturedViewHolder> {
    ArrayList<CategoryHelperClass>category;
    public categoryadapter(ArrayList<CategoryHelperClass> category) {
        this.category = category;

    }
    @NonNull
    @Override
    public categoryadapter.FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category,parent,false);
        categoryadapter.FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);

        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull categoryadapter.FeaturedViewHolder holder, int position) {

        CategoryHelperClass categoryHelperClass = category.get(position);

        holder.image.setImageResource(categoryHelperClass.getImage());
        holder.title.setText(categoryHelperClass.getTitle());
        holder.desc.setText(categoryHelperClass.getDescription());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), scifi.class);
                intent.putExtra("image", categoryHelperClass.getImage());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return category.size();
    }
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.c_img);
            title = itemView.findViewById(R.id.c_title);
            desc = itemView.findViewById(R.id.c_desc);
        }
    }
}
