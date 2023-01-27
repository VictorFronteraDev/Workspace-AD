package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Persona;
import pojos.Situacion;

public class Ejercicio1b {
	public static void main(String[] args) {
		
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Situacion s = new Situacion();
		
		int hora = 11;
		String lugar = "jardin";
		String vestuario = "gabardina";
		String mercancia = "agua";
		
		session.beginTransaction();
		Persona p = session.get(Persona.class, "14");
		
		if(p != null) {
			s.setHora(hora);
			s.setLugar(lugar);
			s.setPersona(p);
			s.setVestuario(vestuario);
			s.setMercancia(mercancia);
			session.save(s);
		}
		
		session.getTransaction().commit();
		
		factory.close();
	}

}
