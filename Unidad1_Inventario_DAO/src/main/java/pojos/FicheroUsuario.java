package pojos;

public class FicheroUsuario {
	private String idFicheroUsuario;
	private Integer usuario;
	private String tipo;
	private String nombre;
	private String contenido;
	
	public FicheroUsuario() {
		
	}

	public FicheroUsuario(String idFicheroUsuario, Integer usuario, String tipo, String nombre, String contenido) {
		super();
		this.idFicheroUsuario = idFicheroUsuario;
		this.usuario = usuario;
		this.tipo = tipo;
		this.nombre = nombre;
		this.contenido = contenido;
	}

	public String getIdFicheroUsuario() {
		return idFicheroUsuario;
	}

	public void setIdFicheroUsuario(String idFicheroUsuario) {
		this.idFicheroUsuario = idFicheroUsuario;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + ((idFicheroUsuario == null) ? 0 : idFicheroUsuario.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		FicheroUsuario other = (FicheroUsuario) obj;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		if (idFicheroUsuario == null) {
			if (other.idFicheroUsuario != null)
				return false;
		} else if (!idFicheroUsuario.equals(other.idFicheroUsuario))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FicheroUsuario [idFicheroUsuario=" + idFicheroUsuario + ", usuario=" + usuario + ", tipo=" + tipo
				+ ", nombre=" + nombre + ", contenido=" + contenido + "]";
	}
	
	

}
