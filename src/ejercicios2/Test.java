package ejercicios2;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;




public class Test {

	private static final String SQLITE_DATABASE = "res/sqlite.db";

	public static void main(String[] args) {
		
		//Borramos la base de datos
		try {
		    Files.delete(Paths.get(SQLITE_DATABASE));
		    System.out.println("borrando base de datos");
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", SQLITE_DATABASE);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", SQLITE_DATABASE);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
		
		AyudanteBD ayudanteDB = new AyudanteBD();
		
		ayudanteDB.insertarProveedores();

		ayudanteDB.insertarCafes();

		ayudanteDB.insertarLibros();
		

	}

}
