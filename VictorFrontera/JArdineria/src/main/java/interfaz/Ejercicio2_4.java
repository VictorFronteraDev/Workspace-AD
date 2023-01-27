package interfaz;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Productos;

public class Ejercicio2_4 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		BigDecimal subidaPrecio = new BigDecimal("2");
		
		
		session.beginTransaction();
		Productos p = session.get(Productos.class, "30310");
		
		if(p != null) {
			BigDecimal precioActualProveedor = p.getPrecioProveedor();
			BigDecimal precioActualVenta = p.getPrecioVenta();
			
			p.setPrecioProveedor(precioActualProveedor.add(subidaPrecio));
			p.setPrecioVenta(precioActualVenta.add(subidaPrecio));
			session.save(p);
		}
		
		
		session.getTransaction().commit();
		factory.close();
	}
}
