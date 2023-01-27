package pojos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")

@Entity
@Table(name="premios")
public class Premio implements Serializable{
	@Id
	private Integer codigo;
	private String descripcion;
	private Integer cantidad;
	
	//Relacion con ciclista
	@ManyToMany
	@JoinTable(name="gana", joinColumns = {@JoinColumn(name="premio", referencedColumnName="codigo")},
	inverseJoinColumns= {@JoinColumn(name="dorsal", referencedColumnName="dorsal")})
	private List<Ciclista> ciclistas;

	public Premio() {
		
	}

	public Premio(Integer codigo, String descripcion, Integer cantidad, List<Ciclista> ciclistas) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.ciclistas = ciclistas;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, ciclistas, codigo, descripcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premio other = (Premio) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(ciclistas, other.ciclistas)
				&& Objects.equals(codigo, other.codigo) && Objects.equals(descripcion, other.descripcion);
	}

	@Override
	public String toString() {
		return "Premio [codigo=" + codigo + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", ciclistas="
				+ ciclistas + "]";
	}

	
	
}
