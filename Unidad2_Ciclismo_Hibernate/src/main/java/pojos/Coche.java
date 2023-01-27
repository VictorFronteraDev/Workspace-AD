package pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "coche")
public class Coche implements Serializable{

	@Id
	private Integer cod;
	private String matricula;
	//nomeq es la clave ajena 
	private Integer km;
	private String patrocinador;
	private String marca;
	private String funcion;
	private String tipo;

	//Relacion con Equipo
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "nomequipo")
	private Equipo equipo;
	
	
	public Coche() {
	}


	public Coche(Integer cod, String matricula, Integer km, String patrocinador, String marca, String funcion,
			String tipo, Equipo equipo) {
		super();
		this.cod = cod;
		this.matricula = matricula;
		this.km = km;
		this.patrocinador = patrocinador;
		this.marca = marca;
		this.funcion = funcion;
		this.tipo = tipo;
		this.equipo = equipo;
	}


	public Integer getCod() {
		return cod;
	}


	public void setCod(Integer cod) {
		this.cod = cod;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public Integer getKm() {
		return km;
	}


	public void setKm(Integer km) {
		this.km = km;
	}


	public String getPatrocinador() {
		return patrocinador;
	}


	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getFuncion() {
		return funcion;
	}


	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	

}
