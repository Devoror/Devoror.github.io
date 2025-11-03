# Sistema de Gestão de Clínica-Escola de Fisioterapia

## 📋 Descrição do Projeto

Sistema desenvolvido para gerenciar o atendimento clínico em uma clínica-escola de fisioterapia, controlando pacientes, sessões terapêuticas e evoluções clínicas. A aplicação permite que administradores gerenciem usuários, professores supervisione e validem atendimentos, e alunos estagiários registrem sessões e evoluções dos pacientes.

**Disciplina:** Programação Orientada a Objetos / Análise e Projeto de Sistemas  
**Formato:** Trabalho em equipe - APS

---

## 🎯 Funcionalidades Principais

- ✅ Cadastro e gerenciamento de pacientes
- ✅ Controle de usuários com perfis diferenciados (ADMIN, PROFESSOR, ALUNO)
- ✅ Autenticação e autorização por perfil
- ✅ Registro de sessões de atendimento
- ✅ Registro de evoluções clínicas por sessão
- ✅ Validação de sessões por professores supervisores
- ✅ Consulta de histórico do paciente

---

## 🏗️ Arquitetura e Tecnologias

### Backend
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA** (persistência)
- **H2 Database** (banco de dados em memória para desenvolvimento)
- **Maven** (gerenciamento de dependências)

### Frontend
- **HTML5/CSS3/JavaScript** (interface web básica)

### Padrões e Conceitos Aplicados
- **REST API** (arquitetura de comunicação)
- **MVC** (Model-View-Controller)
- **DTO** (Data Transfer Objects)
- **Repository Pattern** (camada de dados)
- **Service Layer** (lógica de negócio)

---

## 🔧 Conceitos de POO Implementados

### 1. **Encapsulamento**
- Atributos privados nas classes de modelo (`Paciente`, `Usuario`, `Sessao`, `Evolucao`)
- Acesso controlado via getters e setters
- Proteção de dados sensíveis (senhaHash, informações pessoais)

**Exemplo:** Classe `Usuario` com atributos privados e métodos públicos de acesso

### 2. **Herança**
- Classe base `Usuario` com subclasses `Aluno` e `Professor`
- Reutilização de código comum (nome, email, senha, perfil)
- Especialização de comportamento em subclasses

**Exemplo:** `Aluno extends Usuario` e `Professor extends Usuario`

### 3. **Polimorfismo**
- Método `obterInformacoesCompletas()` sobrescrito em cada subclasse
- Tratamento uniforme de diferentes tipos de usuários
- Comportamentos específicos por tipo (aluno vs professor)

**Exemplo:** Mesmo método retorna informações diferentes para Aluno e Professor

### 4. **Abstração**
- Classes de modelo representam entidades do mundo real
- Controllers abstraem a comunicação HTTP
- Services abstraem a lógica de negócio
- Repositories abstraem o acesso ao banco de dados

---

## 📁 Estrutura do Projeto

```
clinica-api/
├── src/
│   ├── main/
│   │   ├── java/br/com/clinica/
│   │   │   ├── ClinicaApiApplication.java      # Classe principal
│   │   │   ├── config/
│   │   │   │   └── DataLoader.java             # Carga inicial de dados
│   │   │   ├── controller/                     # Camada de controle (REST)
│   │   │   │   ├── PacienteController.java
│   │   │   │   ├── SessaoController.java
│   │   │   │   └── UsuarioController.java
│   │   │   ├── dto/                            # Objetos de transferência
│   │   │   │   ├── AuthRequest.java
│   │   │   │   ├── EvolucaoRequest.java
│   │   │   │   ├── PacienteRequest.java
│   │   │   │   └── SessaoRequest.java
│   │   │   ├── model/                          # Camada de modelo (entidades)
│   │   │   │   ├── Aluno.java
│   │   │   │   ├── Evolucao.java
│   │   │   │   ├── Paciente.java
│   │   │   │   ├── Professor.java
│   │   │   │   ├── Sessao.java
│   │   │   │   └── Usuario.java
│   │   │   ├── repository/                     # Camada de persistência
│   │   │   │   ├── EvolucaoRepository.java
│   │   │   │   ├── PacienteRepository.java
│   │   │   │   ├── SessaoRepository.java
│   │   │   │   └── UsuarioRepository.java
│   │   │   └── service/                        # Lógica de negócio
│   │   │       └── ClinicaService.java
│   │   └── resources/
│   │       ├── application.properties          # Configurações
│   │       └── static/
│   │           └── index.html                  # Interface web
│   └── test/                                   # Testes (opcional)
├── pom.xml                                     # Dependências Maven
└── README.md
```

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **Java JDK 17** ou superior instalado
- **Maven 3.6+** instalado
- **IDE** (recomendado: IntelliJ IDEA, Eclipse ou VS Code com extensões Java)

