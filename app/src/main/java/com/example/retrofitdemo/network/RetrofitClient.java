package network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofitClient  = null;
    private static final String baseUrl = "https://www.simplifiedcoding.net/demos/";

    private static final String baseUrlAlbum = "https://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofitClient() {
        if(retrofitClient == null) {
            retrofitClient =  new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitClient;

    }


    public static Retrofit getRetrofitAlbumClient() {
        if(retrofitClient == null) {
            retrofitClient = new Retrofit.Builder().
                    baseUrl(baseUrlAlbum).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }

        return retrofitClient;
    }
}
