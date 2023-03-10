package pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PagosId generated by hbm2java
 */
@Embeddable
public class PagosId implements java.io.Serializable {

	private int codigoCliente;
	private String idtransaccion;

	public PagosId() {
	}

	public PagosId(int codigoCliente, String idtransaccion) {
		this.codigoCliente = codigoCliente;
		this.idtransaccion = idtransaccion;
	}

	@Column(name = "CodigoCliente", nullable = false)
	public int getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	@Column(name = "IDTransaccion", nullable = false, length = 50)
	public String getIdtransaccion() {
		return this.idtransaccion;
	}

	public void setIdtransaccion(String idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PagosId))
			return false;
		PagosId castOther = (PagosId) other;

		return (this.getCodigoCliente() == castOther.getCodigoCliente())
				&& ((this.getIdtransaccion() == castOther.getIdtransaccion())
						|| (this.getIdtransaccion() != null && castOther.getIdtransaccion() != null
								&& this.getIdtransaccion().equals(castOther.getIdtransaccion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoCliente();
		result = 37 * result + (getIdtransaccion() == null ? 0 : this.getIdtransaccion().hashCode());
		return result;
	}

}
