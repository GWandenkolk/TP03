/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pessoa;

/**
 *
 * @author LOWCOST
 */
public class Pessoa {

    /**
     * @param args the command line arguments
     */
    
    private static int kp = 0;
    private String nome;
    private char sexo;
    private int idade;

    /**
     * Construtor para inicializar uma nova pessoa.
     * 
     * @param nome  O nome da pessoa.
     * @param sexo  O sexo da pessoa (M ou F).
     * @param idade A idade da pessoa.
     */
    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;
    }

    /**
     * Retorna o valor do contador de instâncias.
     * 
     * @return O contador de instâncias de Pessoa.
     */
    public static int getKp() {
        return kp;
    }

    /**
     * Retorna o nome da pessoa.
     * 
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o sexo da pessoa.
     * 
     * @return O sexo da pessoa.
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Retorna a idade da pessoa.
     * 
     * @return A idade da pessoa.
     */
    public int getIdade() {
        return idade;
    }
}
