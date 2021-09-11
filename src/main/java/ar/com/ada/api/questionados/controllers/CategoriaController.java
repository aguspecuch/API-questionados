package ar.com.ada.api.questionados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.questionados.entities.*;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.services.CategoriaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CategoriaController {
    
    @Autowired
    CategoriaService service;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias(){
        return ResponseEntity.ok(service.traerCategorias());
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarCategoriaPorId(id));
    }

    @PostMapping("/categorias")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){
        GenericResponse r = new GenericResponse();
        
        if (service.crearCategoria(categoria)) {
            r.isOk = true;
            r.id = categoria.getCategoriaId();
            r.message = "Categoria creada con exito";
            return ResponseEntity.ok(r);
        } else {
            r.isOk = false;
            r.message = "La Categoria que desea crear ya existe";
            return ResponseEntity.badRequest().body(r);
        }
    }
}
