package pojos;
// Generated 15 dic. 2022 9:05:46 by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ganadores generated by hbm2java
 */
@Entity
@Table(name = "ganadores", catalog = "ciclismo")
public class Ganadores implements java.io.Serializable {

	private GanadoresId id;

	public Ganadores() {
	}

	public Ganadores(GanadoresId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "nombre", column = @Column(name = "nombre", nullable = false, length = 30)),
			@AttributeOverride(name = "nomeq", column = @Column(name = "nomeq", nullable = false, length = 25)),
			@AttributeOverride(name = "netapa", column = @Column(name = "netapa", nullable = false)) })
	public GanadoresId getId() {
		return this.id;
	}

	public void setId(GanadoresId id) {
		this.id = id;
	}

}