package com.numadesarrollos.dagger2practice.di;

import androidx.lifecycle.ViewModelProvider;

import com.numadesarrollos.dagger2practice.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
