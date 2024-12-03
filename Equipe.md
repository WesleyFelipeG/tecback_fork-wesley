# Projeto API Rest - Equipe

## Detalhamento do Time

Este projeto foi desenvolvido pela equipe, composta pelos seguintes membros:

- **Wesley Felipe Gouveia Soares**

Cada membro contribuiu com a implementação de um ou mais endpoints, além dos requisitos discutidos em sala de aula. Cada um desenvolveu um CRUD completo (excluindo o método PATCH), bem como os Services, Repositories e Models, anotados com @Entity.

### Detalhamento das Contribuições:

- **Wesley Felipe Gouveia Soares**

  Desenvolveu o CRUD completo para **Diretor**:
  - `GET /diretor`
  - `POST /diretor`
  - `PUT /diretor/{id}`
  - `DELETE /diretor/{id}`
  Também criou o `DiretorService`, `DiretorRepository` e o model `Diretor` anotado com `@Entity`.
  
  Desenvolveu o CRUD completo para **Ator**:
  - `GET /ator`
  - `POST /ator`
  - `PUT /ator/{id}`
  - `DELETE /ator/{id}`
  Também criou o `AtorService`, `AtorRepository` e o model `Ator` anotado com `@Entity`.

  Desenvolveu o CRUD completo para **Genero**:
  - `GET /genero`
  - `POST /genero`
  - `PUT /genero/{id}`
  - `DELETE /genero/{id}`
  Também criou o `GeneroService`, `GeneroRepository` e o model `Genero` anotado com `@Entity`.

--Avaliação 2--
  Desenvolveu o CRUD completo para **Personagem**
  - `GET /personagem`
  - `POST /personagem`
  - `PUT /personagem/{id}`
  Também criou o `PersonagemService`, `PersonagemRepository` e o model `Personagem` anotado com `@Entity`.
  Também criou o `PersoangemControllerTest` e o `PersonagemServiceTest`
