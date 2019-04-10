package network;

import com.example.retrofitdemo.model.Album;

import java.util.List;

import model.Actor;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterfce {

    @GET("marvel")
    Call<List<Actor>> getData();

    @GET("photos")
    Call<List<Album>> getAlbumData();
}
