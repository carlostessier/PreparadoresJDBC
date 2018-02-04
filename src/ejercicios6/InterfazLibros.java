package ejercicios6;

import java.sql.SQLException;

/**
 * @descrition
 * @author carlosfernandez
 * @date Feb 3, 2018
 * @version 1.0
 * @license GPLv3
 */

public interface InterfazLibros {
	
	/**
	 * Metodo que muestra por pantalla los datos de la tabla cafes
	 * 
	 * @param con
	 * @throws SQLException
	 */
	public void verCatalogo();
	
	/**
	 * Actualiza el numero de copias para un libro
	 * 
	 * @param isbn
	 * @param copias
	 */
	
	public void actualizarCopias(int isbn, int copias);
	
	/**
	 * A�ade un nuevo libro a la BD
	 * 
	 * @param isbn
	 * @param titulo
	 * @param autor
	 * @param editorial
	 * @param paginas
	 * @param copias
	 * @throws AccesoDatosException
	 */
	public void anadirLibro(int isbn, String titulo, String autor, String editorial, int paginas, int copias);



	/**
	 * Borra un libro por ISBN
	 * 
	 * @param isbn
	 * @throws AccesoDatosException
	 */
	public void borrar(int isbn) ;
	
	/**
	 * Devulve los nombres de los campos de BD
	 * 
	 * @return
	 * @throws AccesoDatosException
	 */
	public String[] getCamposLibro() ;
}
