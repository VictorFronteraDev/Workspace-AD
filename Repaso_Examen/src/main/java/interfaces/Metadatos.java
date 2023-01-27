package interfaces;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class Metadatos {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("configuracion/PropiedadesInventario"));
			DataSource ds = BasicDataSourceFactory.createDataSource(props);
			
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			
			DatabaseMetaData dbmd = con.getMetaData();

			infoDriver(dbmd);
			infoTables(dbmd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void infoDriver(DatabaseMetaData dbmd) throws SQLException {
		String driver = dbmd.getDriverName();
		String driverVersion = dbmd.getDriverVersion();
		System.out.println();
		System.out.println("---- INFO DRIVER ----");
		System.out.println("Driver: " + driver);
		System.out.println("Version: " + driverVersion);
	}
	
	public static void infoTables(DatabaseMetaData dbmd) throws SQLException {
		ResultSet rs = dbmd.getTables(null, null, null, new String[]{"TABLE", "SYSTEM_TABLE"});
		while(rs.next()) {
			System.out.println(rs.getString("TABLE_NAME"));
		}
	}
}
