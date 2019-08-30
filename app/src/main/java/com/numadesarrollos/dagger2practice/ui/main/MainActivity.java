package com.numadesarrollos.dagger2practice.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.numadesarrollos.dagger2practice.BaseActivity;
import com.numadesarrollos.dagger2practice.R;
import com.numadesarrollos.dagger2practice.ui.main.profile.ProfileFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                sessionManager.logout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testFragment();
    }

    private void testFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, new ProfileFragment())
                .commit();
    }
}

