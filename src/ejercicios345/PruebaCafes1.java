package ejercicios345;


/**
 * @description Clase para probar la clase cafes
 * @author carlosfernandez
 * @date Feb 3, 2018
 * @version 1.0
 * @license GPLv3
 */

public class PruebaCafes1 {

	public static void main(String[] args) {
		

			Cafes1 miCafe = new Cafes1();
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

	}
}
