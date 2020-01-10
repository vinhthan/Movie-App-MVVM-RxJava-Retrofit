package com.example.moviemvvmrxjavaretrofit.ui.home;

import android.annotation.SuppressLint;
import android.util.Log;
import com.example.moviemvvmrxjavaretrofit.data.model.api.Constants;
import com.example.moviemvvmrxjavaretrofit.data.model.api.MoviePopular;
import com.example.moviemvvmrxjavaretrofit.data.model.api.MovieUpcoming;
import com.example.moviemvvmrxjavaretrofit.data.remote.ApiManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class MovieViewModel {

    private ApiManager apiManager;

    public BehaviorSubject<MoviePopular> moviesPopularBehaviorSubject;
    public BehaviorSubject<MovieUpcoming> movieUpcomingBehaviorSubject;

    public MovieViewModel() {
        moviesPopularBehaviorSubject = BehaviorSubject.create();
        movieUpcomingBehaviorSubject = BehaviorSubject.create();
        apiManager = new ApiManager();
    }

    @SuppressLint("CheckResult")
    public void getMoviePopular(){
        apiManager.getMoviePopular(Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(moviePopular -> {
                    moviesPopularBehaviorSubject.onNext(moviePopular);
                }, errorPopular ->{
                    Log.d("TAG", "getMovies: " + errorPopular);
                });

    }

    @SuppressLint("CheckResult")
    public void getMovieUpcoming(){
        apiManager.getMovieUpcoming(Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieUpcoming -> {
                    movieUpcomingBehaviorSubject.onNext(movieUpcoming);
                }, errorUp -> {
                    Log.d("TAG", "getMovies: " + errorUp);
                });
    }

}
