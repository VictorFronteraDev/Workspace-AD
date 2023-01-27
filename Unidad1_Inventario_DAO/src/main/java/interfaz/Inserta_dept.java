package interfaz;

import java.net.ConnectException;
import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;
import dao.DaoDepartamento;
import excepcions.BusinessException;
import pojos.Departamento;

public class Inserta_dept {

	public static void main(String[] args) {
		ConnectionJdbc conJdbc = null;
		Departamento d = null;
		DaoDepartamento daoDepartamento = null;
		String nombre = null;
		// Conectar Bd ruta fitxer configuracio
		try {
			conJdbc = new ConnectionJdbc("configuracion\\PropiedadesInventario");
			conJdbc.conectar();

			// Llegir de la interfaz nom departament
			Scanner tec = new Scanner(System.in);
			System.out.println("Nombre del departamento:");
			nombre = tec.nextLine();
			// Crear Pojo departamento d
			// d = new Departamento(null,nombre);
			d = new Departamento();
			d.setNombre(nombre);
			// Instanciar objecte clase DaoDepartamento .grabar(d)

			daoDepartamento = new DaoDepartamento();

			daoDepartamento.grabar(d);

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}

}
