package interfaces;

import connectionjdbc.ConnectionJdbc;

public class PruebaConexion {
	public static void main(String[] args) {
		ConnectionJdbc con = null;
		
		try {
			con = new ConnectionJdbc("configuracion/PropiedadesAvions");
			con.conectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
