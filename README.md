# **🛒 Sistema de E-commerce**

Este repositório contém um sistema de e-commerce desenvolvido como parte do curso de Java Spring da **Build & Run**. O objetivo é criar uma aplicação para gerenciar usuários, produtos, tags, pedidos e itens de pedido, aplicando conceitos essenciais do **Spring Boot**.

## **✨ Funcionalidades**
- 🧑‍💼 **Gerenciamento de Usuários**: Cadastro e consulta de usuários.
- 🏠 **Gerenciamento de Endereços**: Associação de endereços aos usuários.
- 📦 **Gerenciamento de Produtos**: Cadastro de produtos com categorização por tags.
- 🛍️ **Gerenciamento de Pedidos**: Criação e controle de pedidos.
- 📑 **Gerenciamento de Itens de Pedido**: Associação de produtos aos pedidos.

## **🛠️ Tecnologias Utilizadas**
- ☕ **Java 21**
- 🚀 **Spring Boot** (Spring Web, Spring Data JPA)
- 🗃️ **JPA/Hibernate** (ORM para mapeamento de entidades)
- 🐳 **Docker + MySQL** (Banco de Dados)
- 🏗️ **Maven**

## ** Endpoints da API**

### **🆕 Criar um novo usuário**
- **POST** `/users`
- **Body**:
  ```json
  {
    "name": "Wallace Vilela",
    "email": "wallace@email.com"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "name": "Wallace Vilela",
    "email": "wallace@email.com"
  }
  ```

### **📜 Listar produtos**
- **GET** `/products`
- **Response**:
  ```json
  [
    {
      "id": 1,
      "name": "Smartphone",
      "price": 1999.99,
      "tags": ["Eletrônicos", "Mobile"]
    }
  ]
  ```

### **📦 Criar um pedido**
- **POST** `/orders`
- **Body**:
  ```json
  {
    "userId": 1,
    "items": [
      {
        "productId": 1,
        "quantity": 2
      }
    ]
  }
  ```
- **Response**:
  ```json
  {
    "orderId": 1,
    "totalValue": 3999.98,
    "createdAt": "2025-02-01T10:00:00Z"
  }
  ```

## **🚀 Como Executar o Projeto**

1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd ecommerce-app
   ```
3. Execute o projeto utilizando o Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Acesse a aplicação no navegador ou via Postman em: [http://localhost:8080](http://localhost:8080).

## **🤝 Contribuição**
Se desejar contribuir com melhorias ou novas funcionalidades, sinta-se à vontade para abrir uma issue ou enviar um pull request.

