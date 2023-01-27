package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionjdbc.*;
import excepcions.BusinessException;
import pojos.Departamento;
import utilesdao.DaoGenerico;

public class DaoDepartamento extends DaoGenerico<Departamento, Integer> {
	public void grabar(Departamento d) throws BusinessException {
		PreparedStatement pstm = null;
		String sql = null;
		ResultSet rs = null;
		Connection con = ConnectionJdbc.getConnection();

		sql = "INSERT INTO departamento (nombre)VALUES(?)";

		try {
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, d.getNombre());
			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();

			if (rs.first()) {
				Integer id = rs.getInt(1);
				d.setIdDepartamento(id);
				System.out.println("Insertado " + d.getNombre() + " " + d.getIdDepartamento());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	public void actualizar(Departamento d) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		String sql = null;

		try {
			sql = "SELECT * FROM departamento WHERE nombre = ? AND iddepartamento = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, d.getNombre());
			pstm.setInt(2, d.getIdDepartamento());
			pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al actualizar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	public void borrar(Departamento d) throws BusinessException {
		borrar(d.getIdDepartamento());
	}

	public void borrar(Integer id) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		String sql = null;

		try {
			sql = "SELECT * FROM departamento WHERE iddepartamento = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);

			if (pstm.executeUpdate() == 0) {
				throw new BusinessException("El elemento que desea borrar, no existe");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al borrar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	public Departamento buscarPorId(Integer id) throws BusinessException {
		Departamento result = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM departamento WHERE iddepartamento = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			if (rs.first()) {
				result = new Departamento();
				result.setIdDepartamento(id);
				result.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}

		return result;
	}

	public List<Departamento> buscarTodos() throws BusinessException {
		List<Departamento> result = new ArrayList<Departamento>();
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM departamento ORDER BY iddepartamento";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Departamento d = new Departamento();
				d.setIdDepartamento(rs.getInt(1));
				d.setNombre(rs.getString(2));
				result.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		}

		return result;
	}

	public void grabarOActualizar(Departamento d) throws BusinessException {
		if (buscarPorId(d.getIdDepartamento()) == null) {
			grabar(d);
		} else {
			actualizar(d);
		}
	}

	public Integer buscarPorNombre(String nombre) throws BusinessException {
		Integer id = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT iddepartamento FROM departamento WHERE nombre = ?";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, nombre);
			rs = pstm.executeQuery();

			if (rs.first()) {
				id = rs.getInt("iddepartamento");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}

		return id;
	}
	
	
}
