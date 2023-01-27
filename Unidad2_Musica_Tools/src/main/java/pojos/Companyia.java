package pojos;
// Generated 11 ene. 2023 11:34:46 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Companyia generated by hbm2java
 */
@Entity
@Table(name = "companyia", catalog = "musica")
public class Companyia implements java.io.Serializable {

	private Integer cod;
	private String nombre;
	private String dir;
	private String fax;
	private String tfno;
	private Set<Disco> discos = new HashSet<Disco>(0);

	public Companyia() {
	}

	public Companyia(String nombre) {
		this.nombre = nombre;
	}

	public Companyia(String nombre, String dir, String fax, String tfno, Set<Disco> discos) {
		this.nombre = nombre;
		this.dir = dir;
		this.fax = fax;
		this.tfno = tfno;
		this.discos = discos;
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

	@Column(name = "nombre", nullable = false, length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "dir", length = 30)
	public String getDir() {
		return this.dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	@Column(name = "fax", length = 15)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "tfno", length = 15)
	public String getTfno() {
		return this.tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companyia")
	public Set<Disco> getDiscos() {
		return this.discos;
	}

	public void setDiscos(Set<Disco> discos) {
		this.discos = discos;
	}

}
