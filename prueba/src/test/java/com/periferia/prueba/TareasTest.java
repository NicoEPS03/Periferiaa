package com.periferia.prueba;

import com.periferia.prueba.entity.Tarea;
import com.periferia.prueba.exception.ModelNotFoundException;
import com.periferia.prueba.repository.ITareaRepo;
import com.periferia.prueba.service.ITareaService;
import com.periferia.prueba.service.imp.ITareaServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TareasTest {

    @Mock
    private ITareaRepo repo;

    @InjectMocks
    private ITareaServiceImp service;

    @Test
    void testListar() {
        List<Tarea> tareasMock = Arrays.asList(new Tarea(1, "Tarea 1","Esta es la tarea 1"), new Tarea(2, "Tarea 2","Esta es la tarea 2"));
        when(repo.findAll()).thenReturn(tareasMock);

        List<Tarea> result = service.listar();

        assertEquals(2, result.size());
        verify(repo).findAll();
    }

    @Test
    void testGuardar() {
        Tarea tareaMock = new Tarea(1, "Nueva Tarea", "Esta es una nueva tarea");

        service.guardar(tareaMock);
        verify(repo).save(tareaMock);
    }

    @Test
    void testBorrar_Exito() throws Exception {
        Integer idMock = 1;
        when(repo.existsById(idMock)).thenReturn(true);
        service.borrar(idMock);
        verify(repo).deleteById(idMock);
    }

    @Test
    void testBorrar_ModelNotFoundException() {
        Integer idMock = 1;
        when(repo.existsById(idMock)).thenReturn(false);

        assertThrows(ModelNotFoundException.class, () -> {
            service.borrar(idMock);
        });
    }
}
