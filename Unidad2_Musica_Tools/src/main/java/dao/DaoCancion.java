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
import pojos.Cancion;

public class DaoCancion 
	extends DaoGenericoHibernate<Cancion,Integer> {
	private final static Logger 
	LOGGER=Logger.getLogger(DaoCancion.class.getName());
	
	public Cancion buscarPorNombre(String nombre) throws BusinessException {
		Cancion cancion = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query q = s.createQuery("SELECT c FROM Cancion c where c.nombre=:nombre").setParameter("nombre", nombre);

			cancion  = (Cancion) q.uniqueResult();
			
			s.getTransaction().commit();
			
			return cancion ;
			
			

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en el rollback");
			}
		}

		return cancion ;
	}
	
	public List<Cancion> ejercicio12i(double duracion) {
		List<Cancion> cancion = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query q = s.createQuery("SELECT c FROM Cancion c WHERE c.duracion > :duracion").setParameter("duracion", duracion);

			cancion = (List<Cancion>) q.list();
			
			s.getTransaction().commit();
			
			return cancion;

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en el rollback");
			}
		}
		
		return cancion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cancion> ejercicio1ii(Double duracion, Integer anyo) {
		List<Cancion> cancion = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query q = s.createQuery("SELECT DISTINCT c FROM Cancion c join c.discos d WHERE c.duracion >:dur and year (d.fecha) >:fecha")
						.setParameter("dur", duracion)
						.setParameter("fecha", anyo);

			cancion = q.list();
			
			s.getTransaction().commit();
			
			return cancion;

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en el rollback");
			}
		}
		
		return cancion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cancion> entrega02j(String nombre, double duracion) throws BusinessException {
		List<Cancion> canciones = new ArrayList<Cancion>();
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		
		try {
			s.beginTransaction();
			
			if(nombre != "" && duracion == 0) {
				@SuppressWarnings("rawtypes")
				Query q = s.createQuery("SELECT titulo FROM Cancion c where discos.nombre =:nombre").setParameter("nombre", nombre);

				canciones = q.list();
				
				s.getTransaction().commit();
				
				return canciones;
			} else if(nombre.equals("") && duracion > 0.0) {
				@SuppressWarnings("rawtypes")
				Query q = s.createQuery("SELECT titulo FROM Cancion c where c.duracion >=:duracion").setParameter("duracion", duracion);

				canciones = q.list();
				
				s.getTransaction().commit();
				
				return canciones;
			} else {
				@SuppressWarnings("rawtypes")
				Query q = s.createQuery("SELECT titulo FROM Cancion c where discos.nombre =:nombre AND c.duracion >=:duracion")
				.setParameter("nombre", nombre)
				.setParameter("duracion", duracion);

				canciones = q.list();
				
				s.getTransaction().commit();
				
				return canciones;
			}

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en el rollback");
			}
		}
		
		return canciones;
	}
	

}