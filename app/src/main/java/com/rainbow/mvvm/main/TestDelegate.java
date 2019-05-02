package com.rainbow.mvvm.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.rainbow.latte.delegate.LatteDelegate;
import com.rainbow.mvvm.R;
import com.rainbow.mvvm.databinding.DelegateTestBinding;
import com.rainbow.mvvm.entity.User;

import org.jetbrains.annotations.NotNull;

public class TestDelegate extends LatteDelegate {

    //    private TextView tvId;
//    private TextView tvName;
//    private LifecycleListener listener;
//    private UserViewModel userViewModel;
    private int id = 1;
    private DelegateTestBinding binding;

    @Override
    public Object setLayout() {
        return R.layout.delegate_test;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NotNull View rootView) {
//        listener = new LifecycleListener(getContext(), getLifecycle(), new CallBack() {
//            @Override
//            public void onSuccess(String text) {
//                LatteLogger.d(text);
//            }
//        });
//        listener.enable();
//        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
//
//        userViewModel.getUser().observe(this, user -> {
//            tvId.setText(user.getId() + "");
//            tvName.setText(user.getName());
//        });
//
//        userViewModel.setUsername("hhh");
//        android.R.color.holo_red_dark
        binding = DataBindingUtil.setContentView(getProxyActivity(), R.layout.delegate_test);
        binding.setUser(new User(id, "Rainbow"));
        binding.setDelegate(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_change:
                id++;
                binding.setUser(new User(id, "Rainbow"));
                break;
            case R.id.btn_change2:
                id = id + 2;
                binding.setUser(new User(id, "Rainbow"));
                break;
        }
    }
}
