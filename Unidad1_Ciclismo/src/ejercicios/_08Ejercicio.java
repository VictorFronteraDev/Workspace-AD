package ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class _08Ejercicio {

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

			
			Scanner tec = new Scanner(System.in);
			System.out.println("Dorsal del ciclista");
			Integer vDorsal=tec.nextInt();
			System.out.println("Color maillot: ");
			String vColor=tec.next();
			
			sql = "SELECT count(*) from llevar join maillot on llevar.codigo=maillot.codigo where color=? and dorsal=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vColor);
			pstmt.setInt(2, vDorsal);
			rs=pstmt.executeQuery();
			
			
			
			
			if(!rs.first())
				System.out.println("ese dorsal no ha portat eixe maillot");
			else {
				System.out.println("El ciclista " + vDorsal  + " ha llevado el maillot " + vColor + " " + rs.getString(1) + " veces");
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
