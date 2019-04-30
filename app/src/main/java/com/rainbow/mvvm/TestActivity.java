package com.rainbow.mvvm;

import com.rainbow.latte.activity.ProxyActivity;
import com.rainbow.latte.delegate.LatteDelegate;

public class TestActivity extends ProxyActivity {
    @Override
    public LatteDelegate setRootDelegate() {
        return null;
    }
}
