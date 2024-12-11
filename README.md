# service_app_bluevelvet
Repositório para a aplicação do projeto BlueVelvet.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.5**
- **Spring Data JPA**
- **Flyway Migration**
- **MySQL**

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- [JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) ou superior
- [Maven 3.8+](https://maven.apache.org/download.cgi) ou superior
- [MySQL 8.0+](https://www.mysql.com/downloads/) ou superior
- Uma ferramenta de API (opcional): [Postman](https://www.postman.com/) ou [cURL](https://curl.se/)

## Instalação e Configuração

### Clonando o Repositório

Clone o repositório em sua máquina local:

```
git clone https://github.com/BCC-BlueVelvet/service_app_bluevelvet.git
```

### Configurando o Banco de Dados

Crie um banco de dados no MySQL para o projeto:

```
CREATE DATABASE bluevelvet_db;
```

Configure as credenciais do banco de dados como variáveis de ambiente:
```
export DATABASE_URL=jdbc:mysql://localhost:3306/bluevelvet_db
export DATABASE_USERNAME=seu_usuario
export DATABASE_PASSWORD=sua_senha
```

### Instalando Dependências

Utilize o Maven para baixar as dependências do projeto:
```
mvn clean install
```

## Executando a Aplicação

Inicie com o comando:

```
mvn spring-boot:run
```

Verifique em - [http://localhost:8080](http://localhost:8080)