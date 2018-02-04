package ejercicios2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conexion;
	
	Conexion(String driver,String URL){
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(URL);
			System.out.println("Contectado a la BD");
		
		} catch (ClassNotFoundException e) {
			System.err.println("driver no encontrado");
		} catch (SQLException e) {
			System.err.println("Error al conectar");

		}

	}

	public static Connection getConexion() {
		return conexion;
	}



}
