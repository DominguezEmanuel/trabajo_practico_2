package ar.edu.unju.fi.ejercicio6.model;

public class FelinoSalvaje extends FelinoDomestico{

	public FelinoSalvaje() {
		
	}
	
	public FelinoSalvaje(String nombre, byte edad, float peso) {
		super(nombre, edad, peso);
	}

	@Override
	public String toString() {
		return "Felino Salvaje [Nombre: " + getNombre() + " - Edad: " + getEdad() + " - Peso: " + getPeso() + "kg]";
	}
}
