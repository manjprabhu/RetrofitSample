package com.example.retrofitdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.adatpters.MarvelAdapter;

import java.util.ArrayList;
import java.util.List;

import model.Actor;
import network.RetrofitClient;
import network.RetrofitInterfce;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MarvelAdapter mMarvelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initRequest();
    }

    private void initview() {
        mMarvelAdapter = new MarvelAdapter(new ArrayList<Actor>(0),this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_actorlist);
        mRecyclerView.setAdapter(mMarvelAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initRequest() {

        RetrofitInterfce retrofitRequest = RetrofitClient.getRetrofitClient().create(RetrofitInterfce.class);

        retrofitRequest.getData().enqueue(new Callback<List<Actor>>() {
            @Override
            public void onResponse(Call<List<Actor>> call, retrofit2.Response<List<Actor>> response) {
                mMarvelAdapter.updateResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Actor>> call, Throwable t) {
            }
        });

    }
}
