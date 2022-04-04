package com.example.recyclerview3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatePost extends AppCompatActivity {

    private Button btnSavePost;
    private EditText edtTitle, edtDescription;
    private TextView txtDate;
    private ImageView imgSelectImage;
    private int dayOfMonth, Month, Year;
    private int imageId = R.drawable.imageicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_post);

        init();

        btnSavePost.setOnClickListener(new OnBtnSaveClickListener());
        txtDate.setOnClickListener(new OnEdtDateClickListener());
        imgSelectImage.setOnClickListener(new OnImgSelectImageClickListener());

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = date.format(new Date());
        txtDate.setText(currentDateandTime);
        String[] sepratedDate = currentDateandTime.split("/");
        dayOfMonth = Integer.parseInt(sepratedDate[0]);
        Month = Integer.parseInt(sepratedDate[1]);
        Year = Integer.parseInt(sepratedDate[2]);

    }

    private class OnBtnSaveClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            Post post = new Post(
                    edtTitle.getText().toString(),
                    edtDescription.getText().toString(),
                    imageId
            );

            Intent resultIntent = new Intent();
            resultIntent.putExtra("post", post);
            setResult(1, resultIntent);
            finish();
        }
    }

    private class OnEdtDateClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    CreatePost.this,
                    new MyOnDateSetListener(),
                    Year,
                    Month,
                    dayOfMonth);
            datePickerDialog.show();
        }
    }

    private  class  OnImgSelectImageClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CreatePost.this, ImagesSelection.class);
            startActivityForResult(intent, 1);
        }
    }



    private class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            txtDate.setText(dayOfMonth+"/" +(month+1)+"/"+year);
        }
    }

    private void init(){

        btnSavePost = findViewById(R.id.btnSavePost);

        txtDate = findViewById(R.id.txtCreatePostSystemDate);

        imgSelectImage = findViewById(R.id.imgSelectImage);

        edtTitle = findViewById(R.id.edtCreatePostTitle);
        edtDescription = findViewById(R.id.edtCreatePostDescription);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(data == null){
            return;
        }
        imageId = data.getIntExtra("imageid",1);
        imgSelectImage.setImageResource(imageId);

        super.onActivityResult(requestCode, resultCode, data);

    }
}