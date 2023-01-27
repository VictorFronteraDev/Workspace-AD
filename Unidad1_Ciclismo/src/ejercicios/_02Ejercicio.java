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

public class _02Ejercicio {
	public static void main(String[] args) {
		Connection con = null;
		String sql = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		String maillot = null;
		int nPremio = 0;
		
		Scanner tec=new Scanner (System.in);
		System.out.println("Maillot:");
		maillot = tec.nextLine();
		System.out.println("Nuevo premio");
		nPremio = tec.nextInt();
		
		
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo.txt"));
			
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			//Acceso a las base de datos
			sql="UPDATE maillot SET premio =? + 200 WHERE color =?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nPremio);
			pstmt.setString(2, maillot);
			pstmt.executeUpdate();
			
			sql = "select * from maillot;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString(1)+ " - ");
				System.out.print(rs.getString(2)+ " - ");
				System.out.print(rs.getString(3)+ " - ");
				System.out.println(rs.getString(4));
			}
			
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null && !con.isClosed())
					con.close();
					System.out.println("Desconectado");
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
