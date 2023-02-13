package ejercicios_bd_musica_orm;

import java.util.List;
import java.util.Scanner;

import dao.DaoCancion;
import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Cancion;

public class _02l {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		UtilesHibernate.openSession();
		
		String nombreDisco = null;
		double duracion = 0;
		
		List<Cancion> canciones = null;
		
		System.out.println("Nombre del disco (si no quieres filtar por nombre dejalo vacio)");
		nombreDisco = tec.nextLine();
		
		System.out.println("Duracion de la cancion (si no quieres filtar por nombre dejalo vacio)");
		duracion = tec.nextDouble();
		
		try {
			DaoCancion daoCancion = new DaoCancion();
			canciones = daoCancion.entrega02j(nombreDisco, duracion);
			
			for (Cancion cancion : canciones) {
				System.out.println(cancion.getTitulo());
			}
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		
	}

}
