import java.util.ArrayList;

public class Programa {

    public static void main(String[] args) {

        GestorEmpleados g = new GestorEmpleados();

        //ArrayList<Empleado> lista = g.obtenerTodos();
        //for (Empleado e: lista) {
        //    System.out.println(e);
        //}

        Empleado e1 = g.obtenerUno(100);
        Empleado e2 = g.obtenerUno(123);


        System.out.println(e1);
        System.out.println(e2);
    }

}
