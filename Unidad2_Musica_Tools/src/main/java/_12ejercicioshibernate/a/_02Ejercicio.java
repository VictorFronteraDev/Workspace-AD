package _12ejercicioshibernate.a;

import java.util.List;
import java.util.Scanner;
import dao.DaoCancion;
import hibernate.UtilesHibernate;
import pojos.Cancion;
import pojos.Disco;

public class _02Ejercicio {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		UtilesHibernate.openSession();
		Double duracion = 3.0;
		Integer anyo = 1982;
		
		try {
			DaoCancion daoCan = new DaoCancion();
			List<Cancion> canciones = daoCan.ejercicio1ii(duracion, anyo);
			
			if(canciones!=null) {
				for (Cancion cancion : canciones) {
					System.out.println(cancion.getTitulo() + " - " + cancion.getDuracion());
					for (Disco disco : cancion.getDiscos()) {
						System.out.println("\t" + disco.getNombre() + " - " + disco.getFecha());
					}	
				}
			} else {
				System.out.println("No existe la compañia con ese nombre");
			}	
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			
		}

		tec.close();
	}

}
