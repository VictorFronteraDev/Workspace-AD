package interfaces;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;


public class _02AnyadirCiclista {
	
	public static void main(String[] args) {
		
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		String nombre = "Rayo McQueen";
		
		Ciclista c = new Ciclista();
		session.beginTransaction();
		Equipo eq = session.get(Equipo.class,"Kelme");
		if(eq != null) {
			c.setNombre(nombre);
			c.setEquipo(eq);
			session.save(c);
		}
		session.getTransaction().commit();
		factory.close();
	}
}
