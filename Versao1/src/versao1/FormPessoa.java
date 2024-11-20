/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package versao1;

package pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FormPessoa extends JFrame {
    private JTextField numeroField, nomeField, idadeField, sexoField;
    private Versao1 umaPessoa;

    public FormPessoa() {
        // Configuração da janela
        setTitle("Formulário Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        inputPanel.add(new JLabel("Número:"));
        numeroField = new JTextField();
        numeroField.setEditable(false); // Campo não editável
        inputPanel.add(numeroField);

        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        inputPanel.add(idadeField);

        inputPanel.add(new JLabel("Sexo (M/F):"));
        sexoField = new JTextField();
        inputPanel.add(sexoField);

        add(inputPanel, BorderLayout.CENTER);

        // Painel para botões
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");
        JButton showButton = new JButton("Mostrar");

        okButton.addActionListener(this::salvarPessoa);
        showButton.addActionListener(this::mostrarPessoa);

        buttonPanel.add(okButton);
        buttonPanel.add(showButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Tornando visível
        setVisible(true);
    }

    private void salvarPessoa(ActionEvent e) {
        try {
            String nome = nomeField.getText();
            String sexoInput = sexoField.getText().toUpperCase(); // Aceita "m" ou "f" em minúsculas
            if (!(sexoInput.equals("M") || sexoInput.equals("F"))) {
                throw new IllegalArgumentException("Sexo deve ser 'M' ou 'F'.");
            }
            char sexo = sexoInput.charAt(0);

            int idade = Integer.parseInt(idadeField.getText());

            if (nome.isEmpty()) throw new IllegalArgumentException("O nome não pode ser vazio.");
            umaPessoa = new Versao1(nome, sexo, idade);

            // Atualiza o campo "Número" com o valor único da pessoa criada
            numeroField.setText(String.valueOf(umaPessoa.getNumero()));

            JOptionPane.showMessageDialog(this, "Pessoa salva com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade deve ser um número.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void mostrarPessoa(ActionEvent e) {
        if (umaPessoa != null) {
            JOptionPane.showMessageDialog(this,
                    "Número: " + umaPessoa.getNumero() +
                    "\nNome: " + umaPessoa.getNome() +
                    "\nSexo: " + umaPessoa.getSexo() +
                    "\nIdade: " + umaPessoa.getIdade() +
                    "\nContador (kp): " + Versao1.getKp());
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma pessoa cadastrada.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormPessoa::new);
    }
}
