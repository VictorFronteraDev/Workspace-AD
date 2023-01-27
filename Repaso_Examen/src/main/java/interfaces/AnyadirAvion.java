package interfaces;

import java.net.ConnectException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;
import dao.DaoAvion;
import excepcions.BusinessException;
import pojos.Avion;

public class AnyadirAvion {
	public static void main(String[] args) {
		ConnectionJdbc conJdbc = null;
		Avion a = null;
		DaoAvion daoAvion = null;
		Scanner tec = new Scanner(System.in);
		
		try {
			conJdbc = new ConnectionJdbc("configuracion/PropiedadesAvions");
			conJdbc.conectar();
		System.out.println("Insertar Avion");
		System.out.println("Inserte un numero de avion:");
		Integer num = tec.nextInt();
		
		System.out.println("Inserte una matricula:");
		Integer matricula = tec.nextInt();
		tec.nextLine();
		
		System.out.println("Inserte la fecha de registro en formato dd/mm/yyyy:");
		String fechaRegistroTxt = tec.nextLine();
		
		System.out.println("Inserte la antiguedad del avion;");
		Integer antiguedad = tec.nextInt();
		
		System.out.println("Inserte el codigo del hangar donde estará ubicado:");
		Integer hangars_codigo = tec.nextInt();
		tec.nextLine();
		
		System.out.println("Inserte la fecha de compra;");
		String fechaCompraTxt = tec.nextLine();
		
		System.out.println("Inserte el codigo de la companyia");
		Integer companyia_codigo = tec.nextInt();
		
		System.out.println("Inserte cod_t_avion");
		Integer tipoAvionCodigo = tec.nextInt();
		
		SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy");
		Date fechaCompra = sf.parse(fechaCompraTxt);
		
		Date fechaRegistro = sf.parse(fechaRegistroTxt);
		
		a = new Avion();
		
		a.setNum(num);
		a.setMatricula(matricula);
		a.setFechaRegistro(fechaCompra);
		a.setAntiguedad(antiguedad);
		a.setHangarsCodigo(hangars_codigo);
		a.setFechaCompra(fechaRegistro);
		a.setCompanyiaCodigo(companyia_codigo);
		a.setCodTAvion(tipoAvionCodigo);
		
		daoAvion = new DaoAvion();
		
		daoAvion.grabar(a);
		
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}

}
