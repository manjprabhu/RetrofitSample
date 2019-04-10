package network;

import java.util.List;

import model.Actor;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterfce {

    @GET("marvel")
    Call<List<Actor>> getData();
}
