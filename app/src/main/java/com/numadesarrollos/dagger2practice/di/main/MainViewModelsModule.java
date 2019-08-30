package com.numadesarrollos.dagger2practice.di.main;

import androidx.lifecycle.ViewModel;

import com.numadesarrollos.dagger2practice.di.ViewModelKey;
import com.numadesarrollos.dagger2practice.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel profileViewModel);
}
