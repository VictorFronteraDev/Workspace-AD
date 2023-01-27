package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;

public class UtilesHibernate {
	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();

		} catch (Throwable e) {
			System.err.println("Error al crear la SessionsFactory." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void openSession() {
		ThreadLocalSessionContext.bind(sessionFactory.openSession());
	}

	public static void closeSession() {
		Session session = ThreadLocalSessionContext.unbind(sessionFactory);
		if(session != null) {
			session.close();
		}
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory != null && !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}

}
