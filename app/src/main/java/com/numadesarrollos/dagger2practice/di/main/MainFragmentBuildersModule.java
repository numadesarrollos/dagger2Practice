package com.numadesarrollos.dagger2practice.di.main;

import com.numadesarrollos.dagger2practice.ui.main.posts.PostsFragment;
import com.numadesarrollos.dagger2practice.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();
}
