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

public class _03Ejercicio {

	public static void main(String[] args) {
		Connection con = null;
		String sql = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		Scanner tec=new Scanner (System.in);
		
		
		
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo.txt"));
			
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conexion realizada");
			//Acceso a las base de datos
			System.out.println("a) Dorsal, nom i equip de tots els ciclistes\n");
			
			sql="SELECT dorsal, nombre, nomeq from ciclista";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + " - ");
				System.out.print(rs.getString(2) + " - ");
				System.out.println(rs.getString(3));
			}
			
			System.out.println("\nb) Dorsal, nom i nom del director de tots els ciclistes\n");
			sql="SELECT dorsal, nombre, director from ciclista, equipo WHERE ciclista.nomeq = equipo.nomeq";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + " - ");
				System.out.print(rs.getString(2) + " - ");
				System.out.println(rs.getString(3));
			}
			
			
			System.out.println("\nc)  Dorsal, nom i director dels ciclistes de l'equip “ONCE”\n");
			
			
			sql="SELECT dorsal, nombre, director from ciclista JOIN equipo ON ciclista.nomeq=equipo.nomeq where ciclista.nomeq='ONCE'";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + " - ");
				System.out.print(rs.getString(2) + " - ");
				System.out.println(rs.getString(3));
			}
			
			
			System.out.println("\nd)  Dorsal, nom i equip dels ciclistes de l'equip el nom del qual indique l'usuari\n");
			
			String nombreEquipo = null;
			
			System.out.println("Indique el nombre del equipo");
			nombreEquipo = tec.nextLine();
			
			
			sql="SELECT dorsal, nombre, nomeq FROM ciclista WHERE nomeq=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nombreEquipo);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + " - ");
				System.out.print(rs.getString(2) + " - ");
				System.out.println(rs.getString(3));
			}
			
			System.out.println("\ne)Dorsal, nom i equip dels ciclistes de l'equip el nom del qual indique l'usuari i el\r\n"
					+ "nom del ciclista el qual continga el text que indique l'usuari.\n");
			
			
			String nombreCiclista = null;
			System.out.println("Indique el nombre del equipo");
			nombreEquipo = tec.nextLine();
			System.out.println("Indique el nombre del ciclista");
			nombreCiclista = tec.nextLine();
			
			
			sql="SELECT dorsal, nombre, nomeq FROM ciclista WHERE nomeq = ? AND nombre LIKE ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nombreEquipo);
			pstmt.setString(2,"%" + nombreCiclista + "%");	
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + " - ");
				System.out.print(rs.getString(2) + " - ");
				System.out.println(rs.getString(3));
			}
			
			System.out.println("\nf)Consulta el ciclista de l'equip ONCE MÉS jove\n");
			
			
			sql="SELECT nombre, MIN(nacimiento) FROM ciclista WHERE nomeq='ONCE'";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + " - ");
				System.out.println(rs.getString(2));
			}
			
			System.out.println("\ng)Consulta de quants equips participen en la BD ciclista\n");
			
			
			sql="SELECT COUNT(nomeq) FROM equipo ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			System.out.println("\nh)Consulta el nom del ciclistes de més de 20 anys que han guanyat alguna etapa\n");
			
			
			sql="SELECT DISTINCT nombre FROM ciclista JOIN etapa ON etapa.dorsal=ciclista.dorsal where nacimiento<'2002-09-28'";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			System.out.println("\n i)Consulta quants ciclistes té cada equíp\n");
			
			
			sql="SELECT nomeq, COUNT(dorsal) from ciclista GROUP BY nomeq";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + " - ");
				System.out.println(rs.getString(2));
			}
			
			
			System.out.println("\n j)Obtindre el nom dels ciclistes que han guanyat ports de la *categoria que indica\r\n"
					+ "l'usuari\n");
			
			String categoria = null;
			
			System.out.println("Categoria: ");
			categoria = tec.nextLine();
			
			
			sql="SELECT DISTINCT nombre from ciclista JOIN puerto ON ciclista.dorsal=puerto.dorsal WHERE categoria = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, categoria);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
				
			}
			
			
			System.out.println("\n Consulta el nom i equip del ciclistes que han guanyat més de 2 etapes.\n");		
			
			sql="SELECT nombre, nomeq from ciclista, etapa WHERE etapa.dorsal= ciclista.dorsal GROUP BY ciclista.nombre HAVING COUNT(*)>2  ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
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
