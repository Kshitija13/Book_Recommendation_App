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

import helper.homeadapter.LatestHelperClass;

public class l_adapter extends RecyclerView.Adapter<l_adapter.FeaturedViewHolder> {

    ArrayList<LatestHelperClass>latestbooks;

    public l_adapter(ArrayList<LatestHelperClass> latestbooks) {
        this.latestbooks = latestbooks;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        LatestHelperClass latest_helperClass = latestbooks.get(position);

        holder.image.setImageResource(latest_helperClass.getImage());
        holder.title.setText((CharSequence) latest_helperClass.getTitle());
        holder.desc.setText(latest_helperClass.getDescription());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), pf.class);
                //intent.putExtra("image", LatestHelperClass.getImage());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return latestbooks.size();

    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.l_img);
            title = itemView.findViewById(R.id.l_title);
            desc = itemView.findViewById(R.id.l_desc);
        }
    }
}
