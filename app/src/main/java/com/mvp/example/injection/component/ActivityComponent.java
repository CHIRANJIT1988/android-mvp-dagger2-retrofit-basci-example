package com.mvp.example.injection.component;

import android.content.Context;

import com.mvp.example.injection.annotation.ActivityContext;
import com.mvp.example.injection.annotation.PerActivity;
import com.mvp.example.injection.module.ActivityModule;
import com.mvp.example.ui.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    @ActivityContext
    Context context();
}