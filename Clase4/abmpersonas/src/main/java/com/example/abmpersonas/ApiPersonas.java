package com.example.abmpersonas;

import org.hibernate.dialect.lock.PessimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import sun.util.resources.ext.CalendarData_sr;

import javax.sql.DataSource;
import java.net.URI;
import java.sql.SQLException;
import java.util.Optional;

@RestController()
@RequestMapping("/personas")
public class ApiPersonas {

    @Autowired
    DataSource d;

    @Autowired
    PersonasRepository repo;

    @GetMapping("")
    public Iterable<Persona> obtenerTodos()
    {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerUna(@PathVariable int id) {
        Optional<Persona> p = repo.findById(id);
        if (p.isPresent())
            return ResponseEntity.ok().body(p.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Persona> agregar(@RequestBody Persona nueva)
    {
        try {
            repo.save(nueva);
            return ResponseEntity.created(URI.create("/personas/" + nueva.getId())).body(nueva);
        }
        catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().build();
        }
   }

}
