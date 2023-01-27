package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;

public class _07ModificarEtapa {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Ciclista c = null;
		Etapa e = null;
		
		session.beginTransaction();
		c = session.get(Ciclista.class, 9);
		e = session.get(Etapa.class, 22);
		e.setCiclista(c);

		session.getTransaction().commit();
		
		e.setLlegada("Reus");
		e.setKm(455);
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(e);
		e.setKm(56);
		
		session.getTransaction().commit();		
		factory.close();
	}

}
