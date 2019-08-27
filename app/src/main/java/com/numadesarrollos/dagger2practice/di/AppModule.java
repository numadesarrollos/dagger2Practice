package com.numadesarrollos.dagger2practice.di;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static String someSring(){
        return "this is a test String";
    }

}
