package com.mvp.example.injection.module;

import android.app.Activity;
import android.content.Context;

import com.mvp.example.injection.annotation.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity)
    {
        this.activity = activity;
    }


    @Provides
    Activity activityModule()
    {
        return activity;
    }

    @Provides
    @ActivityContext
    Context activityContext()
    {
        return activity;
    }
}