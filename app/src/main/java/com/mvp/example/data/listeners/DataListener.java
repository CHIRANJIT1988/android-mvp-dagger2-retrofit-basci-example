package com.mvp.example.data.listeners;

import com.mvp.example.data.model.Movie;

import java.util.List;

public interface DataListener {

    void onResponse(List<Movie> data);
    void onError(String error);
}