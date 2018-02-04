package ejercicios2;

public abstract class TablaLibros {
	
	public static final String TABLE_NAME = "LIBROS";
	public static final String COLUMN_ISBN="ISBN";
	public static final String COLUMN_TITULO="TITULO";
	public static final String COLUMN_AUTOR="AUTOR";
	public static final String COLUMN_EDITORIAL="EDITORIAL";
	public static final String COLUMN_PAGINAS="PAGINAS";
	public static final String COLUMN_COPIAS="COPIAS";


	public static final String CREATE_TABLE =
			"CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
			COLUMN_ISBN+" INTEGER PRIMARY KEY,"+
			COLUMN_TITULO+" TEXT NOT NULL,"+
			COLUMN_AUTOR+" TEXT NOT NULL,"+
			COLUMN_EDITORIAL+" TEXT NOT NULL,"+
			COLUMN_PAGINAS+" INTEGER NOT NULL,"+
			COLUMN_COPIAS+" INTEGER NOT NULL"+
						
			  ");";
	

}
