package com.rainbow.latte.delegate;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rainbow.latte.activity.ProxyActivity;

import org.jetbrains.annotations.NotNull;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Latte-Core
 * Created By Rainbow on 2019/4/30.
 */
public abstract class BaseDelegate extends SwipeBackFragment {

    private View mRootView = null;

    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState, @NotNull View rootView);

    public <T extends View> T $(@IdRes int viewId) {
        if (mRootView != null) {
            return mRootView.findViewById(viewId);
        }
        throw new NullPointerException("rootView is null");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }
        if (rootView != null) {
            mRootView = rootView;
            onBindView(savedInstanceState, rootView);
        }
        return attachToSwipeBack(rootView);
    }

    public final ProxyActivity getProxyActivity() {
        return (ProxyActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
