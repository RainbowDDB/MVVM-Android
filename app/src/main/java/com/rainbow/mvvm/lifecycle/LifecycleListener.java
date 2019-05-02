package com.rainbow.mvvm.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

import com.rainbow.latte.util.logger.LatteLogger;

/**
 * MVVM-Android
 * 接管Activity和Fragment的生命周期
 * Created By Rainbow on 2019/5/2.
 */
public class LifecycleListener implements LifecycleObserver {

    private final Context mContext;
    private final Lifecycle mLifecycle;
    private final CallBack mCallBack;
    private boolean enabled = false;

    public LifecycleListener(Context context, Lifecycle lifecycle, CallBack callBack) {
        this.mContext = context;
        this.mLifecycle = lifecycle;
        this.mCallBack = callBack;
    }

    public void enable() {
        enabled = true;
        mLifecycle.addObserver(this);
        if (mLifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
            mCallBack.onSuccess("enable");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void create() {
        LatteLogger.d("onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        if (enabled) {
            // connect
            LatteLogger.d("onStart");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        // disconnect if connected
        LatteLogger.d("onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void destroy() {
        LatteLogger.d("onDestroy");
    }
}
