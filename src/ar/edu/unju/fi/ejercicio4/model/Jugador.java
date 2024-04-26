package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {

	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private Double estatura;
	private Double peso;
	private Posicion posicion;
	
	public Jugador() {
		
	}

	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, Double estatura,
			Double peso, Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Datos del Jugador [Nombre: " + nombre + " - Apellido: " + apellido + " - Fecha de Nacimiento: " + fechaNacimiento + 
				" - Edad: " + calcularEdad(fechaNacimiento) + " años - Nacionalidad: " + nacionalidad + " - Estatura: " + estatura + "mts - Peso: " + peso + "kg - Posición: "
				+ posicion + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public int calcularEdad(LocalDate fechaNacimiento) {
		
		int anioNacimiento = fechaNacimiento.getYear();
		int mesNacimiento = fechaNacimiento.getMonthValue();
		int anioActual = LocalDate.now().getYear();
		int mesActual = LocalDate.now().getMonthValue();
		
		if (mesNacimiento <= mesActual)
			return anioActual - anioNacimiento;
		else
			return anioActual - anioNacimiento - 1;
	}
}
