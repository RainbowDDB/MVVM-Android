package com.rainbow.mvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.rainbow.latte.activity.ProxyActivity;
import com.rainbow.latte.delegate.LatteDelegate;
import com.rainbow.mvvm.main.MainDelegate;

import qiu.niorgai.StatusBarCompat;

public class TestActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.setStatusBarColor(
                this, ContextCompat.getColor(this, R.color.colorPrimary));
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new MainDelegate();
    }
}
