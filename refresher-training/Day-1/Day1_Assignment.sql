SELECT VERSION();
CREATE DATABASE health_clinic_db;
USE health_clinic_db;
CREATE TABLE specializations (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 name VARCHAR(100) NOT NULL,
                                 description VARCHAR(255)
);
CREATE TABLE appointments (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              patient_id INT NOT NULL,
                              doctor_id INT NOT NULL,
                              appointment_date DATETIME NOT NULL
);
SHOW TABLES;
DESCRIBE specializations;
DESCRIBE appointments;
INSERT INTO specializations (name, description)
VALUES
    ('Cardiology', 'Heart and cardiovascular treatments'),
    ('Dermatology', 'Skin, hair, and nail treatments'),
    ('Orthopedics', 'Bones, joints, and muscles treatment');

SELECT * FROM specializations;

INSERT INTO appointments (patient_id, doctor_id, appointment_date)
VALUES
    (101, 201, '2026-08-02 10:00:00'),
    (102, 202, '2026-08-02 11:30:00'),
    (103, 203, '2026-08-03 09:15:00');

SELECT * FROM appointments;



ALTER TABLE specializations

    ADD COLUMN experience_years INT;

DESCRIBE specializations;

ALTER TABLE specializations
DROP COLUMN experience_years;

DESCRIBE specializations;

SELECT * FROM specializations;

UPDATE specializations
SET description = 'Diagnosis and treatment of skin disorders'
WHERE id = 2;


SELECT * FROM appointments;
DELETE FROM appointments
WHERE id = 3;


CREATE USER 'clinic_app_user'@'localhost'
IDENTIFIED BY 'Clinic@123';

GRANT SELECT, INSERT, UPDATE, DELETE
      ON health_clinic_db.*
          TO 'clinic_app_user'@'localhost';

FLUSH PRIVILEGES;
SHOW GRANTS FOR 'clinic_app_user'@'localhost';