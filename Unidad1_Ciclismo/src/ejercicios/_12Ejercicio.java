package ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class _12Ejercicio {
	
	
	public void infoDriver(DatabaseMetaData dbmd) throws SQLException {
		
		//Nombre driver
		String driver = dbmd.getDriverName();
		//Version driver
		String driverVersion = dbmd.getDriverVersion();
		System.out.println("---- INFORMACION SOBRE EL driver ----");
		System.out.println("driver: " + driver);
		System.out.println("Version: " + driverVersion);
		
		
	}

	public static void main(String[] args) {
		Connection con = null;
		String sql = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo.txt"));

			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			
			
			//q) Quina versió de driver tens instal·lat

			//String driverVersion = dbmd.getDriverVersion();
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + " - ");
				System.out.println(rs.getString(2));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed())
					con.close();
				System.out.println("Desconectado");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
