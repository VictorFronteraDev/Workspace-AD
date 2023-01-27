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
import pojos.Companyia;

public class DaoCompanyia extends DaoGenericoHibernate<Companyia, Integer> {
	private final static Logger LOGGER = Logger.getLogger(DaoCompanyia.class.getName());

	public Companyia buscarPorNombre(String nombre) throws BusinessException {
		Companyia comp = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query q = s.createQuery("SELECT c FROM Companyia c where c.nombre=:nombre").setParameter("nombre", nombre);

			comp = (Companyia) q.uniqueResult();
			
			s.getTransaction().commit();
			
			return comp;
			
			

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en el rollback");
			}
		}

		return comp;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ejercicio12v() throws BusinessException{
		List<Object[]> companyias = new ArrayList<Object[]>();
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query q = s.createQuery("SELECT DISTINCT c.nombre, d.grupo.nombre FROM Companyia c left join c.discos d ");

			companyias = q.list();
			
			s.getTransaction().commit();
			
			return companyias;

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en el rollback");
			}
		}
		
		return companyias;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ejercicio12vi() throws BusinessException{
		List<Object[]> companyias = new ArrayList<Object[]>();
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query q = s.createQuery("SELECT DISTINCT c.nombre, a.nombre FROM Companyia c left join c.discos d left join d.grupo g "
					+ " left join g.perteneces p left join p.artista a");

			companyias = q.list();
			
			s.getTransaction().commit();
			
			return companyias;

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en el rollback");
			}
		}
		
		return companyias;
	}
}
