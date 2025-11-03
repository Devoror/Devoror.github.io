package br.com.clinica.model;

public class Aluno extends Usuario {

    public Aluno(String nome, String email, String senhaHash) {
        super(nome, email, senhaHash);
    }

    // Polimorfismo: Implementação do método abstrato
    @Override
    public String getPapel() {
        return "Aluno (Estagiário)";
    }
}
