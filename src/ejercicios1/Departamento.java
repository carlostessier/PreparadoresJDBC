package ejercicios1;

public class Departamento {
	private int num;
	private String nombre;
	private String loc;

	public Departamento() {

	}

	public Departamento(int num, String nombre, String loc) {
		this.num = num;
		this.nombre = nombre;
		this.loc = loc;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Departamento [num=" + num + ", nombre=" + nombre + ", loc=" + loc + "]";
	}
	
	

}
