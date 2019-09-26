package com.example.test1.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
 
    public static final String BASE_URL = "http://solodigo.com/demo_api.php/";
    private static Retrofit retrofit = null;
 
 
    public static  synchronized Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}


