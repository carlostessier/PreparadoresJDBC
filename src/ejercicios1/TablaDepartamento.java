package ejercicios1;

public abstract class TablaDepartamento {
	
	public static final String TABLE_NAME = "departamento";
	public static final String COLUMN_DEPT_NO="dept_no";
	public static final String COLUMN_DNOMBRE="dnombre";
	public static final String COLUMN_LOC="loc";

	public static final String CREATE_TABLE =
			"CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
			 COLUMN_DEPT_NO+" INTEGER NOT NULL PRIMARY KEY,"+
			 COLUMN_DNOMBRE+" TEXT NOT NULL,"+
			 COLUMN_LOC+" TEXT NOT NULL"+
			  ");";
}
