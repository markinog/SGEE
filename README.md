# 🎯 SGEE — Sistema de Gestão de Equipamentos Empresariais

---

## 📑 Sumário

- [🔍 Visão Geral](#🔍-visão-geral)
- [🚀 Funcionalidades](#🚀-funcionalidades)
- [🛠️ Tecnologias](#🛠️-tecnologias)
- [🏗️ Arquitetura](#🏗️-arquitetura)
- [⚙️ Pré-requisitos](#⚙️-pré-requisitos)
- [📥 Instalação & Execução](#📥-instalação--execução)
- [🔧 Configuração](#🔧-configuração)
- [📡 Endpoints](#📡-endpoints)
- [📚 Documentação Interativa](#📚-documentação-interativa)
- [🧪 Testes](#🧪-testes)
- [🤝 Contribuição](#🤝-contribuição)
- [📄 Licença](#📄-licença)
- [📬 Contato](#📬-contato)

---

## 🔍 Visão Geral

O **SGEE** (Sistema de Gestão de Equipamentos Empresariais) é uma API RESTful em **Java 21+** e **Spring Boot** para gerenciar ativos, empréstimos, tipos de equipamento e funcionários de forma simples e escalável.

---

## 🚀 Funcionalidades

- CRUD de **Equipamentos**
- CRUD de **TipoEquipamento**
- CRUD de **Funcionários**
- Registro de **Empréstimos**
- Histórico de movimentações (consultas via filtros)

---

## 🛠️ Tecnologias

- **Java 21+**
- **Spring Boot 3.4.4**
- **Spring Data JPA** (MySQL) e **Spring Data MongoDB** ([build.gradle](https://github.com/markinog/SGEE/blob/main/build.gradle))
- **MapStruct**
- **Lombok**
- **Gradle**
- **SpringDoc OpenAPI** (Swagger UI) ([build.gradle](https://github.com/markinog/SGEE/blob/main/build.gradle))

---

## 🏗️ Arquitetura

```text
src/main/java/br/com/sgee/gestaodeequipamentos
├── controller/    # REST Controllers (Equipamento, TipoEquipamento, Funcionario, Emprestimo)
├── dto/           # Data Transfer Objects
├── mapper/        # MapStruct mappers
├── model/         # JPA entities
├── repository/    # Spring Data repositories
├── service/       # Business logic
└── GestaodeequipamentosApplication.java # Classe principal
```


---

## ⚙️ Pré-requisitos

- Java 21 ou superior
- Gradle (wrapper incluso)
- MySQL em execução (H2 para testes locais opcional)

---

## 📥 Instalação & Execução

```bash
# Clone o projeto
git clone https://github.com/markinog/SGEE.git
cd SGEE

# Build e execução
./gradlew clean build
./gradlew bootRun
```

A aplicação ficará disponível em \`http://localhost:8080\`.

---

## 🔧 Configuração

Edite `src/main/resources/application.yml` para ajustar conexão ao banco:

```yaml
spring:
  datasource:
    url: jdbc:mysql://<HOST>:<PORT>/<DB>
    username: <USER>
    password: <PASS>
  jpa:
    hibernate:
      ddl-auto: update
  data:
    mongodb:
      uri: mongodb://<USER>:<PASS>@<HOST>:<PORT>/<DB>
```

Use perfis (\`application-dev.yml\`, \`application-prod.yml\`) para separar ambientes.

---

## 📡 Endpoints

| Método | Rota                     | Descrição                         |
|:------:|:--------------------------|:----------------------------------|
| GET    | \`/equipamentos\`         | Lista todos os equipamentos        |
| POST   | \`/equipamentos\`         | Cria novo equipamento              |
| GET    | \`/equipamentos/{id}\`    | Consulta equipamento por ID        |
| PUT    | \`/equipamentos/{id}\`    | Atualiza equipamento               |
| DELETE | \`/equipamentos/{id}\`    | Remove equipamento                 |
| GET    | \`/tipoequipamento\`      | Lista tipos de equipamento         |
| POST   | \`/tipoequipamento\`      | Cria tipo de equipamento           |
| GET    | \`/tipoequipamento/{id}\` | Consulta tipo por ID               |
| PUT    | \`/tipoequipamento/{id}\` | Atualiza tipo de equipamento       |
| DELETE | \`/tipoequipamento/{id}\` | Remove tipo de equipamento         |
| GET    | \`/funcionarios\`         | Lista funcionários                 |
| POST   | \`/funcionarios\`         | Cria novo funcionário              |
| GET    | \`/funcionarios/{id}\`    | Consulta funcionário por ID        |
| PUT    | \`/funcionarios/{id}\`    | Atualiza funcionário               |
| DELETE | \`/funcionarios/{id}\`    | Remove funcionário                 |
| GET    | \`/emprestimos\`          | Lista todos os empréstimos         |
| POST   | \`/emprestimos\`          | Registra novo empréstimo           |
| GET    | \`/emprestimos/{id}\`     | Consulta empréstimo por ID         |

---

## 📚 Documentação Interativa

A documentação automática da API é gerada pelo **SpringDoc OpenAPI** e fica disponível em:

```
http://localhost:8080/swagger-ui.html
```

Lá você pode testar todos os endpoints de forma visual e interativa.

---

## 🧪 Testes

Execute testes unitários e de integração com:

```bash
./gradlew test
```

Relatório de cobertura disponível em `build/reports/jacoco`.

---

## 🤝 Contribuição

1. Fork no repositório  
2. Crie branch de feature:
```bash
git checkout -b feature/nome-da-feature
```
3. Faça commits:
```bash
git commit -m "feat: descreva sua mudança"
```
4. Push para o remoto:
```bash
git push origin feature/nome-da-feature
```
5. Abra um Pull Request

---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## 📬 Contato

Dúvidas ou sugestões? Abra uma Issue ou PR, ou contate:
- Email: markinog@example.com
- GitHub: https://github.com/markinog

---

# 🏁 Vamos gerenciar equipamentos de forma inteligente! 🚀
