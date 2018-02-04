package ejercicios345;

/**
 * @descrition
 * @author carlosfernandez
 * @date Feb 3, 2018
 * @version 1.0
 * @license GPLv3
 */

public interface InterfazCafes {
	
	/**
	 * Metodo que busca un cafe por nombre y muestra sus datos
	 *
	 * @param nombre
	 */
	public void buscar(String nombre) ;
	
	/**
	 * Metodo para borrar una fila dado un nombre de caf�
	 * 
	 * @param nombre
	 * @return
	 */
	
	public void borrar(String nombre) ; 

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
	
	public void insertar(String nombre, int provid, float precio, int ventas, int total) ;

	/**
	 * Metodo que busca un cafe por nombre y muestra sus datos
	 *
	 * @param nombre
	 */
	public void cafesPorProveedor(int provid);

}
