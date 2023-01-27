package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Etapa;

public class _14SacarNumeroDePuertoDeUnaEtapa {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		Etapa e = session.get(Etapa.class, 11);
		
		System.out.println(e.getPuertos().size());
		
		session.getTransaction().commit();
		factory.close();
	}

}
