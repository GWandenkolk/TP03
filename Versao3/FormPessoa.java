/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pessoa;

/**
 *
 * @author LOWCOST
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FormPessoa extends JFrame {
    private JTextField nomeField, idadeField;
    private JRadioButton masculinoButton, femininoButton;
    private Pessoa umaPessoa;

    public FormPessoa() {
        // Configuração da janela
        setTitle("Formulário Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        inputPanel.add(idadeField);

        inputPanel.add(new JLabel("Sexo:"));
        masculinoButton = new JRadioButton("M");
        femininoButton = new JRadioButton("F");

        // Grupo de botões para garantir que apenas um pode ser selecionado
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(masculinoButton);
        sexoGroup.add(femininoButton);

        // Painel para os botões de sexo
        JPanel sexoPanel = new JPanel(new FlowLayout());
        sexoPanel.add(masculinoButton);
        sexoPanel.add(femininoButton);

        inputPanel.add(sexoPanel);
        add(inputPanel, BorderLayout.CENTER);

        // Painel para botões de ação
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
            char sexo;
            if (masculinoButton.isSelected()) {
                sexo = 'M';
            } else if (femininoButton.isSelected()) {
                sexo = 'F';
            } else {
                throw new IllegalArgumentException("Selecione o sexo.");
            }

            int idade = Integer.parseInt(idadeField.getText());

            if (nome.isEmpty()) throw new IllegalArgumentException("O nome não pode ser vazio.");
            umaPessoa = new Pessoa(nome, sexo, idade);

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
                    "Nome: " + umaPessoa.getNome() +
                    "\nSexo: " + umaPessoa.getSexo() +
                    "\nIdade: " + umaPessoa.getIdade() +
                    "\nContador: " + Pessoa.getKp());
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma pessoa cadastrada.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormPessoa::new);
    }
}
