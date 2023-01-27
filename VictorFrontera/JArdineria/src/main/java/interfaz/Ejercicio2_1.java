package interfaz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Clientes;
import pojos.Pagos;
import pojos.Pedidos;

public class Ejercicio2_1 {
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Scanner tec = new Scanner(System.in);
		
		System.out.println("introduzca un id");
		int id = tec.nextInt();
		BigDecimal bd = new BigDecimal("5000");
		
		session.beginTransaction();
		List<Pedidos> pedidos = new ArrayList<Pedidos>();
		Clientes c = session.get(Clientes.class, id);
		
		System.out.println("----------------a.1--------------------");
		if(c != null) {
			System.out.println(c.getNombreCliente());
			System.out.println(c.getTelefono());
			
		}
		
		System.out.println("---------------a.ii-------------------");
		if(c != null ) {
			System.out.println(c.getPedidoses().size());
			
		}
		
		System.out.println("---------------a.iii-------------------");
		if(c != null) {
			for (Pedidos pedido : c.getPedidoses()) {
				if(pedido.getEstado().equals("Entregado")) {
					System.out.println(pedido.getFechaEntrega());
				}
			}
			
		}
		
		System.out.println("---------------a.iV-------------------");
		if(c != null) {
			for (Pagos p: c.getPagoses()) {
				if(p.getCantidad().compareTo(bd) == -1) {
					System.out.println(p.getCantidad());
				}
			}
		}
		session.getTransaction().commit();
		factory.close();
	}

}
