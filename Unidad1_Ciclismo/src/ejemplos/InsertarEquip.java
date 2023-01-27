package ejemplos;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class InsertarEquip {
	
	
	
	public static void main(String[] args) {
		
		String vDorsal, vNombre, vNomeq, vNacimiento=null;
		Connection con = null;
		String sql;
		PreparedStatement pstmt;
		
		Scanner tec=new Scanner (System.in);
		System.out.println("Dorsal: ");
		vDorsal=tec.nextLine();
		
		System.out.println("Nombre Ciclista");
		vNombre=tec.nextLine();
		
		System.out.println("Equipo: ");
		vNomeq=tec.nextLine();
		
		System.out.println("Nacimiento: ");
		vNacimiento=tec.nextLine();
		
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo.txt"));
			
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			//Acceso a las base de datos
			sql="insert into ciclista values(?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vDorsal);
			pstmt.setString(2, vNombre);
			pstmt.setString(3, vNomeq);
			pstmt.setString(4, vNacimiento);
			pstmt.executeUpdate();
			
			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
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


