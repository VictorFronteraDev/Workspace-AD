package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;
import pojos.Puerto;

public class _10Exemples04 {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Puerto p = new Puerto();
		
		session.beginTransaction();
		
		Etapa e = session.get(Etapa.class, 12);
		Ciclista c = session.get(Ciclista.class, 10);
		
		p.setCiclista(c);
		p.setEtapa(e);
		p.setNompuerto("Ampriu");
		p.setAltura(1911);
		p.setCategoria("E");
		p.setPendiente(8.0);
		session.save(p);	

		session.getTransaction().commit();
		factory.close();
	}

}
