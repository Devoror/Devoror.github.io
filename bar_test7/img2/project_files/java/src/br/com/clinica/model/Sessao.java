package br.com.clinica.model;

import java.util.Date;
import java.util.UUID;

public class Sessao {
    private UUID id;
    private Paciente paciente;
    private Usuario alunoResponsavel;
    private Usuario professorSupervisor;
    private Date dataHora;
    private String tipo; // avaliação, manutenção, alta...
    private String observacoes;
    private boolean assinadaPorProfessor;

    public Sessao(Paciente paciente, Usuario alunoResponsavel, Date dataHora, String tipo) {
        this.id = UUID.randomUUID();
        this.paciente = paciente;
        this.alunoResponsavel = alunoResponsavel;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.observacoes = "";
        this.assinadaPorProfessor = false;
    }

    // Encapsulamento: Getters e Setters
    public UUID getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Usuario getAlunoResponsavel() {
        return alunoResponsavel;
    }

    public boolean isAssinadaPorProfessor() {
        return assinadaPorProfessor;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // Método para assinar a sessão (Regra de Negócio RN01)
    public boolean assinar(Usuario professor) {
        if (professor instanceof Professor) {
            this.professorSupervisor = professor;
            this.assinadaPorProfessor = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Sessão ID: " + id + ", Paciente: " + paciente.getNome() + ", Data: " + dataHora + ", Assinada: " + assinadaPorProfessor;
    }
}
