package ar.com.ada.api.questionados.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.repos.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    CategoriaRepository repository;

    public List<Categoria> traerCategorias(){
        return repository.findAll();
    }

    public Categoria buscarCategoriaPorId(Integer id){
        Optional<Categoria> resultado = repository.findById(id);
        Categoria categoria = null;

        if (resultado.isPresent()){
            categoria = resultado.get();
        }

        return categoria;
    }

    public boolean crearCategoria(Categoria categoria){

        if (repository.existsByNombre(categoria.getNombre())) {
            return false;
        }
        else {
            repository.save(categoria);
            return true;
        }
    }

}
