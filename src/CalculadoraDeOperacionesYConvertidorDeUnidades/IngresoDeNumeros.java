package CalculadoraDeOperacionesYConvertidorDeUnidades;

import java.util.Scanner;

public class IngresoDeNumeros extends CalculadoraDeNumeros {
    Scanner scanner = new Scanner(System.in);
    protected static final String FIN = "fin";

    protected IngresoDeNumeros() {
        while (true) {
            try {
                System.out.print("Ingresa un número (o escribe 'fin' para salir): ");
                String entrada = scanner.next();

                if (entrada.equalsIgnoreCase(FIN)) {
                    System.out.println("Fin del ingreso de números.");
                    break;
                }

                double num = Double.parseDouble(entrada);
                numeros.add(num);

            } catch (NumberFormatException e) {
                System.err.println("Por favor ingresa un valor válido.");
            }
        }
    }
}
