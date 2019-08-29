package com.numadesarrollos.dagger2practice.network.auth;

import com.numadesarrollos.dagger2practice.models.User;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    @GET("users/{id}")
    Flowable<User> getUser(@Path("id") int id);
}
