package ar.com.ada.api.questionados.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.entities.Respuesta;

@Service
public class QuestionadosService {
    
    @Autowired
    PreguntaService preguntaService;

    public Pregunta traerPreguntaRandom(){

        int min = 1;
        int max = preguntaService.traerPreguntas().size();
        int random = (int) (Math.random() * ((max - min) + 1)) + min;

        return preguntaService.buscarPreguntaPorId(random - 1);
    }

    public boolean verificarRespuesta(Integer preguntaId, Integer respuestaId){
         Pregunta pregunta = preguntaService.buscarPreguntaPorId(preguntaId);
         for (Respuesta respuesta : pregunta.getOpciones()) {
             if (respuesta.getRespuestaId().equals(respuestaId)){
                return respuesta.isEsCorrecta();
            }
         }
         return false;
    }
}
