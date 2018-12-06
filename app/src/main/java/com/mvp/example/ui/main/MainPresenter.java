package com.mvp.example.ui.main;

import android.content.Context;

import com.mvp.example.data.DataManager;
import com.mvp.example.data.listeners.DataListener;
import com.mvp.example.data.model.Movie;
import com.mvp.example.injection.annotation.ActivityContext;
import com.mvp.example.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;


public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V>
{

    private final DataManager dataManager;
    private final Context context;


    @Inject
    public MainPresenter(DataManager dataManager, @ActivityContext Context context)
    {
        this.dataManager = dataManager;
        this.context = context;
    }

    @Override
    public void getMovies()
    {
        getMvpView().showLoading();

        dataManager.getMovies(new DataListener() {

            @Override
            public void onResponse(List<Movie> data) {

                getMvpView().hideLoading();
                getMvpView().showData(data);
            }

            @Override
            public void onError(String error) {

                getMvpView().hideLoading();
                getMvpView().showError(error);
            }
        });
    }
}