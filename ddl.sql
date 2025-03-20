CREATE TABLE patient (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(255)
);

CREATE TABLE doctor (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialty VARCHAR(255) NOT NULL,
    crm VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE medical_consultation (
    id SERIAL PRIMARY KEY,
    date_consultation TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('CANCELED', 'SCHEDULED', 'FINISHED')),
    doctor_id INTEGER,
    patient_id INTEGER,
    FOREIGN KEY (doctor_id) REFERENCES doctor(id) ON DELETE SET NULL,
    FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE SET NULL
);