### Passo 1: Verificar instalação do Java e Maven

```bash
java -version
mvn -version
```

### Passo 2: Clonar/Descompactar o projeto

```bash
# Se estiver em um repositório
git clone <url-do-repositorio>

# Ou descompactar o arquivo .zip
unzip clinica-api-final.zip
cd clinica-api-final
```

### Passo 3: Compilar o projeto

```bash
mvn clean install
```

### Passo 4: Executar a aplicação

```bash
mvn spring-boot:run
```

**OU** executar o arquivo JAR gerado:

```bash
java -jar target/clinica-api-0.0.1-SNAPSHOT.jar
```

### Passo 5: Acessar a aplicação

Abra o navegador e acesse:

```
http://localhost:8080
```

---

## 🗄️ Banco de Dados

O projeto utiliza **H2 Database** (banco em memória) para facilitar o desenvolvimento e testes.

### Console do H2

Para acessar o console do banco de dados:

```
http://localhost:8080/h2-console
```

**Credenciais de acesso:**
- JDBC URL: `jdbc:h2:mem:clinicadb`
- Username: `sa`
- Password: *(deixar em branco)*

---

## 👥 Dados de Teste (Pré-carregados)

O sistema já vem com dados de exemplo carregados automaticamente via `DataLoader.java`:

### Usuários

| Nome | Email | Senha | Perfil |
|------|-------|-------|--------|
| Admin Sistema | admin@clinica.com | admin123 | ADMIN |
| Prof. Carlos Silva | carlos@clinica.com | prof123 | PROFESSOR |
| Maria Santos | maria@clinica.com | aluno123 | ALUNO |

### Pacientes

- João da Silva (CPF: 123.456.789-00)
- Ana Oliveira (CPF: 987.654.321-00)

---

## 📡 Endpoints da API

### Autenticação

```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "admin@clinica.com",
  "password": "admin123"
}
```

### Pacientes

```http
GET    /api/pacientes              # Listar todos
GET    /api/pacientes/{id}         # Buscar por ID
POST   /api/pacientes              # Criar novo
PUT    /api/pacientes/{id}         # Atualizar
DELETE /api/pacientes/{id}         # Excluir
```

### Sessões

```http
GET    /api/sessoes                # Listar todas
GET    /api/sessoes/{id}           # Buscar por ID
POST   /api/sessoes                # Criar nova
PUT    /api/sessoes/{id}           # Atualizar
POST   /api/sessoes/{id}/assinar   # Professor assinar sessão
```

### Evoluções

```http
POST   /api/sessoes/{id}/evolucoes # Adicionar evolução a uma sessão
GET    /api/sessoes/{id}/evolucoes # Listar evoluções de uma sessão
```

### Usuários

```http
GET    /api/usuarios               # Listar todos
GET    /api/usuarios/{id}          # Buscar por ID
POST   /api/usuarios               # Criar novo
PUT    /api/usuarios/{id}          # Atualizar
```

---

## 🧪 Testando a Aplicação

