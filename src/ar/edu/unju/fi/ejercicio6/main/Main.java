package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		
		
		//Conversión de Doméstico a Salvaje
		System.out.println("De Doméstico a Salvaje");
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		//definición de expresión lambda que define el convertidor de FelinoDomestico a FelinoSalvaje.
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		//se realiza la conversión
		FelinoSalvaje felino1 = converter.convert(gato);
		//mostramos los datos del objeto felino salvaje felino1
		converter.mostrarObjeto(felino1);

		//Conversión de Salvaje a Doméstico
		FelinoSalvaje gato2 = new FelinoSalvaje("Tanner", (byte)20, 186f);
		//FelinoSalvaje gato2 = null;
		boolean IsNotNull = Converter.isNotNull(gato2);
		if(IsNotNull == true) {
			Converter<FelinoSalvaje, FelinoDomestico> converter2 = y -> new FelinoDomestico(y.getNombre(), y.getEdad(), y.getPeso());
			FelinoDomestico felino2 = converter2.convert(gato2);
			System.out.println("");
			System.out.println("De Salvaje a Doméstico");
			converter2.mostrarObjeto(felino2);
		}else {
			System.out.println("\nOBJETO NULO");
		}
		
	}

}
