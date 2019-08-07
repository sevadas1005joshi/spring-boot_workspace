DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS ADDRESS;

CREATE TABLE EMPLOYEE (
 `id` varchar(20) NOT NULL,
 `name` varchar(200) NOT NULL,
 `age` INT(100) NOT NULL,
 `gender` varchar(200) NOT NULL,
 `serial_Id` varchar(200) NOT NULL,
 `date_of_birth` TIMESTAMP,
 `last_updated` TIMESTAMP,
 PRIMARY KEY (`id`)
);

CREATE TABLE ADDRESS (
 `id` INT(20) NOT NULL,
 `city` varchar(200) NOT NULL,
 `state` varchar(100) NOT NULL,
 `pin` INT(20) NOT NULL,
 `employee_id` varchar(200) NOT NULL,
 PRIMARY KEY (`id`),
 FOREIGN KEY (`employee_id`) references EMPLOYEE(`id`)

);
