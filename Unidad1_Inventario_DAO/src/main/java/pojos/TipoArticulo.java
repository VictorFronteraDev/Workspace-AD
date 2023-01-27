package pojos;

public class TipoArticulo {
	private Integer idTipoArticulo;
	private String nombre;
	private Integer padre;
	
	public TipoArticulo() {
		// TODO Auto-generated constructor stub
	}

	public TipoArticulo(Integer idTipoArticulo, String nombre, Integer padre) {
		super();
		this.idTipoArticulo = idTipoArticulo;
		this.nombre = nombre;
		this.padre = padre;
	}

	public Integer getIdTipoArticulo() {
		return idTipoArticulo;
	}

	public void setIdTipoArticulo(Integer idTipoArticulo) {
		this.idTipoArticulo = idTipoArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPadre() {
		return padre;
	}

	public void setPadre(Integer padre) {
		this.padre = padre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoArticulo == null) ? 0 : idTipoArticulo.hashCode());
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
		TipoArticulo other = (TipoArticulo) obj;
		if (idTipoArticulo == null) {
			if (other.idTipoArticulo != null)
				return false;
		} else if (!idTipoArticulo.equals(other.idTipoArticulo))
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
