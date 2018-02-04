package ejercicios1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AyudanteBD extends Conexion{

	
	private final static String DRIVER ="org.sqlite.JDBC";
	private final static String DB_NAME = "res/ejemplo.db";
	private final static  String URL="jdbc:sqlite:"+DB_NAME;
	
	private final static String INSERT_DEPARTAMENTO =
			"INSERT INTO "+TablaDepartamento.TABLE_NAME+" VALUES (?,?,?)";
	
	private final static String SELECT_DEPARTAMENTO =
			"SELECT * FROM "+TablaDepartamento.TABLE_NAME+" WHERE "+TablaDepartamento.COLUMN_DEPT_NO+" = ?";

	
	AyudanteBD() {
		super(DRIVER, URL);	
		createTable(TablaDepartamento.CREATE_TABLE);
		createTable(TablaEmpleado.CREATE_TABLE);

	}

    public void insertDepartamento(Departamento dep){
    	try {
			PreparedStatement sentencia = getConexion().prepareStatement(INSERT_DEPARTAMENTO);
		    sentencia.setInt(1, dep.getNum());
		    sentencia.setString(2, dep.getNombre());
		    sentencia.setString(3, dep.getLoc());
			sentencia.executeUpdate();
		} catch (SQLException e) {
			System.err.println("error al insertar el departamento "+dep.getNombre());
			System.err.println(e.getMessage());
		}
    }
    
    public Departamento getDepartamento(int num){
    	Departamento dep = new Departamento();
    	try {
    		PreparedStatement sentencia = getConexion().prepareStatement(SELECT_DEPARTAMENTO);
    		sentencia.setInt(1, num);
		ResultSet result = sentencia.executeQuery();
		if(result.next()){
			dep.setNum(num);
			dep.setNombre(result.getString(TablaDepartamento.COLUMN_DNOMBRE));
			dep.setLoc(result.getString(TablaDepartamento.COLUMN_LOC));
		}
		} catch (SQLException e) {
			System.err.println("error al buscar el departamento "+num);
			System.err.println(e.getMessage());
		}
    	return dep;
    }
	
	
	private void createTable(String sql) {
		try {
			Statement sentencia = getConexion().createStatement();
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(TablaEmpleado.CREATE_TABLE);
			System.err.println(e.getMessage());
			
		}
	}
	
	
	
	
	
	
	
}
