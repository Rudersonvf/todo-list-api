# Projeto To Do List

Este é um projeto simples de To Do List utilizando Java e Spring Boot. A aplicação oferece funcionalidades para criar,
listar, editar e excluir tarefas, com persistência de dados usando H2 Database para desenvolvimento e PostgreSQL para
produção. Conta com suporte básico a CORS para integração com frontends. A segurança é gerenciada com Spring Security,
e a autenticação é feita por OAuth2. Consulte o arquivo README no link abaixo para mais informações e 
instruções de execução.

## Requerimentos

- JDK 21
- Spring Boot 3.4.1
- Maven 3.8+

## Estrutura do projeto

1. **config**: Responsável pela configuração de autenticação e autorização.

2. **controllers**: Controladores responsáveis pelo gerenciamento de requisições HTTP e retorno de respostas.

3. **entities**: Entidades que representam os objetos persistidos no banco de dados.

4. **projections**: Projeções usadas para transferir dados de forma eficiente para operações específicas.

5. **repositories**: Repositórios que gerenciam a persistência dos dados no banco.

6. **services**: Contém a lógica de negócios e coordena a interação entre controladores, repositórios e outras camadas.

## Setup do projeto

1. **Clone the repository:**

    ```bash
    git clone https://github.com/seu-usuario/todo-list.git
    cd todo-list
    ```

2. **Importe o projeto para sua IDE:**

    - Para IntelliJ IDEA: `File -> Open -> Select the project folder`.
    - Para Eclipse: `File -> Import -> Existing Maven Projects -> Select the project folder`.


3. **Inicie o projeto:**

    - Execute o projeto a partir de sua IDE.

## Endpoints da API

1. **Auth**

    - [ Post ] Login: /oauth2/token
   
2. **User**
      
    - [ Post ] New user: /users/register

3. **Task**

    - [ Get ] All tasks by user: /tasks
    - [ Get ] Task by id: /tasks/{id}
    - [ Post ] New task: /tasks
    - [ Put ] Switch task status: /tasks
    - [ Del ] Task by id: /tasks

## Postman Setup

**Fork collection in Postman:**

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://god.gw.postman.com/run-collection/32793447-1a637092-ae43-4c53-a587-abaf5a1d54d1?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D32793447-1a637092-ae43-4c53-a587-abaf5a1d54d1%26entityType%3Dcollection%26workspaceId%3Dec03cabd-7017-4e1e-9732-ede9cc8e46b8#?env%5BLocalJava%5D=W3sia2V5IjoiaG9zdCIsInZhbHVlIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQifSx7ImtleSI6ImFkbWluIiwidmFsdWUiOiJqb2huQGdtYWlsLmNvbSIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0In0seyJrZXkiOiJ1c2VyIiwidmFsdWUiOiJtYXJpYUBnbWFpbC5jb20iLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCJ9LHsia2V5IjoicGFzc3dvcmQiLCJ2YWx1ZSI6IjEyMzQ1NiIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0In0seyJrZXkiOiJteWNsaWVudGlkIiwidmFsdWUiOiJteWNsaWVudGlkIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQifSx7ImtleSI6Im15Y2xpZW50c2VjcmV0IiwidmFsdWUiOiJteWNsaWVudHNlY3JldCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0In0seyJrZXkiOiJ0b2tlbiIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQifV0=)

## Autor

Ruderson Florentino

https://ruderson.com.br

https://www.linkedin.com/in/rudersonvf

# Licence
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devsuperior/sds1-wmazoni/blob/master/LICENSE) 
