package interfaz;

import java.util.Scanner;

import dao.DaoCompanyia;
import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Companyia;

public class _01InsertarConpanyia {
	public static void main(String[] args) {
		//Conectar BD Hibernate
		Companyia comp = null;
		String director, fax, nombre, telefono = null;
		UtilesHibernate.openSession();
		//Crear el pojo Companyia dades Usuari
		Scanner tec = new Scanner(System.in);
		System.out.println("Nombre del director:");
		director = tec.nextLine();
		
		System.out.println("Fax:");
		fax = tec.nextLine();
		
		System.out.println("Nombre");
		nombre = tec.nextLine();
		
		System.out.println("Telefono");
		telefono = tec.nextLine();
		
		comp = new Companyia(nombre, director, fax, telefono, null);
		
		try {
			DaoCompanyia daoComp = new DaoCompanyia();
			daoComp.grabar(comp);
		} catch (BusinessException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
		tec.close();
	}
}
