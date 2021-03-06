package com.example.retrofitdemo.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.retrofitdemo.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumModel extends ViewModel {

    MutableLiveData<List<Album>> liveData;
    private final String TAG  = AlbumModel.class.getSimpleName();

    public MutableLiveData<List<Album>> getAlbumData() {
        Log.v("manju","getAlbumData");

        if(liveData == null) {
            liveData = new MutableLiveData<List<Album>>();
            loadAlbumdate();
        }
        return liveData;
    }

    private void loadAlbumdate() {

        network.RetrofitInterfce interfce = network.RetrofitClient.getRetrofitAlbumClient().create(network.RetrofitInterfce.class);
//        network.RetrofitInterfce interfce = network.RetrofitClient.getRetrofitClient().create(network.RetrofitInterfce.class);


        interfce.getAlbumData().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                Log.v(TAG,"onResponse");
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.v(TAG,"onFailure");
            }
        });
    }
}
