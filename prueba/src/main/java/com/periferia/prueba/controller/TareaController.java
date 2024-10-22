package com.periferia.prueba.controller;

import com.periferia.prueba.entity.Tarea;
import com.periferia.prueba.exception.ModelNotFoundException;
import com.periferia.prueba.service.ITareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/tasks")
public class TareaController {
    @Autowired
    private ITareaService service;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<?> listar() {
        List<Tarea> tareas = service.listar();
        return new ResponseEntity<List<Tarea>>(tareas, HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<?> guardar(@Valid @RequestBody Tarea tarea){
        service.guardar(tarea);

        return new ResponseEntity<Object>(tarea, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) throws ModelNotFoundException, Exception {
        service.borrar(id);

        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
