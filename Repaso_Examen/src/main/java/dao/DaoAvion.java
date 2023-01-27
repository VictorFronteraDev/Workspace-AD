package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionjdbc.ConnectionJdbc;
import excepcions.BusinessException;
import pojos.Avion;
import utilesdao.DaoGenerico;

public class DaoAvion extends DaoGenerico<Avion, Integer> {
	public void grabar(Avion a) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		
		try {
			String sql = "INSERT INTO avio (num, matricula, fechaRegistro, antiguedad, tipoAvion_codigo, hangars_codigo, fechaCompra, companyia_codigo)" 
					+ "VALUES (?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, a.getNum());
			pstm.setInt(2, a.getMatricula());
			pstm.setDate(3, new java.sql.Date(a.getFechaRegistro().getTime()));
			pstm.setInt(4, a.getAntiguedad());
			pstm.setInt(5, a.getCodTAvion());
			pstm.setInt(6, a.getHangarsCodigo());
			pstm.setDate(7, new java.sql.Date(a.getFechaCompra().getTime()));
			pstm.setInt(8, a.getCompanyiaCodigo());
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}

}
