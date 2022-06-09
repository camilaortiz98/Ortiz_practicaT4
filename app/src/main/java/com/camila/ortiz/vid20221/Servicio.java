package com.camila.ortiz.vid20221;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Servicio {

    @GET("Anime")
    Call<List<animeClass>> listaAnimes();

    @POST("Anime")
    Call<Void> crear(@Body animeClass animeClass);

    @Headers({"Content-Type: application/json"})
    @PUT("Anime/{id}")
   // Call<animeClass> getAnimeEdit(@Path("id") String id,@Body animeClass animeClass);
    Call<ResponseBody> updateUser(@Path("id") String id, @Body animeClass body);
}
