`cod_produs`CREATE DATABASE IF NOT EXISTS proiect;

USE proiect;

DROP TABLE IF EXISTS componente_pc;

CREATE TABLE `componente_pc` (
`cod_produs` INT(11) NOT NULL AUTO_INCREMENT,
`marca` VARCHAR(45) NOT NULL,
`garantie` VARCHAR(45) NOT NULL,
`an_fabricatie` VARCHAR(45) NOT NULL,
`tara_provenienta` VARCHAR(45) NOT NULL,
`producator` VARCHAR(45) NOT NULL,
`pret` VARCHAR (45) NOT NULL,
`stoc` INT(10) NOT NULL,
PRIMARY KEY (`cod_produs`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;