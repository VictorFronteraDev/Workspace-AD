package pojos;

public class Espacio {
	private Integer idEspacio;
	private String nombre;
	private String descripcion;
	private Integer padre;
	
	public Espacio() {
		// TODO Auto-generated constructor stub
	}

	public Espacio(Integer idEspacio, String nombre, String descripcion, Integer padre) {
		this.idEspacio = idEspacio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.padre = padre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idEspacio == null) ? 0 : idEspacio.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((padre == null) ? 0 : padre.hashCode());
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
		Espacio other = (Espacio) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idEspacio == null) {
			if (other.idEspacio != null)
				return false;
		} else if (!idEspacio.equals(other.idEspacio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (padre == null) {
			if (other.padre != null)
				return false;
		} else if (!padre.equals(other.padre))
			return false;
		return true;
	}
	
	

}
