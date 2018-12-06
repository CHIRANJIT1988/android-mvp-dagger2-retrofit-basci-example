package com.mvp.example.data;

import com.mvp.example.data.listeners.DataListener;
import com.mvp.example.data.local.PreferencesHelper;
import com.mvp.example.data.model.Movie;
import com.mvp.example.data.remote.ApiService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@Singleton
public class DataManager
{
    private PreferencesHelper helper;
    private ApiService service;

    @Inject
    public DataManager(PreferencesHelper helper, ApiService service)
    {
        this.helper = helper;
        this.service = service;
    }

    public void getMovies(final DataListener listener)
    {
        Call<List<Movie>> call = service.getMovies();

        call.enqueue(new Callback<List<Movie>>() {

            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response)
            {
                if (response.isSuccessful())
                {
                    listener.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t)
            {

            }
        });
    }
}