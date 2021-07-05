package ar.com.ada.api.questionados.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="respuesta")
public class Respuesta {
    
    @Id
    @Column(name="respuesta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer respuestaId;

    private String texto;

    @Column(name="es_correcta")
    private boolean esCorrecta;

    @ManyToOne
    @JoinColumn(name="pregunta_id", referencedColumnName = "pregunta_id")
    @JsonIgnore
    private Pregunta pregunta;
    
    public Integer getRespuestaId() {
        return respuestaId;
    }
    public void setRespuestaId(Integer respuestaId) {
        this.respuestaId = respuestaId;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public boolean isEsCorrecta() {
        return esCorrecta;
    }
    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
    public Pregunta getPregunta() {
        return pregunta;
    }
    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
        pregunta.agregarRespuesta(this);
    }

    
}
