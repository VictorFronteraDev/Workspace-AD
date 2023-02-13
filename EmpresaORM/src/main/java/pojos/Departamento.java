package pojos;
// Generated 5 feb. 2023 22:56:02 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Departamento generated by hbm2java
 */
@Entity
@Table(name = "departamento", catalog = "Empresa")
public class Departamento implements java.io.Serializable {

	private int numDep;
	private String nombre;
	private Set<Empleado> empleadosForDepartamento = new HashSet<Empleado>(0);
	private Set<Empleado> empleadosForDirige = new HashSet<Empleado>(0);
	private Set<Proyecto> proyectos = new HashSet<Proyecto>(0);

	public Departamento() {
	}

	public Departamento(int numDep) {
		this.numDep = numDep;
	}

	public Departamento(int numDep, String nombre, Set<Empleado> empleadosForDepartamento,
			Set<Empleado> empleadosForDirige, Set<Proyecto> proyectos) {
		this.numDep = numDep;
		this.nombre = nombre;
		this.empleadosForDepartamento = empleadosForDepartamento;
		this.empleadosForDirige = empleadosForDirige;
		this.proyectos = proyectos;
	}

	@Id

	@Column(name = "NumDep", unique = true, nullable = false)
	public int getNumDep() {
		return this.numDep;
	}

	public void setNumDep(int numDep) {
		this.numDep = numDep;
	}

	@Column(name = "nombre", length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamentoByDepartamento")
	public Set<Empleado> getEmpleadosForDepartamento() {
		return this.empleadosForDepartamento;
	}

	public void setEmpleadosForDepartamento(Set<Empleado> empleadosForDepartamento) {
		this.empleadosForDepartamento = empleadosForDepartamento;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamentoByDirige")
	public Set<Empleado> getEmpleadosForDirige() {
		return this.empleadosForDirige;
	}

	public void setEmpleadosForDirige(Set<Empleado> empleadosForDirige) {
		this.empleadosForDirige = empleadosForDirige;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	public Set<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}