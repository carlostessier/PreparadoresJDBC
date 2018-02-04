package ejercicios1;

public class Test {

	public static void main(String[] args) {
		AyudanteBD ayudanteDB = new AyudanteBD();
		Departamento dep = new Departamento(1,"RRHH","Madrid");
		System.out.println(dep);

		ayudanteDB.insertDepartamento(dep);
		Departamento dep2 = 
				ayudanteDB.getDepartamento(1);
		System.out.println(dep2);

	}

}
