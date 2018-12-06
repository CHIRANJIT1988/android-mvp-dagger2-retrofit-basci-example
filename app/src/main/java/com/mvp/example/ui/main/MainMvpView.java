package com.mvp.example.ui.main;

import com.mvp.example.data.model.Movie;
import com.mvp.example.ui.base.MvpView;

import java.util.List;

public interface MainMvpView extends MvpView {

    void showData(List<Movie> data);

    void showError(String error);
}
