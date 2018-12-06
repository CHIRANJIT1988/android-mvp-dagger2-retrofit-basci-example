package com.mvp.example.ui.main;

import com.mvp.example.ui.base.MvpPresenter;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V>
{
    void getMovies();
}
