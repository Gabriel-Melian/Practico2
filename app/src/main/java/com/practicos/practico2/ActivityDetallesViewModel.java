package com.practicos.practico2;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ActivityDetallesViewModel extends AndroidViewModel {

    public ActivityDetallesViewModel(@NonNull Application application) {
        super(application);
    }

    public void setLibro(Bundle bundle) {
        Libro libro = (Libro) bundle.getSerializable("libroEncontrado");
    }
}
