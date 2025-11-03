package br.com.clinica.model;

public class Professor extends Usuario {

    public Professor(String nome, String email, String senhaHash) {
        super(nome, email, senhaHash);
    }

    // Polimorfismo: Implementação do método abstrato
    @Override
    public String getPapel() {
        return "Professor (Supervisor)";
    }
}
