package ar.com.ada.api.questionados.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categoria")
public class Categoria {
    
    @Id
    @Column(name="categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriaId;

    private String nombre;
    
    private String descripcion;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Pregunta> preguntas = new ArrayList<>();

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
    public Integer getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
}
