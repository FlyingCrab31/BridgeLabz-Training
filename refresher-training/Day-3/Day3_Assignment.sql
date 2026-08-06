Use health_clinic_db_1;
SHOW TABLES;
SHOW DATABASES;
SELECT * FROM patients;
SELECT * FROM doctors;
SELECT * FROM appointments;
SELECT * FROM specializations;
SELECT * FROM billing;
SELECT * FROM visit_history;
SELECT
    CONCAT(p.first_name, ' ', p.last_name) AS patient_name,
    CONCAT(d.first_name, ' ', d.last_name) AS doctor_name,
    a.appointment_date,
    a.status
FROM appointments a
         INNER JOIN patients p
                    ON a.patient_id = p.patient_id
         INNER JOIN doctors d
                    ON a.doctor_id = d.doctor_id;


SELECT
    CONCAT(p.first_name, ' ', p.last_name) AS patient_name,
    a.appointment_date,
    a.status
FROM patients p
         LEFT JOIN appointments a
                   ON p.patient_id = a.patient_id;





SELECT
    CONCAT(p.first_name, ' ', p.last_name) AS patient_name,
    a.appointment_date,
    a.status
FROM patients p
         RIGHT JOIN appointments a
                    ON p.patient_id = a.patient_id;


SELECT
    p.patient_id,
    CONCAT(p.first_name, ' ', p.last_name) AS patient_name,
    a.appointment_id
FROM patients p
         LEFT JOIN appointments a
                   ON p.patient_id = a.patient_id

UNION

SELECT
    p.patient_id,
    CONCAT(p.first_name, ' ', p.last_name) AS patient_name,
    a.appointment_id
FROM patients p
         RIGHT JOIN appointments a
                    ON p.patient_id = a.patient_id;



SELECT
    d1.doctor_id AS doctor1,
    d2.doctor_id AS doctor2
FROM doctors d1
         INNER JOIN doctors d2
                    ON d1.doctor_id <> d2.doctor_id;


SELECT
    CONCAT(p.first_name,' ',p.last_name) AS patient_name,
    CONCAT(d.first_name,' ',d.last_name) AS doctor_name
FROM patients p
         CROSS JOIN doctors d;

SELECT
    CONCAT(p.first_name,' ',p.last_name) AS patient_name,
    CONCAT(d.first_name,' ',d.last_name) AS doctor_name,
    s.name AS specialization,
    a.appointment_date,
    a.status
FROM appointments a
         JOIN patients p
              ON a.patient_id = p.patient_id
         JOIN doctors d
              ON a.doctor_id = d.doctor_id
         JOIN doctor_specializations ds
              ON d.doctor_id = ds.doctor_id
         JOIN specializations s
              ON ds.specialization_id = s.specialization_id;
DESC patients;
DESC doctors;
DESC appointments;










DELIMITER //

CREATE PROCEDURE BookAppointment(
    IN p_patient_id INT,
    IN p_doctor_id INT,
    IN p_date DATETIME
)
BEGIN

    INSERT INTO appointments
    (patient_id, doctor_id, appointment_date)
    VALUES
        (p_patient_id, p_doctor_id, p_date);

END //

DELIMITER ;

CALL BookAppointment(1,1,'2026-08-10 10:00:00');



DELIMITER //

CREATE PROCEDURE GetAppointmentCount(
    OUT total INT
)
BEGIN

    SELECT COUNT(*) INTO total
    FROM appointments;

END //

DELIMITER ;

CALL GetAppointmentCount(@total);

SELECT @total;


DELIMITER //

CREATE PROCEDURE IncreaseAmount(
    INOUT amount DECIMAL(10,2)
)
BEGIN

    SET amount = amount + 500;

END //

DELIMITER ;

SET @bill = 1000;

CALL IncreaseAmount(@bill);

SELECT @bill;




DELIMITER //

CREATE TRIGGER after_appointment_insert
    AFTER INSERT
    ON appointments
    FOR EACH ROW
BEGIN

    INSERT INTO visit_history
    (appointment_id, notes, visit_date)
    VALUES
        (NEW.appointment_id,
         'New Appointment Created',
         NOW());

END //

DELIMITER ;


DELIMITER //

CREATE TRIGGER before_appointment_update
    BEFORE UPDATE
    ON appointments
    FOR EACH ROW
BEGIN

    IF NEW.status IS NULL THEN
        SET NEW.status='Scheduled';

    END IF;

