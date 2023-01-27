package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;

public class _03AnyadirEtapa {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		//Insertar etapa
		Etapa e = new Etapa();
		
		session.beginTransaction();
		
		Ciclista c = session.get(Ciclista.class, 1);
		
		if(c != null) {
			e.setCiclista(c);
			e.setNetapa(22);
			e.setKm(850);
			e.setSalida("Mi casa");
			e.setLlegada("Casa el Adrian");
			session.save(e);
		}
		
		session.getTransaction().commit();
		factory.close();
	}
}
