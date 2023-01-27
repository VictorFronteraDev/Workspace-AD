package _12ejercicioshibernate.b;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import dao.DaoCancion;
import dao.DaoCompanyia;
import dao.DaoDisco;
import dao.DaoGrupo;
import exceptions.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Cancion;
import pojos.Companyia;
import pojos.Disco;
import pojos.Grupo;

public class _01Ejercicio {
	public static void main(String[] args) {

		Scanner tec = new Scanner(System.in);

		UtilesHibernate.openSession();
		
		Set<Cancion> canciones = new HashSet<Cancion>();
		
		DaoCompanyia daoComp = new DaoCompanyia();
		Companyia comp = null;
		
		DaoGrupo daoGrupo = new DaoGrupo();
		Grupo grupo = null;
		
		try {
			comp = daoComp.buscarPorNombre("Island");
			grupo = daoGrupo.buscarPorId(1);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		String nombreCancion = "Cancion clase";
		String nombreDisco = "Ejercicios clase";
		
		LocalDateTime dateNow = LocalDateTime.now();
		
		//Date date = new Date(dateNow);

		crearCancion(nombreCancion);
		DaoCancion daoCancion = new DaoCancion();
		try {
			canciones.add(daoCancion.buscarPorNombre(nombreCancion));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		//crearDisco(nombreDisco, date, comp, grupo, canciones);
		
		tec.close();
	}
	
	public static void crearDisco(String nombreDisco, Date date, Companyia companyia, Grupo grupo, Set<Cancion> canciones){
		DaoDisco daoDisco = new DaoDisco();
		//Companyia companyia, Grupo grupo, String nombre, Date fecha, Set<Cancion> cancions
		Disco d = new Disco(companyia, grupo, nombreDisco, date, canciones);
		
		
	}
	
	public static void crearCancion(String nombre) {
		DaoCancion daoCancion = new DaoCancion();
		Cancion c = new Cancion(nombre);
		
		try {
			daoCancion.grabar(c);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}
