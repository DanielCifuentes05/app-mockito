package org.dcifuentes.appmockito.ejemplos.services;

import org.dcifuentes.appmockito.ejemplos.models.Examen;
import org.dcifuentes.appmockito.ejemplos.repositories.ExamenRepository;
import org.dcifuentes.appmockito.ejemplos.repositories.ExamenRepositoryOtro;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExamenServiceImplTest {

    @Test
    void findExamenPorNombre() {
        ExamenRepository repository = mock(ExamenRepository.class);
        ExamenService service = new ExamenServiceImpl(repository);
        List<Examen> datos = Arrays.asList(new Examen(5L,"Matematicas"), new Examen(6L,"Lenguaje"),
                new Examen(7L,"Historia"));
        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");

        assertTrue(examen.isPresent());
        assertEquals(5L,examen.orElseThrow().getId());
        assertEquals("Matematicas",examen.orElseThrow().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        ExamenRepository repository = mock(ExamenRepository.class);
        ExamenService service = new ExamenServiceImpl(repository);
        List<Examen> datos = Collections.emptyList();
        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");

        assertTrue(examen.isPresent());
        assertEquals(5L,examen.orElseThrow().getId());
        assertEquals("Matematicas",examen.orElseThrow().getNombre());
    }
}