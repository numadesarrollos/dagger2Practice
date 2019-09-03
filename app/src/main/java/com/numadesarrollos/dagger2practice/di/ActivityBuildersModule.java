package com.numadesarrollos.dagger2practice.di;

import com.numadesarrollos.dagger2practice.di.auth.AuthModule;
import com.numadesarrollos.dagger2practice.di.auth.AuthScope;
import com.numadesarrollos.dagger2practice.di.auth.AuthViewModelsModule;
import com.numadesarrollos.dagger2practice.di.main.MainFragmentBuildersModule;
import com.numadesarrollos.dagger2practice.di.main.MainModule;
import com.numadesarrollos.dagger2practice.di.main.MainScope;
import com.numadesarrollos.dagger2practice.di.main.MainViewModelsModule;
import com.numadesarrollos.dagger2practice.ui.auth.AuthActivity;
import com.numadesarrollos.dagger2practice.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = {AuthViewModelsModule.class,
                AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class,
                        MainViewModelsModule.class,
                        MainModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
