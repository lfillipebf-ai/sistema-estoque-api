# Sistema de Estoque API

API REST para gerenciamento de estoque, desenvolvida como projeto de portfólio e aprendizado.

## Tecnologias

- Java 17
- Spring Boot 3.5.6
- Spring Data JPA
- PostgreSQL
- Maven
- Docker / Docker Compose
- REST API
- Git e GitHub

## Funcionalidades

- Cadastro de categorias
- Cadastro de fornecedores
- Cadastro de produtos
- Controle de estoque
- Entrada e saída de produtos
- Histórico de movimentações
- Consulta de produtos
- Consulta de movimentações por produto
- Persistência em PostgreSQL
- Validação básica de dados

## Principais endpoints

### Categorias
- `GET /api/categories`
- `POST /api/categories`

### Fornecedores
- `GET /api/suppliers`
- `POST /api/suppliers`

### Produtos
- `GET /api/products`
- `GET /api/products/{id}`
- `POST /api/products`
- `PUT /api/products/{id}`
- `DELETE /api/products/{id}`

### Movimentações
- `GET /api/stock-movements`
- `GET /api/stock-movements/product/{productId}`
- `POST /api/stock-movements`

Ao registrar uma entrada, o estoque aumenta. Ao registrar uma saída, o sistema valida se há quantidade suficiente e reduz o estoque.

## Como executar

### Com Docker

```bash
docker compose up --build
```

A API ficará disponível em `http://localhost:8080`.

### Sem Docker

Configure um PostgreSQL local e ajuste `backend/src/main/resources/application.properties`.

Depois execute:

```bash
cd backend
./mvnw spring-boot:run
```

No Windows, também é possível usar `mvnw.cmd spring-boot:run`.

## Projeto

Projeto educacional/portfólio desenvolvido para praticar APIs REST, persistência de dados, modelagem de entidades e regras de negócio relacionadas a estoque.

**Autor:** Luis Fillipe Backer Faria  
**GitHub:** lfillipebf-ai
