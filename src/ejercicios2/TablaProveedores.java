package ejercicios2;

public abstract class TablaProveedores {
	
	public static final String TABLE_NAME = "PROVEEDORES";
	public static final String COLUMN_PROV_ID="PROV_ID";
	public static final String COLUMN_PROV_NOMBRE="PROV_NOMBRE";
	public static final String COLUMN_CALLE="CALLE";
	public static final String COLUMN_CIUDAD="CIUDAD";
	public static final String COLUMN_PAIS="PAIS";
	public static final String COLUMN_CP="CP";

	public static final String CREATE_TABLE =
			"CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
			COLUMN_PROV_ID+" INTEGER NOT NULL PRIMARY KEY,"+
			COLUMN_PROV_NOMBRE+" TEXT NOT NULL,"+
			COLUMN_CALLE+" TEXT NOT NULL,"+
			COLUMN_CIUDAD+" TEXT NOT NULL,"+
			COLUMN_PAIS+" TEXT NOT NULL,"+
			COLUMN_CP+" INTEGER NOT NULL"+
			  ");";
}
