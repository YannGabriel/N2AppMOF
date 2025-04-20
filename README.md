# MOF APP

O **MOF APP** (Mentor Organizador Facultativo) é um aplicativo Android criado para auxiliar estudantes na organização acadêmica, oferecendo uma IA mentora integrada.

## 📘 Visão Geral

O app permite ao usuário cadastrar-se, fazer login, gerenciar tarefas e receber auxílio de uma IA integrada. A estrutura base já está pronta e as próximas etapas envolvem integração com IA e funcionalidades avançadas de tarefas.

## 🛠 Tecnologias Utilizadas

- **Java** — Backend e lógica da aplicação.
- **XML** — Layouts e interface gráfica.
- **SQLite** — Banco de dados local.

## 👥 Equipe

- Yann
- Alan

## ✅ Funcionalidades já implementadas

- Banco de dados SQLite com tabela `usuarios`:
  - `id` (auto incremento, chave primária)
  - `email`, `username`, `tel`, `password`
- Classe `dataCriate.java` responsável por criar/atualizar o banco.
- Tela de login com verificação de credenciais.
- Banco de dados integrado à tela Home.
- Layouts XML prontos.

## 🚧 Funcionalidades a Desenvolver

### Conexão com a IA
- Criar uma aba específica para interação com o mentor virtual.

### Aba "Minhas Tarefas"
- Estrutura no banco:
  - `idUser`, `idTask` (auto incremento), `taskTitle`, `taskDetail`, `startDate`, `endDate`
- Botões para editar e excluir tarefas.

### Página de Criação de Tarefa
- Formulário com:
  - Nome da matéria
  - Nome do trabalho
  - Data de início e data final
- Botão para criar tarefa e inserir no banco.

### Configurações do Usuário
- Edição de dados
- Logout
- Outras configurações futuras

### Modal "Esqueceu a Senha"
- Recuperação de senha via email/telefone

---

Este documento serve como base para a continuação do desenvolvimento em equipe.
