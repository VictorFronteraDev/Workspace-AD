package interfaz;

import java.util.Scanner;

import dao.DaoArtista;
import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Artista;

public class _03BuscarArtistaPorId {
	public static void main(String[] args) {
		String dni = null;
		
		UtilesHibernate.openSession();
		
		Scanner tec = new Scanner(System.in);
		
		System.out.println("DNI:");
		dni = tec.nextLine();
		
		
		try {
			DaoArtista daoArt = new DaoArtista();
			Artista art = daoArt.buscarPorId(dni);
			System.out.println(art.getNombre());
		} catch (BusinessException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
		tec.close();
	}
}
