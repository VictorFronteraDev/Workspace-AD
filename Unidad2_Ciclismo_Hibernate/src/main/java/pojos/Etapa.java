package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "etapa")
public class Etapa implements Serializable {
	@Id
	private Integer netapa;
	private Integer km;
	private String salida;
	private String llegada;
	
	//Relacion con Ciclista
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dorsal")
	private Ciclista ciclista;
	
	//Relacion con Puertos
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etapa")
	private List<Puerto> puertos = new ArrayList<Puerto>();
	
	public Etapa() {
		
	}

	public Etapa(Integer netapa, Integer km, String salida, String llegada, Ciclista ciclista, List<Puerto> puertos) {
		super();
		this.netapa = netapa;
		this.km = km;
		this.salida = salida;
		this.llegada = llegada;
		this.ciclista = ciclista;
		this.puertos = puertos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclista == null) ? 0 : ciclista.hashCode());
		result = prime * result + ((km == null) ? 0 : km.hashCode());
		result = prime * result + ((llegada == null) ? 0 : llegada.hashCode());
		result = prime * result + ((netapa == null) ? 0 : netapa.hashCode());
		result = prime * result + ((puertos == null) ? 0 : puertos.hashCode());
		result = prime * result + ((salida == null) ? 0 : salida.hashCode());
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
		Etapa other = (Etapa) obj;
		if (ciclista == null) {
			if (other.ciclista != null)
				return false;
		} else if (!ciclista.equals(other.ciclista))
			return false;
		if (km == null) {
			if (other.km != null)
				return false;
		} else if (!km.equals(other.km))
			return false;
		if (llegada == null) {
			if (other.llegada != null)
				return false;
		} else if (!llegada.equals(other.llegada))
			return false;
		if (netapa == null) {
			if (other.netapa != null)
				return false;
		} else if (!netapa.equals(other.netapa))
			return false;
		if (puertos == null) {
			if (other.puertos != null)
				return false;
		} else if (!puertos.equals(other.puertos))
			return false;
		if (salida == null) {
			if (other.salida != null)
				return false;
		} else if (!salida.equals(other.salida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Etapa [netapa=" + netapa + ", km=" + km + ", salida=" + salida + ", llegada=" + llegada + ", ciclista="
				+ ciclista + ", puertos=" + puertos + "]";
	}

	public Integer getNetapa() {
		return netapa;
	}

	public void setNetapa(Integer netapa) {
		this.netapa = netapa;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}

	
}
