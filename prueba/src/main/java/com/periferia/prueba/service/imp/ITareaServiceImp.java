package com.periferia.prueba.service.imp;

import com.periferia.prueba.entity.Tarea;
import com.periferia.prueba.exception.ModelNotFoundException;
import com.periferia.prueba.repository.ITareaRepo;
import com.periferia.prueba.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITareaServiceImp implements ITareaService {
    @Autowired
    private ITareaRepo repo;

    @Override
    public List<Tarea> listar() {
        return repo.findAll();
    }

    @Override
    public void guardar(Tarea tarea) {
        repo.save(tarea);
    }

    @Override
    public void borrar(Integer id) throws ModelNotFoundException, Exception{
        if(repo.existsById(id)){
            repo.deleteById(id);
        }else throw new ModelNotFoundException("Tarea no encontrada");
    }
}
