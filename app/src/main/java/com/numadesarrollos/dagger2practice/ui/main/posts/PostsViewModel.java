package com.numadesarrollos.dagger2practice.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.numadesarrollos.dagger2practice.SessionManager;
import com.numadesarrollos.dagger2practice.network.main.MainApi;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    //Inject
    private final SessionManager sessionManager;
    private MainApi mainApi;

    @Inject
    public PostsViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;

        Log.i(TAG, "PostsViewModel: viewmodel is working...");
        

    }
}
