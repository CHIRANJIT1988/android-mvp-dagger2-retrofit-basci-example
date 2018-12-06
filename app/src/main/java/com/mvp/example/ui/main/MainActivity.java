package com.mvp.example.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mvp.example.R;
import com.mvp.example.data.model.Movie;
import com.mvp.example.ui.adapter.MovieRecyclerAdapter;
import com.mvp.example.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainMvpView
{
    @Inject
    MainPresenter<MainMvpView> mainPresenter;

    private ProgressBar pbLoading;
    private RecyclerView recyclerView;

    private MovieRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityComponent().inject(this);
        mainPresenter.attachView(this);

        pbLoading = findViewById(R.id.pbLoading);
        recyclerView = findViewById(R.id.movieList);

        initMovieRecyclerView(recyclerView);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showData(List<Movie> data) {

        adapter.setMovieList(data);
        Toast.makeText(getApplicationContext(), "Refreshed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {

        Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        pbLoading.setVisibility(View.GONE);
    }

    public void onFetchMovies(View view)
    {
        mainPresenter.getMovies();
    }


    /**
     * Initialize movie adapter
     * @param recyclerView
     */
    private void initMovieRecyclerView(RecyclerView recyclerView)
    {
        adapter = new MovieRecyclerAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}