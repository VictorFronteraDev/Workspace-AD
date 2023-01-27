package _12ejercicioshibernate.b;

import dao.DaoArtista;
import dao.DaoGrupo;
import dao.DaoPertenece;
import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Artista;
import pojos.Grupo;
import pojos.Pertenece;
import pojos.PerteneceId;

public class _02Ejercicio {
	public static void main(String[] args) {

		UtilesHibernate.openSession();

		Integer codGrupo = 6;
		String dniArtista = "1111114444";
		String funcion = "saxofon";
		Grupo g = null;
		Artista a = null;

		PerteneceId pId = null;
		Pertenece p = null;

		try {
			DaoGrupo daoGrupo = new DaoGrupo();
			DaoArtista daoArtista = new DaoArtista();
			DaoPertenece daoPertenece = new DaoPertenece();
			g = daoGrupo.buscarPorId(codGrupo);
			a = daoArtista.buscarPorId(dniArtista);
			if (g != null && a != null) {
				p = daoPertenece.buscarPorId(new PerteneceId(dniArtista, codGrupo));
				p.setFuncion(funcion);
				daoPertenece.actualizar(p);

			} else {
				System.out.println("El grupo o artista indicado no existe");
			}

		} catch (BusinessException e) {
			System.out.println(e);
		}
	}

}
