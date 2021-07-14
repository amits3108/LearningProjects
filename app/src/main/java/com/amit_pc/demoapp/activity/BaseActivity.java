package com.amit_pc.demoapp.activity;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by amit_pc on 23-09-2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract void getId();
    public abstract void setData();
    public abstract void setListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        getId();
        setListener();
        setData();
    }

    //NOTE: IN abstract class static method also declare but those are should be the no-abstract method.
    public static void setMoto(){

    }
}
