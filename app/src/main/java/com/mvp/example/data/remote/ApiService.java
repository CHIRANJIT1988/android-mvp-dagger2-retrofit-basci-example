package com.mvp.example.data.remote;

import com.mvp.example.data.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    @GET("demos/marvel/")
    Call<List<Movie>> getMovies();
}