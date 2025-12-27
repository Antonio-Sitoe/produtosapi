# Produtos API

API REST para gerenciamento de produtos usando Spring Boot e PostgreSQL.

## Pré-requisitos

- Java 21
- Maven 3.6+
- Docker e Docker Compose

## Configuração do Banco de Dados

### Iniciar o PostgreSQL com Docker

```bash
docker-compose up -d
```

Isso irá iniciar um container PostgreSQL com as seguintes configurações:

- **Host:** localhost
- **Porta:** 5432
- **Database:** produtosdb
- **Usuário:** produtosuser
- **Senha:** produtospass

### Parar o PostgreSQL

```bash
docker-compose down
```

### Parar e remover volumes (apaga os dados)

```bash
docker-compose down -v
```

## Executando a Aplicação

### 1. Compilar o projeto

```bash
./mvnw clean package
```

### 2. Executar a aplicação

```bash
./mvnw spring-boot:run
```

Ou:

```bash
java -jar target/produtosapi-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em: `http://localhost:8080`

## Endpoints da API

### GET /

Retorna uma mensagem de boas-vindas.

### GET /produtos

Lista todos os produtos.

### POST /produtos

Cria um novo produto.

**Exemplo de requisição:**

```json
{
  "nome": "Produto Exemplo",
  "descricao": "Descrição do produto",
  "preco": 99.99
}
```

## Estrutura do Banco de Dados

A tabela `produto` é criada automaticamente pelo Hibernate com a seguinte estrutura:

- `id` (BIGSERIAL, PRIMARY KEY)
- `nome` (VARCHAR(255), NOT NULL)
- `descricao` (VARCHAR(255))
- `preco` (DECIMAL(10, 2))

## Configuração

As configurações do banco de dados estão no arquivo `src/main/resources/application.yml`.

Para alterar as credenciais do banco, edite o `docker-compose.yml` e o `application.yml` correspondente.
