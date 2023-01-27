package _12ejercicioshibernate.b;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.DaoCancion;
import dao.DaoCompanyia;
import dao.DaoDisco;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojos.Cancion;
import pojos.Companyia;
import pojos.Disco;
import pojos.Grupo;

public class _01EjercicioCorregido {
	public static void main(String[] args) {
		
		Integer comp = 1, grupo = 1;
		Disco disco = null;
		Cancion cancion = null;
		Date fechaDisco = null;
		
		
		
		UtilesHibernate.openSession();
		
		
		try {
			fechaDisco = new SimpleDateFormat("dd/MM/yyyy").parse("10/01/2023");
			DaoCompanyia daoComp = new DaoCompanyia();
			DaoGrupo daoGrupo = new DaoGrupo();
			DaoDisco daoDisco = new DaoDisco();
			DaoCancion daoCancion = new DaoCancion();
			Grupo g = daoGrupo.buscarPorId(grupo);
			Companyia c = daoComp.buscarPorId(comp);
			if (c != null && g != null) {
				disco = new Disco();
				disco.setCompanyia(c);
				disco.setGrupo(g);
				disco.setFecha(fechaDisco);
				disco.setNombre("Disco ejercicio 12b i");
				
				cancion = new Cancion();
				cancion.setDuracion(3.5);
				cancion.setTitulo("Cancion ejercicio 12b i");
				cancion.getDiscos().add(disco);
				
				daoDisco.grabar(disco);
				daoCancion.grabar(cancion);
				
			} else {
				System.out.println("Companyia o grupo no existe");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
