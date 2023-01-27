package pojos;

import java.util.Date;

public class Operacion {
	Integer idOperacion;
	String login;
	String isbn;
	String tipoOperacion;
	String estadoOperacion;
	Date fechaInicio;
	Date fechaFin;
	Date fechaFinReal;
	
	public Operacion( ) {
		
	}

	public Operacion(Integer id, String login, String isbn, String tipoOperacion, String estadoOperacion,
			Date fechaInicio, Date fechaFin, Date fechaFinReal) {
		super();
		this.idOperacion = id;
		this.login = login;
		this.isbn = isbn;
		this.tipoOperacion = tipoOperacion;
		this.estadoOperacion = estadoOperacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaFinReal = fechaFinReal;
	}

	public Integer getId() {
		return idOperacion;
	}

	public void setId(Integer id) {
		this.idOperacion = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getEstadoOperacion() {
		return estadoOperacion;
	}

	public void setEstadoOperacion(String estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaFinReal() {
		return fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadoOperacion == null) ? 0 : estadoOperacion.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaFinReal == null) ? 0 : fechaFinReal.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((idOperacion == null) ? 0 : idOperacion.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((tipoOperacion == null) ? 0 : tipoOperacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operacion other = (Operacion) obj;
		if (estadoOperacion == null) {
			if (other.estadoOperacion != null)
				return false;
		} else if (!estadoOperacion.equals(other.estadoOperacion))
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaFinReal == null) {
			if (other.fechaFinReal != null)
				return false;
		} else if (!fechaFinReal.equals(other.fechaFinReal))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (idOperacion == null) {
			if (other.idOperacion != null)
				return false;
		} else if (!idOperacion.equals(other.idOperacion))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (tipoOperacion == null) {
			if (other.tipoOperacion != null)
				return false;
		} else if (!tipoOperacion.equals(other.tipoOperacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operacion [id=" + idOperacion + ", login=" + login + ", isbn=" + isbn + ", tipoOperacion=" + tipoOperacion
				+ ", estadoOperacion=" + estadoOperacion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", fechaFinReal=" + fechaFinReal + "]";
	}
	
	public Integer compareTo(Object obj) {
		Operacion other = (Operacion) obj;
		return idOperacion.compareTo(other.idOperacion);
	}
	
	
}
