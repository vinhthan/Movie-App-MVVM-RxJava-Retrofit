package com.example.moviemvvmrxjavaretrofit.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviemvvmrxjavaretrofit.R;

public class DetailUpcomingActivity extends AppCompatActivity {
    private TextView txvTitleUp, txvDesUp;
    private ImageView imgUp, imgSmalUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_upcoming);

        getIntentFromMain();
    }

    private void getIntentFromMain() {
        txvTitleUp = findViewById(R.id.txvTitleUp);
        txvDesUp = findViewById(R.id.txvDesUp);
        imgUp = findViewById(R.id.imgUp);
        imgSmalUp = findViewById(R.id.imgSmalUp);

        Intent intent = getIntent();
        String txvTitle = intent.getStringExtra("titleUpcoming");
        txvTitleUp.setText(txvTitle);

        String txvDe = intent.getStringExtra("txvDes");
        txvDesUp.setText(txvDe);

        String imgPopular = intent.getStringExtra("imageUpcoming");
        Glide.with(this).load(imgPopular).into(imgUp);

        String imgSma = intent.getStringExtra("imageUpcoming");
        Glide.with(this).load(imgSma).into(imgSmalUp);
    }
}
