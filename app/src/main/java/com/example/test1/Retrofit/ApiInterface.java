package com.example.test1.Retrofit;

import com.example.test1.Model.Getpostresponce;

import retrofit2.Call;

import retrofit2.http.POST;

public interface ApiInterface {

    @POST("http://solodigo.com/demo_api.php")
    Call<Getpostresponce> getresponcecall();

}
