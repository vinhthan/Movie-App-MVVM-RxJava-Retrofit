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
    private RecyclerView recyclerView;
    private List<MoviePopular.Results> mList;
    private MoviePopularAdapter mAdapter;

    private CompositeDisposable compositeDisposable;
    private MoviePopularViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();
        model = new MoviePopularViewModel();
        getMovies();
    }

    private void getMovies() {
        recyclerView = findViewById(R.id.recyclerView);
        mList = new ArrayList<>();
        mAdapter = new MoviePopularAdapter(mList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        compositeDisposable.add(model.moviesBehaviorSubject.share()
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
//poster
//https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg
