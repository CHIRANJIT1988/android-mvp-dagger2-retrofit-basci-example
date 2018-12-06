package com.mvp.example.injection.component;

import android.content.Context;

import com.mvp.example.MyApplication;
import com.mvp.example.data.DataManager;
import com.mvp.example.injection.annotation.ApplicationContext;
import com.mvp.example.injection.module.ApplicationModule;
import com.mvp.example.injection.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(MyApplication mApplication);


    @ApplicationContext
    Context context();

    DataManager dataManager();
}