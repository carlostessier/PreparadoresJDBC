package ejercicios345;


public abstract class TablaCafes {
	
	public static final String TABLE_NAME = "CAFES";
	public static final String COLUMN_CAF_NOMBRE="CAF_NOMBRE";
	public static final String COLUMN_FOREIGN_PROV_ID="PROV_ID";
	public static final String COLUMN_PRECIO="PRECIO";
	public static final String COLUMN_VENTAS="VENTAS";
	public static final String COLUMN_TOTAL="TOTAL";

	public static final String CREATE_TABLE =
			"CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
			 COLUMN_CAF_NOMBRE+" TEXT NOT NULL PRIMARY KEY,"+
			 COLUMN_FOREIGN_PROV_ID+" INTEGER NOT NULL,"+
			 COLUMN_PRECIO+" INTEGER NOT NULL,"+
			 COLUMN_VENTAS+" INTEGER NOT NULL,"+
			 COLUMN_TOTAL+" INTEGER NOT NULL,"+
			  "FOREIGN KEY ("+COLUMN_FOREIGN_PROV_ID+") REFERENCES "+TablaProveedor.TABLE_NAME +"("+TablaProveedor.COLUMN_PROV_ID+")"+


			  ");";
}
