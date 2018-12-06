package com.mvp.example.injection.module;

import android.app.Application;
import android.content.Context;

import com.mvp.example.injection.annotation.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule
{
    private final Application application;

    public ApplicationModule(Application application)
    {
        this.application = application;
    }

    @Provides
    Application provideApplication()
    {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext()
    {
        return application;
    }
}