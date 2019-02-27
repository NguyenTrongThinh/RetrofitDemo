package com.solo.retrofitdemo.retrofit;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBase {
    public static final String API_URL = "https://api.github.com";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                    .readTimeout(10, TimeUnit.SECONDS)
                                    .writeTimeout(10, TimeUnit.SECONDS)
                                    .connectTimeout(10, TimeUnit.SECONDS)
                                    .retryOnConnectionFailure(true)
                                    .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