END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER after_appointment_update
    AFTER UPDATE
    ON appointments
    FOR EACH ROW
BEGIN

    INSERT INTO visit_history
    (appointment_id, notes, visit_date)
    VALUES
        (NEW.appointment_id,
         'Appointment Updated',
         NOW());

END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER before_appointment_delete
    BEFORE DELETE
    ON appointments
    FOR EACH ROW
BEGIN

    INSERT INTO visit_history
    (appointment_id, notes, visit_date)
    VALUES
        (OLD.appointment_id,
         'Appointment Deleted',
         NOW());

END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER after_appointment_delete
    AFTER DELETE
    ON appointments
    FOR EACH ROW
BEGIN

    INSERT INTO visit_history
    (appointment_id, notes, visit_date)
    VALUES
        (OLD.appointment_id,
         'Delete Completed',
         NOW());

END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE SafeBookAppointment(
    IN p_patient_id INT,
    IN p_doctor_id INT,
    IN p_date DATETIME
)
BEGIN

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
            SELECT 'Error: Appointment booking failed' AS message;
        END;


    START TRANSACTION;

    INSERT INTO appointments
    (patient_id, doctor_id, appointment_date, status)
    VALUES
        (p_patient_id, p_doctor_id, p_date, 'Scheduled');

    COMMIT;

    SELECT 'Appointment booked successfully' AS message;

END //

DELIMITER ;


CALL SafeBookAppointment(1,1,'2026-08-10 10:00:00');

DELIMITER //

CREATE TRIGGER before_appointment_insert
    BEFORE INSERT ON appointments
    FOR EACH ROW
BEGIN

    IF NEW.appointment_date < NOW() THEN

        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT='Cannot book appointment in the past';

    END IF;

END //

DELIMITER ;


INSERT INTO appointments
(patient_id,doctor_id,appointment_date,status)
VALUES
    (1,1,'2020-01-01 10:00:00','Scheduled');



DELIMITER //

CREATE TRIGGER after_appointment_insert
    AFTER INSERT ON appointments
    FOR EACH ROW
BEGIN

    INSERT INTO visit_history
    (
        appointment_id,
        visit_notes
    )
    VALUES
        (
            NEW.appointment_id,
            'Appointment Created'
        );

END //

DELIMITER ;

DESC visit_history;
DROP TRIGGER after_appointment_insert;
INSERT INTO appointments
(patient_id, doctor_id, appointment_date, status)
VALUES
    (1,1,'2026-08-15 11:00:00','Scheduled');

SELECT * FROM visit_history;

ALTER TABLE visit_history
    ADD visit_date DATETIME DEFAULT CURRENT_TIMESTAMP;





DESC billing;

DROP TRIGGER IF EXISTS before_billing_update;
DELIMITER //

CREATE TRIGGER before_billing_update
    BEFORE UPDATE ON billing
    FOR EACH ROW
BEGIN

    IF NEW.payment_status = 'Paid'
        AND OLD.payment_status != 'Paid'
    THEN

        SET NEW.billing_date = NOW();

    END IF;

END //

DELIMITER ;DELIMITER //

CREATE TRIGGER before_billing_update
    BEFORE UPDATE ON billing
    FOR EACH ROW
BEGIN

    IF NEW.payment_status = 'Paid'
        AND OLD.payment_status != 'Paid'
    THEN

        SET NEW.billing_date = NOW();

    END IF;

END //

DELIMITER ;

SELECT * FROM billing;



DELIMITER //

CREATE TRIGGER before_patient_delete
    BEFORE DELETE ON patients
    FOR EACH ROW
BEGIN

    IF EXISTS
        (
            SELECT 1
            FROM appointments
            WHERE patient_id=OLD.patient_id
              AND status='Scheduled'
        )
    THEN

        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT='Cannot delete patient with active appointment';

    END IF;

END //

DELIMITER ;

DELETE FROM patients
WHERE patient_id=1;


CREATE TABLE deleted_patients_archive
(
    patient_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    deleted_at TIMESTAMP
);

DELIMITER //

CREATE TRIGGER after_patient_delete
    AFTER DELETE ON patients
    FOR EACH ROW
BEGIN

    INSERT INTO deleted_patients_archive
    VALUES
        (
            OLD.patient_id,
            OLD.first_name,
            OLD.last_name,
            NOW()
        );

END //

DELIMITER ;