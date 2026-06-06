package conexion;// Define la ubicación lógica del archivo (paquete)

import java.sql.Connection;// Importamos la interfaz que representa la conexión abierta
import java.sql.DriverManager;// Importamos la clase que gestiona el conjunto de drivers
import java.sql.SQLException;

public class ConexionBD {

    // Definimos los datos de conexión de manera clara y ordenada
    // URL: Especifica el protocolo (jdbc:mysql), la dirección (localhost), puerto (3306) y la base de datos (Ontime2BD)
    // El parámetro useSSL=false evita problemas con certificados de seguridad en desarrollo local
    private static final String URL = "jdbc:mysql://localhost:3306/Ontime2BD?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection instance = null;


    //definimos el metodo
    public static Connection getConexion() throws SQLException{

        if (instance == null || instance.isClosed()) {
            try {
                // Registramos formalmente el driver de MySQL para que Java "sepa cómo hablar" con MySQL
                // fN.permite cargar dinámicamente una clase en tiempo de ejecución
                Class.forName("com.mysql.cj.jdbc.Driver");
                // DriverManager intenta crear la conexión usando los datos provistos
                instance = DriverManager.getConnection(URL, USER, PASSWORD);
                // Confirmación visual en consola para depuración
                System.out.println("-> ¡OnTime BD Conectada con éxito!");
            } catch (ClassNotFoundException e) {
                throw new SQLException("driver / conexion no encontrada :(", e);
            }

        }

        return instance;// Retornamos la conexión (o null si falló) para ser usada en los DAOs
    }

}
