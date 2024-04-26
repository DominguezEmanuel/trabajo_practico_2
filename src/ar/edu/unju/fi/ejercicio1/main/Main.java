package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Producto> productos = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		Boolean verificacion;
		
		do {
			verificacion = false;
			
			while(verificacion == false) {
				opcion = menu(scanner);
				verificacion = opcion > 0 && opcion < 5;
				if (verificacion == false) {
					System.out.println("Seleccione una opción válida por favor");
					scanner.nextLine();
				}
			}
			scanner.nextLine();
			switch(opcion) {
			
			case 1:
				crearProducto(scanner, productos);
				break;
				
			case 2:
				if (productos.isEmpty()) {
					System.out.println("La lista de productos está vacía");
				}else {
					for(Producto prod : productos) {
						System.out.println(prod);
					}
				}
				scanner.nextLine();
				break;
			
			case 3:
				if (productos.isEmpty()) {
					System.out.println("La lista de productos está vacía");
					scanner.nextLine();
				}else {
					System.out.println("Ingrese codigo de producto: ");
					String codigo = scanner.nextLine();
					Producto buscado = verificarCodigo(productos, codigo);
					if (buscado != null) {
						int eleccion = menuModificar(scanner);
						scanner.nextLine();
						Modificar(scanner, buscado, eleccion);
					}else {
						System.out.println("El código proporcionado no corresponde con ningún producto de la lista");
						scanner.nextLine();
					}
				}
				break;
				
			case 4:
				System.out.println("Saliendo del Programa...");
				break;
			}
		}while(opcion != 4);

	}
	
	public static int menu(Scanner scanner) {
		int eleccion = 0;
		System.out.println("***MENÚ***");
		System.out.println("1-Crear Producto");
		System.out.println("2-Mostrar Productos");
		System.out.println("3-Modificar Producto");
		System.out.println("4-Salir del Programa");
		System.out.println("");
		try {
			System.out.println("¿Que opción elige?");
			eleccion = scanner.nextInt();
			return eleccion;
		}catch(Exception e) {
			System.out.println("Error en el ingreso, vuelva a intentarlo");
			scanner.nextLine();
			return 0;
		}
	}
	
	public static void crearProducto(Scanner scanner, ArrayList<Producto> productos) {
		Double precio = 0.;

		System.out.println("Ingrese codigo de producto: ");
		String codigo = scanner.nextLine();
		System.out.println("Ingrese una descripción: ");
		String descripcion = scanner.nextLine();
		try {
			System.out.println("Ingrese el precio del producto: ");
			precio = scanner.nextDouble();
			OrigenFabricacion eleccionOrigen = menuOrigen(scanner);
			Categoria eleccionCategoria = menuCategoria(scanner);
			Producto producto = new Producto(codigo, descripcion, precio, eleccionOrigen, eleccionCategoria);
			productos.add(producto);
		}catch(Exception e) {
			System.out.println("Error en el ingreso del precio del producto");
			scanner.nextLine();
		}
}
	
	public static OrigenFabricacion menuOrigen(Scanner scanner) {
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
				}
			}catch(Exception e) {
				System.out.println("Error en el ingreso, vuelva a intentarlo");
				scanner.nextLine();
				
			}
			if (verif == false) 
				System.out.println("Seleccione una opción válida por favor");
			scanner.nextLine();
		}
		return eleccion;
	}
	
	public static Categoria menuCategoria(Scanner scanner) {
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
				}
			}catch(Exception e) {
				System.out.println("Error en el ingreso, vuelva a intentarlo");
				scanner.nextLine();
			}
			if (verif == false) 
				System.out.println("Seleccione una opción válida por favor");
			scanner.nextLine();
		}
		return eleccion;
	}
	
	public static Producto verificarCodigo(ArrayList<Producto> productos, String codigo) {
		Producto encontrado = null;
		for(Producto prod : productos) {
			if (prod.getCodigo().equals(codigo))
				encontrado = prod;
		}
		return encontrado;
	}
	
	public static int menuModificar(Scanner scanner) {
		int opcion = 0;
		Boolean verif = false;
		while(verif == false) {
			System.out.println("----Menú Modificar----");
			System.out.println("1-Descripción");
			System.out.println("2-Precio");
			System.out.println("3-Origen");
			System.out.println("4-Categoría");
			System.out.println("");
			try {
				System.out.println("Elija una opción: ");
				opcion = scanner.nextInt();
				verif = opcion > 0 && opcion < 5;
			}catch(Exception e) {
				System.out.println("Error en el ingreso, vuelva a intentarlo");
				scanner.nextLine();
			}
			if (verif == false) {
				System.out.println("Seleccione una opción válida por favor");
				scanner.nextLine();
			}
		}
		return opcion;
	}
	
	public static void Modificar(Scanner scanner, Producto producto, int eleccion) {
		switch(eleccion) {
		    case 1:
		    	System.out.println("Ingrese nueva descripción: ");
		    	String descripcion = scanner.nextLine();
		    	producto.setDescripcion(descripcion);
		    	break;
			
		    case 2:
		    	try {
			    	System.out.println("Ingrese nuevo Precio: ");
			    	Double precio = scanner.nextDouble();
			    	producto.setPrecio(precio);
		    	}catch(InputMismatchException e) {
		    		System.out.println("Error en el ingreso del precio del producto");
					scanner.nextLine();
		    	}
		    	break;
		    
		    case 3:
		    	OrigenFabricacion eleccionOrigen = menuOrigen(scanner);
		    	producto.setOrigenFabricacion(eleccionOrigen);
		    	break;
		    
		    case 4:
		    	Categoria eleccionCategoria = menuCategoria(scanner);
		    	producto.setCategoria(eleccionCategoria);
		    	break;
		}
	}

}
