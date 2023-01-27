package interfaz;

import java.util.Scanner;

import dao.DaoCompanyia;
import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Companyia;

public class _04BuscarCompanyiaPorNombre {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		String nombre = null;
		
		UtilesHibernate.openSession();
		
		System.out.println("Nombre:");
		nombre = tec.nextLine();
		
		try {
			DaoCompanyia daoComp = new DaoCompanyia();
			Companyia comp = daoComp.buscarPorNombre(nombre);
			
			if(comp!=null) {
				System.out.println(comp.getTfno() + " - " + comp.getFax());
			} else {
				System.out.println("No existe la compañia con ese nombre");
			}
			
			
		} catch (BusinessException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			
		}
		
		tec.close();
	}

}
