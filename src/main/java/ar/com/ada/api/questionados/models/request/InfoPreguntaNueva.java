package ar.com.ada.api.questionados.models.request;

import java.util.List;

import ar.com.ada.api.questionados.entities.Respuesta;

public class InfoPreguntaNueva {
    
    public String enunciado;
    public Integer categoriaId;
    public List<Respuesta> opciones;
}
