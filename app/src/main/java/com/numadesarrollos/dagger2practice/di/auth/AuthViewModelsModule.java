package com.numadesarrollos.dagger2practice.di.auth;

import androidx.lifecycle.ViewModel;

import com.numadesarrollos.dagger2practice.di.ViewModelKey;
import com.numadesarrollos.dagger2practice.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel authViewModel);
}
