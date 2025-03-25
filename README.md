# 📒 Agenda de Contatos

Esta aplicação é uma agenda de contatos que permite gerenciar clientes e seus respectivos contatos. Com ela, é possível:

✅ Cadastrar, visualizar, editar e deletar clientes  
✅ Adicionar múltiplos contatos para cada cliente (telefone, e-mail, etc.)  
✅ Realizar CRUD completo nos contatos (inclusão, visualização, edição e exclusão)

A aplicação foi desenvolvida utilizando Java (Spring Boot) no backend e React no frontend, garantindo uma experiência ágil e intuitiva.

## 🚀 Entidades e Atributos

1. Cliente:
- Id
- Nome do cliente
- CPF
- Data de nascimento
- Endereço
- Lista de Contatos (Relação de classes)

2. Contato:
- Id
- Tipo
- Valor
- Observação
- Cliente (Relação de classes)

## 🚀 Tecnologias e Dependências Utilizadas

### 📌 Tecnologias Principais

#### Backend
- **Java** com o FrameWork **Spring**
- Banco de Dados: **MySQL**
- Cliente Teste Local: **Insomnia**

#### Frontend
- **React** - Biblioteca para construção de interfaces dinâmicas e declarativas.  
- **Vite** - Ferramenta para construção e desenvolvimento rápido de aplicações frontend.  
- **Tailwind CSS** - Framework CSS utilitário para estilização rápida e responsiva.  

### 📦 Dependências
- Spring Boot **DevTools**
- Spring Web
- Spring Data **JPA**
- **MySQL Driver**
- **axios** - Cliente HTTP para consumo de APIs.  
- **react-router-dom** - Gerenciamento de rotas no React.  

### 🛠️ Ferramentas e Configuração  
- **PostCSS** - Processador CSS para melhor compatibilidade e otimização.  
- **@vitejs/plugin-react** - Plugin para otimizar o uso do React no Vite.
 
## 🚀 Rodando o projeto

### 📍 Localmente
Clone o projeto

```bash
  git clone https://github.com/marcoslopesdev/agenda_frontend
```

Entre no diretório do projeto

```bash
  cd agenda
```

Instale as dependências

```bash
  yarn install
```

Inicie o servidor

```bash
  yarn dev
```
## 👨‍💻 Desenvolvedor

Desenvolvido por Marcos Lopes
