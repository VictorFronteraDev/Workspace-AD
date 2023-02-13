package ejercicios_bd_musica_orm;

import java.util.Scanner;

import dao.DaoDisco;
import hibernate.UtilesHibernate;

public class _02j {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		UtilesHibernate.openSession();
		
		DaoDisco daoDisco = new DaoDisco();
		
	}

}
