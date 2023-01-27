package interfaz;

import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;
import dao.DaoArticulo;
import pojos.Articulo;

public class B1 {
	public static void main(String[] args) {
		ConnectionJdbc con = null;
		Articulo art = null;
		DaoArticulo daoArticulo = new DaoArticulo();
		int id = 0;
		
		try {
			con = new ConnectionJdbc("configuracion/PropiedadesInventario");
			con.conectar();
			Scanner tec = new Scanner(System.in);
			
			System.out.println("ID: ");
			id = tec.nextInt();
			String estado = daoArticulo.cogerEstado(id);
			
			System.out.println("introduzaca el estado al que quiere cambiarlo");
			tec.nextLine();
			String estadoCambiado = tec.nextLine();
			if(estado.equals("retirat")) {
				System.out.println("El articulo esta retirado no se puede cambiar el estado");
			} else {
				daoArticulo.cambiarEstado(estado,estadoCambiado ,id);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
