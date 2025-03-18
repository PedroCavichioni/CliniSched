INSERT INTO patient (name, phone, email) VALUES 
('João Silva', '11987654321', 'joao.silva@email.com'),
('Maria Oliveira', '11987654322', 'maria.oliveira@email.com'),
('Carlos Souza', '11987654323', 'carlos.souza@email.com'),
('Ana Pereira', '11987654324', 'ana.pereira@email.com'),
('Fernando Almeida', '11987654325', 'fernando.almeida@email.com'),
('Juliana Costa', '11987654326', 'juliana.costa@email.com'),
('Bruno Mendes', '11987654327', 'bruno.mendes@email.com'),
('Patrícia Lima', '11987654328', 'patricia.lima@email.com'),
('Ricardo Santos', '11987654329', 'ricardo.santos@email.com'),
('Larissa Rocha', '11987654330', 'larissa.rocha@email.com');

INSERT INTO doctor (name, specialty, crm) VALUES 
('Dr. Carlos Souza', 'Cardiologia', 'CRM12345'),
('Dra. Fernanda Lima', 'Dermatologia', 'CRM67890'),
('Dr. Roberto Alves', 'Ortopedia', 'CRM11111'),
('Dra. Camila Farias', 'Pediatria', 'CRM22222'),
('Dr. Eduardo Nascimento', 'Neurologia', 'CRM33333'),
('Dra. Vanessa Martins', 'Ginecologia', 'CRM44444'),
('Dr. Rafael Duarte', 'Urologia', 'CRM55555'),
('Dra. Isabel Fonseca', 'Endocrinologia', 'CRM66666'),
('Dr. André Silva', 'Oftalmologia', 'CRM77777'),
('Dra. Mariana Teixeira', 'Psiquiatria', 'CRM88888');

INSERT INTO medical_consultation (date_consultation, status, doctor_id, patient_id) VALUES 
(TO_TIMESTAMP('17/03/2025 10:00', 'DD/MM/YYYY HH24:MI'), 1, 1, 1),
(TO_TIMESTAMP('18/03/2025 14:30', 'DD/MM/YYYY HH24:MI'), 2, 2, 2),
(TO_TIMESTAMP('19/03/2025 09:00', 'DD/MM/YYYY HH24:MI'), 0, 3, 3),
(TO_TIMESTAMP('20/03/2025 15:15', 'DD/MM/YYYY HH24:MI'), 1, 4, 4),
(TO_TIMESTAMP('21/03/2025 11:45', 'DD/MM/YYYY HH24:MI'), 2, 5, 5),
(TO_TIMESTAMP('22/03/2025 08:30', 'DD/MM/YYYY HH24:MI'), 1, 6, 6),
(TO_TIMESTAMP('23/03/2025 16:00', 'DD/MM/YYYY HH24:MI'), 0, 7, 7),
(TO_TIMESTAMP('24/03/2025 13:20', 'DD/MM/YYYY HH24:MI'), 1, 8, 8),
(TO_TIMESTAMP('25/03/2025 10:10', 'DD/MM/YYYY HH24:MI'), 2, 9, 9),
(TO_TIMESTAMP('26/03/2025 17:50', 'DD/MM/YYYY HH24:MI'), 1, 10, 10);

