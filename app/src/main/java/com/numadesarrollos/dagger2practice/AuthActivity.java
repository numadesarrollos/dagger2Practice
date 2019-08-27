package com.numadesarrollos.dagger2practice;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private final static String TAG = AuthActivity.class.getSimpleName();

    @Inject
    String myString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Log.i(TAG, "OnCreate() " + myString);
    }
}
