package com.example.recyclerview3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedPost extends AppCompatActivity {

    private ImageView imgDetailedPostImage;
    private TextView txtDetailedPostTitle, txtDetailedPostDescription;
    private Post post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_post);

        post = (Post) getIntent().getSerializableExtra(Post.KEY);

        init();
        BindDataToViews();

    }

    private void BindDataToViews (){

        imgDetailedPostImage.setImageResource(post.getImgImageID());
        txtDetailedPostTitle.setText(post.getStrTitle());
        txtDetailedPostDescription.setText(post.getStrDescription());
    }

    private void init(){

        imgDetailedPostImage = findViewById(R.id.imgImageDetailedPost);

        txtDetailedPostTitle = findViewById(R.id.txtDetailedPostTitle);
        txtDetailedPostDescription = findViewById(R.id.txtDetailedPostDescription);
    }
}