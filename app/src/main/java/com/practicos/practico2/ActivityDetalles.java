package com.practicos.practico2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.practicos.practico2.databinding.ActivityDetallesBinding;

public class ActivityDetalles extends AppCompatActivity {
    private ActivityDetallesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetallesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent =getIntent();
        Bundle bundle = intent.getBundleExtra("libro");
        Libro libro =(Libro) bundle.getSerializable("libro");

        binding.tvTitulo.setText(libro.getTitulo());
        binding.tvAutor.setText(libro.getAutor());
        binding.tvGenero.setText(libro.getGenero());
        binding.tvAnio.setText(libro.getAnio() +"");
        binding.tvPaginas.setText(libro.getPaginas() + "");
        binding.tvCategoria.setText(libro.getCategoria());
        binding.imageView.setImageResource(libro.getFoto());


    }
}