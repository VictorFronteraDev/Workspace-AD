package ejemplos;

import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;




public class _02ConectarConDataSource {
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/ciclismo";
	final static String USR = "root";
	final static String PWD = "mysql";
	
//	public static void main(String[] args) {
//		Connection con = null;
//
//		try {
//			Properties propiedades = Properties();
//			propiedades.load(new FileInputStream("Configuracion\\PropiedadesCiclismo.txt"));
//			
//			DataSource ds = BasicDataSourceFactory.createDataSource(propietats);
//			con = ds = BasicDataSourceFactory.createDataSource(propiedades);
//			System.out.println("Conexion realizada");
//		} catch
//	}

}
