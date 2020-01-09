package com.example.moviemvvmrxjavaretrofit.data.remote;

import com.example.moviemvvmrxjavaretrofit.data.model.api.MoviePopular;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/popular")
    Observable<MoviePopular> getMoviePopular(@Query("api_key") String api_key);
}
