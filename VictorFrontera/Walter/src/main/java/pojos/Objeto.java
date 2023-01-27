package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "objeto")
public class Objeto implements Serializable{

	@Id
	private String nombre;
	private Integer tamanyo;
	
	//Relacion con situacion
	@ManyToMany(mappedBy = "objetos")
	private List<Situacion> situaciones = new ArrayList<Situacion>();

	public Objeto() {

	}

	public Objeto(String nombre, Integer tamanyo, List<Situacion> situaciones) {
		super();
		this.nombre = nombre;
		this.tamanyo = tamanyo;
		this.situaciones = situaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(Integer tamanyo) {
		this.tamanyo = tamanyo;
	}

	public List<Situacion> getSituaciones() {
		return situaciones;
	}

	public void setSituaciones(List<Situacion> situaciones) {
		this.situaciones = situaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((situaciones == null) ? 0 : situaciones.hashCode());
		result = prime * result + ((tamanyo == null) ? 0 : tamanyo.hashCode());
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
		Objeto other = (Objeto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (situaciones == null) {
			if (other.situaciones != null)
				return false;
		} else if (!situaciones.equals(other.situaciones))
			return false;
		if (tamanyo == null) {
			if (other.tamanyo != null)
				return false;
		} else if (!tamanyo.equals(other.tamanyo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Objeto [nombre=" + nombre + ", tamanyo=" + tamanyo + ", situaciones=" + situaciones + "]";
	}
	
	
}
