package ejercicios6;

import java.util.Arrays;

/**
 * @descrition Clase para probar la clase cafes
 * @author carlosfernandez
 * @date Feb 3, 2018
 * @version 1.0
 * @license GPLv3
 */

public class Prueba {

	public static void main(String[] args) {
		
			Libros miLibro = new Libros();
			System.out.println("\nCatalogo:");
			miLibro.verCatalogo();
			
			//Observa como al llamar por segunda vez a verTabla los precios en BD se han modificado
			//Esta actualizacion se hace utilizando un ResultSet "CONCUR_UPDATABLE" en modificarPrecio
			System.out.println("\nActualizar copias:");
			miLibro.actualizarCopias(1325, 15);
			System.out.println("\nAgnadir libro:");
			miLibro.anadirLibro(15687, "Prueba", "yo","ies virgen de la paz", 178, 9);
			System.out.println("\nCatalogo:");
			miLibro.verCatalogo();
			System.out.println("\nBorrar libro:");
			miLibro.borrar(15687);
			System.out.println("\nCatalogo:");
			miLibro.verCatalogo();
			System.out.println(Arrays.toString(miLibro.getCamposLibro()));
		

	}
}
