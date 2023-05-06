DROP TABLE IF EXISTS student;
CREATE TABLE `students`.`student` (`id` INT NOT NULL AUTO_INCREMENT,`name` VARCHAR(255) NULL,`mark` INT NULL,PRIMARY KEY (`id`));
INSERT INTO student (name, mark) VALUES ('Ivanov', 5), ('Petrov', 5), ('Sidorov', 5);