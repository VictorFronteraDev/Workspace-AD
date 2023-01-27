package ejemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class _05QueryNumeroEquipos {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo.txt"));
			
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			
			//Realizamos la consulta
			
			stmt = con.createStatement();
			String sql = "SELECT count(*) FROM equipo";
			rs = stmt.executeQuery(sql);
			rs.first();
			System.out.println(rs.getInt(1));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Cerramos el el statement
			try {
				if(stmt !=null && !stmt.isClosed())
					stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			//Cerramos el result
			try {
				if (rs!=null && !rs.isClosed()) {
					rs.close();
					System.out.println("ResultSet cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//cerramos la conexion
			try {
				if(con!=null && !con.isClosed());
				con.close();
				System.out.println("Desconectado");
			} catch(SQLException e ) {
				e.printStackTrace();
			}
		}
	}

}
