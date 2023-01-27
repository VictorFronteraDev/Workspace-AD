package _12ejercicioshibernate.a;

import java.util.List;
import java.util.Scanner;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;

public class _03Ejercicio {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		UtilesHibernate.openSession();
		
		try {
			DaoGrupo daoGrupo = new DaoGrupo();
			List<Object[]> grupos= daoGrupo.ejercicio12iii();
			
			if(grupos != null) {
				for (Object[] grupo : grupos) {
					System.out.println(grupo[0] + " " + grupo[1] + " " + grupo[2]);
				}
			} else {
				System.out.println("No existe la compañia con ese nombre");
			}	
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			
		}

		tec.close();
	}

}
