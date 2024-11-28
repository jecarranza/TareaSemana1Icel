package CalculadoraDeOperacionesYConvertidorDeUnidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Principal extends JFrame {
    private JPanel panelPrincipal;
    private JTextField inputField;
    private JTextArea resultArea;
    private JComboBox<String> comboBoxOperaciones;
    private JButton calcularButton, limpiarButton;

    public Principal() {
        // Configuración del JFrame
        setTitle("Calculadora y Convertidor de Unidades");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Panel principal
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(6, 1));

        // Entrada de números
        JLabel inputLabel = new JLabel("Ingresa los números separados por comas:");
        inputField = new JTextField();
        panelPrincipal.add(inputLabel);
        panelPrincipal.add(inputField);

        // ComboBox para seleccionar operaciones
        JLabel comboBoxLabel = new JLabel("Selecciona una operación:");
        String[] operaciones = {
                "Suma", "Resta", "Multiplicación", "División",
                "Metros a Centímetros", "Metros a Pulgadas",
                "Kilogramos a Libras", "Kilogramos a Gramos",
                "Metros/s a Km/h"
        };
        comboBoxOperaciones = new JComboBox<>(operaciones);
        panelPrincipal.add(comboBoxLabel);
        panelPrincipal.add(comboBoxOperaciones);

        // Botones
        calcularButton = new JButton("Calcular");
        limpiarButton = new JButton("Limpiar");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calcularButton);
        buttonPanel.add(limpiarButton);
        panelPrincipal.add(buttonPanel);

        // Área de resultados
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panelPrincipal.add(scrollPane);

        // Agregar panel al JFrame
        add(panelPrincipal, BorderLayout.CENTER);

        // Listeners para los botones
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion();
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void calcularOperacion() {
        String input = inputField.getText();
        if (input.isEmpty()) {
            resultArea.setText("Por favor, ingresa valores válidos.");
            return;
        }

        String[] valores = input.split(",");
        try {
            // Convertimos los valores a números
            double[] numeros = new double[valores.length];
            for (int i = 0; i < valores.length; i++) {
                numeros[i] = Double.parseDouble(valores[i]);
            }

            // Obtenemos la operación seleccionada
            String operacion = (String) comboBoxOperaciones.getSelectedItem();
            double resultado = 0;

            // Lógica según la operación
            switch (operacion) {
                case "Suma":
                    resultado = CalculadoraDeNumeros.Suma(arrayToArrayList(numeros));
                    break;
                case "Resta":
                    resultado = CalculadoraDeNumeros.Resta(arrayToArrayList(numeros));
                    break;
                case "Multiplicación":
                    resultado = CalculadoraDeNumeros.Multiplicacion(arrayToArrayList(numeros));
                    break;
                case "División":
                    resultado = CalculadoraDeNumeros.Division(arrayToArrayList(numeros));
                    break;
                case "Metros a Centímetros":
                    resultado = ConvertidorDeUnidades.metrosACentimetros(numeros[0]);
                    break;
                case "Metros a Pulgadas":
                    resultado = ConvertidorDeUnidades.metrosAPulgadas(numeros[0]);
                    break;
                case "Kilogramos a Libras":
                    resultado = ConvertidorDeUnidades.kilogramosALibras(numeros[0]);
                    break;
                case "Kilogramos a Gramos":
                    resultado = ConvertidorDeUnidades.kilogramosAgramos(numeros[0]);
                    break;
                case "Metros/s a Km/h":
                    resultado = ConvertidorDeUnidades.metrosSobreSegundoAKilogramosSobreHora(numeros[0]);
                    break;
                default:
                    resultArea.setText("Operación no válida.");
                    return;
            }

            // Mostrar el resultado
            resultArea.setText("Resultado: " + resultado);

        } catch (NumberFormatException ex) {
            resultArea.setText("Error: Por favor ingresa valores numéricos separados por comas.");
        }
    }

    private void limpiarCampos() {
        inputField.setText("");
        resultArea.setText("");
    }

    private ArrayList<Double> arrayToArrayList(double[] array) {
        ArrayList<Double> list = new ArrayList<>();
        for (double val : array) {
            list.add(val);
        }
        return list;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Principal app = new Principal();
            app.setVisible(true);
        });
    }
}
