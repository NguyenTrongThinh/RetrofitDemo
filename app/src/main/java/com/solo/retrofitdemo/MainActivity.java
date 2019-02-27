package com.solo.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.solo.retrofitdemo.retrofit.Contributor;
import com.solo.retrofitdemo.retrofit.GitHub;
import com.solo.retrofitdemo.retrofit.RetrofitBase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GitHub gitHub = RetrofitBase.getClient().create(GitHub.class);
        Call<List<Contributor>> call = gitHub.contributors("square", "retrofit");
        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                List<Contributor> contributors = response.body();
                for (Contributor contributor : contributors) {
                    Log.d("AAA", contributor.getLogin() + " " + contributor.getHtmlUrl());
                }
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
