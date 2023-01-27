package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectionjdbc.ConnectionJdbc;
import excepcions.BusinessException;
import pojos.TipoUsuario;
import utilesdao.DaoGenerico;

public class DaoTipoUsuario extends DaoGenerico<TipoUsuario, Integer>{
	public final static Integer PROFESOR = 1;
	public final static Integer ALUMNO = 2;
	public final static Integer PAS = 3;
	
	public TipoUsuario buscarPorId(Integer id) throws BusinessException {
		TipoUsuario result = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String sql = "Select * from tipousuario where idtipousuario = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);	
			rs = pstm.executeQuery();
			if(rs.first()) {
				result = new TipoUsuario(id, rs.getString("nombre"));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}
}
