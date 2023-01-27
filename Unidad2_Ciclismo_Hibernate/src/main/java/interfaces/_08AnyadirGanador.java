package interfaces;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Premio;

public class _08AnyadirGanador {
	public static void main(String[] args) {
		List<Ciclista> ciclistas = new ArrayList<Ciclista>();
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		session.beginTransaction();
		
		Ciclista c = session.get(Ciclista.class, 2);
		Premio p = session.get(Premio.class, 1);
		
		
		ciclistas = p.getCiclistas();
		ciclistas.add(c);
		p.setCiclistas(ciclistas);
		
		session.getTransaction().commit();
		factory.close();
		
		
	}

}
