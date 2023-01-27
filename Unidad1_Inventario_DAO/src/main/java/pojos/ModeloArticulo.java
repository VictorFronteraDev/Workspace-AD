package pojos;

public class ModeloArticulo {
	private Integer idModeloArticulo;
	private String nombre;
	private String descripcion;
	private String marca;
	private String modelo;
	private Integer tipo;
	
	
	public ModeloArticulo() {
		
	}


	public ModeloArticulo(Integer idModeloArticulo, String nombre, String descripcion, String marca, String modelo,
			Integer tipo) {
		super();
		this.idModeloArticulo = idModeloArticulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
	}


	public Integer getIdModeloArticulo() {
		return idModeloArticulo;
	}


	public void setIdModeloArticulo(Integer idModeloArticulo) {
		this.idModeloArticulo = idModeloArticulo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	
}
