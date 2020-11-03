package com.example.abmhr;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpleadosRepository
        extends CrudRepository<Empleado,Integer> {


    List<Empleado> findByApellidoIgnoreCase(String apellido);

}
