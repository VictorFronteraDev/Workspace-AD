package ejemplos;

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

public class Plantilla {
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


