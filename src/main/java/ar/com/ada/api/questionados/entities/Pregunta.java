package ar.com.ada.api.questionados.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="pregunta")
public class Pregunta {
    
    @Id
    @Column(name="pregunta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer preguntaId;

    private String enunciado;

    @OneToMany (mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> opciones = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="categoria_id", referencedColumnName="categoria_id")
    private Categoria categoria;
    
    public Integer getPreguntaId() {
        return preguntaId;
    }
    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }
    public String getEnunciado() {
        return enunciado;
    }
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    public List<Respuesta> getOpciones() {
        return opciones;
    }
    public void setOpciones(List<Respuesta> opciones) {
        this.opciones = opciones;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        categoria.agregarPregunta(this);
    }

    public void agregarRespuesta(Respuesta respuesta) {
        this.opciones.add(respuesta);
    }

    
}
