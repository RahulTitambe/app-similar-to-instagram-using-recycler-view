package com.example.recyclerview3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private ArrayList<Post> arrPostsList;

    public  PostsAdapter (ArrayList<Post> arrPostsList){
        this.arrPostsList = arrPostsList;
    }

    public interface OnPostClickListener {
        void onLayoutClick (Post post, int position);
    }

    private OnPostClickListener onPostClickListener;

    public void setOnPostClickListener(OnPostClickListener onPostClickListener) {
        this.onPostClickListener = onPostClickListener;
    }

    class PostViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgPostImage;
        public TextView txtPostTitle, txtPostDescription;
        public ConstraintLayout constraintLayout;

        public PostViewHolder (View itemView){
            super(itemView);

            imgPostImage = itemView.findViewById(R.id.imgPrimaryPostImage);
            txtPostTitle = itemView.findViewById(R.id.txtPrimaryPostTitle);
            txtPostDescription = itemView.findViewById(R.id.txtPrimaryPostDescription);
            constraintLayout = itemView.findViewById(R.id.constraintPrimaryPost);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onPostClickListener != null){
                        onPostClickListener.onLayoutClick(
                                arrPostsList.get(getAdapterPosition()),
                                getAdapterPosition());
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return  arrPostsList.size();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.primary_post, null);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        Post post = arrPostsList.get(position);

        holder.imgPostImage.setImageResource(post.getImgImageID());
        holder.txtPostTitle.setText(post.getStrTitle());
        holder.txtPostDescription.setText(post.getStrDescription());
    }
}
