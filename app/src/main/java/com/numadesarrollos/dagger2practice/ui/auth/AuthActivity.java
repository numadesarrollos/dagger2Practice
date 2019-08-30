package com.numadesarrollos.dagger2practice.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.numadesarrollos.dagger2practice.R;
import com.numadesarrollos.dagger2practice.models.User;
import com.numadesarrollos.dagger2practice.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private final static String TAG = AuthActivity.class.getSimpleName();

    private EditText userId;
    private ProgressBar progressBar;

    @Inject
    ViewModelProviderFactory providerFactory;

    AuthViewModel viewModel;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        userId = findViewById(R.id.user_id_input);
        progressBar = findViewById(R.id.progress_bar);
        findViewById(R.id.login_button).setOnClickListener(this);
        viewModel = ViewModelProviders.of(this,providerFactory).get(AuthViewModel.class);
        subscribeObservers();
        setLogo();
    }

    private void subscribeObservers(){
        viewModel.observeAuthState().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if(userAuthResource != null){
                    switch (userAuthResource.status){
                        case LOADING:
                            showProgressBar(true);
                            break;
                        case ERROR:
                            Toast.makeText(AuthActivity.this,userAuthResource.message +
                                    "\n Did you enter a number between 1 and 10", Toast.LENGTH_LONG).show();
                            showProgressBar(false);
                            break;
                        case NOT_AUTHENTICATED:
                            showProgressBar(false);
                            break;
                        case AUTHENTICATED:
                            showProgressBar(false);
                            Log.i(TAG,"Login success : " + userAuthResource.data.getEmail());
                            break;
                    }
                }
            }
        });
    }

    private void showProgressBar(boolean isVisible){
        if (isVisible){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }
    private void setLogo(){
        requestManager
                .load(logo)
                .into((ImageView) findViewById(R.id.login_logo));

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.login_button:
                attemptLogin();
                break;
        }
    }

    private void attemptLogin() {
        if(TextUtils.isEmpty(userId.getText().toString())){
            return;
        }
        viewModel.authenticateWithId(Integer.valueOf(userId.getText().toString()));
    }
}
