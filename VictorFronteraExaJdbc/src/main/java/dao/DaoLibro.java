package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import connectionjdbc.ConnectionJdbc;
import excepcions.BusinessException;
import pojos.Libro;
import utilesDao.DaoGenerico;

public class DaoLibro extends DaoGenerico<Libro, Integer>{

	public void grabar(Libro l) throws BusinessException{
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		
		try {
			String sql = "INSERT INTO libro (isbn, titulo, autor, numPaginas, fechaAlta) "
					+ " VALUES (?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, l.getIsbn());
			pstm.setString(2, l.getTitulo());
			pstm.setString(3, l.getAutor());
			pstm.setInt(4, l.getNumPaginas());
			pstm.setDate(5, new java.sql.Date(l.getFechaAlta().getTime()));
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}
	
	public void actualizar(Libro l) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		
		try {
			// Preparar la actualización.
			String sql = "UPDATE articulo SET isbn= ?, titulo = ?, autor = ?,"
					+ " numPaginas = ?, fechaAlta = ?";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, l.getIsbn());
			pstm.setString(2, l.getTitulo());
			pstm.setString(3, l.getAutor());
			pstm.setInt(4, l.getNumPaginas());
			pstm.setDate(5,  new java.sql.Date(l.getFechaAlta().getTime()));

			// Ejecutar la actualizacion
			pstm.executeUpdate();

		} catch (SQLException e) {
			throw new BusinessException("Error al actualizar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
	}
	
	public Libro buscarPorId(Integer id) throws BusinessException {
		Libro l = null;
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM articulo WHERE idarticulo=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.first()) {
				l = new Libro();

				l.setIsbn(rs.getString("isbn"));
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				l.setNumPaginas(rs.getInt("numPaginas"));
				l.setFechaAlta(rs.getDate("fechaAlta"));

			}
			return l;
		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConnectionJdbc.cerrar(pstm);
		}
		
	}
	
	public void comprobarEstadoOperacion(String isbn, String login, Date fechaDevolucion) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "Select isbn, login, estadoOperacion, fechaFin from operacion where isbn = ? AND login = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, isbn);
			pstm.setString(2, login);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("estadoOperacion").equals("ACTIVA") && rs.getString("login").equals(login) &&
						rs.getTimestamp("fechaFin").before(fechaDevolucion)) {
					devolucion(fechaDevolucion, login, isbn);
				} else {
					System.out.println("No se puede devolver el libro");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	 
	public void devolucion(Date fechaFinReal, String login, String isbn) throws BusinessException {
		Connection con = ConnectionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String sql = "UPDATE operacion SET estadoOperacion = ?, fechaFinReal = ?"
					+ " WHERE login = ? AND isbn = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, "HISTORICO");
			pstm.setDate(2, new java.sql.Date(fechaFinReal.getTime()));
			pstm.setString(3, login);
			pstm.setString(4, isbn);
			
			pstm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
