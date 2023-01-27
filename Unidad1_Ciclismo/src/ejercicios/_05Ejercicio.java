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

public class _05Ejercicio {
	
	public static void main(String[] args) {
		Connection con = null;
		String sql = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		int dorsal = 0;
		String nombre = null;
		String nomeq = null;
		String nacimiento = null;
		int vNumEq = 0;
		
		Scanner tec=new Scanner (System.in);
		
		System.out.println("Dorsal: ");
		dorsal = tec.nextInt();
		
		System.out.println("Nombre: ");
		nombre = tec.nextLine();
		System.out.println("Equipo: ");
		nomeq = tec.nextLine();
		
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo.txt"));

			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			
			
			
			sql = "Select Count(*) from ciclista where nomeq = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nomeq);
			
			rs = pstmt.executeQuery();
			
		
			while(rs.next())
				vNumEq = rs.getInt(1);
			
			
			if(vNumEq > 8) {
				System.out.println("no se puede insertar ciclista");
			} else {
				sql="Insert into ciclista('nombre', 'nomeq') values (?,?)";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nombre);
			pstmt.setString(2, nomeq);
			
			
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