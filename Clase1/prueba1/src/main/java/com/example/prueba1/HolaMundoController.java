package com.example.prueba1;

import org.springframework.web.bind.annotation.*;

@RestController
public class HolaMundoController {

    private int c = 0;

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

    @GetMapping("/consultarpersona")
    public Persona p() {
        return new Persona("Juan", "Perez");

    }
}

