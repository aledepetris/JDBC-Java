import datos.UsuarioDAO;
import domain.Usuario;

import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Insertamos un nuevo usuario
        Usuario usuarioNuevo = new Usuario("carlos.juarez", "123");
        usuarioDAO.insert(usuarioNuevo);



        // Modificamos un usuario existente
        Usuario usuario = new Usuario(2, "alejandro.juarez","444");
        usuarioDAO.update(usuario);

        usuarioDAO.delete(new Usuario(3));

        //Ejecutando el listado de usuarios
        List<Usuario> usuarios = usuarioDAO.select();
        for(Usuario user : usuarios){
            System.out.println("Usuario:" + user);
        }

    }
}
