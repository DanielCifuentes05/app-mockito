package org.dcifuentes.appmockito.ejemplos.repositories;

import org.dcifuentes.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
    List<Examen> findAll();
}
