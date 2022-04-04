package com.example.recyclerview3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryImageViewHolder> {

    private int[] imagesList;

    public interface OnGalleryImageClickListener {
        public void onGalleryImageClickListener(int imageId, int position);
    }

    private OnGalleryImageClickListener onGalleryImageClickListener;
    public void setOnGalleryImageClickListener(OnGalleryImageClickListener onGalleryImageClickListener){
        this.onGalleryImageClickListener = onGalleryImageClickListener;
    }

    public GalleryAdapter(int[] imagesList) {
        this.imagesList = imagesList;
    }

    public class GalleryImageViewHolder extends RecyclerView.ViewHolder{

        ImageView imgGalleryImage;

        public GalleryImageViewHolder(View itemView) {

            super(itemView);
            imgGalleryImage = (ImageView) itemView;

            imgGalleryImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onGalleryImageClickListener != null){
                        onGalleryImageClickListener.onGalleryImageClickListener(
                                imagesList[getAdapterPosition()],
                                getAdapterPosition()
                        );
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return imagesList.length;
    }

    @NonNull
    @Override
    public GalleryImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.gallery_image, null);

        return new GalleryImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryImageViewHolder holder, int position) {

        holder.imgGalleryImage.setImageResource(imagesList[position]);

    }
}
