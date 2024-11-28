package CalculadoraDeOperacionesYConvertidorDeUnidades;


public class ConvertidorDeUnidades {
  protected static double result;

  protected static Double metrosACentimetros(double num1){
      result = num1 * 100;
      return result;
  }

  protected static Double metrosAPulgadas(double num1){
      result = num1 * 39.3701;
      return result;
  }

  protected static Double kilogramosALibras(double num1){
      result = num1 * 2.20462;
      return result;
  }

  protected static Double kilogramosAgramos(double num1){
      result = num1 * 1000;
      return result;
  }

  protected static Double metrosSobreSegundoAKilogramosSobreHora(double num1){
      result = num1 * 3.6;
      return result;
  }
}
