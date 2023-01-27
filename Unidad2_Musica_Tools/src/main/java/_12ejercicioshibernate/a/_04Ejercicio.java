package _12ejercicioshibernate.a;

import java.util.List;
import java.util.Scanner;

import dao.DaoArtista;
import hibernate.UtilesHibernate;

public class _04Ejercicio {
	public static void main(String[] args) {

		Scanner tec = new Scanner(System.in);

		UtilesHibernate.openSession();
		
		String funcion = "batería";
		
		try {
			DaoArtista daoArt = new DaoArtista();
			List<Object[]> artistas = daoArt.ejercicio12iv(funcion);
			
			if(artistas != null) {
				for (Object[] artista : artistas) {
					System.out.println("Artista: " + artista[0] + "\t Grupo: " + artista[1] + "\t Club: " + artista[2]);
				}
			} else {
				System.out.println("No existe el artista.");
			}	
			
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		tec.close();
	}

}
