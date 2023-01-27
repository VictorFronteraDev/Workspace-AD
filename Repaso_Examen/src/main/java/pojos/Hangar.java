package pojos;

public class Hangar {
	private Integer codigo;
	private Integer capacidad;
	private String localizacion;
	
	public Hangar() {
		
	}
	
	public Hangar(Integer codigo, Integer capacidad, String localizacion) {
		super();
		this.codigo = codigo;
		this.capacidad = capacidad;
		this.localizacion = localizacion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacidad == null) ? 0 : capacidad.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((localizacion == null) ? 0 : localizacion.hashCode());
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
		Hangar other = (Hangar) obj;
		if (capacidad == null) {
			if (other.capacidad != null)
				return false;
		} else if (!capacidad.equals(other.capacidad))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (localizacion == null) {
			if (other.localizacion != null)
				return false;
		} else if (!localizacion.equals(other.localizacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hangar [codigo=" + codigo + ", capacidad=" + capacidad + ", localizacion=" + localizacion + "]";
	}
	
	public Integer compareTo(Object obj) {
		Hangar other = (Hangar) obj;
		return codigo.compareTo(other.codigo);
	}
	
}
