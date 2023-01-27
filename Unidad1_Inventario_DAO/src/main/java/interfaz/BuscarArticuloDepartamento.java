package interfaz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;
import dao.DaoArticulo;
import dao.DaoDepartamento;
import excepcions.BusinessException;
import pojos.Articulo;

public class BuscarArticuloDepartamento {
	public static void main(String[] args) {
		ConnectionJdbc con = null;
		Articulo art = null;
		DaoDepartamento daoDepartamento = null;
		DaoArticulo daoArticulo = null;
		String estado = null;
		Integer idDepartamento = null;
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		
		try {
			con = new ConnectionJdbc("configuracion/PropiedadesInventario");
			con.conectar();
			
			Scanner tec = new Scanner(System.in);
			
			System.out.println("Id departamento: ");
			idDepartamento = tec.nextInt();
			
			System.out.println("Estado: ");
			estado= tec.nextLine();
			
			daoArticulo = new DaoArticulo();
			listaArticulos = daoArticulo.buscar_art_dept_estado(idDepartamento, estado);
			
			for (Articulo a : listaArticulos) {
				System.out.println(a.getIdArticulo() + " " + a.getNumSerie());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
