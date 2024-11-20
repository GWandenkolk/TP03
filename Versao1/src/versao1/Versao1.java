/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package versao1;

/**
 *
 * @author LOWCOST
 */
public class Versao1 {

    private static int kp = 0; // Contador de instâncias
    private final int numero; // Número único para cada pessoa
    private String nome;
    private char sexo;
    private int idade;

    public Versao1(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.numero = ++kp; // Incrementa o contador e atribui o número único
    }

    public static int getKp() {
        return kp;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }
}
