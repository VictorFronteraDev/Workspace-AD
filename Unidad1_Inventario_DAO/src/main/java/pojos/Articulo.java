package pojos;

import java.util.Date;

public class Articulo {
	private Integer idArticulo;
	private String numSerie;
	private String estado;
	private Date fechaAlta;
	private Date fechaBaja;
	private Integer usuarioAlta;
	private Integer usuarioBaja;
	private Integer modelo;
	private Integer departamento;
	private Integer espacio;
	private Integer dentroDe;
	private String observaciones;
	
	public Articulo() {
		// TODO Auto-generated constructor stub
	}

	public Articulo(Integer idArticulo, String numSerie, String estado, Date fechaAlta, Date fechaBaja,
			Integer usuarioAlta, Integer usuarioBaja, Integer modelo, Integer departamento, Integer espacio, Integer dentroDe,
			String observaciones) {
		this.idArticulo = idArticulo;
		this.numSerie = numSerie;
		this.estado = estado;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.usuarioAlta = usuarioAlta;
		this.usuarioBaja = usuarioBaja;
		this.modelo = modelo;
		this.departamento = departamento;
		this.espacio = espacio;
		this.dentroDe = dentroDe;
		this.observaciones = observaciones;
	}

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Integer getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(Integer usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public Integer getUsuarioBaja() {
		return usuarioBaja;
	}

	public void setUsuarioBaja(Integer usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer departamento) {
		this.departamento = departamento;
	}
	
	public Integer getDepartamento() {
		return modelo;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}
	

	public Integer getEspacio() {
		return espacio;
	}

	public void setEspacio(Integer espacio) {
		this.espacio = espacio;
	}

	public Integer getDentroDe() {
		return dentroDe;
	}

	public void setDentroDe(Integer dentroDe) {
		this.dentroDe = dentroDe;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dentroDe == null) ? 0 : dentroDe.hashCode());
		result = prime * result + ((espacio == null) ? 0 : espacio.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((idArticulo == null) ? 0 : idArticulo.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((numSerie == null) ? 0 : numSerie.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((usuarioAlta == null) ? 0 : usuarioAlta.hashCode());
		result = prime * result + ((usuarioBaja == null) ? 0 : usuarioBaja.hashCode());
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
		Articulo other = (Articulo) obj;
		if (dentroDe == null) {
			if (other.dentroDe != null)
				return false;
		} else if (!dentroDe.equals(other.dentroDe))
			return false;
		if (espacio == null) {
			if (other.espacio != null)
				return false;
		} else if (!espacio.equals(other.espacio))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (fechaBaja == null) {
			if (other.fechaBaja != null)
				return false;
		} else if (!fechaBaja.equals(other.fechaBaja))
			return false;
		if (idArticulo == null) {
			if (other.idArticulo != null)
				return false;
		} else if (!idArticulo.equals(other.idArticulo))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (numSerie == null) {
			if (other.numSerie != null)
				return false;
		} else if (!numSerie.equals(other.numSerie))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (usuarioAlta == null) {
			if (other.usuarioAlta != null)
				return false;
		} else if (!usuarioAlta.equals(other.usuarioAlta))
			return false;
		if (usuarioBaja == null) {
			if (other.usuarioBaja != null)
				return false;
		} else if (!usuarioBaja.equals(other.usuarioBaja))
			return false;
		return true;
	}
	
	
	

}
