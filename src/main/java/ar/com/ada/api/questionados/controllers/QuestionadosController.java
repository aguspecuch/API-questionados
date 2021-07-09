package ar.com.ada.api.questionados.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.models.request.RespuestaAVerificar;
import ar.com.ada.api.questionados.models.response.*;
import ar.com.ada.api.questionados.services.QuestionadosService;

@RestController
public class QuestionadosController {
    
    @Autowired
    QuestionadosService service;

    @GetMapping("/questionados/next")
    public ResponseEntity<PreguntaAResolver> traerPreguntaRandom(){
        
        Pregunta preguntaRandom = service.traerPreguntaRandom();

        PreguntaAResolver preguntaAResolver = PreguntaAResolver.convertirDesde(preguntaRandom);

        return ResponseEntity.ok(preguntaAResolver);
    }

    @PostMapping("/questionados/verificaciones")
    public ResponseEntity<RespuestaVerificada> verificarRespuesta(@RequestBody RespuestaAVerificar respuestaAVerificar){

        RespuestaVerificada respuestaVerificada = new RespuestaVerificada();

        if (service.verificarRespuesta(respuestaAVerificar.preguntaId, respuestaAVerificar.respuestaId)){
            respuestaVerificada.esCorrecta = true;
        } else {
            respuestaVerificada.esCorrecta = false;
        }

        return ResponseEntity.ok(respuestaVerificada);
    }
}
