import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

public class ConexionBBDD {

	private String url;
	private String usr;
	private String pwd;
	private String esquema;
	private Connection conexion;
	

	public ConexionBBDD()  {
		FicheroINI();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void FicheroINI() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/Config.ini");
			if(miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url = propiedades.getProperty("basedatos");
				usr=propiedades.getProperty("nombre");
				pwd=propiedades.getProperty("contraseña");
				esquema=propiedades.getProperty("esquema");
			}
			else {
				System.err.println("fichero no encontrado");
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			if(entrada != null) {
				try {
					entrada.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public DefaultTableModel Bebidas() {
		String [] columnas={"ID_PRODUCTO","NOMBRE","PRECIO"};
		String [] registro=new String[3];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT  ID_PRODUCTO, NOMBRE, PRECIO FROM "+esquema+".PRODUCTO WHERE ID_CATEGORIA =1";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_PRODUCTO");
		         registro[1]=rset.getString("NOMBRE");
		         registro[2]=rset.getString("PRECIO");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public DefaultTableModel Comidas() {
		String [] columnas={"ID_PRODUCTO","NOMBRE","PRECIO"};
		String [] registro=new String[3];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT  ID_PRODUCTO, NOMBRE, PRECIO FROM "+esquema+".PRODUCTO WHERE ID_CATEGORIA =2";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_PRODUCTO");
		         registro[1]=rset.getString("NOMBRE");
		         registro[2]=rset.getString("PRECIO");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public DefaultTableModel Postres() {
		String [] columnas={"ID_PRODUCTO","NOMBRE","PRECIO"};
		String [] registro=new String[3];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT  ID_PRODUCTO, NOMBRE, PRECIO FROM "+esquema+".PRODUCTO WHERE ID_CATEGORIA =3";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
		         registro[0]=rset.getString("ID_PRODUCTO");
		         registro[1]=rset.getString("NOMBRE");
		         registro[2]=rset.getString("PRECIO");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public int A_Producto (int ID, String NOMBRE, int PRECIO, int ID_CATEGORIA) {
		String query = "INSERT INTO "+esquema+".PRODUCTO VALUES ("+ID+",'"+NOMBRE+"',"+PRECIO+", null ,"+ID_CATEGORIA+")";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
		
	}
	
	

	public int M_Producto_id (int ID) {
		String query = "SElECT ID_PRODUCTO FROM "+esquema+".PRODUCTO WHERE ID_PRODUCTO = "+ID+"";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		 
		return ID;
	}
	
	public String M_Producto_nom (int id) {
		String nombre = null;
		String query = "SElECT NOMBRE FROM "+esquema+".PRODUCTO WHERE ID_PRODUCTO = "+id+"";
		try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery(query);
				while(rset.next()) {
					nombre = rset.getString("NOMBRE");
				}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		 
		return nombre;
	}
	
	public int M_Producto_pre (int ID) {
		int precio = 0;
		String query = "SElECT PRECIO FROM "+esquema+".PRODUCTO WHERE ID_PRODUCTO = "+ID+"";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				precio = rset.getInt("PRECIO");
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		 
		return precio;
	}
	
	public int E_Producto (int ID) {
		String query = "DELETE FROM "+esquema+".PRODUCTO WHERE ID_PRODUCTO = "+ID+"";
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
		
	}
	
	public int M_Producto (String nombre, int id, int precio, int id_categoria) {
		String query = "UPDATE "+esquema+".PRODUCTO SET ID_PRODUCTO = "+id+", NOMBRE = '"+nombre+"', PRECIO = "+precio+", ID_CATEGORIA = "+id_categoria+" WHERE ID_PRODUCTO = "+id+"";
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
		
	}
}


