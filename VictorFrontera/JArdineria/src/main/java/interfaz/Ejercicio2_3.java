package interfaz;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Empleados;
import pojos.Oficinas;

public class Ejercicio2_3 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();

		List<Empleados> empleados = new ArrayList<Empleados>();
		
		List<Oficinas> oficinas = new ArrayList<Oficinas>();
		
		session.beginTransaction();
		Oficinas o = session.get(Oficinas.class, "BCN-ES");
		if(o != null) {
			for (Empleados empleado : empleados) {
				if(empleado.getOficinas().getCodigoOficina().equals("MAD-ES")) {	
					empleado.setOficinas(o);
					session.save(empleado);
				}
			}
		}

		session.getTransaction().commit();
		factory.close();
	}
}
