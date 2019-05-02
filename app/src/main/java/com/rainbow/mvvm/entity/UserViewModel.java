package com.rainbow.mvvm.entity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * MVVM-Android
 * Created By Rainbow on 2019/5/2.
 */
public class UserViewModel extends ViewModel {

    private MutableLiveData<User> user;

    public LiveData<User> getUser() {
        if (user == null)
            user = new MutableLiveData<>();
        return user;
    }

    public void setUsername(String username) {
        user.setValue(new User(1, username));
    }
}
