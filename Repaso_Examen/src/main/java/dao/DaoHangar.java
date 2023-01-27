package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionjdbc.ConnectionJdbc;
import excepcions.BusinessException;
import pojos.Hangar;
import utilesdao.DaoGenerico;

public class DaoHangar extends DaoGenerico<Hangar, Integer> {

	public void grabar(Hangar h) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		
		try {
			String sql = "INSERT INTO hangars (codigo, capacidad, localizacion) "
					+ " VALUES (?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, h.getCodigo());
			pstm.setInt(2, h.getCapacidad());
			pstm.setString(3, h.getLocalizacion());
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}
}
