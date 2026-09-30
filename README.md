# DevShowcase API

API REST desenvolvida com Java e Spring Boot para gerenciamento de perfis de desenvolvedores, projetos, tecnologias e feedbacks.

O projeto foi desenvolvido como atividade prática de desenvolvimento backend, utilizando persistência de dados com Spring Data JPA e banco de dados H2.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Jakarta Validation
- Maven
- H2 Database
- Git e GitHub
- Postman

## Entidades

O sistema possui quatro entidades principais:

### Profile

Representa o perfil de um desenvolvedor.

Principais atributos:

- id
- name
- email
- bio
- githubUrl
- linkedinUrl

### Project

Representa um projeto desenvolvido e associado a um perfil.

Principais atributos:

- id
- title
- description
- repositoryUrl
- demoUrl

### Technology

Representa uma tecnologia utilizada nos projetos.

Principais atributos:

- id
- name

### Feedback

Representa um feedback associado a um projeto.

Principais atributos:

- id
- author
- comment

## Relacionamentos

As entidades possuem os seguintes relacionamentos:

```text
Profile 1:N Project

Project N:N Technology

Project 1:N Feedback
```

Um perfil pode possuir vários projetos.

Um projeto pode utilizar várias tecnologias e uma tecnologia pode estar associada a vários projetos.

Um projeto também pode possuir vários feedbacks.

## Endpoints

### Profiles

Cadastrar um perfil:

```http
POST /api/profiles
```

Buscar perfil pelo ID:

```http
GET /api/profiles/{id}
```

### Technologies

Cadastrar uma tecnologia:

```http
POST /api/technologies
```

Listar tecnologias:

```http
GET /api/technologies
```

### Projects

Cadastrar um projeto:

```http
POST /api/projects
```

Listar projetos:

```http
GET /api/projects
```

## Exemplos de requisições

### Cadastrar Profile

```json
{
  "name": "Nome do Desenvolvedor",
  "email": "desenvolvedor@email.com",
  "bio": "Estudante de Sistemas para Internet",
  "githubUrl": "https://github.com/usuario",
  "linkedinUrl": "https://linkedin.com/in/usuario"
}
```

### Cadastrar Technology

```json
{
  "name": "Java"
}
```

### Cadastrar Project

```json
{
  "title": "P2 Conecta",
  "description": "Portal web para divulgação turística e de serviços",
  "repositoryUrl": "https://github.com/usuario/p2-conecta",
  "demoUrl": "https://exemplo.com",
  "profileId": 1,
  "technologyIds": [1, 2]
}
```

## Validação

Os dados recebidos pela API são validados por meio do Jakarta Validation.

Entre as validações utilizadas estão:

- `@NotBlank` para campos obrigatórios;
- `@NotNull` para referências obrigatórias;
- `@Email` para validação de e-mail;
- `@Pattern` para validação básica das URLs.

## Banco de dados

Durante o desenvolvimento foi utilizado o banco H2 em memória.

Configuração principal:

```properties
spring.datasource.url=jdbc:h2:mem:devshowcase
```

O console do H2 pode ser acessado durante a execução da aplicação em:

```text
http://localhost:8081/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:devshowcase
```

Usuário:

```text
sa
```

A senha permanece em branco.

## Como executar

1. Clone o repositório.
2. Abra o projeto em uma IDE compatível com Spring Boot.
3. Aguarde o Maven baixar as dependências.
4. Execute a classe `DevshowcaseApplication`.
5. A API ficará disponível em:

```text
http://localhost:8081
```

## Testes da API

Os endpoints foram testados utilizando Postman.

Resultados esperados:

- `POST /api/profiles` → `201 Created`
- `GET /api/profiles/{id}` → `200 OK`
- `POST /api/technologies` → `201 Created`
- `GET /api/technologies` → `200 OK`
- `POST /api/projects` → `201 Created`
- `GET /api/projects` → `200 OK`

## Estrutura do projeto

```text
src/main/java/br/com/gilaguiar/devshowcase
│
├── controller
├── dto
├── entity
├── repository
├── service
└── DevshowcaseApplication.java
```

A organização em camadas separa as responsabilidades da aplicação entre controllers, DTOs, entidades, repositories e services.

## Autor

Gildevan de Aguiar Rego

Projeto acadêmico desenvolvido no curso de Tecnologia em Sistemas para Internet.