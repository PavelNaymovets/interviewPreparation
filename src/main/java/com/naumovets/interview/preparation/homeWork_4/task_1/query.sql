#MySQL

#Создаю БД cinema
CREATE SCHEMA cinema ;

#Переключаюсь на БД cinema
USE cinema

#Создаю таблицу movie
CREATE TABLE cinema.movie (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
duration INT NOT NULL,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

#Создаю таблицу session
CREATE TABLE cinema.session (
id INT NOT NULL AUTO_INCREMENT,
movie_id INT NOT NULL,
start_time TIME NULL,
show_date DATE NULL,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE INDEX `movie_id_UNIQUE` (`movie_id` ASC) VISIBLE);

#Создаю таблицу ticket
CREATE TABLE cinema.ticket (
id INT NOT NULL AUTO_INCREMENT,
session_id INT NOT NULL,
price INT NOT NULL,
is_bouth TINYINT NOT NULL DEFAULT 0,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE INDEX `session_id_UNIQUE` (`session_id` ASC) VISIBLE);

#Добавляю внешний ключ таблице session
ALTER TABLE `cinema`.`session` 
ADD CONSTRAINT `session_movie_fk_1`
  FOREIGN KEY (`movie_id`)
  REFERENCES `cinema`.`movie` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

#Добавляю внешний ключ таблице ticket
ALTER TABLE `cinema`.`ticket` 
ADD CONSTRAINT `ticket_session_fk_1`
  FOREIGN KEY (`session_id`)
  REFERENCES `cinema`.`session` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

#Наполняю таблицу movie данными
INSERT INTO cinema.movie(name, duration) VALUES('Превосходство Борна', 108);
INSERT INTO cinema.movie(name, duration) VALUES('Анна', 100);
INSERT INTO cinema.movie(name, duration) VALUES('Выкрутасы', 110);
INSERT INTO cinema.movie(name, duration) VALUES('Хардкор', 90);
INSERT INTO cinema.movie(name, duration) VALUES('Плутоний-239', 97);

#Добавляю в таблицу session столбец с длительностью перерыва
ALTER TABLE `cinema`.`session` 
ADD COLUMN `break` INT NOT NULL AFTER `created_at`,
CHANGE COLUMN `start_time` `start_time` TIME NULL ,
CHANGE COLUMN `show_date` `show_date` DATE NULL ;

#Меняю в таблице session расположение столбца break
ALTER TABLE `cinema`.`session` 
CHANGE COLUMN `break` `break` INT NOT NULL AFTER `start_time`;

#Наполняю таблицу session данными
INSERT INTO `cinema`.`session`(`movie_id`,`start_time`, `break`,`show_date`) VALUES(1,'10:00', 40, '2023-02-01');
INSERT INTO `cinema`.`session`(`movie_id`,`start_time`, `break`,`show_date`) VALUES(2,'11:00', 30, '2023-02-01');
INSERT INTO `cinema`.`session`(`movie_id`,`start_time`, `break`,`show_date`) VALUES(3,'13:00', 50, '2023-02-01');
INSERT INTO `cinema`.`session`(`movie_id`,`start_time`, `break`,`show_date`) VALUES(4,'16:40', 10, '2023-02-01');
INSERT INTO `cinema`.`session`(`movie_id`,`start_time`, `break`,`show_date`) VALUES(5,'18:20', 35, '2023-02-01');

#Наполняю таблицу ticket данными
INSERT INTO `cinema`.`ticket`(`session_id`,`price`) VALUES(1, 100);
INSERT INTO `cinema`.`ticket`(`session_id`,`price`,`is_bouth`) VALUES(1, 100, 1);
INSERT INTO `cinema`.`ticket`(`session_id`,`price`) VALUES(2, 90);
INSERT INTO `cinema`.`ticket`(`session_id`,`price`,`is_bouth`) VALUES(2, 90, 1);
INSERT INTO `cinema`.`ticket`(`session_id`,`price`) VALUES(3, 110);
INSERT INTO `cinema`.`ticket`(`session_id`,`price`,`is_bouth`) VALUES(3, 110, 1);
INSERT INTO `cinema`.`ticket`(`session_id`,`price`) VALUES(4, 50);
INSERT INTO `cinema`.`ticket`(`session_id`,`price`,`is_bouth`) VALUES(4, 50, 1);
INSERT INTO `cinema`.`ticket`(`session_id`,`price`) VALUES(5, 80);
INSERT INTO `cinema`.`ticket`(`session_id`,`price`,`is_bouth`) VALUES(5, 80, 1);

#Запрос выводящий ошибки в расписании
SELECT
  name,
  start_time,
  duration
FROM session
  JOIN movie
    ON session.movie_id = movie.id
ORDER BY start_time ASC;

#Запрос выводящий перерывы 30 минут и более между фильмами
SELECT
  name,
  start_time,
  break
FROM session
  JOIN movie
    ON session.movie_id = movie.id
ORDER BY break DESC;
