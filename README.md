# LudicoM – Backend 🎲

**LudicoM Backend** é a aplicação servidor (API REST) desenvolvida em **Java com Spring Boot** para apoiar o gerenciamento de jogos, usuários, eventos e atividades do **Ludico UTFPR**.

Este repositório faz parte do sistema **LudicoM**, que busca modernizar e centralizar o controle das ações do programa de extensão **Ludico**, facilitando a organização e ampliando o alcance do projeto junto à comunidade acadêmica e externa.

---

## 🏛 Sobre o Programa Ludico

O **Ludico** é um programa de extensão da **Universidade Tecnológica Federal do Paraná (UTFPR)**, ativo desde **2016**, com atividades contínuas de caráter mensal. Ele é composto por três frentes principais:  

- 🎲 **Board Games**  
- 🧩 **RPG**  
- 🔐 **Escape Room**  

O programa tem como público-alvo **alunos da UTFPR** e a **comunidade externa** das cidades de **Londrina, Cornélio Procópio** e regiões metropolitanas.  

### 🎯 Objetivos
- Desenvolver **capacidades de aprendizagem** nos participantes.  
- Melhorar **raciocínio lógico** e **análise crítica**.  
- Estimular **organização** e **relações interpessoais**.  
- Atuar como **ferramenta de inserção cultural**.  

### 📅 Atividades
- Eventos mensais desde 2016, realizados alternadamente nos campus de **Cornélio Procópio** e **Londrina**.  
- Média de **160 participantes por evento**.  
- Sessões de **board games**, **RPG**, **escape room** e **jogos em inglês**.  
- **Palestras** com profissionais convidados sobre jogos, cultura e educação.  
- **Sorteios de brindes** em parceria com colaboradores.  
- Eventos online realizados durante a pandemia (palestras, workshops, jogos digitais).  

### 🌍 Reconhecimento
- Único projeto da **América Latina** aprovado no edital internacional **Game in Lab**, que estuda o uso de jogos de tabuleiro para aquisição e manutenção de habilidades sociais.  
- Destaque em veículos como **Folha de Londrina**, **Taberna Role Play (YouTube)** e **Podcast A Taverna do Beholder Cego**.  
- Participações em eventos culturais e acadêmicos como **WRPG Fest**, **Semana do Orgulho Nerd**, **Expo Japão 2018** e **SPIEL Digital 2020**.  

📢 O Ludico também mantém presença ativa nas redes sociais:  
- [Facebook](https://www.facebook.com/)  
- [Instagram](https://www.instagram.com/)  

---

## 🚀 Funcionalidades do Backend (em desenvolvimento)

- API REST para gerenciamento de usuários, jogos, eventos e empréstimos. - Autenticação e autorização com **Spring Security**.  
- Persistência de dados com **Spring Data JPA / Hibernate**.  
- Banco de dados **CockroachDB**.  
- Documentação da API (planejado via Swagger/OpenAPI).  
- Relatórios e estatísticas (planejado).  

---

## 🛠 Tecnologias Utilizadas

- **Java 17**  
- **Spring Boot**  
- **Spring Security**  
- **Spring Data JPA / Hibernate**  
- **CockroachDB**  
- **Maven**  
- **JUnit 5**  

---

## 🧭 Como Executar

### Pré-requisitos
- **Java 17+**  
- **Maven 3.8+**  
- Acesso a uma instância **CockroachDB**  

### Passos

```bash
# Clonar o repositório
git clone https://github.com/LudicoM-UTFPR/LudicoM-backend.git
cd LudicoM-backend

# Compilar
mvn clean compile

# Rodar a aplicação
mvn spring-boot:run
