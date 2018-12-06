package com.mvp.example;

import android.app.Application;
import android.content.Context;

import com.mvp.example.injection.component.ApplicationComponent;
import com.mvp.example.injection.component.DaggerApplicationComponent;
import com.mvp.example.injection.module.ApplicationModule;

public class MyApplication extends Application {

    ApplicationComponent applicationComponent;


    @Override
    public void onCreate()
    {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }


    public static MyApplication get(Context context)
    {
        return (MyApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent()
    {
        return applicationComponent;
    }
}