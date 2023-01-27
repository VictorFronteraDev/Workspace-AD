package pojos;

public class Departamento {
	private Integer idDepartamento;
	private String nombre;
	
	public Departamento() {
		// TODO Auto-generated constructor stub
	}

	public Departamento(Integer idDepartamento, String nombre) {
		
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
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
		result = prime * result + ((idDepartamento == null) ? 0 : idDepartamento.hashCode());
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
		Departamento other = (Departamento) obj;
		if (idDepartamento == null) {
			if (other.idDepartamento != null)
				return false;
		} else if (!idDepartamento.equals(other.idDepartamento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public Integer compareTo(Object obj) {
		Departamento other = (Departamento) obj;
		return idDepartamento.compareTo(other.idDepartamento);
	}
}
