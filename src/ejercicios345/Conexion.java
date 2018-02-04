package ejercicios345;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conexion;
	
	private final static String DRIVER = "org.sqlite.JDBC";
	private final static String DB_NAME = "res/sqlite.db";
	private final static String URL = "jdbc:sqlite:" + DB_NAME;
	
	Conexion(){
		try {
			Class.forName(DRIVER);
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
