package ejercicios1;

public abstract class TablaEmpleado {
	
	public static final String TABLE_NAME = "empleado";
	public static final String COLUMN_EMP_NO="emp_no";
	public static final String COLUMN_APELLIDO="apellido";
	public static final String COLUMN_OFICIO="oficio";
	public static final String COLUMN_DIR="dir";
	public static final String COLUMN_FECHA_ALT="fecha_alt";
	public static final String SALARIO="salario";
	public static final String COLUMN_FOREIGN_KEY_DEPT="dept_no";


	public static final String CREATE_TABLE =
			"CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
			COLUMN_EMP_NO+"INTEGER PRIMARY KEY,"+
			COLUMN_APELLIDO+" TEXT NOT NULL,"+
			COLUMN_OFICIO+" TEXT NOT NULL,"+
			COLUMN_DIR+"TEXT NOT NULL,"+
			COLUMN_FECHA_ALT+"TEXT NOT NULL,"+
			SALARIO+" REAL NOT NULL,"+
			COLUMN_FOREIGN_KEY_DEPT+" INTEGER,"+ 
			"FOREIGN KEY ("+COLUMN_FOREIGN_KEY_DEPT+") REFERENCES "+TablaDepartamento.TABLE_NAME +"("+TablaDepartamento.COLUMN_DEPT_NO+")"+
			
			  ");";
	

}
