package com.practicos.practico2;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Libro> libroLiveData;
    private List<Libro> libros;
    Intent intent;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
      //  librosLiveData = new MutableLiveData<>();
        libros = new ArrayList<>();
        cargarLibros();
    }

    public MutableLiveData<Libro> getLibroLiveData() {
        return libroLiveData;
    }
    private void cargarLibros() {
        Libro principito = new Libro(
                "El Principito",
                "Antoine de Saint-Exupéry",
                96,
                1943,
                "Ficción",
                "Novela",
                R.drawable.principito,
                "Una fábula poética y filosófica que aborda temas como la soledad, la amistad, el amor y la pérdida."
        );

        Libro got = new Libro(
                "Game of Thrones",
                "George R. R. Martin",
                694,
                1996,
                "Fantasía",
                "Saga",
                R.drawable.got,
                "Primera novela de la saga 'Canción de hielo y fuego', que narra la lucha por el Trono de Hierro en los Siete Reinos."
        );

        Libro hobbit = new Libro(
                "El Hobbit",
                "J. R. R. Tolkien",
                310,
                1937,
                "Fantasía",
                "Novela",
                R.drawable.hobbit,
                "Una obra clásica que relata las aventuras de Bilbo Bolsón en su viaje para recuperar un tesoro custodiado por un dragón."
        );

        libros.add(principito);
        libros.add(got);
        libros.add(hobbit);
      //  librosLiveData.setValue(libros);//Actualizo el mutable con la lista de libros
    }
    public void buscarLibro(String titulo){
        intent = new Intent(getApplication(), ActivityDetalles.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle   = new Bundle();
        if(!titulo.isEmpty()){
            for(Libro libro : libros){
                if(libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                    bundle.putSerializable("libro", libro);
                    intent.putExtra("libro",bundle);
                    getApplication().startActivity(intent);
                    Log.d("mierda", "buscarLibro: " + libro.toString());
                    return;
                }
            }
            Libro libro =new Libro( "No se puedo Encontrar Libro con ese Titulo", R.drawable.libro_no_disponible);
            Log.d("mierda", "buscarLibro: " + libro.toString());
            bundle.putSerializable("libro", libro);
            intent.putExtra("libro",bundle);
            getApplication().startActivity(intent);
        }else{
            Libro libro =new Libro( "No ingresaste ningun libro " +
                    "Libro con ese Titulo", R.drawable.libro_no_disponible);
            Log.d("mierda", "buscarLibro: " + libro.toString());
            bundle.putSerializable("libro", libro);
            intent.putExtra("libro",bundle);
            getApplication().startActivity(intent);
        }
    }
}
