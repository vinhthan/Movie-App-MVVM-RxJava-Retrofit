package com.example.moviemvvmrxjavaretrofit.data.remote;

import com.example.moviemvvmrxjavaretrofit.data.model.api.MoviePopular;
import com.example.moviemvvmrxjavaretrofit.data.model.api.MovieUpcoming;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/popular")
    Observable<MoviePopular> getMoviePopular(@Query("api_key") String api_key);

    @GET("movie/upcoming")
    Observable<MovieUpcoming> getMovieUpcoming(@Query("api_key") String api_key);

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