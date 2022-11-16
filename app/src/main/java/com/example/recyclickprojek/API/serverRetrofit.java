package com.example.recyclickprojek.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class serverRetrofit {

    public static final String url = "http://10.0.0.2/belajarphp/TugasBesar/";
    public static Retrofit retrofit;

    public static Retrofit koneksiRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    //lisk url data json
                    .baseUrl(url)
                    //converter agar data json dapat dikenali di java
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
