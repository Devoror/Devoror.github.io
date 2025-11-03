# Trabalho Integrador - Modelagem e Desenvolvimento de Sistema Orientado a Objetos

## 1. Introdução

Este documento apresenta a solução completa para o **Trabalho Integrador - Modelagem e Desenvolvimento de Sistema Orientado a Objetos**, conforme o modelo fornecido. O sistema proposto é um **Sistema de Gestão Clínica (CMS)**, focado no gerenciamento de pacientes, sessões de atendimento e evoluções em um ambiente de clínica universitária, envolvendo Alunos (Estagiários) e Professores (Supervisores).

### 1.1. Objetivo Geral do Sistema

O objetivo principal é fornecer uma plataforma que digitalize e organize o fluxo de trabalho da clínica, garantindo a aplicação dos princípios de Programação Orientada a Objetos (POO) e aderência às regras de negócio, como a validação de sessões por um supervisor (Professor).

### 1.2. Escopo Funcional (Síntese)

O sistema abrange os seguintes domínios e funcionalidades principais:
*   **Domínios:** Pacientes, Usuários (Professor, Aluno), Sessões, Evoluções.
*   **Funcionalidades:** Autenticação, Cadastro de Pacientes, Criação de Sessões, Registro de Evoluções e Assinatura de Sessões.

---

## 2. Modelagem UML (Etapa 1)

A modelagem foi realizada utilizando os diagramas UML solicitados, com base nas entidades e casos de uso definidos no anexo do documento base.

### 2.1. Diagrama de Casos de Uso

O Diagrama de Casos de Uso ilustra as interações entre os atores (Administrador, Professor, Aluno e Paciente) e as funcionalidades do sistema.

![Diagrama de Casos de Uso](uml/img/use_case_diagram.png)

**Descrição:** O diagrama mostra que o **Aluno (Estagiário)** é o principal usuário operacional, responsável pelo cadastro de pacientes e registro de sessões. O **Professor (Supervisor)** atua na validação e supervisão das sessões. O **Administrador** gerencia o sistema, e o **Paciente** interage minimamente (ex: consentimento). Todos os casos de uso dependem da autenticação (`<<include>> UC04`).

### 2.2. Diagrama de Classes

O Diagrama de Classes define a estrutura estática do sistema, suas classes, atributos, métodos e relacionamentos, aplicando os conceitos de **Encapsulamento** e **Herança**.

![Diagrama de Classes](uml/img/class_diagram.png)

**Destaques da POO:**
*   **Herança:** As classes `Professor` e `Aluno` herdam da classe abstrata `Usuario`.
*   **Encapsulamento:** Atributos são privados e acessados via métodos *getters* e *setters*.
*   **Polimorfismo:** O método `getPapel()` na classe `Usuario` é abstrato e implementado de forma diferente em `Professor` e `Aluno`.

### 2.3. Diagrama de Sequência (Registro de Sessão/Evolução)

Este diagrama detalha o fluxo de mensagens para o cenário crítico de registro de uma sessão e sua posterior validação.

![Diagrama de Sequência](uml/img/sequence_diagram.png)

**Fluxo:** O Aluno inicia o processo, o sistema registra a `Evolucao` e, posteriormente, o Professor realiza a assinatura, que é uma regra de negócio crucial (RN01).

### 2.4. Diagrama de Atividades (Fluxo de Atendimento)

O diagrama de atividades mapeia o processo de atendimento clínico, desde o cadastro do paciente até a alta/encaminhamento.

![Diagrama de Atividades](uml/img/activity_diagram.png)

**Destaque:** O diagrama ilustra a decisão de "Consentimento disponível?" e o ciclo de repetição para "Sessões recorrentes?", demonstrando o fluxo de controle do sistema.

---

## 3. Implementação em Java (Etapa 2)

O sistema foi implementado em Java, seguindo a modelagem UML e aplicando os princípios de POO e SOLID.

### 3.1. Aplicação dos Conceitos de POO

| Conceito | Aplicação no Código |
| :--- | :--- |
| **Encapsulamento** | Todos os atributos das classes (`Paciente`, `Sessao`, `Usuario`, etc.) são `private` e acessados por métodos `public` (getters/setters). Ex: `Usuario.senhaHash` é interno. |
| **Abstração** | A classe `Usuario` é `abstract`, definindo um contrato (`getPapel()`) sem fornecer a implementação completa, focando apenas na essência de um usuário do sistema. |
| **Herança** | As classes `Professor` e `Aluno` estendem a classe `Usuario`, herdando atributos e métodos comuns (ex: `autenticar()`). |
| **Polimorfismo** | O método `getPapel()` é sobrescrito em `Professor` e `Aluno`, retornando o papel específico de cada um, mas sendo chamado de forma uniforme no `Main`. |

### 3.2. Estruturas de Dados e Funcionalidades

A classe `ClinicaService` atua como o *Service Layer*, gerenciando as operações e simulando o armazenamento de dados através de **Listas Dinâmicas** (`ArrayList`) para `usuarios`, `pacientes`, `sessoes` e `evolucoes`.

**Funcionalidades Mínimas Implementadas:**
*   **Cadastro:** `ClinicaService.cadastrarPaciente()`.
*   **Busca/Listagem:** `ClinicaService.listarPacientes()`, `ClinicaService.buscarPacientePorCpf()`.
*   **Regras de Negócio:** `Sessao.assinar()` (RN01) e `ClinicaService.registrarEvolucao()` (RN02).

### 3.3. Demonstração (Saída do Programa)

O código-fonte está contido na pasta `project_files/java`. A execução do arquivo `Main.java` demonstra o fluxo de trabalho:

\`\`\`
--- Sistema de Gestão Clínica (MVP) ---

--- Autenticação de Teste ---
Aluno Logado: Aluno Estagiário (Aluno (Estagiário))
Professor Logado: Prof. Supervisor (Professor (Supervisor))

--- Cadastro de Paciente ---
Paciente cadastrado com sucesso: Maria da Silva

--- Criação de Sessão ---
Sessão criada: Sessão ID: [UUID], Paciente: Maria da Silva, Data: [Data/Hora], Assinada: false
Status do Paciente atualizado para: EM_AVALIAÇÃO

--- Registro de Evolução ---
Evolução registrada.

--- Histórico de Evoluções ---
- Paciente demonstrou boa comunicação inicial. (por Aluno Estagiário)

--- Assinatura de Sessão (Professor) ---
Sessão assinada pelo Professor: true
Status da Sessão: ASSINADA

--- Demonstração de Polimorfismo ---
Prof. Supervisor tem o papel de: Professor (Supervisor)
Aluno Estagiário tem o papel de: Aluno (Estagiário)
\`\`\`

---

## 4. Conclusão

O projeto atende a todos os requisitos do Trabalho Integrador, fornecendo:
1.  **Modelagem Completa:** Diagramas de Casos de Uso, Classes, Sequência e Atividades.
2.  **Implementação Funcional (MVP):** Código Java que aplica Herança, Polimorfismo, Encapsulamento e Abstração.
3.  **Aderência às Regras de Negócio:** A validação da sessão pelo Professor é implementada e demonstrada.

O sistema está pronto para ser apresentado, demonstrando a integração entre a modelagem teórica (UML) e a implementação prática (Java).

---

## 5. Referências

*   **Código-Fonte Java:** Arquivos em \`project_files/java/\`
*   **Diagramas UML:** Imagens em \`project_files/uml/img/\`
*   **Requisitos do Projeto:** Documento \`pasted_content.txt\`
