package com.example.retrofitdemo.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.adatpters.AlbumAdapter;
import com.example.retrofitdemo.adatpters.MarvelAdapter;
import com.example.retrofitdemo.databinding.ActivityMainBinding;
import com.example.retrofitdemo.model.Album;
import com.example.retrofitdemo.viewmodel.AlbumModel;

import java.util.ArrayList;
import java.util.List;

import model.Actor;
import network.RetrofitClient;
import network.RetrofitInterfce;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MarvelAdapter mMarvelAdapter;
    private AlbumAdapter mAlbumAdapter;

    private ActivityMainBinding binding;

    private AlbumModel albumModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        binding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.activity_main,null, true);

        albumModel = ViewModelProviders.of(this).get(AlbumModel.class);

        initview();
        initRequest();
//        initAlbumRequest();

//        albumModel.getAlbumData().observe(this, new Observer<List<Album>>() {
//            @Override
//            public void onChanged(@Nullable List<Album> albumList) {
//                mAlbumAdapter.updateAlbumList(albumList);
//            }
//        });
    }

    private void initview() {
        mMarvelAdapter = new MarvelAdapter(new ArrayList<Actor>(0),this);
        mAlbumAdapter = new AlbumAdapter(this, new ArrayList<Album>(0));

//        binding.rvActorlist.setAdapter(mAlbumAdapter);
//        binding.rvActorlist.setLayoutManager(new LinearLayoutManager(this));


        mRecyclerView = (RecyclerView) findViewById(R.id.rv_actorlist);
        mRecyclerView.setAdapter(mMarvelAdapter);
//        mRecyclerView.setAdapter(mAlbumAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAlbumRequest() {

        RetrofitInterfce retrofitInterfce = RetrofitClient.getRetrofitAlbumClient().create(RetrofitInterfce.class);

        retrofitInterfce.getAlbumData().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
               mAlbumAdapter.updateAlbumList(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
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
                Log.v("manju","failure");
            }
        });

    }
}
