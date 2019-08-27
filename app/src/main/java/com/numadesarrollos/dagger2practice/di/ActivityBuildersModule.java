package com.numadesarrollos.dagger2practice.di;

import com.numadesarrollos.dagger2practice.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();
}
