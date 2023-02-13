package ejercicios_bd_musica_orm;

import java.util.Scanner;

import dao.DaoClub;
import dao.DaoGrupo;
import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Club;
import pojos.Grupo;

public class _01b {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		UtilesHibernate.openSession();
		
		String nombre = null;
		String sede = null;
		Short num = null;
		Integer grupo = 6;
		Grupo g = null;
		Club c = null;
		
		System.out.println("Nombre del club");
		nombre = tec.nextLine();
		
		System.out.println("Donde esta la sede");
		sede = tec.nextLine();
		
		System.out.println("Introduce el numero");
		num = tec.nextShort();
		tec.nextLine();
		
		try {
			DaoClub daoClub = new DaoClub();
			DaoGrupo daoGrupo = new DaoGrupo();
			g = daoGrupo.buscarPorId(grupo);
			
			if(g != null) {
				c = new Club();
				c.setGrupo(g);
				c.setNombre(nombre);
				c.setNum(num);
				c.setSede(sede);
				
				daoClub.grabar(c);
			}
			
		} catch (BusinessException e) {
			System.out.println(e);
		}
		
		tec.close();
	}

}
