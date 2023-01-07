import java.sql.*;

public class TestPostgreSqlJDBC {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/JDBCTest?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try {
            Connection conexion = DriverManager.getConnection(url, "postgres", "123456");
            Statement instruccion = conexion.createStatement();

            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);

            while(resultado.next()) {
                System.out.println("---------------------------------- ");
                System.out.print("[Id persona: " + resultado.getInt("id_persona"));
                System.out.print(" Nombre: " + resultado.getString("nombre"));
                System.out.print(" Apellido: " + resultado.getString("apellido"));
                System.out.print(" Mail: " + resultado.getString("email"));
                System.out.print(" Tel: " + resultado.getString("telefono") + "]");
                System.out.print(" ");

            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
