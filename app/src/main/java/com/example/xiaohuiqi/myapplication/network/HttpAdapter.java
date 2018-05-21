package com.example.xiaohuiqi.myapplication.network;

import com.example.xiaohuiqi.myapplication.model.Resturant;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface HttpAdapter {
    @GET("/restaurant")
    void getRestaurant(@Query("lat") double lat,
                       @Query("lng") double lng,
                       Callback<List<Resturant>> callback);
}
