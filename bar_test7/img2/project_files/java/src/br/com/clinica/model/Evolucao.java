package br.com.clinica.model;

import java.util.Date;
import java.util.UUID;

public class Evolucao {
    private UUID id;
    private Sessao sessao;
    private Date dataHora;
    private String texto;
    private Usuario criadoPor;

    public Evolucao(Sessao sessao, String texto, Usuario criadoPor) {
        this.id = UUID.randomUUID();
        this.sessao = sessao;
        this.dataHora = new Date();
        this.texto = texto;
        this.criadoPor = criadoPor;
    }

    // Encapsulamento: Getters
    public UUID getId() {
        return id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getCriadoPor() {
        return criadoPor;
    }

    @Override
    public String toString() {
        return "Evolução ID: " + id + ", Data: " + dataHora + ", Autor: " + criadoPor.getNome();
    }
}
