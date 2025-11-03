package br.com.clinica.main;

import br.com.clinica.model.*;
import br.com.clinica.service.ClinicaService;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ClinicaService service = new ClinicaService();

        System.out.println("--- Sistema de Gestão Clínica (MVP) ---");

        // 1. Autenticação (UC04)
        Usuario alunoLogado = service.autenticarUsuario("aluno@clinica.com", "123");
        Usuario professorLogado = service.autenticarUsuario("prof@clinica.com", "123");

        if (alunoLogado != null && professorLogado != null) {
            System.out.println("\n--- Autenticação de Teste ---");
            System.out.println("Aluno Logado: " + alunoLogado.getNome() + " (" + alunoLogado.getPapel() + ")");
            System.out.println("Professor Logado: " + professorLogado.getNome() + " (" + professorLogado.getPapel() + ")");

            // 2. Cadastro de Paciente (UC01)
            System.out.println("\n--- Cadastro de Paciente ---");
            Paciente novoPaciente = new Paciente(
                "Maria da Silva",
                "123.456.789-00",
                new Date(), // Data de Nascimento
                "(11) 98765-4321",
                "Rua Exemplo, 123"
            );
            service.cadastrarPaciente(novoPaciente);
            System.out.println("Paciente cadastrado com sucesso: " + novoPaciente.getNome());

            // 3. Criação de Sessão (UC06)
            System.out.println("\n--- Criação de Sessão ---");
            Sessao sessao = service.criarSessao(novoPaciente, alunoLogado, "Avaliação Inicial");
            System.out.println("Sessão criada: " + sessao);
            System.out.println("Status do Paciente atualizado para: " + novoPaciente.getStatus());

            // 4. Registro de Evolução (UC06)
            System.out.println("\n--- Registro de Evolução ---");
            service.registrarEvolucao(sessao.getId(), "Paciente demonstrou boa comunicação inicial.", alunoLogado);
            System.out.println("Evolução registrada.");

            // 5. Listagem de Evoluções (UC09)
            System.out.println("\n--- Histórico de Evoluções ---");
            for (Evolucao e : service.listarEvolucoesPorSessao(sessao.getId())) {
                System.out.println("- " + e.getTexto() + " (por " + e.getCriadoPor().getNome() + ")");
            }

            // 6. Assinatura da Sessão (RN01)
            System.out.println("\n--- Assinatura de Sessão (Professor) ---");
            boolean assinado = sessao.assinar(professorLogado);
            System.out.println("Sessão assinada pelo Professor: " + assinado);
            System.out.println("Status da Sessão: " + (sessao.isAssinadaPorProfessor() ? "ASSINADA" : "NÃO ASSINADA"));

            // 7. Demonstração de Polimorfismo
            System.out.println("\n--- Demonstração de Polimorfismo ---");
            for (Usuario u : service.getUsuarios()) {
                System.out.println(u.getNome() + " tem o papel de: " + u.getPapel());
            }
        } else {
            System.out.println("Erro: Falha na autenticação inicial dos usuários de teste.");
        }
    }
}
