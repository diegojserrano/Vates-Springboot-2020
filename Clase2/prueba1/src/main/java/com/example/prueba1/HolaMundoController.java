package com.example.prueba1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// Cuando se navegue /consultarpersona
// devolver un objeto Persona
// Cuando se navegue /arreglo devolver
// un vector de números enteros



@RestController
public class HolaMundoController {

    private int c = 0;

    @Autowired
    private GestorPersonas g;

    @GetMapping("/agregarpersona/{nombre}:{apellido}")
    public void agregar1(@Autowired Persona p,@PathVariable String nombre,@PathVariable String apellido)
    {
        p.setNombre(nombre);
        p.setApellido(apellido);
        g.agregar(p);
    }

    @PostMapping("/agregarpersona/{nombre}:{apellido}")
    public void agregar2(@Autowired Persona p,@PathVariable String nombre,@PathVariable String apellido)
    {
        p.setNombre(nombre);
        p.setApellido(apellido);
        g.agregar(p);
    }

    @PostMapping("/agregarpersona")
    public void agregar3(@RequestBody Persona p) {
        g.agregar(p);
    }

    @PostMapping("/modificarpersona")
    public void modificar(@RequestBody Persona p) {
        g.modificar(p);
    }

    @GetMapping("/consultarpersona/{codigo}")
    public Persona consultar(@PathVariable int codigo) {
        return g.buscar(codigo);
    }

    @GetMapping("/eliminarpersona/{codigo}")
    public void eliminar(@PathVariable int codigo) {
        g.eliminar(codigo);
    }

    @GetMapping("/personas")
    public ArrayList<Persona> listarTodas() {

        return g.listar();
    }






    @GetMapping("/")
    public int contar() {
        return ++c;
    }

    @GetMapping("/comun")
    public String holamundo() {
        return "Hola mundo.....";
    }
    @GetMapping("/tarde")
    public String holamundo1()
    {
        return "Hola, buenas tardes!";
    }


    @GetMapping("/arreglo")
    public int[] vector() {
        return new int[]{23,4,5,7,8,6,3};
    }



/*





    @GetMapping("/agregar/{nombre}")
    public void agregarPersona(@Autowired Persona x, @PathVariable String nombre) {

        x.setNombre(nombre);
        x.setApellido(nombre);

        gestor.agregarPersona(x);
    }

    @GetMapping("/listar")
    public Persona[] listar() {
        return gestor.todas();
    }

    @PostMapping("/agregar")
    public void agregarPersona(@RequestBody Persona nueva) {
        gestor.agregarPersona(nueva);
    }


 */
}

