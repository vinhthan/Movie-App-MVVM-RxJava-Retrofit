package com.example.moviemvvmrxjavaretrofit.data.remote;

import com.example.moviemvvmrxjavaretrofit.data.model.api.MoviePopular;
import com.example.moviemvvmrxjavaretrofit.data.model.api.MovieUpcoming;

import io.reactivex.Observable;

public class ApiManager {
    private ApiInterface apiInterface;

    public ApiManager() {
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
    }

    public Observable<MoviePopular> getMoviePopular(String API_KEY){
        return apiInterface.getMoviePopular(API_KEY);
    }

    public Observable<MovieUpcoming> getMovieUpcoming(String API_KEY){
        return apiInterface.getMovieUpcoming(API_KEY);
    }
}
