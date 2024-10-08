package org.dcifuentes.appmockito.ejemplos.services;

import org.dcifuentes.appmockito.ejemplos.Datos;
import org.dcifuentes.appmockito.ejemplos.models.Examen;
import org.dcifuentes.appmockito.ejemplos.repositories.ExamenRepository;
import org.dcifuentes.appmockito.ejemplos.repositories.ExamenRepositoryImpl;
import org.dcifuentes.appmockito.ejemplos.repositories.PreguntaRepository;
import org.dcifuentes.appmockito.ejemplos.repositories.PreguntasRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplSpyTest {

    @Spy
    ExamenRepositoryImpl repository;
    @Spy
    PreguntasRepositoryImpl preguntaRepository;

    @InjectMocks
    ExamenServiceImpl service;

    @Test
    void testSpy() {
        List<String> preguntas = Arrays.asList("aritmetica");
        //when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        doReturn(preguntas).when(preguntaRepository).findPreguntasPorExamenId(anyLong());

        Examen examen = service.findExamenPorNombreconPreguntas("Matematicas");
        assertEquals(5L, examen.getId());
        assertEquals("Matematicas", examen.getNombre());
        assertEquals(1, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("aritmetica"));

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenId(anyLong());

    }
}