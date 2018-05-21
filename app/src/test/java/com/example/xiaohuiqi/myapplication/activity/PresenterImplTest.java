package com.example.xiaohuiqi.myapplication.activity;

import android.util.Log;

import com.example.xiaohuiqi.myapplication.model.Resturant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Log.class})
public class PresenterImplTest {

    @Mock
    private MainContract.view view;
    @Mock
    private ModelImpl model;
    private PresenterImpl presenter;

    private List<Resturant> resturants = new ArrayList<>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new PresenterImpl(view, model);
        PowerMockito.mockStatic(Log.class);
    }

    @Test
    public void onDestroy() {
        presenter.onDestroy();
        assertNull(presenter.view);
        assertNull(presenter.model);
    }

    @Test
    public void fetchData() {
        presenter.fetchData();
        Mockito.verify(model, Mockito.times(1)).fetchData(presenter);
    }

    @Test
    public void onSuccess() {
        presenter.onSuccess(resturants);
        Mockito.verify(view, Mockito.times(1)).loadView(resturants);
    }

    @Test
    public void onFailure() {
        Throwable throwable = new Throwable();
        presenter.onFailure(throwable);
        Mockito.verify(view, Mockito.times(1)).failLoadView();
    }
}