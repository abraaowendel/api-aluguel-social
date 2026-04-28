# Aluguel Social API

Backend para o sistema de gestão de aluguéis sociais da Secretaria de Assistência Social do município de Senador Rui Palmeira – AL. Permite o cadastro de beneficiários e a emissão mensal de recibos de auxílio financeiro.

---

## Tecnologias

- Java 21
- Spring Boot 4.0.6
- Spring Data JPA + Hibernate
- PostgreSQL
- Maven
- Lombok
- Bean Validation

---

## Estrutura do projeto

```
src/main/java/br/com/api/aluguelsocial/
├── controller/
│   ├── BeneficiarioController.java
│   └── ReciboController.java
├── model/
│   ├── entities/
│   │   ├── Beneficiario.java
│   │   └── Recibo.java
│   └── embeddables/
│       ├── Endereco.java
│       └── DadosBancarios.java
├── dto/
│   ├── BeneficiarioRequestDTO.java
│   ├── BeneficiarioResponseDTO.java
│   ├── ReciboRequestDTO.java
│   └── ReciboResponseDTO.java
├── repository/
│   ├── BeneficiarioRepository.java
│   └── ReciboRepository.java
└── service/
    ├── BeneficiarioService.java
    └── ReciboService.java
```

---

## Modelagem

### Entidades

**Beneficiario**
| Campo | Tipo |
|---|---|
| id | UUID |
| nome | String |
| cpf | String |
| endereco | `@Embedded` Endereco |
| dadosBancarios | `@Embedded` DadosBancarios |

**Recibo**
| Campo | Tipo |
|---|---|
| id | UUID |
| beneficiario | `@ManyToOne` Beneficiario |
| valor | BigDecimal |
| mes | Month |
| ano | Integer |

### Embeddables

**Endereco** — `logradouro`, `municipio`

**DadosBancarios** — `banco`, `agencia`, `conta`

---

## Como executar

### Pré-requisitos

- Java 21+
- Maven 3.9+
- PostgreSQL rodando localmente

### Configuração do banco

Crie o banco de dados:

```sql
CREATE DATABASE aluguel_social;
```

Configure o `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/aluguel_social
spring.datasource.username=
spring.datasource.password=s
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Rodando a aplicação

```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

---

## Referências

- [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.6/reference/data/sql.html#data.sql.jpa-and-spring-data)
- [Spring Web](https://docs.spring.io/spring-boot/4.0.6/reference/web/servlet.html)
- [Validation](https://docs.spring.io/spring-boot/4.0.6/reference/io/validation.html)
- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
