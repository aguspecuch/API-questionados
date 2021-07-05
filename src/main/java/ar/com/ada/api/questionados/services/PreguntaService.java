package ar.com.ada.api.questionados.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.repos.PreguntaRepository;
import ar.com.ada.api.questionados.entities.*;

@Service
public class PreguntaService {
    
    @Autowired
    PreguntaRepository repository;

    @Autowired
    CategoriaService categoriaService;

    public List<Pregunta> traerPreguntas(){
        return repository.findAll();
    }

    public Pregunta buscarPreguntaPorId(Integer preguntaId){

        Optional<Pregunta> resultado = repository.findById(preguntaId);
        Pregunta pregunta = null;

        if (resultado.isPresent())
            pregunta = resultado.get();

        return pregunta;
    }

    public Pregunta crearPregunta(String enunciado, Integer categoriaId, List<Respuesta> opciones){
        
        Pregunta pregunta = null;

        if (!repository.existsByEnunciado(enunciado)){
            pregunta = new Pregunta();
            pregunta.setEnunciado(enunciado);
            pregunta.setCategoria(categoriaService.buscarCategoriaPorId(categoriaId));

            for (Respuesta respuesta: opciones) {
                respuesta.setPregunta(pregunta);
            }
            
            repository.save(pregunta);
        }

        return pregunta;
    }
}
