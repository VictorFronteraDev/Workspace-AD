package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Gamasproductos;
import pojos.Productos;

public class Ejercicio2_2 {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Scanner tec = new Scanner(System.in);
		
		System.out.println("Codigo producto");
		String codPro = tec.nextLine();
		
		System.out.println("Nombre");
		String nombre = tec.nextLine();
		
		System.out.println("Gama");
		String gama = tec.nextLine();
		tec.nextLine();
		
		System.out.println("Cantidad en stock");
		int cantStock = tec.nextInt();
		
		System.out.println("Precio venta");
		int precioVenta = tec.nextInt();
		
		session.beginTransaction();
		
		Gamasproductos gp = session.get(Gamasproductos.class, gama);
		
		Productos p = new Productos();
		
		p.setCodigoProducto(codPro);
		
		session.getTransaction().commit();
		factory.close();
	}

}
