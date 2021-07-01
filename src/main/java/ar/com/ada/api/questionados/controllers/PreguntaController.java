package ar.com.ada.api.questionados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.services.PreguntaService;
import ar.com.ada.api.questionados.entities.*;
import ar.com.ada.api.questionados.models.response.GenericResponse;

@RestController
public class PreguntaController {
    
    @Autowired
    PreguntaService service;

    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> traerPreguntas(){
        return ResponseEntity.ok(service.traerPreguntas());
    }

    @GetMapping("/preguntas/{id}")
    public ResponseEntity<Pregunta> traerPregunta(@PathVariable Integer id){
        return ResponseEntity.ok(service.traerPregunta(id));
    }

    @PostMapping("/preguntas")
    public ResponseEntity<?> crearPregunta(@RequestBody Pregunta pregunta){
        service.crearPregunta(pregunta);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.id = pregunta.getPreguntaId();
        r.message = "Pregunta creada con exito";

        return ResponseEntity.ok(r);
    }
}
