package org.dcifuentes.appmockito.ejemplos.services;

import org.dcifuentes.appmockito.ejemplos.models.Examen;

import java.util.Optional;

public interface ExamenService {
   Optional<Examen> findExamenPorNombre(String nombre);
}
