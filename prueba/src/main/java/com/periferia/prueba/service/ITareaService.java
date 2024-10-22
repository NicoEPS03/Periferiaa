package com.periferia.prueba.service;

import com.periferia.prueba.entity.Tarea;
import com.periferia.prueba.exception.ModelNotFoundException;

import java.util.List;

public interface ITareaService {
    public List<Tarea> listar();
    public void guardar(Tarea tarea);
    public void borrar(Integer id) throws ModelNotFoundException, Exception;
}
