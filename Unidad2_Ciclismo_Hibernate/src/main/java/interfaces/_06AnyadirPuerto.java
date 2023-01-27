package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;
import pojos.Puerto;

public class _06AnyadirPuerto {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Puerto p = new Puerto();
		
		session.beginTransaction();
		
		Ciclista c = session.get(Ciclista.class, 1);
		Etapa e = session.get(Etapa.class, 11);
		
		if(c != null && e != null) {
			p.setNompuerto("Bajo Naranco");
			p.setAltura(1500);
			p.setCategoria("E");
			p.setPendiente(14.0);
			p.setCiclista(c);
			p.setEtapa(e);
			session.save(p);
			
		}
		session.getTransaction().commit();
		factory.close();
		
	}

}
