package com.example.pistock;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pistock.model.ImageModel;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.imageViewHolder> {

    private Context context;
    private ArrayList<ImageModel>list;

    public ImageAdapter(Context context, ArrayList<ImageModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public imageViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item,parent,false);

        return new imageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ImageAdapter.imageViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getUrls().getRegular()).into(holder.imageView);

        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context,FullImage.class);
            intent.putExtra("Image",list.get(position).getUrls().getRegular());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class imageViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public imageViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


}
