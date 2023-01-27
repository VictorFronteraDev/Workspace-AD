package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;

public class _09Exemples03 {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		
		
		
		session.getTransaction().commit();
		factory.close();
	}

}
