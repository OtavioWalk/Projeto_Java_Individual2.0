create database java;
use java;
-- drop database java;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE registro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sistemaOperacional VARCHAR(255),
    fabricante VARCHAR(255),
    arquitetura VARCHAR(255),
    inicializado DATETIME,
    nome VARCHAR(255)
);

insert into usuarios values (null, "Otávio", "1234"),(null, "Ana", "4321");

select * from usuarios;
select * from registro;
