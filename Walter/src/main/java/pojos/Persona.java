package pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String dni;
	private String nombre;
	private String apellidos;
	private String trabajo;
	
	//Relacion con situacion
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
	private Situacion situacion;

	public Persona() {

	}

	public Persona(String dni, String nombre, String apellidos, String trabajo, Situacion situacion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.trabajo = trabajo;
		this.situacion = situacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public Situacion getSituacion() {
		return situacion;
	}

	public void setSituacion(Situacion situacion) {
		this.situacion = situacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((situacion == null) ? 0 : situacion.hashCode());
		result = prime * result + ((trabajo == null) ? 0 : trabajo.hashCode());
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
		Persona other = (Persona) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (situacion == null) {
			if (other.situacion != null)
				return false;
		} else if (!situacion.equals(other.situacion))
			return false;
		if (trabajo == null) {
			if (other.trabajo != null)
				return false;
		} else if (!trabajo.equals(other.trabajo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", trabajo=" + trabajo
				+ ", situacion=" + situacion + "]";
	}
	
	
	 
	

}
