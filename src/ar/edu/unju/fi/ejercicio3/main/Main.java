package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		
		Provincia[] provincias = Provincia.values();
		
		for(Provincia prov : provincias) {
			System.out.println(prov.name());
			System.out.println("Cantidad de Población: "+prov.getPoblacion()+" habitantes");
			System.out.println("Superficie: "+prov.getSuperficie()+"km²");
			System.out.println("Densidad Poblacional: "
			+prov.densidadPoblacional(prov.getPoblacion(), prov.getSuperficie())+" hab/km²");
			System.out.println("");
		}

	}

}
