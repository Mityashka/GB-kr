Задание 1
Создать файлы и заполнить их данными:
echo -e "Собака\nКошка\nХомяк" > Домашние_животные.txt
echo -e "Лошадь\nВерблюд\nОсел" > Вьючные_животные.txt

Объединить файлы и просмотреть результат:
cat Домашние_животные.txt Вьючные_животные.txt > Все_животные.txt
cat Все_животные.txt

Переименовать файл:
mv Все_животные.txt Друзья_человека.txt

Задание 2
Создать директорию и переместить файл:
mkdir Мои_животные
mv Друзья_человека.txt Мои_животные

Задание 3
Подключить репозиторий MySQL и установить пакет:
sudo apt update
sudo apt install -y wget
wget https://dev.mysql.com/get/mysql-apt-config_0.8.13-1_all.deb
sudo dpkg -i mysql-apt-config_0.8.13-1_all.deb
sudo apt update
sudo apt install -y mysql-server

Задание 4
Установка и удаление deb-пакета с помощью dpkg:
sudo dpkg -i mysql-apt-config_0.8.13-1_all.deb
sudo dpkg -r mysql-apt-config

Задание 5
Сохранить историю команд:
history > history.txt

Задание 6
![Снимок экрана 2024-10-27 101848](https://github.com/user-attachments/assets/f70ff24b-9b4c-4d61-b63e-64f8bfeabc77)


Задание 7
Создать базу данных в MySQL:
CREATE DATABASE Друзья_человека;

Задание 8
Создать таблицы с иерархией:
USE Друзья_человека;

CREATE TABLE Животные (
    id INT AUTO_INCREMENT PRIMARY KEY,
    имя VARCHAR(50),
    дата_рождения DATE
);

CREATE TABLE Домашние_животные (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Животные(id)
);

CREATE TABLE Вьючные_животные (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Животные(id)
);

CREATE TABLE Собаки (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Домашние_животные(id)
);

CREATE TABLE Кошки (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Домашние_животные(id)
);

CREATE TABLE Хомяки (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Домашние_животные(id)
);

CREATE TABLE Лошади (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Вьючные_животные(id)
);

CREATE TABLE Верблюды (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Вьючные_животные(id)
);

CREATE TABLE Ослы (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Вьючные_животные(id)
);

Задание 9
Заполнить таблицы данными:
INSERT INTO Животные (имя, дата_рождения) VALUES ('Шарик', '2022-05-15');
INSERT INTO Домашние_животные (id) VALUES (1);
INSERT INTO Собаки (id) VALUES (1);

INSERT INTO Животные (имя, дата_рождения) VALUES ('Мурка', '2021-09-10');
INSERT INTO Домашние_животные (id) VALUES (2);
INSERT INTO Кошки (id) VALUES (2);

INSERT INTO Животные (имя, дата_рождения) VALUES ('Верблюд1', '2019-07-23');
INSERT INTO Вьючные_животные (id) VALUES (3);
INSERT INTO Верблюды (id) VALUES (3);

Задание 10
Удалить всех верблюдов и объединить таблицы лошадей и ослов:
DELETE FROM Верблюды;

CREATE TABLE Лошади_Ослы AS
SELECT * FROM Лошади
UNION ALL
SELECT * FROM Ослы;

Задание 11
Создать таблицу "Молодые животные":
CREATE TABLE Молодые_животные AS
SELECT *, TIMESTAMPDIFF(MONTH, дата_рождения, CURDATE()) AS возраст_в_месяцах
FROM Животные
WHERE TIMESTAMPDIFF(YEAR, дата_рождения, CURDATE()) BETWEEN 1 AND 3;

Задание 12
Объединить все таблицы в одну, сохраняя принадлежность:
CREATE TABLE Все_животные AS
SELECT *, 'Собака' AS принадлежность FROM Собаки
UNION ALL
SELECT *, 'Кошка' AS принадлежность FROM Кошки
UNION ALL
SELECT *, 'Хомяк' AS принадлежность FROM Хомяки
UNION ALL
SELECT *, 'Лошадь' AS принадлежность FROM Лошади
UNION ALL
SELECT *, 'Осел' AS принадлежность FROM Ослы;
