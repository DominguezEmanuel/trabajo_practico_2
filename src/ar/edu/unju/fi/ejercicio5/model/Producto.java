package ar.edu.unju.fi.ejercicio5.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private Double precio;
	private OrigenFabricacion origenFabricacion;
    private Categoria categoria;
    private Boolean estado;
    
public Producto() {
    	
    }

    public Producto(String codigo, String descripcion, Double precio, OrigenFabricacion origenFabricacion,
			Categoria categoria, Boolean estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}
    
	@Override
	public String toString() {
		return "Producto [Código: " + codigo + " - Descripción: " + descripcion + " - Precio: $" + precio
				+ " - Origen de Fabricación: " + origenFabricacion + " - Categoría: " + categoria + " - Estado: " + estado + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public enum OrigenFabricacion {
        ARGENTINA, CHINA, BRASIL, URUGUAY;
    }

    public enum Categoria {
        TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
    }
}
