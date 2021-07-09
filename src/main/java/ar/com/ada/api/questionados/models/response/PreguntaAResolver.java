package ar.com.ada.api.questionados.models.response;

import java.util.*;

import ar.com.ada.api.questionados.entities.*;

public class PreguntaAResolver {
    
    public Integer preguntaId;
    public String enunciado;
    public Categoria categoria;
    public List<OpcionPregunta> opciones;

    public static PreguntaAResolver convertirDesde(Pregunta pregunta) {

        PreguntaAResolver preguntaAResolver = new PreguntaAResolver();
        
        preguntaAResolver.preguntaId = pregunta.getPreguntaId();
        preguntaAResolver.enunciado = pregunta.getEnunciado();
        preguntaAResolver.categoria = pregunta.getCategoria();
        preguntaAResolver.opciones = new ArrayList<>();

        for (Respuesta respuesta : pregunta.getOpciones()) {
            
            OpcionPregunta opcion = new OpcionPregunta();

            opcion.respuestaId = respuesta.getRespuestaId();
            opcion.texto = respuesta.getTexto();
            
            preguntaAResolver.opciones.add(opcion);
        }

        return preguntaAResolver;
    }
}
