Este repositorio contem o codigo completo do projeto Barber SHOP, um sistema moderno de agendamento desenvolvido para barbearias. A aplicacao utiliza uma arquitetura baseada em uma Single Page Application (SPA) no front-end, que se comunica de forma assincrona via REST API com um back-end estruturado em Java Spring Boot, persistindo os dados em um banco relacional MySQL por meio do XAMPP.

## Arquitetura do Projeto

O sistema esta dividido em duas camadas principais:
1. **Front-end:** Interface de pagina unica construida com HTML5 nativo, estilizada com Tailwind CSS e dinamizada com JavaScript puro (Vanilla JS) utilizando a Fetch API para requisicoes assincronas (AJAX).
2. **Back-end:** API RESTful desenvolvida com Spring Boot 3.x, estruturada no padrao de camadas (Controller, Service, Repository, DTO, Model) com persistencia automatica via Spring Data JPA e Hibernate.

---

## Pre-requisitos para Execucao

Antes de iniciar, certifique-se de ter as seguintes ferramentas instaladas em sua maquina:
* **Java Development Kit (JDK):** Versao 17 ou superior instalada e configurada nas variaveis de ambiente.
* **Apache Maven:** Versao 3.8 ou superior (geralmente embutido nas IDEs).
* **XAMPP:** Para gerenciamento do servidor de banco de dados MySQL local.
* **IDE de sua preferencia:** IntelliJ IDEA, Eclipse ou Visual Studio Code.

---

## Passo a Passo para Configuracao e Inicializacao

### 1. Configuracao do Banco de Dados (XAMPP / phpMyAdmin)

1. Inicie o painel de controle do **XAMPP**.
2. Clique no botao **Start** correspondente ao modulo **MySQL**. *Nota: Nao ative o Tomcat do XAMPP para evitar conflitos de porta com o Spring Boot.*
3. Clique em **Admin** na linha do MySQL para abrir a interface do **phpMyAdmin** no seu navegador.
4. No menu esquerdo, clique em **Novo** (New), defina o nome do banco de dados como `barber_shop` e clique em **Criar**.
5. Selecione o banco `barber_shop`, clique na aba **SQL** no menu superior, cole o script estrutural abaixo e clique em **Executar** (Go):
```sql
-- Criacao da tabela de profissionais
CREATE TABLE profissional (
cpf_profissional VARCHAR(14) PRIMARY KEY,
nome_profissional VARCHAR(80),
endereco_profissional VARCHAR(120),
email_profissional VARCHAR(50),
data_de_nascimento DATE
);

-- Criacao da tabela de servicos cadastrados
CREATE TABLE servicos (
id_servico INT PRIMARY KEY,
nome_procedimento VARCHAR(80),
preco DECIMAL(10,2)
);

-- Criacao da tabela de clientes
CREATE TABLE cliente (
cpf_cliente VARCHAR(14) PRIMARY KEY,
nome_cliente VARCHAR(80),
endereco_cliente VARCHAR(120),
email_cliente VARCHAR(50),
data_de_nascimento_cliente DATE
);

-- Criacao da tabela de agendamentos relacionando as entidades
CREATE TABLE agendamento (
protocolo INT AUTO_INCREMENT PRIMARY KEY,
cpf_cliente VARCHAR(14),
cpf_profissional VARCHAR(14),
id_servico INT,
data_agendamento DATE,
horario_agendamento VARCHAR(5),
FOREIGN KEY(id_servico) REFERENCES servicos(id_servico),
FOREIGN KEY(cpf_profissional) REFERENCES profissional(cpf_profissional),   
FOREIGN KEY(cpf_cliente) REFERENCES cliente(cpf_cliente)
);

-- Carga inicial de dados para testes da aplicacao
INSERT INTO profissional (cpf_profissional, nome_profissional, endereco_profissional, email_profissional, data_de_nascimento_profissional)
VALUES ('111.222.333-44', 'Carlos Silva', 'Rua dos Barbeiros, 10', 'carlos@barber.com', '1990-05-15');

INSERT INTO servicos (id_servico, nome_procedimento, preco) VALUES (1, 'Corte Masculino', 50.00);
INSERT INTO servicos (id_servico, nome_procedimento, preco) VALUES (2, 'Design de Barba', 40.00);
INSERT INTO servicos (id_servico, nome_procedimento, preco) VALUES (3, 'Design Sobrancelha', 25.00);
 ```

### 2. Inicializacao do Back-end (Spring Boot)
   Abra a IDE de sua escolha e importe a pasta raiz do back-end como um projeto Maven (pom.xml).

Localize o arquivo de propriedades em src/main/resources/application.properties e valide as credenciais de acesso locais. Por padrao, a configuracao para o XAMPP segue a estrutura abaixo:

Properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/barber_shop?createDatabaseIfNotExist=true&serverTimezone=UTC  
spring.datasource.username=root  
spring.datasource.password=  
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  
  
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
spring.jpa.properties.hibernate.format_sql=true  
Aguarde a IDE processar e baixar as dependencias descritas no Maven.
```

Navegue ate a classe principal do projeto (src/main/java/barbershop/demo/DemoApplication.java), clique com o botao direito e selecione a opcao Run (Executar).

O console exibira a inicializacao do servidor Tomcat embutido na porta padrao 8080.

### 3. Inicializacao do Front-end
   Localize os arquivos estaticos do front-end (index.html, style.css, script.js).

Abra o arquivo index.html diretamente em seu navegador dando um duplo clique ou utilize a extensao Live Server dentro do VS Code para rodar sob um servidor local estatico (ex: http://127.0.0.1:5500).

Navegue ate a secao de Agendamento e preencha o formulario para testar a integracao de ponta a ponta.

