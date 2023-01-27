package pojos;
// Generated 15 dic. 2022 9:05:46 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LlevarId generated by hbm2java
 */
@Embeddable
public class LlevarId implements java.io.Serializable {

	private short netapa;
	private String codigo;

	public LlevarId() {
	}

	public LlevarId(short netapa, String codigo) {
		this.netapa = netapa;
		this.codigo = codigo;
	}

	@Column(name = "netapa", nullable = false)
	public short getNetapa() {
		return this.netapa;
	}

	public void setNetapa(short netapa) {
		this.netapa = netapa;
	}

	@Column(name = "codigo", nullable = false, length = 3)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LlevarId))
			return false;
		LlevarId castOther = (LlevarId) other;

		return (this.getNetapa() == castOther.getNetapa())
				&& ((this.getCodigo() == castOther.getCodigo()) || (this.getCodigo() != null
						&& castOther.getCodigo() != null && this.getCodigo().equals(castOther.getCodigo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getNetapa();
		result = 37 * result + (getCodigo() == null ? 0 : this.getCodigo().hashCode());
		return result;
	}

}