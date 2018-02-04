package ejercicios1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conexion;
	
	Conexion(String driver,String URL){
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(URL);

			
		} catch (ClassNotFoundException e) {
			System.err.println("driver no encontrado");
		} catch (SQLException e) {
			System.err.println("error al conectar");

		}

	}

	public static Connection getConexion() {
		return conexion;
	}



}
