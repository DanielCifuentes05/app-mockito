package org.dcifuentes.appmockito.ejemplos.repositories;

import org.dcifuentes.appmockito.ejemplos.models.Examen;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamenRepositoryOtro implements ExamenRepository{
    @Override
    public List<Examen> findAll() {
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return null;
    }
}
