package interfaz;

import java.util.List;
import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;
import dao.DaoArticulo;
import dao.DaoDepartamento;
import pojos.Articulo;

public class A4 {
	public static void main(String[] args) {
		ConnectionJdbc con = null;
		Articulo art = null;
		DaoDepartamento daoDepartamento = null;
		DaoArticulo daoArticulo = null;
		try {
			con = new ConnectionJdbc("configuracion/PropiedadesInventario");
			con.conectar();
			
			Scanner tec = new Scanner(System.in);
			
			System.out.println("Descripcion del modelo: ");
			String descripcion = tec.nextLine();
			List<Articulo> idmodelo = daoArticulo.consultarArticulosPorModeloDescripcion(descripcion);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
