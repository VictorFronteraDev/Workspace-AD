package interfaz;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;
import dao.DaoLibro;
import pojos.Libro;

public class Ejercicio3 {
	public static void main(String[] args) {
		ConnectionJdbc conJdbc = null;
		Libro l = null;
		DaoLibro daoLibro = null;
		
		Scanner tec = new Scanner(System .in);
		
		try {
			conJdbc = new ConnectionJdbc("configuracion/PropiedadesBiblioteca");
			conJdbc.conectar();
			Calendar cAhora = Calendar.getInstance();
			Date fechaAlta = cAhora.getTime();
			
			System.out.println("Insertar Libro");
			
			System.out.println("Inserte un isbn: ");
			String isbn = tec.nextLine();
			
			System.out.println("Insertar un titulo: ");
			String titulo = tec.nextLine();
			
			System.out.println("Inserte un autor: ");
			String autor = tec.nextLine();
			
			System.out.println("Inserte el numero de paginas: ");
			int nPaginas = tec.nextInt();
			tec.nextLine();
			
			System.out.println("Inserte el la fecha de alta yyyy/MM/dd");
			String sFechaAlta = tec.nextLine();

			fechaAlta = new SimpleDateFormat("yyyy/MM/dd").parse(sFechaAlta);
			
			l = new Libro();
			
			l.setIsbn(isbn);
			l.setTitulo(titulo);
			l.setAutor(autor);
			l.setNumPaginas(nPaginas);
			l.setFechaAlta(fechaAlta);
			
			daoLibro = new DaoLibro();
			
			daoLibro.grabar(l);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
