package ejercicios345;


/**
 * @description Clase para probar la clase cafes
 * @author Laura
 * @date 9/4/2015
 * @version 1.0
 * @license GPLv3
 */

public class PruebaCafes {

	public static void main(String[] args) {
		
			Cafes miCafe = new Cafes();
			System.out.println("\nContents of CAFES table:");
			miCafe.verTabla();
			
			//Observa como al llamar por segunda vez a verTabla los precios en BD se han modificado
			System.out.println("\nBuscar cafe:");
			miCafe.buscar("Colombian");
			//El id de proveedor tiene que existir en la tabla proveedores
			System.out.println("\nInsertar café:");
			miCafe.insertar("Nescafe", 35, new Float(4.99), 89, 94);
			//Comprobamos que se inserta
			System.out.println("\nBuscar Nescafe:");
			miCafe.buscar("Nescafe");
			System.out.println("\nBorrar Nescafe:");
			miCafe.borrar("Nescafe");
			System.out.println("\nContents of CAFES table:");
			miCafe.verTabla();
			System.out.println("\nContents CAFES proveedor:");
			miCafe.cafesPorProveedor(35);
			
		

	}
}
