package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ciclista")

public class Ciclista implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dorsal;
	private String nombre;
	private Date nacimiento;
	
	//Relacion con Equipo
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "nomeq")
	private Equipo equipo;
	
	//Relacion con Etapa
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ciclista")
	private List<Etapa> etapas = new ArrayList<Etapa>();
	
	//Relacion con Puertos
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ciclista")
	private List<Puerto> puertos = new ArrayList<Puerto>();
	
	//Relacion con Premios
	@ManyToMany(mappedBy = "ciclistas")
	private List<Premio> premios = new ArrayList<Premio>();
	
	public Ciclista() {
		
	}

	public Ciclista(Integer dorsal, String nombre, Date nacimiento, Equipo equipo, List<Etapa> etapas,
			List<Puerto> puertos, List<Premio> premios) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.equipo = equipo;
		this.etapas = etapas;
		this.puertos = puertos;
		this.premios = premios;
	}

	public Integer getDorsal() {
		return dorsal;
	}

	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Etapa> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
	}

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}

	public List<Premio> getPremios() {
		return premios;
	}

	public void setPremios(List<Premio> premios) {
		this.premios = premios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dorsal, equipo, etapas, nacimiento, nombre, premios, puertos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciclista other = (Ciclista) obj;
		return Objects.equals(dorsal, other.dorsal) && Objects.equals(equipo, other.equipo)
				&& Objects.equals(etapas, other.etapas) && Objects.equals(nacimiento, other.nacimiento)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(premios, other.premios)
				&& Objects.equals(puertos, other.puertos);
	}

	@Override
	public String toString() {
		return "Ciclista [dorsal=" + dorsal + ", nombre=" + nombre + ", nacimiento=" + nacimiento + ", equipo=" + equipo
				+ ", etapas=" + etapas + ", puertos=" + puertos + ", premios=" + premios + "]";
	}

	
	
}
