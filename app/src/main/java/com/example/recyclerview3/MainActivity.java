package com.example.recyclerview3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Post> postsList;
    private RecyclerView recyclerPosts;
    private PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.meny_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuAddProduct) {
            //start add product activity
            startCreatePostActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void startCreatePostActivity (){
        Intent intent = new Intent(MainActivity.this, CreatePost.class);
        startActivityForResult(intent, 1);
    }

    private  void init(){

        postsList = new ArrayList<Post>();
        recyclerPosts = findViewById(R.id.recyclerPosts);

        recyclerPosts.setLayoutManager( new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));

        postsAdapter = new PostsAdapter(postsList);
        recyclerPosts.setAdapter(postsAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {
            Post newPost = (Post) data.getSerializableExtra("post");
            postsList.add(newPost);
            postsAdapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}