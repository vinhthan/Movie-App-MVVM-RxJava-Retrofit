package com.example.moviemvvmrxjavaretrofit.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.moviemvvmrxjavaretrofit.R;
import com.example.moviemvvmrxjavaretrofit.data.model.api.MoviePopular;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPopular, recyclerViewUpComing;
    private List<MoviePopular.Results> mList;
    private MoviePopularAdapter mAdapter;

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
    }


    private void getMoviesPopular() {
        recyclerViewPopular = findViewById(R.id.recyclerViewPopular);
        mList = new ArrayList<>();
        mAdapter = new MoviePopularAdapter(mList, this);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewPopular.setHasFixedSize(true);
        recyclerViewPopular.setAdapter(mAdapter);

        compositeDisposable.add(model.moviesPopularBehaviorSubject.share()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieCall ->{
                    mList.addAll(movieCall.getResults());
                    if (mAdapter!=null){
                        mAdapter.notifyDataSetChanged();
                    }
                }));
        model.getMoviePopular();

    }

    private void getMovieUpcoming() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
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
