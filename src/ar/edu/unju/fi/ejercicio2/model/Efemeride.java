package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {

	private String codigo;
	private Mes mes;
	private short dia;
	private String detalle;
	
	public Efemeride() {
		
	}

	public Efemeride(String codigo, Mes mes, short dia, String detalle) {
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Datos de Efemeride [Código: " + codigo + " - Mes: " + mes + " - Día: " + dia + 
				" - Detalle: " + detalle + "]";
	}

 	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public short getDia() {
		return dia;
	}

	public void setDia(short dia) {
		this.dia = dia;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
}
