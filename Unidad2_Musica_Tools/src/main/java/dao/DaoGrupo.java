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
import pojos.Grupo;

public class DaoGrupo extends DaoGenericoHibernate<Grupo, Integer> {
	private final static Logger LOGGER = Logger.getLogger(DaoGrupo.class.getName());

	@SuppressWarnings("unchecked")
	public List<Object[]> ejercicio12iii() throws BusinessException{
		List<Object[]> grupos = new ArrayList<Object[]>();
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query q = s.createQuery("SELECT g.nombre, p.artista.nombre, p.funcion FROM Grupo g join g.perteneces p ORDER BY g.nombre ");

			grupos = q.list();
			
			s.getTransaction().commit();
			
			return grupos;

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en el rollback");
			}
		}
		
		return grupos;
	}

}