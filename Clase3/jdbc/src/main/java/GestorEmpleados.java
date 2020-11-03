import java.sql.*;

import java.util.ArrayList;

public class GestorEmpleados {

    public ArrayList<Empleado> obtenerTodos() {
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("select * from hr.employees order by last_name");

            while(rs.next()) { // Una vuelta por cada fila
                int id = rs.getInt("employee_id");
                String nombre = rs.getString("first_name");
                String apellido = rs.getString("last_name");

                Empleado nuevo = new Empleado(id,nombre,apellido);
                lista.add(nuevo);
            }

            rs.close();
            st.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

    public Empleado obtenerUno(int id) {
        Empleado emp = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
            PreparedStatement st = conn.prepareStatement("select * from hr.employees where employee_id = ?");



            st.setInt(1,id);

            ResultSet rs = st.executeQuery();
            if(rs.next()) { // Devuelve falso si no encuentra
                id = rs.getInt("employee_id");
                String nombre = rs.getString("first_name");
                String apellido = rs.getString("last_name");

                emp = new Empleado(id,nombre,apellido);
            }

            rs.close();
            st.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return emp;
    }
}
