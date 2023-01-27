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

public class _04Ejercicio {

	public static void main(String[] args) {
		Connection con = null;
		String sql = null;
		PreparedStatement pstmt;
		ResultSet rs = null;

		String maillot = "";

		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo.txt"));

			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			// Acceso a las base de datos
			System.out.println("\nActualitzar el premi del mallots del tipus que indique l'usuari en 50€\n");

			
			
			while(!maillot.equals("salir")) {
				Scanner tec = new Scanner(System.in);
				System.out.println("Maillot: (inserte salir para dejar de actualizar la tabla maillot)");
				maillot = tec.nextLine();

				sql = "UPDATE maillot SET premio = 50 WHERE color = ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, maillot);
				pstmt.executeUpdate();
				
				
				sql = "Select color, premio from maillot WHERE color = ? ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, maillot);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					System.out.print(rs.getString(1) + " - ");
					System.out.println(rs.getString(2));
				}
				
				
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
