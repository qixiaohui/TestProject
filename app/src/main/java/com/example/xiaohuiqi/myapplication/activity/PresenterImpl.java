package com.example.xiaohuiqi.myapplication.activity;

import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.example.xiaohuiqi.myapplication.model.Resturant;

import java.util.List;

public class PresenterImpl implements MainContract.presenter, MainContract.model.modelListener {
    private static final String TAG = PresenterImpl.class.getSimpleName();

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public MainContract.view view;
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public MainContract.model model;

    public PresenterImpl(MainContract.view view, MainContract.model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void onDestroy() {
        view = null;
        model = null;
    }

    @Override
    public void fetchData() {
        model.fetchData(this);
    }

    @Override
    public void onSuccess(List<Resturant> resturants) {
        view.loadView(resturants);
    }

    @Override
    public void onFailure(Throwable throwable) {
        Log.e(TAG, "Failed to load data", throwable);
        view.failLoadView();
    }
}
