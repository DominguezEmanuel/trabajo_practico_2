package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Producto> productos = new ArrayList<>(); 
		Scanner scanner = new Scanner(System.in);
		
		int opcion = 0;
		Boolean verificacion;
		
		//IMPORTANTE: Dependiendo de la forma en la que quiera trabajar, puede comentar el tipo de carga del ArrayList de Productos
		
		//cargaArrayManual(scanner, productos); //Carga manual del Arrays de Productos
		cargaArrayAutomatica(scanner, productos); //Carga automatica del Arrays de Productos
		
		do {
			verificacion = false;
			while (verificacion == false) {
				opcion = menu(scanner);
				verificacion = opcion >= 1 && opcion <= 3;
				if (verificacion == false) {
					System.out.println("Debe escoger una opcion valida");
					scanner.nextLine();
				}
			}
			
			switch(opcion) {
			case 1:
				System.out.println("");
				System.out.println("LISTA DE PRODUCTOS");
				for(Producto prod: productos) {
					System.out.println(prod);
				}
				scanner.nextLine();
				break;
				
			case 2:
				ArrayList<Producto> compras = new ArrayList<>();
				comprar(scanner, productos, compras);
				System.out.println("");
				if (compras.isEmpty()) {
					System.out.println("El carrito de compras se encuentra vacío\n");
				}else {
					System.out.println("Listado de Compras");
					for(Producto prod : compras) {
						System.out.println(prod.getDescripcion()+" $"+prod.getPrecio());
					}
					System.out.println("");
					int formaPago = opcionesPago(scanner);
					Pagar(scanner, compras, formaPago);
					scanner.nextLine();
				}
				break;
				
			case 3:
				System.out.println("Saliendo del Programa...");
				break;
			}
		}while(opcion != 3);
	}

	public static int menu(Scanner scanner) {
		int eleccion;
		System.out.println("***MENU DE OPCIONES***");
		System.out.println("1-Mostrar Productos");
		System.out.println("2-Realizar Compra");
		System.out.println("3-Salir");
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
	
	public static void cargaArrayManual(Scanner scanner, ArrayList<Producto> productos) {
		int numeroProducto = 1;
		for(int i = 0; i < 15; i++) {
			System.out.println("PRODUCTO N°"+numeroProducto);
			Producto producto = new Producto();
			producto = cargaProducto(scanner);
			productos.add(producto);
			scanner.nextLine();
			numeroProducto++;
			System.out.println("");
		}
	}
	
	public static void cargaArrayAutomatica(Scanner scanner, ArrayList<Producto> productos) {
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
		Producto producto12 = new Producto("2020", "Aire Acondicionado BGH", 350000., OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true);
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
	
	public static Producto cargaProducto(Scanner scanner) {
		Producto producto = new Producto();
		Double precio = 0.;
		Boolean verifPrecio = false, verifEstado = false;
		System.out.println("Ingrese codigo de producto: ");
		String codigo = scanner.nextLine();
		producto.setCodigo(codigo);
		System.out.println("Ingrese una descripción: ");
		String descripcion = scanner.nextLine();
		producto.setDescripcion(descripcion);
		while (verifPrecio == false) {
			try {
				System.out.println("Ingrese el precio del producto: ");
				precio = scanner.nextDouble();
				verifPrecio = true;
			}catch(Exception e) {
				System.out.println("Error en el ingreso del precio del producto");
				scanner.nextLine();
			}
		}
		producto.setPrecio(precio);
		OrigenFabricacion eleccionOrigen = cargaOrigen(scanner);
		producto.setOrigenFabricacion(eleccionOrigen);
		Categoria eleccionCategoria = cargaCategoria(scanner);
		producto.setCategoria(eleccionCategoria);
		while(verifEstado == false) {
			try {
				System.out.println("Ingrese estado del Producto (true/false): ");
				Boolean estado = scanner.nextBoolean();
				verifEstado = true;
				producto.setEstado(estado);
			}catch(Exception e) {
				System.out.println("Error en el ingreso del estado del producto");
				scanner.nextLine();
			}
		}
		return producto;
	}
	
	public static OrigenFabricacion cargaOrigen(Scanner scanner) {
		OrigenFabricacion[] origenes = OrigenFabricacion.values();
		OrigenFabricacion eleccion = null;
		int opcion;
		Boolean verif = false;
		while(verif == false) {
			System.out.println("----Origen de Fabricación----");
			System.out.println("1-Argentina");
			System.out.println("2-China");
			System.out.println("3-Brasil");
			System.out.println("4-Uruguay");
			System.out.println("");
			try {
				System.out.println("Elija una opción: ");
				opcion = scanner.nextInt();
				verif = opcion > 0 && opcion < 5;
				if (verif == true) {
					for (OrigenFabricacion origen : origenes) {
			            if (origen.ordinal() == opcion - 1) {
			            	eleccion = origen;
			            }
			        }
				}else {
					System.out.println("Seleccione una opción válida por favor");
				}
			}catch(Exception e) {
				System.out.println("Error en el ingreso, vuelva a intentarlo");
				scanner.nextLine();
				
			}
			scanner.nextLine();
		}
		return eleccion;
	}
	
	public static Categoria cargaCategoria(Scanner scanner) {
		Categoria[] categorias = Categoria.values();
		Categoria eleccion = null;
		int opcion;
		Boolean verif = false;
		while(verif == false) {
			System.out.println("----Categoría----");
			System.out.println("1-Telefonía");
			System.out.println("2-Informática");
			System.out.println("3-Electrohogar");
			System.out.println("4-Herrramientas");
			System.out.println("");
			try {
				System.out.println("Elija una opción: ");
				opcion = scanner.nextInt();
				verif = opcion > 0 && opcion < 5;
				if (verif == true) {
					for (Categoria cat : categorias) {
			            if (cat.ordinal() == opcion - 1) {
			            	eleccion = cat;
			            }
			        }
				}else {
					System.out.println("Seleccione una opción válida por favor");
				}
			}catch(Exception e) {
				System.out.println("Error en el ingreso, vuelva a intentarlo");
				scanner.nextLine();
			}
			scanner.nextLine();
		}
		return eleccion;
	}
	
	public static void comprar(Scanner scanner, ArrayList<Producto> productos, ArrayList<Producto> compras) {
		for(int i = 0; i < productos.size(); i++) {
			System.out.println(productos.get(i).getDescripcion());
			System.out.println("¿Comprar? Si/No ");
			char respuesta = scanner.next().charAt(0);
			if (respuesta == 's' || respuesta == 'S') {
				if (productos.get(i).getEstado() == true) {
					System.out.println("Añadido al carro de compras\n");
					compras.add(productos.get(i));
					scanner.nextLine();
				}else {
					System.out.println("Lo siento, este producto se encuentra fuera de stock\n");
				}
			}
		}
	}
	
	public static int opcionesPago(Scanner scanner) {
		int eleccion = 0;
		Boolean verificar = false;
		while(verificar == false) {
			System.out.println("***OPCIONES DE PAGO***");
			System.out.println("1-Pago con Efectivo");
			System.out.println("2-Pago con Tarjeta");
			System.out.println("");
			try {
				System.out.println("¿Que opcion elige? ");
				eleccion = scanner.nextInt();
				scanner.nextLine();
				verificar = eleccion > 0 && eleccion < 3;
				if (verificar == false)
					System.out.println("Debe ingresar una opción válida");
			}catch(Exception e){
				System.out.println("ERROR: Debe ingresar una opción valida");
				scanner.nextLine();
			}
		}
		return eleccion;
	}
	
	public static void Pagar (Scanner scanner, ArrayList<Producto> compras, int formaPago) {
		
		switch(formaPago) {
		case 1:
			Double montoApagar = calcularMonto(compras);
			LocalDate fecha = LocalDate.now();
			PagoEfectivo efectivo = new PagoEfectivo(montoApagar, fecha);
			efectivo.realizarPago(montoApagar);
			efectivo.imprimirRecibo();
			break;
			
		case 2:
			System.out.println("Ingrese número de tarjeta: ");
			String numeroTarjeta = scanner.nextLine();
			LocalDate hoy = LocalDate.now();
			Double montoParaPagar = calcularMonto(compras);
			PagoTarjeta tarjeta = new PagoTarjeta(numeroTarjeta, hoy, montoParaPagar);
			tarjeta.realizarPago(montoParaPagar);
			tarjeta.imprimirRecibo();
			break;
		}
	}
	
	public static Double calcularMonto(ArrayList<Producto> compras) {
		Double sumatoria = 0.;
		for(Producto prod : compras) {
			sumatoria = sumatoria + prod.getPrecio();
		}
		return sumatoria;
	}
	
}
