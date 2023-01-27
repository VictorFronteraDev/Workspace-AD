package connectionjdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class ConnectionJdbc {

	// la conexion se matiene abierta
	private static Connection con;
	// parametros de la conexion
	private String driver;
	private String url;
	private String usr;
	private String pwd;
	// fichero configuracion de conexion
	private String ficheroConfiguracion;

	// Constructor Conexion con parametros
	public ConnectionJdbc(String driver, String url, String usr, String pwd) {
		this.driver = driver;
		this.url = url;
		this.usr = usr;
		this.pwd = pwd;
	}

	// Metodo conectar con fichero

	public ConnectionJdbc(String fichero) {
		this.ficheroConfiguracion = fichero;
	}

	private void conectar(String ficheroConfiguracion) throws ConnectException {
		con = null;

		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream(ficheroConfiguracion));

			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ConnectException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ConnectException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConnectException();
		}
	}

	private void conectar(String driver, String url, String usr, String pwd) throws ConnectException{
		con = null;
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(usr);
		ds.setPassword(pwd);
		
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			// throw new ConnectException();
		}
	}
	
	public void conectar() throws ConnectException {
		if(con == null) {
			if(ficheroConfiguracion!=null) 
				conectar(ficheroConfiguracion);
			else 
				conectar(driver,url,usr,pwd);
		}
		System.out.println("Conectado");
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public void desconectar() {
		try {
			if (con!=null && !con.isClosed()) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Cerramos un PreparesStatement
	public static void cerrar(PreparedStatement pstm) {
		try {
			if(pstm!=null && !pstm.isClosed()) pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
