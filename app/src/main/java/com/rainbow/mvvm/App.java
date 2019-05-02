package com.rainbow.mvvm;

import android.app.Application;

import com.rainbow.latte.app.Latte;

/**
 * MVVM-Android
 * Created By Rainbow on 2019/5/2.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .debug(false)
                .configure();
    }
}
