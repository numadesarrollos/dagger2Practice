package com.numadesarrollos.dagger2practice.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    @Inject
    public ProfileViewModel() {
        Log.i(TAG,"ProfileViewModel() : viewModel is ready");
    }
}
