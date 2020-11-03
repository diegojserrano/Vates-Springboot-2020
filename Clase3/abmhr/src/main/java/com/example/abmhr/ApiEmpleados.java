package com.example.abmhr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class ApiEmpleados {

    @Autowired
    DataSource d;

    @Autowired
    EmpleadosRepository repo;

    @GetMapping("empleados2")
    public Iterable<Empleado> obtenerTodos2() {
        return repo.findAll();
    }

    @GetMapping("empleado/{id}")
    public Empleado obtenerUno(@PathVariable int id) {
       return repo.findById(id).orElse(null);
    }

    @GetMapping("empleado3/{ape}")
    public List<Empleado> obtenerApellido(@PathVariable String ape) {
        return repo.findByApellidoIgnoreCase(ape);
    }
}
