package CalculadoraDeOperacionesYConvertidorDeUnidades;

import java.util.ArrayList;

public class CalculadoraDeNumeros extends ConvertidorDeUnidades {
    protected static double result;
    protected static ArrayList<Double> numeros = new ArrayList<>();

    protected static double Suma(ArrayList<Double> numeros) {
        result = 0;
        for (double num : numeros){
            result += num;
        }
        return result;
    }

    protected static double Resta(ArrayList<Double> numeros){
        result = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            result -= numeros.get(i);
        }
        return result;
    }

    protected static double Multiplicacion(ArrayList<Double> numeros){
        result = 1;
        for (double num : numeros){
            result *= num;
        }
        return result;
    }

    protected static double Division(ArrayList<Double> numeros){
        result = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) == 0){
                System.out.println("Error: No se puede dividir por cero.");
                return 0;
            }
            result /= numeros.get(i);
        }
        return result;
    }

}
