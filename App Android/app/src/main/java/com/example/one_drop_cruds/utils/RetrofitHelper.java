package com.example.one_drop_cruds.utils;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    SharedPrefManager sharedPrefManager;
    String baseUrl = new BackendUrl().getBackendUrl();
    String token;

    public RetrofitHelper(String token) {
        this.token = token;
    }

    public RetrofitHelper() {
    }

    public Retrofit getRetrofitHelper(){
        HttpLoggingInterceptor recordInterceptor = new HttpLoggingInterceptor();
        recordInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS);
        httpClient.addInterceptor(recordInterceptor);

        return new Retrofit.Builder()
                .baseUrl(baseUrl) // +"/auth/register/"
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }
    public Retrofit getRetrofitHelperWithToken(){
        HttpLoggingInterceptor recordInterceptor = new HttpLoggingInterceptor();
        recordInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS);
        httpClient.addInterceptor(recordInterceptor);

        // interceptor para agregar el token al header
        httpClient.addInterceptor(chain -> {
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder();
            if (token!= null &&!token.isEmpty()) {
                builder.header("Authorization", "Bearer " + token);
            }
            return chain.proceed(builder.build());
        });
        return new Retrofit.Builder()
                .baseUrl(baseUrl) // +"/auth/register/"
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
