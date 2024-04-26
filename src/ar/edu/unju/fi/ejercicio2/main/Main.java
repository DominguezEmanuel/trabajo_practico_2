package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		Boolean verificacion;
		
		do {
			verificacion = false;
			
			while(verificacion == false) {
				opcion = menu(scanner);
				verificacion = opcion > 0 && opcion < 6;
				if (verificacion == false) {
					System.out.println("Seleccione una opción válida por favor");
					scanner.nextLine();
				}
			}
			scanner.nextLine();
			
			switch(opcion) {
			
			case 1:
				crearEfemeride(scanner, efemerides);
				scanner.nextLine();
				break;
				
			case 2:
				if (efemerides.isEmpty()) {
					System.out.println("La lista está vacía");
				}else {
					for(Efemeride efe : efemerides) {
						System.out.println(efe);
					}
				}
				scanner.nextLine();
				break;
				
			case 3:
				if (efemerides.isEmpty()) {
					System.out.println("La lista está vacía");
				}else {
					System.out.println("Ingrese codigo de Efeméride: ");
					String codigo = scanner.nextLine();
					Efemeride eliminar = buscarCodigo(efemerides, codigo);
					if(eliminar != null) {
						efemerides.remove(eliminar);
						System.out.println("Efeméride eliminado");
					}else {
						System.out.println("El codigo proporcionado no pertenece a ningún Efeméride");
					}
					//scanner.nextLine();
				}
				scanner.nextLine();
				break;
				
			case 4:
				int eleccionModificar = 0;
				if (efemerides.isEmpty()) {
					System.out.println("La lista está vacía");
				}else {
					System.out.println("Ingrese codigo de Efeméride: ");
					String codigoMod = scanner.nextLine();
					Efemeride modificar = buscarCodigo(efemerides, codigoMod);
					if (modificar != null) {
						while(eleccionModificar <= 0 || eleccionModificar > 3) {
							eleccionModificar = menuModificar(scanner);
							if (eleccionModificar <= 0 || eleccionModificar > 3) {
								System.out.println("Elija una opción válida");
							}else {
								Modificar(scanner, modificar, eleccionModificar);
							}
						}
					}else {
						System.out.println("El codigo proporcionado no pertenece a ningún Efeméride");
					}
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
		int eleccion = 0;
		System.out.println("***MENÚ***");
		System.out.println("1-Crear Efeméride");
		System.out.println("2-Mostrar Efemérides");
		System.out.println("3-Eliminar Efeméride");
		System.out.println("4-Modificar Efeméride");
		System.out.println("5-Salir");
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

	public static void crearEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
		Mes[] meses = Mes.values();
		Mes eleccionMes = null;
		int mes = 0;
		short dia = (short) 0;
		Boolean aprobado = false;
		
		System.out.println("Ingrese Código de Efeméride: ");
		String codigo = scanner.nextLine();
		System.out.println("Ingrese detalle: ");
		String detalle = scanner.nextLine();
		while (aprobado == false) {
			try {
			System.out.println("Ingrese número de Mes: ");
			mes = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Ingrese día: ");
			dia = scanner.nextShort();
			aprobado = (mes > 0 && mes <= 12) && (dia > 0 && dia <= 31);
			if (aprobado == false)
				System.out.println("Datos erroneos para la fecha");
			}catch(Exception e) {
				System.out.println("Error en el ingreso de datos, intente otra vez");
				scanner.nextLine();
			}
		}
		if(aprobado == true) {
			for (Mes m : meses) {
	            if (m.ordinal() == mes - 1) {
	            	eleccionMes = m;
	            }
	        }
			Efemeride efemeride = new Efemeride(codigo, eleccionMes, dia, detalle);
			efemerides.add(efemeride);
		}
	}
	
	public static Efemeride buscarCodigo(ArrayList<Efemeride> efemerides, String codigo) {
		Efemeride encontrado = null;
		for(int i = 0; i < efemerides.size(); i++) {
			Efemeride efe = (Efemeride)efemerides.get(i);
			if (efe.getCodigo().equals(codigo)) {
				encontrado = efe;
			}
		}
		return encontrado;
	}
	
	public static int menuModificar(Scanner scanner) {
		int eleccion = 0;
		System.out.println("***Menú Modificar***");
		System.out.println("1-Modificar Detalle");
		System.out.println("2-Modificar Mes");
		System.out.println("3-Modificar Día");
		System.out.println("");
		try {
			System.out.println("¿Que opción elige?");
			eleccion = scanner.nextInt();
			scanner.nextLine();
			return eleccion;
		}catch(Exception e) {
			System.out.println("Error en el ingreso, vuelva a intentarlo");
			scanner.nextLine();
			return 0;
		}
	}
	
	public static void Modificar(Scanner scanner, Efemeride efemeride, int eleccion) {
		
		Boolean verifMes = false, verifDia = false;
		
		switch(eleccion) {
		
		case 1:
			System.out.println("Ingrese nuevo Detalle: ");
			String detalle = scanner.nextLine();
			efemeride.setDetalle(detalle);
			break;
		
		case 2:
			int mes = 0;
			while(verifMes == false){
				try {
					System.out.println("Ingrese nuevo Mes: ");
					mes = scanner.nextInt();
					scanner.nextLine();
					verifMes = mes > 0 && mes <= 12;
					if (verifMes == false)
						System.out.println("Error en elección del mes");
				}catch(Exception e) {
					System.out.println("Error en el ingreso, vuelva a intentarlo");
					scanner.nextLine();
				}
			}
			if (verifMes == true) {
				Mes[] meses = Mes.values();
				Mes eleccionMes = null;
				for (Mes m : meses) {
		            if (m.ordinal() == mes - 1) {
		            	eleccionMes = m;
		            }
		        }
				efemeride.setMes(eleccionMes);
			}
			break;
			
		case 3:
			short dia = (short) 0;
			while(verifDia == false) {
				try {
					System.out.println("Ingrese nuevo Día: ");
					dia = scanner.nextShort();
					scanner.nextLine();
					verifDia = dia > 0 && dia <= 31;
					if (verifDia == false)
						System.out.println("Error en elección del dia");
				}catch(Exception e) {
					System.out.println("Error en el ingreso, vuelva a intentarlo");
					scanner.nextLine();
				}
			}
			if (verifDia == true) {
				efemeride.setDia(dia);
			}
			break;
		}
	}

}
