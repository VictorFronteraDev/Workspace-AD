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
import pojos.Usuario;
import utilesdao.DaoGenerico;

public class DaoUsuario extends DaoGenerico<Usuario, Integer> {
	public void grabar(Usuario u) throws BusinessException {
		PreparedStatement pstm = null;
		String sql = null;
		ResultSet rs = null;
		Connection con = ConnectionJdbc.getConnection();
		
		comprobarTipoUsuario(u);

		sql = "INSERT INTO usuario (nombre)VALUES(?)";

		try {
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, u.getNombre());
			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();

			if (rs.first()) {
				Integer id = rs.getInt(1);
				u.setIdUsuario(id);
				System.out.println("Insertado " + u.getNombre() + " " + u.getIdUsuario());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	public void actualizar(Usuario u) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		String sql = null;

		comprobarTipoUsuario(u);
		try {
			sql = "SELECT * FROM usuario WHERE nombre = ? AND idusuario = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getNombre());
			pstm.setInt(2, u.getIdUsuario());
			pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al actualizar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	public void borrar(Usuario u) throws BusinessException {
		borrar(u.getIdUsuario());
	}

	public void borrar(Integer id) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		String sql = null;

		try {
			sql = "SELECT * FROM usuario WHERE idusuario = ?";
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

	public Usuario buscarPorId(Integer id) throws BusinessException {
		Usuario result = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM usuario WHERE idusuario = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			if (rs.first()) {
				result = new Usuario();
				result.setIdUsuario(id);
				result.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al buscar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}

		return result;
	}

	public List<Usuario> buscarTodos() throws BusinessException {
		List<Usuario> result = new ArrayList<Usuario>();
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM usuario ORDER BY idusuario";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Usuario u = new Usuario();
				u.setIdUsuario(rs.getInt(1));
				u.setNombre(rs.getString(2));
				result.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al actualizar");
		}

		return result;
	}

	public void grabarOActualizar(Usuario u) throws BusinessException {
		if (buscarPorId(u.getIdUsuario()) == null) {
			grabar(u);
		} else {
			actualizar(u);
		}
	}

	private void comprobarTipoUsuario(Usuario u) throws BusinessException {
		Integer tipo = u.getTipo();
		if (tipo == DaoTipoUsuario.PROFESOR) {
			if (u.getGrupo() != null) {
				throw new BusinessException();
			}
			if (u.getDepartamento() == null) {
				throw new BusinessException();
			}
		} else if (tipo == DaoTipoUsuario.ALUMNO) {
			if (u.getGrupo() == null) {
				throw new BusinessException();
			}
			if (u.getDepartamento() != null) {
				throw new BusinessException();
			}
		} else {
			if (u.getGrupo() != null) {
				throw new BusinessException();
			}
			if (u.getDepartamento() != null) {
				throw new BusinessException();
			}
		}
	}
}
