package com.example.xiaohuiqi.myapplication.activity;

import com.example.xiaohuiqi.myapplication.model.Resturant;

import java.util.List;

public interface MainContract {
    interface presenter {
        void onDestroy();
        void fetchData();
    }

    interface view {
        void loadView(List<Resturant> resturants);
        void failLoadView();
    }

    interface model {
        void fetchData(modelListener modelListener);

        interface modelListener {
            void onSuccess(List<Resturant> resturants);
            void onFailure(Throwable throwable);
        }
    }
}
