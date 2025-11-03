package br.com.clinica.service;

import br.com.clinica.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Aplicação do princípio Single Responsibility (S de SOLID) e Abstração
public class ClinicaService {
    // Simulação de banco de dados com Listas (Estruturas de dados dinâmicas)
    private List<Usuario> usuarios;
    private List<Paciente> pacientes;
    private List<Sessao> sessoes;
    private List<Evolucao> evolucoes;

    public ClinicaService() {
        this.usuarios = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.sessoes = new ArrayList<>();
        this.evolucoes = new ArrayList<>();
        // Usuários iniciais para teste
        usuarios.add(new Professor("Prof. Supervisor", "prof@clinica.com", "123"));
        usuarios.add(new Aluno("Aluno Estagiário", "aluno@clinica.com", "123"));
    }

    // --- Métodos de Usuário (UC03 Gerir Usuários) ---
    public Usuario autenticarUsuario(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.autenticar(senha)) {
                return u;
            }
        }
        return null;
    }

    // --- Métodos de Paciente (UC01 e UC02) ---
    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }

    // --- Métodos de Sessão (UC06) ---
    public Sessao criarSessao(Paciente paciente, Usuario aluno, String tipo) {
        Sessao novaSessao = new Sessao(paciente, aluno, new java.util.Date(), tipo);
        sessoes.add(novaSessao);
        // Atualiza o status do paciente (Diagrama de Estados)
        if (paciente.getStatus().equals("CADASTRADO")) {
            paciente.setStatus("EM_AVALIAÇÃO");
        }
        return novaSessao;
    }

    public Sessao buscarSessaoPorId(UUID id) {
        for (Sessao s : sessoes) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean registrarEvolucao(UUID sessaoId, String texto, Usuario autor) {
        Sessao sessao = buscarSessaoPorId(sessaoId);
        if (sessao != null) {
            // RN02: Evoluções devem referenciar sessão existente e usuário autor.
            Evolucao novaEvolucao = new Evolucao(sessao, texto, autor);
            evolucoes.add(novaEvolucao);
            return true;
        }
        return false;
    }

    public boolean assinarSessao(UUID sessaoId, Usuario professor) {
        Sessao sessao = buscarSessaoPorId(sessaoId);
        if (sessao != null && professor instanceof Professor) {
            // RN01: Sessão clínica só é válida quando assinada por Professor.
            return sessao.assinar(professor);
        }
        return false;
    }

    public List<Evolucao> listarEvolucoesPorSessao(UUID sessaoId) {
        List<Evolucao> lista = new ArrayList<>();
        for (Evolucao e : evolucoes) {
            if (e.getSessao().getId().equals(sessaoId)) {
                lista.add(e);
            }
        }
        return lista;
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
