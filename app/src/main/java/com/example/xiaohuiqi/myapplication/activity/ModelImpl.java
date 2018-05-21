package com.example.xiaohuiqi.myapplication.activity;

import com.example.xiaohuiqi.myapplication.model.Resturant;
import com.example.xiaohuiqi.myapplication.network.HttpAdapter;
import com.example.xiaohuiqi.myapplication.network.HttpClient;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ModelImpl implements MainContract.model {

    @Override
    public void fetchData(final modelListener modelListener) {
        HttpAdapter httpAdapter = HttpClient.getHttpAdapter();
        httpAdapter.getRestaurant(37.422740, -122.139956, new Callback<List<Resturant>>() {
            @Override
            public void success(List<Resturant> resturants, Response response) {
                modelListener.onSuccess(resturants);
            }

            @Override
            public void failure(RetrofitError error) {
                modelListener.onFailure(error);
            }
        });
    }
}
