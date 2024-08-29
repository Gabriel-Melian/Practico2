package com.practicos.practico2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<Libro>> librosLiveData;
    private List<Libro> libros;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        librosLiveData = new MutableLiveData<>();
        libros = new ArrayList<>();
        cargarLibros();
    }

    public MutableLiveData<List<Libro>> getLibrosLiveData() {
        return librosLiveData;
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

        librosLiveData.setValue(libros);//Actualizo el mutable con la lista de libros
    }
}
