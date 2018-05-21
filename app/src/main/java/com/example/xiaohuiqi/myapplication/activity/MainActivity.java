package com.example.xiaohuiqi.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.xiaohuiqi.myapplication.R;
import com.example.xiaohuiqi.myapplication.adapter.ViewAdapter;
import com.example.xiaohuiqi.myapplication.model.Resturant;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.view {
    private PresenterImpl presenter;
    private ModelImpl model;

    private RecyclerView recyclerView;
    private ViewAdapter viewAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        viewAdapter = new ViewAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        init();
    }

    private void init() {
        model = new ModelImpl();
        presenter = new PresenterImpl(this, model);
        presenter.fetchData();
    }

    @Override
    public void loadView(List<Resturant> resturants) {
        if (recyclerView != null) {
            viewAdapter.addData(resturants);
        }
    }

    @Override
    public void failLoadView() {
        Toast.makeText(this, "Failed to load data", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
