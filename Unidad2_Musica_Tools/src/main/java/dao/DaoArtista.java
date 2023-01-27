package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Artista;

public class DaoArtista 
	extends DaoGenericoHibernate<Artista,String> {
	private final static Logger 
	LOGGER=Logger.getLogger(DaoArtista.class.getName());
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ejercicio12iv(String funcion) throws BusinessException{
		List<Object[]> artistas = new ArrayList<Object[]>();
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query q = s.createQuery("SELECT p.artista.nombre, p.grupo.nombre, c.nombre FROM Pertenece p join p.grupo.clubs c WHERE funcion=:funcion")
					.setParameter("funcion", funcion);
			//Query q = s.createQuery("SELECT a.nombre , p.grupo.nombre, c.nombre FROM Artista a join a.perteneces p join p.grupo.clubs c WHERE funcion=:funcion")
					//.setParameter("funcion",funcion);

			artistas = q.list();
			
			s.getTransaction().commit();
			
			return artistas;

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en el rollback");
			}
		}
		
		return artistas;
	}

}
