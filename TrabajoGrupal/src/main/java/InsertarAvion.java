import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import connectionjdbc.ConnectionJdbc;

/**
 * @author Adrian Carmona
 * @author Victor Frontera
 */

public class InsertarAvion {
	static Scanner tec = new Scanner(System.in);
	private static Connection con = null;
	private static PreparedStatement pstmt;
	private static ResultSet rs = null;

	public static void main(String[] args) throws ConnectException, SQLException {
		System.out.println("¿Que quieres hacer?: ");
		System.out.println("Opcion 1: Conectar a la bbdd.");
		System.out.println("Opcion 2: Salir.");
		int opcion = tec.nextInt();

		if (opcion == 1) {
			conectar();
			menu();
		}
	}

	private static void conectar() throws ConnectException {
		System.out.println("Â¿Como vas a conectarte a la bbdd?: ");
		System.out.println("Opcion 1: Mediante un fichero de configuracion.");
		System.out.println("Opcion 2: Mediante parametros.");
		int opcion = tec.nextInt();
		tec.nextLine();

		ConnectionJdbc propiedades = null;
		if (opcion == 1) {
			System.out.println("Introduce la ruta del fichero de configuracion: ");
			String rutaFichero = tec.nextLine();
			propiedades = new ConnectionJdbc(rutaFichero);

		} else {
			System.out.println("Driver: ");
			String driver = tec.nextLine();
			System.out.println("Url: ");
			String url = tec.nextLine();
			System.out.println("User: ");
			String user = tec.nextLine();
			System.out.println("pwd: ");
			String pwd = tec.nextLine();

			propiedades = new ConnectionJdbc(driver, url, user, pwd);
		}

		propiedades.conectar();
		con = ConnectionJdbc.getConnection();
	}

	private static void menu() throws SQLException {
		System.out.println("Â¿Que accion quiere realizar?: ");
		System.out.println("Opcion 1: Insertar datos");
		System.out.println("Opcion 2: Consulta");
		System.out.println("Opcion 3: Modificar con restriccion");
		int opcion = tec.nextInt();
		tec.nextLine();
		String sql = "";

		switch (opcion) {
		case 1:
			System.out.println("Introduzca la secuencia sql para insertar datos: ");
			sql = tec.nextLine();
			insertar(sql);
			break;
		case 2:
			System.out.println("Introduzca la consulta sql: ");
			sql = tec.nextLine();
			consultar(sql);
			break;
		case 3:
			System.out.println("Introduzca la actualizacion: ");
			sql = tec.nextLine();
			modificar(sql);
			break;
		default:
			break;
		}

	}

	private static void insertar(String sql) throws SQLException {
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
	}

	private static void consultar(String sql) throws SQLException {
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		// Cojemos los datos para sacar el numero de columnas.
		ResultSetMetaData rsmd = rs.getMetaData();

		while (rs.next()) {
			String resultado = "";
			// Recorremos un for para mostar los datos de la consulta.
			for (int i = 1; i < rsmd.getColumnCount(); i++) {
				if (rs.getString(i) != null) {
					resultado += rs.getString(i) + " - ";
				}
			}

			// Mostramos una fila.
			System.out.println(resultado.substring(0, resultado.length() - 3));
		}
	}

	private static void modificar(String sql) throws SQLException {
		// Extraemos la tabla.
		String tabla = sql.toUpperCase().substring(7, sql.indexOf("SET") - 1);
		String[] tablas = tabla.split(" ");

		// Extraemos la modificacion que se va a realizar.
		String texto = sql.toUpperCase().substring(sql.indexOf("SET") + 4, sql.indexOf("WHERE") - 1);
		// La separamos por palabras (ej: nomeq, =, 'Artiach').
		String[] palabras = texto.split(" ");

		int cont = 0;

		// Si el UPDATE tiene mÃ¡s de dos tablas o mÃ¡s de una actualizaciÃ³n no realizara
		// la modificacion.
		if (tablas.length > 1 || palabras.length > 3) {
			System.out.println("ADVERTENCIA: Solo puedes realizar una modificacion a la vez y en una sola tabla!!!");
		} else {
			// Cojemos los valores del UPDATE desde nuestro array de palabras.
			String columna = palabras[0];
			String valor = palabras[2];

			// Comprobamos las restricciones.
			switch (tabla) {
			case "AVIO":
				if (columna.equals("ANTIGUEDAD") && Integer.parseInt(valor) > 10) {
					System.out.println("El avion no puede tener mas de 10 anyos de antiguedad.");
					cont++;
				}
				break;
			case "COMPANYIA":
				if (columna.equals("TELEFONO") && valor.length() > 9) {
					System.out.println("El telefono");
					cont++;
				}
				break;
			case "HANGARS":
				if (columna.equals("CAPACIDAD") && Integer.parseInt(valor) > 50) {
					System.out.println("La capacidad del hangar no puede superar los 20 aviones");
				}
			case "TIPOAVION":
				if (columna.equals("PESO") && Integer.parseInt(valor) > 200) {
					System.out.println("El peso del avion no puede superar las 200T");
				}
			default:
				break;
			}

			if (cont == 0) {
				pstmt = con.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE);
				pstmt.executeUpdate();
			}
		}
	}
}