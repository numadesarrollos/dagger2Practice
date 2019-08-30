package com.numadesarrollos.dagger2practice.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.numadesarrollos.dagger2practice.BaseActivity;
import com.numadesarrollos.dagger2practice.R;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

