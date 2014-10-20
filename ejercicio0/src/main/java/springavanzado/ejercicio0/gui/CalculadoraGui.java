package springavanzado.ejercicio0.gui;

import java.util.Scanner;

import springavanzado.ejercicio0.service.Calculadora;

public class CalculadoraGui {
	private Calculadora calculadora;
	private Scanner scanner;
	
	public CalculadoraGui() {
		this.scanner = new Scanner(System.in);
	}

	public void iniciar() {
		while (true) {
			System.out.println();
			System.out.println("1. Sumar");
			System.out.println("2. Restar");
			System.out.println("3. Multiplicar");
			System.out.println("4. Dividir");
			System.out.println("5. Salir");
			System.out.print("?");
			String opcion = scanner.nextLine();
			
			if (opcion.equals("5"))
				break;
			else if (opcion.equals("1") || opcion.equals("2") ||
					opcion.equals("3") || opcion.equals("4")) {

				System.out.print("a? ");
				float a = Float.parseFloat(scanner.nextLine());
				System.out.print("b? ");
				float b = Float.parseFloat(scanner.nextLine());
				
				if (opcion.equals("1"))
					System.out.println(a + " + " + b + " = " + calculadora.sumar(a, b));
				else if (opcion.equals("2"))
					System.out.println(a + " - " + b + " = " + calculadora.restar(a, b));
				else if (opcion.equals("3"))
					System.out.println(a + " * " + b + " = " + calculadora.multiplicar(a, b));
				else 
					System.out.println(a + " / " + b + " = " + calculadora.dividir(a, b));
			}
		}
	}
	
	public void setCalculadora(Calculadora calculadora) {
		this.calculadora = calculadora;
	}
}
