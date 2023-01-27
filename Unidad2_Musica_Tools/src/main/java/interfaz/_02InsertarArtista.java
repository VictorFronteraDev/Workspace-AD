package interfaz;

import java.util.Scanner;

import dao.DaoArtista;
import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Artista;

public class _02InsertarArtista {
	public static void main(String[] args) {
		//Conectar BD Hibernate
		Artista art = null;
		String dni, nombre = null;
		UtilesHibernate.openSession();
		//Crear pojo Artista dades usuari
		Scanner tec = new Scanner(System.in);
		System.out.println("DNI:");
		dni = tec.nextLine();
		System.out.println("Nombre:");
		nombre = tec.nextLine();
		
		art = new Artista(dni, nombre, null);
		
		try {
			DaoArtista daoArt = new DaoArtista();
			daoArt.grabar(art);
		} catch (BusinessException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	
		tec.close();
	}

}
