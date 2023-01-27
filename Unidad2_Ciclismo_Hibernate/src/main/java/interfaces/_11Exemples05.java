package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Puerto;

public class _11Exemples05 {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		session.beginTransaction();

		Ciclista c = session.get(Ciclista.class, 8);
		Puerto p = session.get(Puerto.class, "ampriu");
		p.setCiclista(c);
		
		System.out.println();
		
	
		session.getTransaction().commit();
		factory.close();
	}

}
