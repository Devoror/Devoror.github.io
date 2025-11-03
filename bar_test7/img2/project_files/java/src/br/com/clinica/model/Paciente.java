package br.com.clinica.model;

import java.util.UUID;
import java.util.Date;

public class Paciente {
    private UUID id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private String endereco;
    private String status; // CADASTRADO, EM_AVALIAÇÃO, EM_TRATAMENTO, ALTA, INATIVO
    private Date createdAt;
    private Date updatedAt;

    public Paciente(String nome, String cpf, Date dataNascimento, String telefone, String endereco) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.status = "CADASTRADO";
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Encapsulamento: Getters e Setters
    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = new Date();
    }

    // Outros getters e setters omitidos para brevidade

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", CPF: " + cpf + ", Status: " + status;
    }
}
