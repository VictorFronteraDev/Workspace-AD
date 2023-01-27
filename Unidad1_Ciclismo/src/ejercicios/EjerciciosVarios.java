package ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class EjerciciosVarios {
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
			
			//Obtener el ciclista mas joven y mas viejo (sin filtrar en la sql)
			
			
			sql = "Select * from ciclista WHERE nacimiento is not null ORDER BY nacimiento";
			
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE);
			
			rs = pstmt.executeQuery();
			rs.last();
			System.out.println("mas joven: " + rs.getString("nombre")+ " " + rs.getDate("nacimiento"));
			rs.first();
			System.out.println("mas viejo: " + rs.getString("nombre")+ " " + rs.getDate("nacimiento"));
			rs.last();
			rs.relative(-1);
			System.out.println("El 2 mas joven: " + rs.getString("nombre")+ " " + rs.getDate("nacimiento"));
			
			
			
			
			
			//Buscar el ciclista (dorsal) que en la clasificacion de etapas ganadas está el 4 por etapas mas ganadas
			
			sql="select dorsal, count(*) from etapa group by dorsal desc";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE);
			
			rs=pstmt.executeQuery();
			rs.absolute(2);
			System.out.println(rs.getString("dorsal"));
			
			//Modificar el port Angliru que el dorsal del guanyador siga Adriano Baffi
			
			sql="select dorsal from ciclista where nombre='Adriano Baffi'";
			pstmt=con.prepareStatement(sql);
			rs.first();
			int vdorsal = rs.getInt(1);
			
			sql="Select * from puerto where nompuerto='Angliru'";
			
			pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
			rs.first();
			rs.updateInt("dorsal", vdorsal);
			rs.updateRow();
			
			
			
			
			
			

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
