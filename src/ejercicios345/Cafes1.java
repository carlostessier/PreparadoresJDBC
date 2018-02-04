package ejercicios345;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicios2.TablaCafes;

/**
 * @descrition
 * @author carlosfernandez
 * @date Feb 3, 2018
 * @version 1.0
 * @license GPLv3
 */

public class Cafes1 extends Conexion implements InterfazCafes {

	// Consultas a realizar en BD
	private static final String SELECT_CAFES_QUERY = "select * from CAFES";

	
	Cafes1() {
		createTable(TablaCafes.CREATE_TABLE);
		createTable(TablaProveedor.CREATE_TABLE);

	}



	/**
	 * Metodo que muestra por pantalla los datos de la tabla cafes
	 * 
	 * @param con
	 * @throws SQLException
	 */
	public void verTabla() {
		try (Statement stmt = getConexion().createStatement()) {

			try (ResultSet rs = stmt.executeQuery(SELECT_CAFES_QUERY)) {

				// Recuperacion de los datos del ResultSet
				while (rs.next()) {
					String coffeeName = rs.getString(TablaCafes.COLUMN_CAF_NOMBRE);
					int supplierID = rs.getInt(TablaCafes.COLUMN_FOREIGN_PROV_ID);
					float PRECIO = rs.getFloat(TablaCafes.COLUMN_PRECIO);
					int VENTAS = rs.getInt(TablaCafes.COLUMN_VENTAS);
					int total = rs.getInt(TablaCafes.COLUMN_TOTAL);
					System.out.println("\t"+coffeeName + ", " + supplierID + ", " + PRECIO + ", " + VENTAS + ", " + total);
				}
			}
		} catch (SQLException e) {
			System.err.println("buscar"+e.getMessage()+" "+SELECT_CAFES_QUERY);
		}

	}

	
	/**
	 * M�todo que busca un cafe por nombre y muestra sus datos
	 *
	 * @param nombre
	 */
	public void buscar(String nombre)  {
		try (Statement stmt = getConexion().createStatement()) {
			try (ResultSet rs = stmt.executeQuery("select * from CAFES WHERE CAF_NOMBRE='"+nombre+"'")) {
				
				// Recuperacion de los datos del ResultSet
				if (rs.next()) {
					String coffeeName = rs.getString(TablaCafes.COLUMN_CAF_NOMBRE);
					int supplierID = rs.getInt(TablaCafes.COLUMN_FOREIGN_PROV_ID);
					float PRECIO = rs.getFloat(TablaCafes.COLUMN_PRECIO);
					int VENTAS = rs.getInt(TablaCafes.COLUMN_VENTAS);
					int total = rs.getInt(TablaCafes.COLUMN_TOTAL);
					System.out.println(coffeeName + ", " + supplierID + ", " + PRECIO + ", " + VENTAS + ", " + total);
				}

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}
	/**
	 * M�todo para insertar una fila
	 * 
	 * @param nombre
	 * @param provid
	 * @param precio
	 * @param ventas
	 * @param total
	 * @return
	 */
	public void insertar(String nombre, int provid, float precio, int ventas, int total) {

		try (Statement stmt = getConexion().createStatement()) {
			
			stmt.executeUpdate("insert into CAFES values ('"+nombre+"',"+provid+","+precio+","+ventas+","+total+")");
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Metodo para borrar una fila dado un nombre de caf�
	 * 
	 * @param nombre
	 * @return
	 */
	public void borrar(String nombre) {

		try (Statement stmt = getConexion().createStatement()) {

			stmt.executeUpdate("delete from CAFES WHERE CAF_NOMBRE = '"+nombre+"'");


		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}
	
	private void createTable(String sql) {
		try (Statement sentencia = getConexion().createStatement()){
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}
	}


	@Override
	public void cafesPorProveedor(int provid) {
		// TODO Auto-generated method stub
		
	}

}
