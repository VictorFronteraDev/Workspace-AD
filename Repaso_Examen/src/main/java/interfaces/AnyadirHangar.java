package interfaces;

import java.net.ConnectException;
import java.text.ParseException;
import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;
import dao.DaoHangar;
import excepcions.BusinessException;
import pojos.Hangar;

public class AnyadirHangar {
	public static void main(String[] args) {
		ConnectionJdbc con = null;
		Hangar h = null;
		DaoHangar daoHangar = null;
		Scanner tec = new Scanner(System.in);
		
		try {
			con = new ConnectionJdbc("configuracion/PropiedadesAvions");
			con.conectar();
			
			System.out.println("Insertar Hangar");
			System.out.println("Inserte codigo: ");
			Integer codigo = tec.nextInt();
			
			System.out.println("Inserte capacidad: ");
			Integer capacidad = tec.nextInt();
			tec.nextLine();
			
			System.out.println("Inserte localizacion");
			String localizacion = tec.nextLine();
			
			h = new Hangar();
			h.setCodigo(codigo);
			h.setCapacidad(capacidad);
			h.setLocalizacion(localizacion);
			
			daoHangar = new DaoHangar();
			
			daoHangar.grabar(h);
			
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			e.printStackTrace();
		} finally {
			con.desconectar();
		}
	}

}
