INSERT INTO EMPLOYEE (id, name, age, gender,serial_Id, date_of_birth, last_updated) VALUES
('EMP21', 'Raj', 38, 'F', 'AR12321', TIMESTAMP('1988-10-28','yyyy-MM-dd'), TIMESTAMP '2019-10-13 10:35:24.076'),
('EMP22', 'Nisha', 38, 'M', 'AR12322', TIMESTAMP('1987-09-11','yyyy-MM-dd'), TIMESTAMP '2019-10-13 10:35:24.076'),
('EMP23', 'Alia', 38, 'M', 'AR12323', TIMESTAMP('1990-08-14','yyyy-MM-dd'), TIMESTAMP '2019-10-13 10:35:24.076');


INSERT INTO ADDRESS (id, city, state, pin,employee_id) VALUES
(101, 'BNG', 'KAR', 560037,'EMP22'),
(102, 'KWD', 'CHH', 491446,'EMP22'),
(103, 'PUN', 'MAH', 254776,'EMP22');
