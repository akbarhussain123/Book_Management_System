package com.adevelopercompany.bookmanagementsystem.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adevelopercompany.bookmanagementsystem.R;
import com.adevelopercompany.bookmanagementsystem.entities.EntityImages;
import com.adevelopercompany.bookmanagementsystem.viewModels.ViewModelBookImages;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterBookImages extends RecyclerView.Adapter<AdapterBookImages.ViewHolder> {
    Context ctx;
    List<EntityImages> imagesList;
    ViewModelBookImages viewModelBookImages;
    private int lastPosition = -1;
    public AdapterBookImages(Context ctx, List<EntityImages> imagesList, ViewModelBookImages viewModelBookImages) {
        this.ctx = ctx;
        this.imagesList = imagesList;
        this.viewModelBookImages = viewModelBookImages;

    }

    public void refreshAdapter(List<EntityImages> newList) {
        imagesList = newList;
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.card_classes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        EntityImages entityImages = imagesList.get(position);

        byte[] image = entityImages.getImage();
        Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
        holder.imageView.setImageBitmap(bmp);
        setAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv);

        }
    }
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(ctx, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
}}
