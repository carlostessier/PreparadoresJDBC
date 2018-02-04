package ejercicios2;

import java.sql.SQLException;
import java.sql.Statement;

public class AyudanteBD extends Conexion {

	private final static String DRIVER = "org.sqlite.JDBC";
	private final static String DB_NAME = "res/sqlite.db";
	private final static String URL = "jdbc:sqlite:" + DB_NAME;

	AyudanteBD() {
		super(DRIVER, URL);
		createTable(TablaLibros.CREATE_TABLE);
		createTable(TablaProveedores.CREATE_TABLE);
		createTable(TablaCafes.CREATE_TABLE);


	}

	public void insertarCafes() {

		try (Statement stmt = getConexion().createStatement()) {

			stmt.executeUpdate("insert into CAFES values ('Colombian',35,3.99,100,200);");

		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}

	}
	
	public void insertarProveedores() {

		try (Statement stmt = getConexion().createStatement()) {

			stmt.executeUpdate("insert into PROVEEDORES values (35,'Cafe Mexicana','Calle de Preciados', 'Madrid','España',28013);");

		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}

	}

	public void insertarLibros() {

		try (Statement stmt = getConexion().createStatement()) {

			stmt.executeUpdate(
					"insert into libros values (12345,'Sistemas Operativos','Tanembaun','Informatica',156,3);");
			stmt.executeUpdate("insert into libros values (12453,'Minix','Stallings','Informatica',345,4);");
			stmt.executeUpdate("insert into libros values (1325,'Linux','Richard Stallman','FSF',168,10);");
			stmt.executeUpdate("insert into libros values (1725,'Java','Juan Garcia','Programacion',245,9);");

		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}

	}

	private void createTable(String sql) {
		
		try (Statement sentencia = getConexion().createStatement()){
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(sql);


		}
	}

}
