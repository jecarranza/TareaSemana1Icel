package CalculadoraDeOperacionesYConvertidorDeUnidades;

import java.util.Scanner;

public class Principal extends IngresoDeNumeros {
    protected static Scanner entrada = new Scanner(System.in);
    protected static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    Principal();
    }

    public static void Principal(){
        System.out.println("Bienvenido al sistema de operaciones \nElige con el numero 1 si quieres operaciones matematicas \nElige con el numero 2 si quieres conversiones de unidades");
        if (entrada.nextInt() == 1){
            System.out.println("Haz ingresado a la app de Calculadora \nIngresa la operacion a realizar \n1-. Suma \n2-. Resta \n3-. Multiplicacion \n4-. Division");
            System.err.println("Recuerda escribir el numero ´0´ para cuando termines de colocar los numeros de tus operaciones");
            double resultado = 0;
            switch (entrada.nextInt()){
                case 1:
                    System.out.println("Ingresa los numeros para hacer la suma que requieres");
                    new IngresoDeNumeros();
                    resultado = Suma(numeros);
                    break;
                case 2:
                    System.out.println("Ingresa los numeros para hacer la resta que requieres");
                    new IngresoDeNumeros();
                    resultado = Resta(numeros);
                    break;
                case 3:
                    System.out.println("Ingresa los numeros para hacer la multiplicacion que requieres");
                    new IngresoDeNumeros();
                    resultado = Multiplicacion(numeros);
                    break;
                case 4:
                    System.out.println("Ingresa los numeros para hacer la division que requieres");
                    new IngresoDeNumeros();
                    resultado = Division(numeros);
                    break;
                default:
                    System.out.println("Operacion no valida");
            }
            System.out.println("El resultado de la operacion es: " + resultado);

        } else if (entrada.nextInt() == 2) {
            System.out.println("Haz ingresado a la app de Convertidor de unidades \nIngresa la operacion a realizar \n1-. metros a centímetros \n2-. metros a pulgadas \n3-. kilogramos a libras \n4-. kilogramos a gramos \n5-. metros/segundo a kilómetros/hora.");
            System.err.println("Recuerda escribir el numero ´0´ para cuando termines de colocar los numeros de tus operaciones");
            double resultado = 0;
            switch (entrada.nextInt()){
                case 1:
                    System.out.println("Ingresa los metros para centimetros");
                    resultado = metrosACentimetros(scanner.nextDouble());
                    break;
                case 2:
                    System.out.println("Ingresa los metros para pulgadas");
                    resultado = metrosAPulgadas(scanner.nextDouble());
                    break;
                case 3:
                    System.out.println("Ingresa los kilogramos para libras");
                    resultado = kilogramosALibras(scanner.nextDouble());
                    break;
                case 4:
                    System.out.println("Ingresa los kilogramos para gramos");
                    resultado = kilogramosAgramos(scanner.nextDouble());
                    break;
                case 5:
                    System.out.println("Ingresa los metros/segundo para kilómetros/hora.");
                    resultado = metrosSobreSegundoAKilogramosSobreHora(scanner.nextDouble());
                default:
                    System.out.println("Operacion no valida");
            }
            System.out.println("El resultado de la conversion fue: " + resultado);
        }else {
            System.out.println("La opcion fue incorrecta");
        }
    }
}
