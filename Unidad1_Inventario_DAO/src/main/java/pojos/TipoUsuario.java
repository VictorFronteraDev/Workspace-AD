package pojos;

public class TipoUsuario {
	
	private Integer idTipoUsuario;
	private String nombre;
	
	public TipoUsuario() {
		// TODO Auto-generated constructor stub
	}

	public TipoUsuario(Integer idTipoUsuario, String nombre) {
		
		this.idTipoUsuario = idTipoUsuario;
		this.nombre = nombre;
	}

	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoUsuario == null) ? 0 : idTipoUsuario.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		TipoUsuario other = (TipoUsuario) obj;
		if (idTipoUsuario == null) {
			if (other.idTipoUsuario != null)
				return false;
		} else if (!idTipoUsuario.equals(other.idTipoUsuario))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
