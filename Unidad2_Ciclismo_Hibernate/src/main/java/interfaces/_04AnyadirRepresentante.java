package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Equipo;
import pojos.Representante;

public class _04AnyadirRepresentante {
	public static void main(String[] args) {
		
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Representante rp = new Representante();
		
		session.beginTransaction();
		
		Equipo eq = session.get(Equipo.class, "Carrera");
		
		if(eq != null) {
			rp.setId(3);
			rp.setNombre("Adriancin2");
			rp.setEquipo(eq);
			session.save(rp);
		}
		session.getTransaction().commit();
		factory.close();
		
	}

}
