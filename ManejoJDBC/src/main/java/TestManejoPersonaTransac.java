import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;

import java.sql.Connection;
import java.sql.SQLException;

public class TestManejoPersonaTransac {

    public static void main(String[] args) {

        Connection connection = null;

        try {
            connection = Conexion.getConnection();
            if (connection.getAutoCommit())
                connection.setAutoCommit(false);

            PersonaDAO personaDAO = new PersonaDAO();

            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(1);
            cambioPersona.setNombre("Meli");
            cambioPersona.setApellido("Nara");
            cambioPersona.setEmail("melinara@gmail.com");
            cambioPersona.setTelefono("486485645650");
            personaDAO.actualizar(cambioPersona);

            Persona nuevaPersona = new Persona(1, "Carlos", "Gomez", "cargomez@gmail.com", "123123");
            personaDAO.insertar(nuevaPersona);

            connection.commit();

        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos en el rollback");
            try {
                connection.rollback();
            } catch (SQLException ex2) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
