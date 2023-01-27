package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {
	@Id
	@Column(name = "nomeq")
	private String nombre;
	private String director;

	//Relacion con Ciclista
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipo")
	private List<Ciclista> ciclistas = new ArrayList<Ciclista>();
	
	//Relacion con Representante
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipo")
	private Representante representante;
	
	//Relacion con coshe
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipo")
	private Coche coche;

	public Equipo() {

	}

	public Equipo(String nombre, String director, List<Ciclista> ciclistas, Representante representante, Coche coche) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.ciclistas = ciclistas;
		this.representante = representante;
		this.coche = coche;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciclistas, coche, director, nombre, representante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(ciclistas, other.ciclistas) && Objects.equals(coche, other.coche)
				&& Objects.equals(director, other.director) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(representante, other.representante);
	}

	

}
