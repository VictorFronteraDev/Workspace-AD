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

public class _06Ejercicio {
	public static void main(String[] args) {
		Connection con = null;
		String sql = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		int cont = 0;
		Scanner tec = new Scanner(System.in);
		
		
		
		
//		Actualitzar l'etapa que ix de «Salamanca» i arriba a *Caceres, modificar l'arribada a un
//		altra ciutat, comprova abans d'insertar la ciutat que cap etapa ja registrada arriba a eixa
//		ciutat (pe exemple Badajoz modificar els km 292 km,) tots els valors es parametritzen de
//		manera que pugues modificar qualsevol etapa sabent la ciutat d'eixida i arribada

		
		
		
		
		
		try {
			
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo.txt"));

			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			
			System.out.println("");
			
			
			System.out.println("Introduce la salida actual");
			String vsalida_act=tec.nextLine();
			
			System.out.println("Llegada actual");
			String vllegada_act=tec.nextLine();
			
			System.out.println("Introduce la llegada nueva");
			String vllegada_nueva=tec.nextLine();
			
			System.out.println("Introduce, los kilometros");
			Integer vkm=tec.nextInt();
			tec.nextLine();
					
			
			sql = "select llegada from etapa where lcalegada=? ";
			

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,vllegada_nueva);
			rs = pstmt.executeQuery();
			if(rs.first()) {
				System.out.println("Ya llega una etapa a esa ciudad");
			} else { 
				sql="Update etapa set km=?,llegada=? where salida=? and llegada=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vkm);
			pstmt.setString(2, vllegada_nueva);
			pstmt.setString(3, vsalida_act);
			pstmt.setString(4, vllegada_act);
			cont=pstmt.executeUpdate();
			}
			if(cont==0)
				System.out.println("La ciudad de salida es una etapa que no existe");
			else
				System.out.println("Actualizacion realizada");
			
			
			
			
			
			

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
