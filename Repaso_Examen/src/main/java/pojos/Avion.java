package pojos;

import java.util.Date;

public class Avion {
	private Integer num;
	private Integer matricula;
	private Date fechaRegistro;
	private Integer antiguedad;
	private Integer hangarsCodigo;
	private Date fechaCompra;
	private Integer companyiaCodigo;
	private Integer codTAvion;

	public Avion() {
		
	}
	
	public Avion(Integer num, Integer matricula, Date fechaRegistro, Integer antiguedad, Integer hangarsCodigo,
			Date fechaCompra, Integer companyiaCodigo, Integer codTAvion) {
		super();
		this.num = num;
		this.matricula = matricula;
		this.fechaRegistro = fechaRegistro;
		this.antiguedad = antiguedad;
		this.hangarsCodigo = hangarsCodigo;
		this.fechaCompra = fechaCompra;
		this.companyiaCodigo = companyiaCodigo;
		this.codTAvion = codTAvion;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Integer getHangarsCodigo() {
		return hangarsCodigo;
	}

	public void setHangarsCodigo(Integer hangarsCodigo) {
		this.hangarsCodigo = hangarsCodigo;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Integer getCompanyiaCodigo() {
		return companyiaCodigo;
	}

	public void setCompanyiaCodigo(Integer companyiaCodigo) {
		this.companyiaCodigo = companyiaCodigo;
	}

	public Integer getCodTAvion() {
		return codTAvion;
	}

	public void setCodTAvion(Integer codTAvion) {
		this.codTAvion = codTAvion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((antiguedad == null) ? 0 : antiguedad.hashCode());
		result = prime * result + ((codTAvion == null) ? 0 : codTAvion.hashCode());
		result = prime * result + ((companyiaCodigo == null) ? 0 : companyiaCodigo.hashCode());
		result = prime * result + ((fechaCompra == null) ? 0 : fechaCompra.hashCode());
		result = prime * result + ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
		result = prime * result + ((hangarsCodigo == null) ? 0 : hangarsCodigo.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
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
		Avion other = (Avion) obj;
		if (antiguedad == null) {
			if (other.antiguedad != null)
				return false;
		} else if (!antiguedad.equals(other.antiguedad))
			return false;
		if (codTAvion == null) {
			if (other.codTAvion != null)
				return false;
		} else if (!codTAvion.equals(other.codTAvion))
			return false;
		if (companyiaCodigo == null) {
			if (other.companyiaCodigo != null)
				return false;
		} else if (!companyiaCodigo.equals(other.companyiaCodigo))
			return false;
		if (fechaCompra == null) {
			if (other.fechaCompra != null)
				return false;
		} else if (!fechaCompra.equals(other.fechaCompra))
			return false;
		if (fechaRegistro == null) {
			if (other.fechaRegistro != null)
				return false;
		} else if (!fechaRegistro.equals(other.fechaRegistro))
			return false;
		if (hangarsCodigo == null) {
			if (other.hangarsCodigo != null)
				return false;
		} else if (!hangarsCodigo.equals(other.hangarsCodigo))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avion [num=" + num + ", matricula=" + matricula + ", fechaRegistro=" + fechaRegistro + ", antiguedad="
				+ antiguedad + ", hangarsCodigo=" + hangarsCodigo + ", fechaCompra=" + fechaCompra
				+ ", companyiaCodigo=" + companyiaCodigo + ", codTAvion=" + codTAvion + "]";
	}

	public Integer compareTo(Object obj) {
		Avion other = (Avion) obj;
		return matricula.compareTo(other.matricula);
	}
	
}
