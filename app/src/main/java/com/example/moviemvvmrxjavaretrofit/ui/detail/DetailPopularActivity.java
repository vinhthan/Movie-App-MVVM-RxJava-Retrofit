package com.example.moviemvvmrxjavaretrofit.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviemvvmrxjavaretrofit.R;

public class DetailPopularActivity extends AppCompatActivity {
    private TextView txvTitleUp;
    private ImageView imgUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_popular);

        getIntentFromMain();
    }

    private void getIntentFromMain() {
        Intent intent = getIntent();
        String txvTitle = intent.getStringExtra("titlePopular");

    }
}
