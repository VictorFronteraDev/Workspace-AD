package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Equipo;

public class _12Example02 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Equipo e = session.get(Equipo.class, "dam2");
		
		if(e != null) {
			session.delete(e);
		}
		session.getTransaction().commit();
		factory.close();
	}
}
