# 🏥 CliniSched

## 📌 Sobre o Projeto
O **CliniSched** é uma aplicação de gerenciamento de consultas médicas desenvolvida com **Spring Boot** e **PostgreSQL**, permitindo o cadastro de médicos e pacientes, gerenciamento de consultas, envio de lembretes automáticos e armazenamento de histórico de consultas.

## 🚀 Tecnologias Utilizadas
- **Java 23**
- **Spring Boot 3+**
- **PostgreSQL**
- **Spring Data JPA**
- **Spring Mail (Envio de e-mails)**
- **Twilio API (WhatsApp Notifications)**
- **Lombok**
- **Swagger (Documentação da API)**

## 🛠️ Funcionalidades
✅ Cadastro de médicos e pacientes
✅ Agendamento de consultas
✅ Listagem de consultas por paciente ou médico
✅ Envio de lembretes automáticos por e-mail e WhatsApp
✅ Registro de histórico de consultas

## 🛠️ Configuração do Projeto

### 🔹 Requisitos
- **Java 17+**
- **PostgreSQL instalado ou banco em nuvem**
- **Maven 3+**

### 🔹 Clonar o Repositório
```bash
  git clone https://github.com/PedroCavichioni/CliniSched.git
  cd CliniSched
```

### 🔹 Configurar as Variáveis de Ambiente
Crie um arquivo **.env** na raiz do projeto e adicione:
```env
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/clinicaDB
SPRING_DATASOURCE_USERNAME=seu_usuario
SPRING_DATASOURCE_PASSWORD=sua_senha
SPRING_JPA_HIBERNATE_DDL-AUTO=update
JWT_SECRET=seu-segredo
EMAIL_HOST=smtp.seuprovedor.com
EMAIL_USER=seuemail@email.com
EMAIL_PASS=sua-senha
TWILIO_ACCOUNT_SID=seu-sid
TWILIO_AUTH_TOKEN=seu-token
TWILIO_WHATSAPP_NUMBER=+1234567890
```

### 🔹 Executar o Projeto
```bash
mvn spring-boot:run
```

O servidor iniciará na porta **8080**. Acesse a documentação da API:
```url
http://localhost:8080/swagger-ui/index.html
```

## 📌 Melhorias Futuras
- 📌 Implementar pagamento de consultas
- 📌 Sistema de Login

## 👨‍💻 Autor
- **Pedro Henrique Cavichioni de Oliveira**
- [LinkedIn]([https://www.linkedin.com/in/seu-perfil](https://www.linkedin.com/in/pedro-henrique-cavichioni-de-oliveira-600028261/))
- [GitHub](https://github.com/PedroCavichioni)

