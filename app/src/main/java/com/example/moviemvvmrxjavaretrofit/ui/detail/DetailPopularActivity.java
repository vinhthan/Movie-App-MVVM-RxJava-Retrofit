package com.example.moviemvvmrxjavaretrofit.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviemvvmrxjavaretrofit.R;

public class DetailPopularActivity extends AppCompatActivity {
    private TextView txvTitlePupular, txvDes;
    private ImageView imgPopula, imgSmal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_popular);

        getIntentFromMain();
    }

    private void getIntentFromMain() {
        txvTitlePupular = findViewById(R.id.txvTitlePopular);
        txvDes = findViewById(R.id.txvDescription);
        imgPopula = findViewById(R.id.imgpopular);
        imgSmal = findViewById(R.id.imgSmalUp);

        Intent intent = getIntent();
        String txvTitle = intent.getStringExtra("titlePopular");
        txvTitlePupular.setText(txvTitle);

        String txvDe = intent.getStringExtra("txvDes");
        txvDes.setText(txvDe);

        String imgPopular = intent.getStringExtra("imagePopular");
        Glide.with(this).load(imgPopular).into(imgPopula);

        String imgSma = intent.getStringExtra("imagePopular");
        Glide.with(this).load(imgSma).into(imgSmal);

    }
}
