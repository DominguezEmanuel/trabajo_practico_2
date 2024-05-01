package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.until.Producto;
import ar.edu.unju.fi.ejercicio7.until.Producto.Categoria;
import ar.edu.unju.fi.ejercicio7.until.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		
		List<Producto> productos = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		Boolean verificacion = false;
		int opcion = 0;
		cargaArrayAutomatica(scanner, productos); //Carga automatica del Arrays de Productos
		
		do {
			verificacion = false;
			while (verificacion == false) {
				opcion = menu(scanner);
				verificacion = opcion >= 1 && opcion <= 7;
				if (verificacion == false) {
					System.out.println("Debe escoger una opcion valida");
					scanner.nextLine();
				}
			}
			
			switch(opcion) {
			case 1:
				System.out.println("\nProductos Disponibles\n");
				MostrarDisponibles(productos);
				scanner.nextLine();
				break;
				
			case 2:
				System.out.println("\nProductos NO Disponibles\n");
				MostrarNoDisponibles(productos);
				scanner.nextLine();
				break;
				
			case 3:
				System.out.println("\nListado de nuevos precios\n");
				incrementarPrecios(productos);
				scanner.nextLine();
				break;
				
			case 4:
				System.out.println("\nListado de productos de tipo ELECTROHOGAR\n");
				MostrarProductosdeElectrohogar(productos);
				scanner.nextLine();
				break;
				
			case 5:
				System.out.println("\nLista de los Productos ordenados por precio\n");
				ordenadorPorPrecio(productos);
				scanner.nextLine();
				break;
				
			case 6:
				System.out.println("\nLista de Productos con nombres en Mayúsculas");
				MostrarNombresEnMayusculas(productos);
				scanner.nextLine();
				break;
				
			case 7:
				System.out.println("Saliendo del Programa...");
				break;
			}
			
		}while(opcion != 7);
	}

	
	public static void cargaArrayAutomatica(Scanner scanner, List<Producto> productos) {
		Producto producto1 = new Producto("0909", "Procesador Intel Core i5", 175000., OrigenFabricacion.CHINA, Categoria.INFORMATICA, true);
		Producto producto2 = new Producto("5555", "Kit desarmador de Computadoras", 25000., OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, false);
		Producto producto3 = new Producto("0012", "Impresora hp", 100500., OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true);
		Producto producto4 = new Producto("8901", "Heladera Panoramic", 500750., OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true);
		Producto producto5 = new Producto("0001", "Licuadora Philips", 55000., OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true);
		Producto producto6 = new Producto("9998", "Motorola G52", 450000., OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, false);
		Producto producto7 = new Producto("1234", "Monitor Philips 22''", 160000., OrigenFabricacion.CHINA, Categoria.INFORMATICA, true);
		Producto producto8 = new Producto("5000", "Teclado Constrictor", 13800., OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true);
		Producto producto9 = new Producto("6665", "Mouse Gaming NOGA", 8750., OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, false);
		Producto producto10 = new Producto("8888", "Auriculares Inalambricos", 7500., OrigenFabricacion.CHINA, Categoria.TELEFONIA, true);
		Producto producto11 = new Producto("8987", "Gabinete Gamer", 90000., OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true);
		Producto producto12 = new Producto("2020", "Aire Acondicionado BGH", 350000., OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false);
		Producto producto13 = new Producto("2024", "Iphone 15 Pro Max", 950000., OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, false);
		Producto producto14 = new Producto("7537", "Pasta Termica MX-4", 8900., OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto producto15 = new Producto("9639", "Coolers RGB", 7500., OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);
		productos.add(producto5);
		productos.add(producto6);
		productos.add(producto7);
		productos.add(producto8);
		productos.add(producto9);
		productos.add(producto10);
		productos.add(producto11);
		productos.add(producto12);
		productos.add(producto13);
		productos.add(producto14);
		productos.add(producto15);
	}

	public static int menu(Scanner scanner) {
		int eleccion;
		System.out.println("***MENU DE OPCIONES***");
		System.out.println("1-Mostrar Productos disponibles");
		System.out.println("2-Mostrar Productos NO disponibles");
		System.out.println("3-Incrementar precios 20%");
		System.out.println("4-Mostrar Productos de tipo ELECTROHOGAR que estén disponibles");
		System.out.println("5-Ordenar los Productos por precio");
		System.out.println("6-Mostrar Productos con nombres en Mayúsculas");
		System.out.println("7-Salir\n");
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

	public static void MostrarDisponibles(List<Producto> productos) {
		Predicate<Producto> disponibles = p->p.getEstado();
		productos.stream().filter(disponibles).forEach(System.out::println);
	}
	
	public static void MostrarNoDisponibles(List<Producto> productos) {
		Predicate<Producto> NoDisponibles = p->!p.getEstado();
		productos.stream().filter(NoDisponibles).forEach(System.out::println);
	}
	
	public static void incrementarPrecios(List<Producto> productos) {
		Function<Producto, Producto> incremento = (p)->{
				Double resultado = p.getPrecio()+(p.getPrecio()*0.20);
				p.setPrecio(resultado);
				return p;
			};
		List<Producto> productosIncrementados = new ArrayList<>();
		productosIncrementados = productos.stream().map(incremento).collect(Collectors.toList());
		productosIncrementados.forEach(System.out::println);
	}
	
	public static void MostrarProductosdeElectrohogar(List<Producto> productos) {
		Predicate<Producto> productosElectrohogar = p->p.getCategoria().name().equals("ELECTROHOGAR") && p.getEstado();
		productos.stream().filter(productosElectrohogar).forEach(System.out::println);
	}
	
	public static void ordenadorPorPrecio(List<Producto> productos) {
		productos.sort(Comparator.comparing(Producto::getPrecio).reversed());
		productos.forEach(p->System.out.println(p));
	}
	
	public static void MostrarNombresEnMayusculas(List<Producto> productos) {
		Function<Producto, Producto> pasarAmayusculas = (p)->{
			String nombreEnMayusculas = p.getDescripcion().toUpperCase();
			p.setDescripcion(nombreEnMayusculas);
			return p;
		};
		productos.stream().map(pasarAmayusculas).forEach(System.out::println);
	}
}
