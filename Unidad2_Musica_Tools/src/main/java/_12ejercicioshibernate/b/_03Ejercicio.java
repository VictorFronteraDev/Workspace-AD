package _12ejercicioshibernate.b;

import java.util.Set;

import dao.DaoCompanyia;
import dao.DaoDisco;
import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Companyia;
import pojos.Disco;

public class _03Ejercicio {
	public static void main(String[] args) {
	
		
		Integer codComp1 = 1;
		Integer codComp2 = 2;
		
		Companyia comp1 = null;
		Companyia comp2 = null;
		
		Set<Disco> d1 = null;
		Set<Disco> d2 = null;
		
		UtilesHibernate.openSession();
		
		try {
			DaoCompanyia daoComp = new DaoCompanyia();
			DaoDisco daoDisco = new DaoDisco();
			comp1 = daoComp.buscarPorId(codComp1);
			comp2 = daoComp.buscarPorId(codComp2);
			
			if(comp1 != null && comp2 != null) {
				d1 = comp1.getDiscos();
				d2 = comp2.getDiscos();
				for (Disco disco : d1) {
					disco.setCompanyia(comp2);
					daoDisco.actualizar(disco);
					
				}
			} else {
				System.out.println("Una de la companyias no existe");
			}
			
		} catch (BusinessException e) {
			System.out.println(e);
		}
		
	}
}
