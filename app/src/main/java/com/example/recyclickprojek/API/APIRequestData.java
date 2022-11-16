package com.example.recyclickprojek.API;

import com.example.recyclickprojek.Model.responsDataBarang;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("showData.php")
    Call<responsDataBarang> ardRetriveBarang();


}
