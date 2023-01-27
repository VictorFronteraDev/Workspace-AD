package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "situacion")
public class Situacion implements Serializable{

	@Id
	private Integer Hora;
	private String Lugar;
	private String Vestuario;
	private String Mercancia;
	
	//relacion con Persona
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "situacion")
	private Persona persona;
	
	///Relacion con objeto
	@ManyToMany
	@JoinTable(name = "lleva", joinColumns = {@JoinColumn(name = "HoraSITUACION", referencedColumnName="Hora")},
	inverseJoinColumns= {@JoinColumn(name="nombreOBJETO", referencedColumnName="nombre")})
	private List<Objeto> objetos = new ArrayList<Objeto>();

	public Situacion() {

	}

	public Situacion(Integer hora, String lugar, String vestuario, String mercancia, Persona persona,
			List<Objeto> objetos) {
		super();
		Hora = hora;
		Lugar = lugar;
		Vestuario = vestuario;
		Mercancia = mercancia;
		this.persona = persona;
		this.objetos = objetos;
	}

	public Integer getHora() {
		return Hora;
	}

	public void setHora(Integer hora) {
		Hora = hora;
	}

	public String getLugar() {
		return Lugar;
	}

	public void setLugar(String lugar) {
		Lugar = lugar;
	}

	public String getVestuario() {
		return Vestuario;
	}

	public void setVestuario(String vestuario) {
		Vestuario = vestuario;
	}

	public String getMercancia() {
		return Mercancia;
	}

	public void setMercancia(String mercancia) {
		Mercancia = mercancia;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Hora == null) ? 0 : Hora.hashCode());
		result = prime * result + ((Lugar == null) ? 0 : Lugar.hashCode());
		result = prime * result + ((Mercancia == null) ? 0 : Mercancia.hashCode());
		result = prime * result + ((Vestuario == null) ? 0 : Vestuario.hashCode());
		result = prime * result + ((objetos == null) ? 0 : objetos.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
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
		Situacion other = (Situacion) obj;
		if (Hora == null) {
			if (other.Hora != null)
				return false;
		} else if (!Hora.equals(other.Hora))
			return false;
		if (Lugar == null) {
			if (other.Lugar != null)
				return false;
		} else if (!Lugar.equals(other.Lugar))
			return false;
		if (Mercancia == null) {
			if (other.Mercancia != null)
				return false;
		} else if (!Mercancia.equals(other.Mercancia))
			return false;
		if (Vestuario == null) {
			if (other.Vestuario != null)
				return false;
		} else if (!Vestuario.equals(other.Vestuario))
			return false;
		if (objetos == null) {
			if (other.objetos != null)
				return false;
		} else if (!objetos.equals(other.objetos))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Situacion [Hora=" + Hora + ", Lugar=" + Lugar + ", Vestuario=" + Vestuario + ", Mercancia=" + Mercancia
				+ ", persona=" + persona + ", objetos=" + objetos + "]";
	}
	
	
	
	
}
