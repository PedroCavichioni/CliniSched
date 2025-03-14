# 🏥 CliniSched

## 📌 Sobre o Projeto
O **CliniSched** é uma aplicação desenvolvida com **Spring Boot** e **MongoDB**, permitindo o cadastro de médicos e pacientes, gerenciamento de consultas, envio de lembretes automáticos e armazenamento de histórico de consultas.

## 🚀 Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **MongoDB**
- **Spring Data MongoDB**
- **Spring Mail (Envio de e-mails)**
- **Twilio API (WhatsApp Notifications)**
- **Lombok**
- **Swagger (Documentação da API)**

## 🔧 Funcionalidades
✅ Cadastro de médicos e pacientes
<br>
✅ Agendamento de consultas
<br>
✅ Listagem de consultas por paciente e médico
<br>
✅ Envio de lembretes automáticos por e-mail e WhatsApp
<br>
✅ Registro de histórico de consultas

## 🛠️ Configuração do Projeto

### 🔹 Requisitos
- **Java 17+**
- **MongoDB instalado ou Atlas Cloud**
- **Maven 3+**

### 🔹 Clonar o Repositório
```bash
  git clone https://github.com/PedroCavichioni/CliniSched.git
  cd CliniSched
```

### 🔹 Configurar as Variáveis de Ambiente
Crie um arquivo **.env** na raiz do projeto e adicione:
```env
MONGO_URI=mongodb://localhost:27017/clinicaDB
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

## 🛠️ Endpoints Principais

### 🔹 Autenticação
- `POST /auth/register` - Registro de usuário
- `POST /auth/login` - Autenticação e geração de token

### 🔹 Médicos
- `POST /medicos` - Cadastro de médicos
- `GET /medicos` - Listagem de médicos

### 🔹 Pacientes
- `POST /pacientes` - Cadastro de pacientes
- `GET /pacientes` - Listagem de pacientes

### 🔹 Consultas
- `POST /consultas` - Agendamento de consulta
- `GET /consultas/paciente/{id}` - Consultas de um paciente
- `GET /consultas/medico/{id}` - Consultas de um médico

## 👨‍💻 Autor
- **Pedro Henrique Cavichioni de Oliveira**
- [LinkedIn]([https://www.linkedin.com/in/s](https://www.linkedin.com/in/pedro-henrique-cavichioni-de-oliveira-600028261/))
- [GitHub]([https://github.com/seu-usuario](https://github.com/PedroCavichioni))

