package com.numadesarrollos.dagger2practice.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.numadesarrollos.dagger2practice.SessionManager;
import com.numadesarrollos.dagger2practice.models.User;
import com.numadesarrollos.dagger2practice.ui.auth.AuthResource;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        Log.i(TAG,"ProfileViewModel() : viewModel is ready");
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser(){
        return  sessionManager.getAuthUser();
    }
}
