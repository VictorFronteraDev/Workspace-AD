package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionjdbc.ConnectionJdbc;
import excepcions.BusinessException;
import pojos.Articulo;
import utilesdao.DaoGenerico;

public class DaoArticulo extends DaoGenerico<Articulo, Integer> {
	@Override
	public void grabar(Articulo a) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;

		try {
			String sql = "INSERT INTO articulo " + "(idarticulo, numserie, estado, fechaalta, fechabaja, usuarioalta, "
					+ "usuariobaja, modelo, departamento, espacio, dentrode, observaciones) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, a.getIdArticulo());
			pstm.setString(2, a.getNumSerie());
			pstm.setString(3, a.getEstado());
			pstm.setDate(4, new java.sql.Date(a.getFechaAlta().getTime()));
			pstm.setDate(5, null);
			pstm.setObject(6, a.getUsuarioAlta());
			pstm.setObject(7, a.getUsuarioAlta());
			pstm.setObject(8, a.getModelo());
			pstm.setObject(9, a.getDepartamento());
			pstm.setObject(10, a.getEspacio());
			pstm.setObject(11, a.getDentroDe());
			pstm.setString(12, a.getObservaciones());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	public Boolean grabarAlta(Articulo a) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		Boolean fin = false;

		try {
			String sql = "INSERT INTO articulo " + "(idarticulo, numserie, estado, fechaalta, "
					+ "usuarioalta, modelo, departamento, espacio) " + "VALUES (?,?,?,?,?,?,?,?)";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, a.getIdArticulo());
			pstm.setString(2, a.getNumSerie());
			pstm.setString(3, a.getEstado());
			pstm.setDate(4, new java.sql.Date(a.getFechaAlta().getTime()));
			pstm.setObject(5, a.getUsuarioAlta());
			pstm.setObject(6, a.getModelo());
			pstm.setObject(7, a.getDepartamento());
			pstm.setObject(8, a.getEspacio());
			pstm.executeUpdate();
			fin = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
			
		}
		return fin;
	}

	@Override
	public void actualizar(Articulo a) throws BusinessException {

		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			// Preparar la actualización.
			String sql = "UPDATE articulo SET numserie= ?, estado = ?, fechaalta= ?, fechabaja= ?,"
					+ " usuarioalta = ?, usuariobaja = ?, modelo = ?, departamento = ?, espacio = ?,"
					+ "dentrode = ?, observaciones = ?" + " WHERE idarticulo = ?";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, a.getNumSerie());
			pstm.setString(2, a.getEstado());
			pstm.setDate(3, new java.sql.Date(a.getFechaAlta().getTime()));
			pstm.setDate(4, new java.sql.Date(a.getFechaBaja().getTime()));
			pstm.setInt(5, a.getUsuarioAlta());
			pstm.setInt(6, a.getUsuarioBaja());
			pstm.setInt(7, a.getModelo());
			pstm.setInt(8, a.getDepartamento());
			pstm.setInt(9, a.getEspacio());
			pstm.setInt(10, a.getDentroDe());
			pstm.setString(11, a.getObservaciones());
			pstm.setInt(12, a.getIdArticulo());

			// Ejecutar la actualizacion
			pstm.executeUpdate();

		} catch (SQLException e) {
			throw new BusinessException("Error al actualizar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void grabarOActualizar(Articulo a) throws BusinessException {
		if (buscarPorId(a.getIdArticulo()) != null)
			grabar(a);
		else
			actualizar(a);
	}

	@Override
	public void borrar(Articulo a) throws BusinessException {
		borrar(a.getIdArticulo());
	}

	@Override
	public void borrar(Integer id) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "DELETE FROM articulo WHERE idarticulo= ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new BusinessException("Error al eliminar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	@Override
	public Articulo buscarPorId(Integer id) throws BusinessException {
		Articulo a = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM articulo WHERE idarticulo=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.first()) {
				a = new Articulo();

				a.setIdArticulo(rs.getInt("idarticulo"));
				a.setNumSerie(rs.getString("numserie"));
				a.setEstado(rs.getString("estado"));
				a.setFechaAlta(rs.getDate("fechaalta"));
				a.setFechaBaja(rs.getDate("fechabaja"));
				a.setUsuarioAlta(rs.getInt("usuarioalta"));
				a.setUsuarioBaja(rs.getInt("usuariobaja"));
				a.setModelo(rs.getInt("modelo"));
				a.setDepartamento(rs.getInt("departamento"));
				a.setEspacio(rs.getInt("espacio"));
				a.setDentroDe(rs.getInt("dentrode"));
				a.setObservaciones(rs.getString("observaciones"));
			}
			return a;
		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	@Override
	public List<Articulo> buscarTodos() throws BusinessException {
		List<Articulo> result = new ArrayList<>();
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM articulo ORDER BY idarticulo";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Articulo a = new Articulo();

				a.setIdArticulo(rs.getInt("idarticulo"));
				a.setNumSerie(rs.getString("numserie"));
				a.setEstado(rs.getString("estado"));
				a.setFechaAlta(rs.getDate("fechaalta"));
				a.setFechaBaja(rs.getDate("fechabaja"));
				a.setUsuarioAlta(rs.getInt("usuarioalta"));
				a.setUsuarioBaja(rs.getInt("usuariobaja"));
				a.setModelo(rs.getInt("modelo"));
				a.setDepartamento(rs.getInt("departamento"));
				a.setEspacio(rs.getInt("espacio"));
				// a.setDentrode(rs.getInt("dentrode"));
				a.setObservaciones(rs.getString("observaciones"));

				result.add(a);
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	public List<Articulo> buscar_art_dept(Integer departamento) throws BusinessException {
		Articulo a = null;
		List<Articulo> listaArticulos = new ArrayList<>();
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Articulo> result = new ArrayList<Articulo>();
		try {
			String sql = "SELECT * FROM articulo WHERE departamento = ?";
			pstm = con.prepareCall(sql);
			pstm.setInt(1, departamento);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new Articulo();
				a.setIdArticulo(rs.getInt("idartidulo"));
				a.setNumSerie(rs.getString("numseries"));
			}
			result.add(a);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		}
		return result;
	}

	public List<Articulo> buscar_art_dept_estado(Integer departamento, String estado) throws BusinessException {
		Articulo a = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Articulo> result = new ArrayList<Articulo>();
		try {
			String sql = "SELECT * FROM articulo WHERE departamento = ? and estado = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, departamento);
			pstm.setString(2, estado);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new Articulo();
				a.setIdArticulo(rs.getInt("idartidulo"));
				a.setNumSerie(rs.getString("numseries"));
			}
			result.add(a);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		}
		return result;
	}

	public List<Articulo> consultarArticulosPorModeloDescripcion(String descripcion) {
		Articulo a = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Articulo> result = new ArrayList<Articulo>();
		try {
			String sql = "SELECT idmodeloarticulo FROM modeloarticulo WHERE descripcion = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, descripcion);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new Articulo();
				a.setIdArticulo(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public List<Articulo> filtroDepArt(Integer departamento, String estado) throws BusinessException {
		Articulo a = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Articulo> result = new ArrayList<Articulo>();
		Integer numParam;
		try {
			String sql = "SELECT * FROM articulo WHERE true";

			if (departamento != null) {
				sql += " and departamento = ?";
			}

			if (estado != null) {
				sql += " and estado = ?";
			}

			pstm = con.prepareStatement(sql);
			numParam = 1;
			if (departamento != null) {
				pstm.setInt(numParam, departamento);
			}

			if (estado != null) {
				pstm.setString(numParam++, estado);
			}

			rs = pstm.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		}
		return result;
	}

	public String cogerEstado(Integer id) {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String estado = "";

		try {
			String sql = "SELECT estado FROM articulo WHERE idarticulo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			while (rs.next()) {
				estado = rs.getString("estado");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return estado;
	}

	public void cambiarEstado(String estado, String estadoCambiado, int id) {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		switch (estado) {
		case "operativo":
			if (estado.equals(estadoCambiado)) {
				System.out.println("El articulo ya esta operativo");
			} else {
				try {
					String sql = "UPDATE articulo SET estado = ? WHERE idarticulo = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, estadoCambiado);
					pstm.setInt(2, id);
					pstm.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
		case "manteniment":
			if (estado.equals(estadoCambiado)) {
				System.out.println("El articulo ya esta en mantenimiento");
			} else {
				try {
					String sql = "UPDATE articulo SET estado = ? WHERE idarticulo = ?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, estadoCambiado);
					pstm.setInt(2, id);
					pstm.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			break;

		default:
			break;
		}
	}
}