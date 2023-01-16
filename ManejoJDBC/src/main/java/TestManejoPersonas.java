import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();

        Persona personaNueva = new Persona("asdsa", "Depetris","sebadepetris@gmail.com","3451356524");
        personaDAO.insertar(personaNueva);

        List<Persona> personas = personaDAO.seleccionar();
        personas.forEach(System.out::println);

    }
}
