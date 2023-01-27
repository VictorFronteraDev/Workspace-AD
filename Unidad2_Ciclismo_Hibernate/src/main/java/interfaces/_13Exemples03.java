package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;
import pojos.Puerto;

public class _13Exemples03 {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Ciclista c = session.get(Ciclista.class, 4);

		if (c != null) {
			System.out.println("\nEl ciclista " + c.getNombre() +
					" ha ganado las estapas con las salida/llegada: ");
			for (Etapa e : c.getEtapas()) {
				System.out.print(e.getSalida() + "/" + e.getLlegada() + " ");
			}
			System.out.println("\nEl ciclista " + c.getNombre() + 
					" ha ganado los puertos con el nombre: ");
			for (Puerto p : c.getPuertos()) {
				System.out.print(p.getNompuerto() + " ");
			}

		}

		session.getTransaction().commit();
		factory.close();
	}

}
