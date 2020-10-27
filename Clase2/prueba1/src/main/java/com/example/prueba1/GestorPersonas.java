package com.example.prueba1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;

@Component
@ApplicationScope
// Convierte la clase en un Singleton
// Solicita a Spring que la instancie
// una única vez.
public class GestorPersonas {


    ArrayList<Persona> lista;

    public GestorPersonas() {
        lista = new ArrayList<>();
    }

    public void agregar(Persona nueva) {
        lista.add(nueva);
        System.out.println("Agregada la persona: " +
                nueva.toString());
    }

    public Persona buscar(int codigo) {
        Persona buscada = null;
        for (Persona p: lista) {
            if (p.getCodigo() == codigo) {
                buscada = p;
                break;
            }
        }
        return buscada;
    }

    public void eliminar(int codigo) {
        for (int i=0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo() == codigo) {
                lista.remove(i);
                break;
            }

        }

    }

    public void modificar(Persona p) {
        Persona buscada = buscar(p.getCodigo());
        if (buscada != null) {
            buscada.setNombre(p.getNombre());
            buscada.setApellido(p.getApellido());
        }
    }

    public ArrayList listar() {
        return lista;
    }
}
