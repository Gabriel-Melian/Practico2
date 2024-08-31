package com.practicos.practico2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.practicos.practico2.databinding.ActivityDetallesBinding;

public class ActivityDetalles extends AppCompatActivity {

    private ActivityDetallesBinding binding;
    private ActivityDetallesViewModel mv;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = getIntent();
        bundle = intent.getBundleExtra("libroEncontrado");
        binding = ActivityDetallesBinding.inflate(getLayoutInflater());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ActivityDetallesViewModel.class);

        Libro libro = (Libro) bundle.getSerializable("libroEncontrado");
        binding.imageView.setImageResource(libro.getFoto());
        binding.tvAutor.setText(libro.getAutor());
        binding.tvTitulo.setText(libro.getTitulo());
        binding.tvAnio.setText(String.valueOf(libro.getAnio()));
        binding.tvPaginas.setText(String.valueOf(libro.getPaginas()));
        binding.tvCategoria.setText(libro.getCategoria());
        binding.tvGenero.setText(libro.getGenero());
        binding.tvDescripcion.setText(libro.getDescripcion());

        binding.btnVolverId.setOnClickListener(v -> {
            finish();
        });

        mv.setLibro(bundle);
        setContentView(binding.getRoot());

    }
}