### Teste 1: Login
1. Acesse `http://localhost:8080`
2. Use as credenciais: `admin@clinica.com` / `admin123`

### Teste 2: Cadastrar Paciente (via Postman/Insomnia)

```json
POST http://localhost:8080/api/pacientes
Content-Type: application/json

{
  "nome": "Pedro Costa",
  "cpf": "111.222.333-44",
  "dataNascimento": "1990-05-15",
  "telefone": "(11) 98765-4321",
  "endereco": "Rua das Flores, 123",
  "status": "ATIVO"
}
```

### Teste 3: Criar Sessão

```json
POST http://localhost:8080/api/sessoes
Content-Type: application/json

{
  "pacienteId": "ID_DO_PACIENTE",
  "professorId": "ID_DO_PROFESSOR",
  "alunoId": "ID_DO_ALUNO",
  "tipo": "AVALIACAO",
  "observacoes": "Primeira sessão de avaliação"
}
```

---

## 🎓 Mapeamento: Diagramas UML → Código

### Diagrama de Classes → Implementação

| Classe UML | Arquivo Java | Conceito POO |
|------------|--------------|--------------|
| Usuario | `model/Usuario.java` | Classe base (Herança) |
| Aluno | `model/Aluno.java` | Subclasse (Herança + Polimorfismo) |
| Professor | `model/Professor.java` | Subclasse (Herança + Polimorfismo) |
| Paciente | `model/Paciente.java` | Encapsulamento |
| Sessao | `model/Sessao.java` | Encapsulamento + Relacionamentos |
| Evolucao | `model/Evolucao.java` | Encapsulamento + Relacionamentos |

### Diagrama de Casos de Uso → Controllers

| Caso de Uso | Controller | Método |
|-------------|------------|--------|
| UC01 - Cadastrar Paciente | `PacienteController` | `criarPaciente()` |
| UC02 - Atualizar Paciente | `PacienteController` | `atualizarPaciente()` |
| UC04 - Autenticar | `UsuarioController` | `login()` |
| UC06 - Registrar Sessão | `SessaoController` | `criarSessao()` |
| UC06 - Adicionar Evolução | `SessaoController` | `adicionarEvolucao()` |

### Diagrama de Sequência → Fluxo de Execução

**Exemplo: Cadastro de Paciente**

```
1. Cliente HTTP → POST /api/pacientes
2. PacienteController.criarPaciente()
3. ClinicaService.salvarPaciente()
4. PacienteRepository.save()
5. Banco de Dados (H2)
6. Retorno → HTTP 201 Created
```

---

## 🛠️ Troubleshooting (Problemas Comuns)

### Erro: "Port 8080 already in use"

**Solução:** Altere a porta em `application.properties`:

```properties
server.port=8081
```

### Erro: "Could not find or load main class"

**Solução:** Recompile o projeto:

```bash
mvn clean install
```

### Erro: "Failed to configure a DataSource"

**Solução:** Verifique se as dependências do H2 estão no `pom.xml`

---

## 👨‍💻 Equipe de Desenvolvimento

- [Nome do Integrante 1]
- [Nome do Integrante 2]
- [Nome do Integrante 3]
- [Nome do Integrante 4]

---

## 📝 Documentação Adicional

- **Diagramas UML:** Pasta `/diagramas`
  - `use_case_diagram.png`
  - `class_diagram.png`
  - `sequence_diagram.png`
  - `activity_diagram.png`

- **Documento de Modelagem:** `Documentacao_APS.pdf`

---

## 📄 Licença

Projeto acadêmico desenvolvido para a disciplina de Programação Orientada a Objetos.

---

## 📞 Contato

Para dúvidas ou sugestões:
- Email: [seu-email@exemplo.com]
- Professor: Prof. Abraão Henrique

---

**Data de Entrega:** [Inserir data]  
**Instituição:** [Nome da Instituição]  
**Curso:** [Nome do Curso]
