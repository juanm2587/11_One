package Challenge.LiterAlura.service;


import Challenge.LiterAlura.model.Libro;
import Challenge.LiterAlura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServices {
    @Autowired
    public LibroRepository libroRepository;

    public List<String> obtenerIdiomasDistintos() {
        return libroRepository.findDistinctIdiomas();
    }

    public List<Libro> obtenerLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }


}