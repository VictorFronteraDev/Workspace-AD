package interfaz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;
import dao.DaoLibro;

public class Ejercicio5 {
	public static void main(String[] args) {
		ConnectionJdbc conJdbc = null;
		DaoLibro daoLibro = null;
		Scanner tec = new Scanner(System.in);

		try {
			conJdbc = new ConnectionJdbc("configuracion/PropiedadesBiblioteca");
			conJdbc.conectar();
			Calendar cAhora = Calendar.getInstance();
			Date fechaDevolucion = cAhora.getTime();
			System.out.println("Introduzca el login de usuairo: ");
			String login = tec.nextLine();
			
			System.out.println("Introduzca el isbn del libr: ");
			String isbn = tec.nextLine();
			
			System.out.println("Introduzca la fecha de devolucion yyyy/MM/dd: ");
			String sFechaDevolucion = tec.nextLine();
			
			fechaDevolucion = new SimpleDateFormat("yyyy/MM/dd").parse(sFechaDevolucion);
			
			daoLibro = new DaoLibro();
			
			daoLibro.comprobarEstadoOperacion(isbn, login, fechaDevolucion);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
