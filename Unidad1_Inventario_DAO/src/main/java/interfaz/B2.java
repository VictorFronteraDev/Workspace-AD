package interfaz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;
import dao.DaoArticulo;
import dao.DaoDepartamento;
import pojos.Articulo;

public class B2 {
	public static void main(String[] args) {
		ConnectionJdbc con = null;
		Articulo articulo = null;
		DaoArticulo daoArticulo = new DaoArticulo();
		DaoDepartamento daoDepartamento = new DaoDepartamento();
		
		Integer idArticulo = 1100026, idDepartamento = null, idEspacio = 2, idUsuarioAlta = 481, idModelo = 3189;
		String estado = "operativo", numSerie = "ORD123", sfechaAlta = "", nomDepartamento = "Informática";
		Date vfechaAlta;
		Boolean fin = false;

		try {
			con = new ConnectionJdbc("configuracion/PropiedadesInventario");
			con.conectar();
			
			Calendar cAhora = Calendar.getInstance();
			Date fAhora = cAhora.getTime();
			
			Scanner tec = new Scanner(System.in);

			System.out.println("Fecha de alta yyyy/MM/dd");
			String sFecha = tec.nextLine();
			vfechaAlta = new SimpleDateFormat("yyyy/MM/dd").parse(sFecha);

			if (fAhora.before(vfechaAlta)) {
				System.out.println("La fecha de alta no puede ");
			} else {
				daoDepartamento = new DaoDepartamento();
				idDepartamento = daoDepartamento.buscarPorNombre(nomDepartamento);
				
				articulo = new Articulo();
				articulo.setIdArticulo(idArticulo);
				articulo.setDepartamento(idDepartamento);
				articulo.setEspacio(idEspacio);
				articulo.setFechaAlta(vfechaAlta);
				articulo.setUsuarioAlta(idUsuarioAlta);
				articulo.setEstado(estado);
				articulo.setModelo(idModelo);
				daoArticulo = new DaoArticulo();
				fin = daoArticulo.grabarAlta(articulo);
				
				if (fin) {
					System.out.println("La insercion se ha realizado");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.desconectar();
		}
	}
}
