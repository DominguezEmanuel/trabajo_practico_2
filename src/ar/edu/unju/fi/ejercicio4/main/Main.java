package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		int opcion = 0;
		Boolean verificacion;
		
		do {
			verificacion = false;
			while (verificacion == false) {
				opcion = menu(scanner);
				if (opcion >= 1 && opcion <= 8) {
					verificacion = true;
				}else {
					System.out.println("Debe escoger una opcion valida");
					scanner.nextLine();
				}
			}
		switch(opcion) {
		case 1:
			altaJugador(scanner, jugadores);
			break;
			
		case 2:
			if (jugadores.isEmpty()) {
				System.out.println("Lista Vacía");
			}else {
				for(Jugador jugador : jugadores) {
					System.out.println(jugador);
				}
			}
			scanner.nextLine();
			break;
			
		case 3:
			if (jugadores.isEmpty()) {
				System.out.println("Lista Vacía");
			}else {
				modificarJugador(jugadores, scanner);
			}
			scanner.nextLine();
			break;
			
		case 4:
			if (jugadores.isEmpty()) {
				System.out.println("Lista Vacía");
			}else {
				borrarJugador(jugadores, scanner);
			}
			scanner.nextLine();
			break;
			
		case 5:
			System.out.println("Saliendo del Programa...");
			break;
		}
		}while(opcion != 5);

	}

	public static int menu(Scanner scanner) {
		int eleccion;
		System.out.println("***MENU DE OPCIONES***");
		System.out.println("1-Alta Jugador");
		System.out.println("2-Mostrar todos los Jugadores");
		System.out.println("3-Modificar posicion de un Jugador");
		System.out.println("4-Eliminar Jugador");
		System.out.println("5-Salir");
		System.out.println("");
		try {
			System.out.println("¿Que opcion elige? ");
			eleccion = scanner.nextInt();
			scanner.nextLine();
			return eleccion;
		}catch(Exception e){
			System.out.println("Debe ingresar un numero");
			scanner.nextLine();
			return 0;
		}
	}
	
	public static void altaJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
		Boolean verificado = false;
		
		System.out.println("Ingrese nombre de jugador: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese apellido: ");
        String apellido = scanner.nextLine();
		System.out.println("Ingrese nacionalidad: ");
		String nacionalidad = scanner.nextLine();
		while(verificado == false) {
			try {
				System.out.println("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
				String fechaNac = scanner.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechaNacimiento = LocalDate.parse(fechaNac,formatter);
				System.out.println("Ingrese estatura Ej:1,70 ");
				Double estatura = scanner.nextDouble();
				System.out.println("Ingrese peso Ej: 70,5: ");
				Double peso = scanner.nextDouble();
				scanner.nextLine();
				Posicion posicion = eleccionPosicion(scanner);
				verificado = true;
				if (verificado == true) {
					 Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, 
							 nacionalidad, estatura, peso, posicion);
				     jugadores.add(jugador);
				     System.out.println("Jugador dado de alta");
				}
				
			}catch(Exception e) {
				System.out.println("Error en el ingreso de datos, intente otra vez");
				scanner.nextLine();
			}
		}
	}

	public static Posicion eleccionPosicion(Scanner scanner) {
		Posicion[] posiciones = Posicion.values();
		Posicion eleccion = null;
		int opcion = 0;
		Boolean band = false;
		while(band == false) {
			System.out.println("***POSICIONES***");
			System.out.println("1-DELANTERO");
			System.out.println("2-MEDIO");
			System.out.println("3-DEFENSA");
			System.out.println("4-ARQUERO");
			System.out.println("");
			try{
				System.out.println("¿Que opcion elige? ");
				opcion = scanner.nextInt();
				//scanner.nextLine();
				band = opcion > 0 && opcion < 5;
				if (band == false)
					System.out.println("Ingrese una opción válida");
				scanner.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("Error: opcion erronea");
				scanner.nextLine();
			}
		}
		
		if (band == true) {
			for(Posicion pos : posiciones) {
				if (pos.ordinal() == opcion - 1) {
					eleccion = pos;
				}
			}
		}
		return eleccion;
	}
	
	public static void modificarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
		Jugador jugador = new Jugador();
		Boolean band = false;
		
		System.out.println("Ingrese nombre de Jugador: ");
		String nombre = scanner.nextLine();
		System.out.println("Ingrese apellido de Jugador: ");
		String apellido = scanner.nextLine();
		
		for(Jugador jug : jugadores) {
			if (jug.getNombre().equals(nombre) && jug.getApellido().equals(apellido)) {
				jugador = jug;
				band = true;
			}
		}
		if (band == false)
			System.out.println("Los datos proporcionados no corresponden con ningún jugador");
		else {
			Posicion posicion = eleccionPosicion(scanner);
			jugador.setPosicion(posicion);
			System.out.println("Posicion Modificada");
		}
	}
	
	
 	public static void borrarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
		
		Iterator<Jugador> iteratorJugador = jugadores.iterator();
		Boolean band = false;
		
		System.out.println("Ingrese nombre de Jugador: ");
		String nombre = scanner.nextLine();
		System.out.println("Ingrese apellido de Jugador: ");
		String apellido = scanner.nextLine();
		
		while(iteratorJugador.hasNext()) {
			Jugador jug = iteratorJugador.next();
			if (jug.getNombre().equals(nombre) && jug.getApellido().equals(apellido)) {
				iteratorJugador.remove();
				band = true;
			}
		}
		if (band == false)
			System.out.println("Los datos proporcionados no corresponden con ningún jugador");
		else
			System.out.println("Jugador Eliminado");
	}
}