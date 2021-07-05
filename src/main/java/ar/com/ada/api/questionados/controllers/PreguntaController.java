package ar.com.ada.api.questionados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.services.PreguntaService;
import ar.com.ada.api.questionados.entities.*;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.models.request.InfoPreguntaNueva;

@RestController
public class PreguntaController {
    
    @Autowired
    PreguntaService service;

    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> traerPreguntas(){
        return ResponseEntity.ok(service.traerPreguntas());
    }

    @GetMapping("/preguntas/{id}")
    public ResponseEntity<Pregunta> buscarPreguntaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarPreguntaPorId(id));
    }

    @PostMapping("/preguntas")
    public ResponseEntity<?> crearPregunta(@RequestBody InfoPreguntaNueva preguntaNueva){
       
        Pregunta pregunta = service.crearPregunta(preguntaNueva.enunciado, preguntaNueva.categoriaId, preguntaNueva.opciones);
        GenericResponse r = new GenericResponse();

        if (pregunta != null) {
            r.isOk = true;
            r.id = pregunta.getPreguntaId();
            r.message = "La pregunta fue creada con exito";
            return ResponseEntity.ok(r);
        } else {
            r.isOk = false;
            r.message = "La pregunta que desea crear ya existe";
            return ResponseEntity.badRequest().body(r);
        }
    }
}
