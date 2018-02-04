package ejercicios345;

import java.sql.PreparedStatement;
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

public class Cafes extends Conexion implements InterfazCafes {

	// Consultas a realizar en BD
	private static final String SELECT_CAFES_QUERY = "select " + TablaCafes.COLUMN_CAF_NOMBRE + ", "+TablaCafes.COLUMN_FOREIGN_PROV_ID+" ,"
			+ TablaCafes.COLUMN_TOTAL + ", " + TablaCafes.COLUMN_PRECIO + ", " + TablaCafes.COLUMN_VENTAS + ", "
			+ TablaCafes.COLUMN_TOTAL + " from " + TablaCafes.TABLE_NAME;
	private static final String SEARCH_CAFE_QUERY = "select * from " + TablaCafes.TABLE_NAME + " WHERE "
			+ TablaCafes.COLUMN_CAF_NOMBRE + "= ?";
	private static final String INSERT_CAFE_QUERY = "insert into " + TablaCafes.TABLE_NAME + " values (?,?,?,?,?)";
	private static final String DELETE_CAFE_QUERY = "delete from " + TablaCafes.TABLE_NAME + " WHERE "
			+ TablaCafes.COLUMN_CAF_NOMBRE + " = ?";
	private static final String SEARCH_CAFES_PROVEEDOR = "select * from " + TablaCafes.TABLE_NAME
			+ ",PROVEEDORES WHERE CAFES.PROV_ID= ? AND CAFES.PROV_ID=PROVEEDORES.PROV_ID";

	Cafes() {
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
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Metodo que busca un cafe por nombre y muestra sus datos
	 *
	 * @param nombre
	 */
	public void buscar(String nombre) {

		try (PreparedStatement pstmt = getConexion().prepareStatement(SEARCH_CAFE_QUERY)) {
			pstmt.setString(1, nombre);
			try (ResultSet rs = pstmt.executeQuery()) {
				
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
	 * Metodo para insertar una fila
	 * 
	 * @param nombre
	 * @param provid
	 * @param precio
	 * @param ventas
	 * @param total
	 * @return
	 */
	public void insertar(String nombre, int provid, float precio, int ventas, int total) {

		try (PreparedStatement pstmt = getConexion().prepareStatement(INSERT_CAFE_QUERY)) {
				pstmt.setString(1, nombre);
				pstmt.setInt(2, provid);
				pstmt.setFloat(3, precio);
				pstmt.setInt(4, ventas);
				pstmt.setInt(5, total);
				// Ejecucion de la insercion
				pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Metodo para borrar una fila dado un nombre de cafe
	 * 
	 * @param nombre
	 * @return
	 */
	public void borrar(String nombre) {

		try (PreparedStatement stmt = getConexion().prepareStatement(DELETE_CAFE_QUERY)) {

			stmt.setString(1, nombre);
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Metodo que busca un cafe por nombre y muestra sus datos
	 *
	 * @param nombre
	 */
	public void cafesPorProveedor(int provid)  {

		try (PreparedStatement stmt = getConexion().prepareStatement(SEARCH_CAFES_PROVEEDOR)) {

			stmt.setInt(1, provid);
			// Ejecucion de la consulta y obtencion de resultados en un
			// ResultSet
			try (ResultSet rs = stmt.executeQuery()) {

				// Recuperacion de los datos del ResultSet
				while (rs.next()) {
					String coffeeName = rs.getString(TablaCafes.COLUMN_CAF_NOMBRE);
					int supplierID = rs.getInt(TablaCafes.COLUMN_FOREIGN_PROV_ID);
					float PRECIO = rs.getFloat(TablaCafes.COLUMN_PRECIO);
					int VENTAS = rs.getInt(TablaCafes.COLUMN_VENTAS);
					int total = rs.getInt(TablaCafes.COLUMN_TOTAL);
					String provName = rs.getString(TablaProveedor.COLUMN_PROV_NOMBRE);
					String calle = rs.getString(TablaProveedor.COLUMN_CALLE);
					String ciudad = rs.getString(TablaProveedor.COLUMN_CIUDAD);
					String pais = rs.getString(TablaProveedor.COLUMN_PAIS);
					int cp = rs.getInt(TablaProveedor.COLUMN_CP);
					
					System.out.println(coffeeName + ", " + supplierID + ", " + PRECIO + ", " + VENTAS + ", " + total
							+ ",Y el proveedor es:" + provName + "," + calle + "," + ciudad + "," + pais + "," + cp);
				}
			}

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
	
	

}
