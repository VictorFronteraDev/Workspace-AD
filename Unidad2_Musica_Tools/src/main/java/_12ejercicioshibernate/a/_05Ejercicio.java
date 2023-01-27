package _12ejercicioshibernate.a;

import java.util.List;
import java.util.Scanner;

import dao.DaoCompanyia;
import hibernate.UtilesHibernate;

public class _05Ejercicio {
	public static void main(String[] args) {

		Scanner tec = new Scanner(System.in);

		UtilesHibernate.openSession();
		
		
		try {
			DaoCompanyia daoComp = new DaoCompanyia();
			List<Object[]> companyias = daoComp.ejercicio12v();
			
			if(companyias != null) {
				for (Object[] companyia : companyias) {
					System.out.println("Companyia: " + companyia[0] + "\t Grupo: " + companyia[1]);
				}
			} else {
				System.out.println("No existe la conpanyia.");
			}	
			
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		tec.close();
	}

}
