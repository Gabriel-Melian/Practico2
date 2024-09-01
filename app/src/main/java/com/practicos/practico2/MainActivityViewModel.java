package com.practicos.practico2;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<String> mutable;
    private List<Libro> libros;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mutable = new MutableLiveData<>();
        libros = new ArrayList<>();
        cargarLibros();
    }

    public MutableLiveData<String> getMutable() {
        return mutable;
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

        /*Libro got2 = new Libro(//Aca queria implementar lista
                "Game of Thrones Saga",
                "George R. R. Martin",
                694,
                1996,
                "Fantasía",
                "Saga",
                R.drawable.got,
                "Primera novela de la saga 'Canción de hielo y fuego', que narra la lucha por el Trono de Hierro en los Siete Reinos."
        );*/

        libros.add(principito);
        libros.add(got);
        libros.add(hobbit);
        //libros.add(got2);
    }

    public void buscarLibros(String titulo) {

        if (titulo.isEmpty()) {
            //Por si el usuario no ingresa nada
            mutable.setValue("Ingrese un libro a buscar");
            return;
        }

        Libro buscado = null;

        //for (Libro x : libros) {//Antes
            //if (x.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                //buscado = new Libro(x.getTitulo(),x.getAutor(),x.getPaginas(),x.getAnio(),x.getGenero(),x.getCategoria(),x.getFoto(),x.getDescripcion());
                //break;
            //}
        //}

        for (Libro x : libros) {//Despues
            if (x.getTitulo().equalsIgnoreCase(titulo)) {
                buscado = new Libro(x.getTitulo(),x.getAutor(),x.getPaginas(),x.getAnio(),x.getGenero(),x.getCategoria(),x.getFoto(),x.getDescripcion());
                break;
            }
        }

        if(buscado == null) {
            mutable.setValue("Libro no encontrado");
        } else {
            Bundle bundle = new Bundle();
            bundle.putSerializable("libroEncontrado", buscado);
            Intent intent = new Intent(getApplication(), ActivityDetalles.class);
            intent.putExtra("libroEncontrado", bundle);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        }
    }
}
