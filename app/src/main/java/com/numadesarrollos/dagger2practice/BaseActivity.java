package com.numadesarrollos.dagger2practice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.numadesarrollos.dagger2practice.models.User;
import com.numadesarrollos.dagger2practice.ui.auth.AuthActivity;
import com.numadesarrollos.dagger2practice.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();

    }

    private void subscribeObservers(){
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                        if(userAuthResource != null){
                            switch (userAuthResource.status){
                                case LOADING:
                                    break;
                                case ERROR:
                                    Toast.makeText(BaseActivity.this,userAuthResource.message +
                                            "\n Did you enter a number between 1 and 10", Toast.LENGTH_LONG).show();
                                    break;
                                case NOT_AUTHENTICATED:
                                    navToLoginScreen();
                                    break;
                                case AUTHENTICATED:
                                    Log.i(TAG,"Login success : " + userAuthResource.data.getEmail());
                                    break;
                            }
                        }
                    }
        });
    }

    private void navToLoginScreen(){
        Intent intent = new Intent(this,AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
