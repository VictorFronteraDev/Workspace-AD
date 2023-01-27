package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Equipo;

public class _01Anyadir {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		
		Equipo eq = new Equipo();
		
		eq.setNombre("dam22");
		eq.setDirector("Javier");
		
		session.save(eq);
		session.getTransaction().commit();
		factory.close();
		
	}
	

}
