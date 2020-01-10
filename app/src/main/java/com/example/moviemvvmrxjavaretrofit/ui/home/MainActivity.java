package com.example.moviemvvmrxjavaretrofit.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.moviemvvmrxjavaretrofit.R;
import com.example.moviemvvmrxjavaretrofit.data.model.api.MoviePopular;
import com.example.moviemvvmrxjavaretrofit.data.model.api.MovieUpcoming;
import com.example.moviemvvmrxjavaretrofit.ui.detail.DetailPopularActivity;
import com.example.moviemvvmrxjavaretrofit.ui.detail.DetailUpcomingActivity;
import com.example.moviemvvmrxjavaretrofit.ui.home.adapter.ItemClickListenerPopular;
import com.example.moviemvvmrxjavaretrofit.ui.home.adapter.ItemClickListenerUpcoming;
import com.example.moviemvvmrxjavaretrofit.ui.home.adapter.MoviePopularAdapter;
import com.example.moviemvvmrxjavaretrofit.ui.home.adapter.MovieUpcomingAdapter;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ItemClickListenerPopular, ItemClickListenerUpcoming {
    private ImageView imgLeft, imgRight;
    private RecyclerView recyclerViewPopular, recyclerViewUpComing;
    private List<MoviePopular.Results> mPopularList;
    private List<MovieUpcoming.Results> mUpcomingList;
    private MoviePopularAdapter mPopularAdapter;
    private MovieUpcomingAdapter mUpcomingAdapter;
    private CompositeDisposable compositeDisposable;
    private MovieViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();
        model = new MovieViewModel();

        getMoviesPopular();

        getMovieUpcoming();

        hideShowLeftRight();




    }


    private void getMoviesPopular() {
        recyclerViewPopular = findViewById(R.id.recyclerViewPopular);
        mPopularList = new ArrayList<>();//thu tu khai bao phai dung truoc sau
        mPopularAdapter = new MoviePopularAdapter(mPopularList, this, this::onClickPopular);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewPopular.setHasFixedSize(true);
        recyclerViewPopular.setAdapter(mPopularAdapter);

        compositeDisposable.add(model.moviesPopularBehaviorSubject.share()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(moviePopular ->{
                    mPopularList.addAll(moviePopular.getResults());
                    if (mPopularAdapter !=null){
                        mPopularAdapter.notifyDataSetChanged();
                    }
                }));
        model.getMoviePopular();

    }

    private void getMovieUpcoming() {
        recyclerViewUpComing = findViewById(R.id.recyclerViewUpComing);
        mUpcomingList = new ArrayList<>();//thu tu khai bao phai dung truoc sau
        mUpcomingAdapter = new MovieUpcomingAdapter(mUpcomingList, this, this::onClickUpcoming);
        recyclerViewUpComing.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewUpComing.setHasFixedSize(true);
        recyclerViewUpComing.setAdapter(mUpcomingAdapter);

        compositeDisposable.add(model.movieUpcomingBehaviorSubject.share()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(movieUpcoming -> {
            mUpcomingList.addAll(movieUpcoming.getResults());
            if (mUpcomingAdapter!= null){
                mUpcomingAdapter.notifyDataSetChanged();
            }
        }));
        model.getMovieUpcoming();
    }

    //hide show image Left Right
    private void hideShowLeftRight() {
        imgLeft = findViewById(R.id.imgLeft);
        imgRight = findViewById(R.id.imgRight);
        recyclerViewUpComing.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                //int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();
                int firstVisible = layoutManager.findFirstVisibleItemPosition();

                if (lastVisible == mUpcomingList.size() - 1){
                    imgRight.setVisibility(View.GONE);
                }else {
                    imgRight.setVisibility(View.VISIBLE);
                }

                if (firstVisible == 0){
                    imgLeft.setVisibility(View.GONE);
                }else {
                    imgLeft.setVisibility(View.VISIBLE);
                }

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }


    @Override
    public void onClickPopular(int position) {
        MoviePopular.Results moviePopular = mPopularList.get(position);
        //Toast.makeText(this, "Position "+position, Toast.LENGTH_SHORT).show();
        Intent intentPopular = new Intent(MainActivity.this, DetailPopularActivity.class);
        intentPopular.putExtra("titlePopular", moviePopular.getTitle());
        intentPopular.putExtra("txvDes", moviePopular.getOverview());
        intentPopular.putExtra("imagePopular", moviePopular.getBackdropPath());
        //


        startActivity(intentPopular);
    }

    @Override
    public void onClickUpcoming(int position) {
        MovieUpcoming.Results movieUpcoming = mUpcomingList.get(position);
        //Toast.makeText(this, "Position "+position, Toast.LENGTH_SHORT).show();
        Intent intentUpcoming = new Intent(MainActivity.this, DetailUpcomingActivity.class);
        intentUpcoming.putExtra("titleUpcoming", movieUpcoming.getTitle());
        intentUpcoming.putExtra("imageUpcoming", movieUpcoming.getBackdropPath());



        startActivity(intentUpcoming);
    }
}
//api key:
//034bbd1b233d6726e0c7dc7f338657f9
//
//URL:
//https://api.themoviedb.org/3/movie/popular?api_key=034bbd1b233d6726e0c7dc7f338657f9
//
//Upcoming movie
//https://api.themoviedb.org/3/movie/upcoming?api_key=034bbd1b233d6726e0c7dc7f338657f9
//poster
//https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg
