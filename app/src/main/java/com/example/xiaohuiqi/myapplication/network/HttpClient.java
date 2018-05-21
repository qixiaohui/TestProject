package com.example.xiaohuiqi.myapplication.network;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class HttpClient {
    private static final String BASE_URL = "https://api.doordash.com/v2/";

    public static HttpAdapter getHttpAdapter() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(SelfSigningClientBuilder.createClient()))
                .build();
        return restAdapter.create(HttpAdapter.class);
    }
}
