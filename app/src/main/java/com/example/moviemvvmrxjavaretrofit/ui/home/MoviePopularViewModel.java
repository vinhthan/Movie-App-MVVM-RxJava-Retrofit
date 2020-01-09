package com.example.moviemvvmrxjavaretrofit.ui.home;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.moviemvvmrxjavaretrofit.data.model.api.Constants;
import com.example.moviemvvmrxjavaretrofit.data.model.api.MoviePopular;
import com.example.moviemvvmrxjavaretrofit.data.remote.ApiManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class MoviePopularViewModel {

    private ApiManager apiManager;

    public BehaviorSubject<MoviePopular> moviesBehaviorSubject;

    public MoviePopularViewModel() {
        moviesBehaviorSubject = BehaviorSubject.create();
        apiManager = new ApiManager();
    }

    @SuppressLint("CheckResult")
    public void getMoviePopular(){
        apiManager.getMoviePopular(Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(moviePopular -> {
                    moviesBehaviorSubject.onNext(moviePopular);
                }, error ->{
                    Log.d("TAG", "getMovies: " + error);
                });

    }
}
