package pojos;
// Generated 5 feb. 2023 22:56:02 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "Cliente", catalog = "Empresa")
public class Cliente implements java.io.Serializable {

	private Integer idCliente;
	private String cif;
	private String nombre;
	private String tipo;
	private String dirección;
	private String teléfono;
	private String ciudad;
	private Set<Proyecto> proyectos = new HashSet<Proyecto>(0);

	public Cliente() {
	}

	public Cliente(String cif) {
		this.cif = cif;
	}

	public Cliente(String cif, String nombre, String tipo, String dirección, String teléfono, String ciudad,
			Set<Proyecto> proyectos) {
		this.cif = cif;
		this.nombre = nombre;
		this.tipo = tipo;
		this.dirección = dirección;
		this.teléfono = teléfono;
		this.ciudad = ciudad;
		this.proyectos = proyectos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idCliente", unique = true, nullable = false)
	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name = "CIF", nullable = false, length = 45)
	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	@Column(name = "Nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "Tipo", length = 45)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "Dirección", length = 45)
	public String getDirección() {
		return this.dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	@Column(name = "Teléfono", length = 45)
	public String getTeléfono() {
		return this.teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	@Column(name = "Ciudad", length = 45)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}