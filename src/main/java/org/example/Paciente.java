package org.example;

import java.util.Random;

public class Paciente implements Comparable<Paciente> {
    private String nome;
    private int idade;
    public boolean prioridade;
    public int senha;

    public Paciente (String nome, boolean condicao, int idade) {
        this.nome = nome;
        this.prioridade = condicao;
        this.idade = idade;
        gerarSenha();

    }

    public String getNome () {
        return this.nome;
    }

    public int getIdade () {
        return this.idade;
    }


    private void gerarSenha() {
        Random random = new Random();
        // Gera um número aleatório entre 1000000 e 9999999 (exatamente 7 dígitos)
        int senhaAleatoria = 1000000 + random.nextInt(9000000);
        setSenha(senhaAleatoria);
    }

    private void setSenha(int senha) {
        this.senha = senha;
    }

    public int getSenha() {
        return this.senha;
    }

    public boolean getPrioridade() {
        return this.prioridade;
    }

    @Override
    public int compareTo(Paciente o) {
        int status = 0;
        if (this.prioridade && !o.getPrioridade()) {
            status = -1;  // 'this' tem maior prioridade
        } else if (!this.prioridade && o.getPrioridade()) {
            status = 1;   // 'o' tem maior prioridade
        }
        return status;       // Ambos têm a mesma prioridade
    }

    public String toString () {
        return " [" + getNome() + " ," +  getSenha() + "]";
    }

}
