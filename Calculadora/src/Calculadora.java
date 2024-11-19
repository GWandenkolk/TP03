/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LOWCOST
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {
    private JTextField num1Field, num2Field, resultField;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Evita chamar métodos sobrescritos diretamente
        inicializarJanela();
    }

    // Método final para proteger o fluxo no construtor
    private final void inicializarJanela() {
        inicializarComponentes();
        setVisible(true);
    }

    // Método protegido que pode ser sobrescrito sem afetar o construtor
    protected void inicializarComponentes() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("Número 1:"));
        num1Field = new JTextField();
        inputPanel.add(num1Field);

        inputPanel.add(new JLabel("Número 2:"));
        num2Field = new JTextField();
        inputPanel.add(num2Field);

        inputPanel.add(new JLabel("Resultado:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        inputPanel.add(resultField);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton clearButton = new JButton("C");

        addButton.addActionListener(this::calcular);
        subButton.addActionListener(this::calcular);
        mulButton.addActionListener(this::calcular);
        divButton.addActionListener(this::calcular);
        clearButton.addActionListener(e -> limpar());

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void calcular(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            String command = ((JButton) e.getSource()).getText();

            switch (command) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) throw new ArithmeticException("Divisão por zero");
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalStateException("Operação desconhecida: " + command);
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira números válidos.");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void limpar() {
        num1Field.setText("");
        num2Field.setText("");
        resultField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}
