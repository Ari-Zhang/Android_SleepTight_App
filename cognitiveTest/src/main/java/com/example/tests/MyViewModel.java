package com.example.tests;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    SavedStateHandle handle;
    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
    }
}
