package br.com.clinica.model;

import java.util.UUID;

public abstract class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private String senhaHash;
    private boolean ativo;

    public Usuario(String nome, String email, String senhaHash) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.ativo = true;
    }

    // Encapsulamento: Getters e Setters
    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    // Abstração e Polimorfismo: Método abstrato para definir o papel
    public abstract String getPapel();

    // Método para simular autenticação
    public boolean autenticar(String senha) {
        // Simulação de autenticação (em um sistema real, usaria um algoritmo de hash)
        return this.senhaHash.equals(senha);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Email: " + email + ", Papel: " + getPapel();
    }
}
