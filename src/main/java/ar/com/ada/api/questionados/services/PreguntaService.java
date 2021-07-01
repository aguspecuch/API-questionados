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

    public List<Pregunta> traerPreguntas(){
        return repository.findAll();
    }

    public Pregunta traerPregunta(Integer preguntaId){

        Optional<Pregunta> resultado = repository.findById(preguntaId);
        Pregunta pregunta = null;

        if (resultado.isPresent())
            pregunta = resultado.get();

        return pregunta;
    }

    public void crearPregunta(Pregunta pregunta){
        repository.save(pregunta);
    }
}
