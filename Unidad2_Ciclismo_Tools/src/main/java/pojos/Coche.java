package pojos;
// Generated 15 dic. 2022 9:05:46 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Coche generated by hbm2java
 */
@Entity
@Table(name = "coche", catalog = "ciclismo", uniqueConstraints = @UniqueConstraint(columnNames = "matricula"))
public class Coche implements java.io.Serializable {

	private Integer cod;
	private Equipo equipo;
	private String matricula;
	private Integer km;
	private String patrocinador;
	private String marca;
	private String funcion;
	private String tipo;

	public Coche() {
	}

	public Coche(String patrocinador) {
		this.patrocinador = patrocinador;
	}

	public Coche(Equipo equipo, String matricula, Integer km, String patrocinador, String marca, String funcion,
			String tipo) {
		this.equipo = equipo;
		this.matricula = matricula;
		this.km = km;
		this.patrocinador = patrocinador;
		this.marca = marca;
		this.funcion = funcion;
		this.tipo = tipo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cod", unique = true, nullable = false)
	public Integer getCod() {
		return this.cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nomequipo")
	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Column(name = "matricula", unique = true, length = 10)
	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Column(name = "km")
	public Integer getKm() {
		return this.km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	@Column(name = "patrocinador", nullable = false, length = 10)
	public String getPatrocinador() {
		return this.patrocinador;
	}

	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}

	@Column(name = "marca", length = 10)
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Column(name = "funcion", length = 10)
	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	@Column(name = "tipo", length = 25)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}