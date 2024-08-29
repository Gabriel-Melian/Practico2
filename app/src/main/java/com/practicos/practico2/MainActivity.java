package com.practicos.practico2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.practicos.practico2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;
 //   private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
     //   intent = getIntent();
        setContentView(binding.getRoot());

//        /*coloco observer*/
//        mv.getLibroLiveData().observe(this, new Observer<Libro>(){
//            @Override
//            public void onChanged(Libro libro) {
//
//            }
//
//                });
         binding.btnId.setOnClickListener(v->{
            String libroTitulo = binding.etId.getText().toString();
            mv.buscarLibro(libroTitulo);
            Log.d("salida", "onCreate: " + libroTitulo);
        });



    }
}