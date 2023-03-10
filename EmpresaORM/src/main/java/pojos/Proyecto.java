package pojos;
// Generated 5 feb. 2023 22:56:02 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Proyecto generated by hbm2java
 */
@Entity
@Table(name = "proyecto", catalog = "Empresa")
public class Proyecto implements java.io.Serializable {

	private int num;
	private Cliente cliente;
	private Departamento departamento;
	private String nombre;
	private String estado;
	private Date fechaInicio;
	private Date fechaFin;
	private Set<TiposProyecto> tiposProyectos = new HashSet<TiposProyecto>(0);

	public Proyecto() {
	}

	public Proyecto(int num) {
		this.num = num;
	}

	public Proyecto(int num, Cliente cliente, Departamento departamento, String nombre, String estado, Date fechaInicio,
			Date fechaFin, Set<TiposProyecto> tiposProyectos) {
		this.num = num;
		this.cliente = cliente;
		this.departamento = departamento;
		this.nombre = nombre;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tiposProyectos = tiposProyectos;
	}

	@Id

	@Column(name = "num", unique = true, nullable = false)
	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cliente")
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamento")
	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Column(name = "nombre", length = 40)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "estado", length = 45)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", length = 10)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin", length = 10)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "proyect-tipo", catalog = "Empresa", joinColumns = {
			@JoinColumn(name = "id_proy", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_tipo", nullable = false, updatable = false) })
	public Set<TiposProyecto> getTiposProyectos() {
		return this.tiposProyectos;
	}

	public void setTiposProyectos(Set<TiposProyecto> tiposProyectos) {
		this.tiposProyectos = tiposProyectos;
	}

}
