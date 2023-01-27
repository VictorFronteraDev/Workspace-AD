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
import pojos.Grupo;
import utilesdao.DaoGenerico;

public class DaoGrupo extends DaoGenerico<Grupo, Integer> {
	public void grabar(Grupo g) throws BusinessException {
		PreparedStatement pstm = null;
		String sql = null;
		ResultSet rs = null;
		Connection con = ConnectionJdbc.getConnection();

		sql = "INSERT INTO grupo (nombre)VALUES(?)";

		try {
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, g.getNombre());
			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();

			if (rs.first()) {
				String id = rs.getString(1);
				g.setIdGrupo(id);
				System.out.println("Insertado " + g.getNombre() + " " + g.getIdGrupo());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	public void actualizar(Grupo g) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		String sql = null;

		try {
			sql = "SELECT * FROM grupo WHERE nombre = ? AND idgrupo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, g.getNombre());
			pstm.setString(2, g.getIdGrupo());
			pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al actualizar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

	public void borrar(Grupo g) throws BusinessException {
		borrar(g.getIdGrupo());
	}

	public void borrar(String id) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		String sql = null;

		try {
			sql = "SELECT * FROM grupo WHERE idgrupo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);

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

	public Grupo buscarPorId(String id) throws BusinessException {
		Grupo result = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM grupo WHERE idgrupo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();

			if (rs.first()) {
				result = new Grupo();
				result.setIdGrupo(id);
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

	public List<Grupo> buscarTodos() throws BusinessException {
		List<Grupo> result = new ArrayList<Grupo>();
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM grupo ORDER BY idgrupo";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Grupo g = new Grupo();
				g.setIdGrupo(rs.getString(1));
				g.setNombre(rs.getString(2));
				result.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		}

		return result;
	}

	public void grabarOActualizar(Grupo g) throws BusinessException {
		if (buscarPorId(g.getIdGrupo()) == null) {
			grabar(g);
		} else {
			actualizar(g);
		}
	}
}
