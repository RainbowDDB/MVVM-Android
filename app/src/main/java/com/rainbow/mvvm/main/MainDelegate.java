package com.rainbow.mvvm.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.rainbow.latte.delegate.LatteDelegate;
import com.rainbow.mvvm.R;

import org.jetbrains.annotations.NotNull;

public class MainDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NotNull View rootView) {

    }
}
