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

/**
 * A classe Pessoa representa uma pessoa com nome, sexo e idade.
 * A classe também mantém um contador estático que incrementa a cada instância criada.
 */

public class FormPessoa extends JFrame {
    private JTextField nomeField, idadeField;
    private JComboBox<String> sexoComboBox;
    private Pessoa umaPessoa;

    /**
     * Construtor da classe FormPessoa que configura a interface gráfica.
     */
    public FormPessoa() {
        // Configuração da janela
        setTitle("Formulário Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        inputPanel.add(idadeField);

        inputPanel.add(new JLabel("Sexo:"));
        sexoComboBox = new JComboBox<>(new String[]{"M", "F"});
        inputPanel.add(sexoComboBox);

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

    /**
     * Método que salva os dados da pessoa a partir dos campos da interface.
     * Exibe uma mensagem de sucesso ou erro.
     */
    private void salvarPessoa(ActionEvent e) {
        try {
            String nome = nomeField.getText();
            char sexo = sexoComboBox.getSelectedItem().toString().charAt(0);
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

    /**
     * Método que exibe as informações da pessoa cadastrada.
     * Se não houver pessoa cadastrada, exibe uma mensagem de erro.
     */
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

    /**
     * Método principal para executar o formulário.
     * Inicializa a interface gráfica.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormPessoa::new);
    }
}
