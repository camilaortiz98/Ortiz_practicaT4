package com.camila.ortiz.vid20221;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Servicio {

    @GET("camianime")
    Call<List<animeClass>> listaAnimes();
}
