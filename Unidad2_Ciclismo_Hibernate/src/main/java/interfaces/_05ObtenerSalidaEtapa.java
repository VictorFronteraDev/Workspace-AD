package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;

public class _05ObtenerSalidaEtapa {
	public static void main(String[] args) {
		
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Ciclista c = session.get(Ciclista.class, 2);
		
		if(c != null) {
			System.out.println(c.getNombre());
			System.out.println("Director equipo: " + c.getEquipo().getDirector());
			
			for (Etapa e : c.getEtapas()) {
				System.out.println(e.getSalida());
			}
		}
		
		session.getTransaction().commit();
		factory.close();
	}

}
