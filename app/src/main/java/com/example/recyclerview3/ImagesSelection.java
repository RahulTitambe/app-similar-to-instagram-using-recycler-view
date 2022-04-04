package com.example.recyclerview3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImagesSelection extends AppCompatActivity {

    private ImageView imageView;
    private RecyclerView recyclerView;

    int[] imagesList = {R.drawable.image_one, R.drawable.image_two, R.drawable.image_three,
                        R.drawable.image_four, R.drawable.image_five, R.drawable.image_six,
                        R.drawable.image_eight, R.drawable.image_nine, R.drawable.image_ten};

    private GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images_selection);

        init();

    }

    private void init(){

        recyclerView = findViewById(R.id.recyclerGallery);
        recyclerView.setLayoutManager( new GridLayoutManager(
                this, 3
        ));

        galleryAdapter = new GalleryAdapter(imagesList);

        galleryAdapter.setOnGalleryImageClickListener( new MyOnImageClickListener());

        recyclerView.setAdapter(galleryAdapter);
    }

    class MyOnImageClickListener implements GalleryAdapter.OnGalleryImageClickListener{
        @Override
        public void onGalleryImageClickListener(int imageId, int position) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("imageid", imageId);
            setResult(1, resultIntent);

            finish();
        }
    }
}