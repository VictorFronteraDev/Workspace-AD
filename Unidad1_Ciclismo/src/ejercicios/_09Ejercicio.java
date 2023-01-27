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

public class _09Ejercicio {
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
			
			
			
			
			
			//l) Actualiza el valor dels mallot de tipus prova incrementa el valor del premi en 100€
			Integer vPremio = 0;
			Scanner tec = new Scanner(System.in);
			System.out.println("Tipo de maillot: ");
			String vTipo = tec.nextLine();
			
			

			sql = "SELECT premio from maillot where tipo=?";

			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, vTipo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vPremio=rs.getInt("premio");
				rs.updateInt("premio", vPremio+100);
				rs.updateRow();
			}
			
			//m) Mostra el valor de l'ultim registre de la taula ETAPA
			System.out.println("ultimo registro en la tabla etapa");
			sql="select * from etapa";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE);
			rs = pstmt.executeQuery();
			
			rs.last();
			System.out.println(rs.getInt("netapa") + " - " + rs.getInt("km") + " - " + rs.getString("salida") + " - " 
			+ rs.getString("llegada") + " - " + rs.getInt("dorsal"));
			
			
			
			
			//n) Quina es la tercera etapa mes llarga
			
			sql = "SELECT netapa, km from etapa order by km desc";
			pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE);
			rs = pstmt.executeQuery();
			
			rs.absolute(3);
			System.out.println(rs.getInt(1) + " - " + rs.getInt(2));
			
			
			//o) Modifica l'equip del *ciclita amb dorsal 1 al equipe Artiach 
			
			sql="update ciclista set nomeq = 'Artiach' where dorsal = '1'";
			pstmt = con.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE);
			pstmt.executeUpdate();
			
			
			//p) Inserir un nou equip *CicliValencia utilitzant la interfície de ResultSet
			
			sql="select * from equipo";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
			rs.moveToInsertRow();
			rs.updateString(1, "CicliValencia");
			rs.updateString(2, "Adrian Carmona");
			rs.insertRow();

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
