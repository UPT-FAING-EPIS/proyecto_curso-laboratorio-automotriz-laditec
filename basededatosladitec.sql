-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.24-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para dbladitec
CREATE DATABASE IF NOT EXISTS `dbladitec` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `dbladitec`;

-- Volcando estructura para tabla dbladitec.tbalmacen
CREATE TABLE IF NOT EXISTS `tbalmacen` (
  `idalmacen` int(11) NOT NULL COMMENT 'Es la llave primaria que sirve para identificar los registros siendo su tipo de datos int de longitud 11',
  `nomalamcen` varchar(50) DEFAULT NULL COMMENT 'sirve para asignarles un nombre a los registros dentro de la tabla siendo su tipo de datos varchar de longitud 50',
  PRIMARY KEY (`idalmacen`) USING BTREE COMMENT 'Indica las llaves primarias'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbalmacen: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tbalmacen` DISABLE KEYS */;
INSERT INTO `tbalmacen` (`idalmacen`, `nomalamcen`) VALUES
	(1, 'Principal'),
	(2, 'Secundario');
/*!40000 ALTER TABLE `tbalmacen` ENABLE KEYS */;

-- Volcando estructura para tabla dbladitec.tbboletaventa
CREATE TABLE IF NOT EXISTS `tbboletaventa` (
  `nroboleta` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria que sirve para identificar los registros segun su numero siendo su tipo de datos int de longitud 11',
  `serieboleta` varchar(50) NOT NULL DEFAULT '' COMMENT 'llave primaria que sirve para identificar los registros segun su serie siendo su tipo de datos varchar de longitud 50',
  `fkidpedido` int(11) DEFAULT NULL COMMENT 'sirve para identificar los registros que se conectan de manera foranea con la tabla tbpedidoventa siendo su tipo de datos int de longitud 11',
  `fechaemision` date DEFAULT NULL COMMENT 'sirve para identificar las fechas de emision de los registros siendo su tipo de datos date',
  `total` double DEFAULT NULL COMMENT 'sirve para identificar los montos totales de los registros siendo su tipo de datos double',
  `impuesto` double DEFAULT NULL COMMENT 'sirve para identificar los montos totales de impuesto de los registros siendo su tipo de datos double',
  PRIMARY KEY (`nroboleta`,`serieboleta`) USING BTREE COMMENT 'Indica las llaves primarias',
  KEY `FK_tbboletaventa_tbpedidoventa` (`fkidpedido`) USING BTREE COMMENT 'Indica la relacion con la tabla tbpedidoventa',
  CONSTRAINT `FK_tbboletaventa_tbpedidoventa` FOREIGN KEY (`fkidpedido`) REFERENCES `tbpedidoventa` (`idpedidoventa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbboletaventa: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `tbboletaventa` DISABLE KEYS */;
INSERT INTO `tbboletaventa` (`nroboleta`, `serieboleta`, `fkidpedido`, `fechaemision`, `total`, `impuesto`) VALUES
	(29, 'EB-202211', 36, '2022-11-26', 182, 32.76),
	(30, 'EB-202211', 37, '2022-11-26', 400, 72),
	(31, 'EB-202211', 38, '2022-11-26', 615, 110.7),
	(32, 'EB-202211', 39, '2022-11-26', 41, 7.38),
	(34, 'EB-202211', 42, '2022-11-27', 400, 72),
	(35, 'EB-202211', 43, '2022-11-28', 1170, 210.6),
	(36, 'EB-202211', 44, '2022-11-28', 330, 59.4),
	(39, 'EB-202211', 48, '2022-11-28', 300, 54),
	(40, 'EB-202211', 49, '2022-11-28', 200, 36),
	(41, 'EB-202211', 50, '2022-11-28', 625, 112.5),
	(42, 'EB-202211', 52, '2022-11-30', 300, 54),
	(43, 'EB-202211', 53, '2022-11-30', 150, 27),
	(51, 'EB-202211', 61, '2022-11-30', 150, 27),
	(52, 'EB-202211', 62, '2022-11-30', 250, 45);
/*!40000 ALTER TABLE `tbboletaventa` ENABLE KEYS */;

-- Volcando estructura para tabla dbladitec.tbcategoria
CREATE TABLE IF NOT EXISTS `tbcategoria` (
  `idcategoria` int(11) NOT NULL COMMENT 'llave primaria que sirve para identificar los registros siendo su tipo de datos int de longitud 11',
  `nomcategoria` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar los nombres de los registros siendo su tipo de datos varchar de longitud 50',
  PRIMARY KEY (`idcategoria`) USING BTREE COMMENT 'Indica las llaves primarias'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbcategoria: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `tbcategoria` DISABLE KEYS */;
INSERT INTO `tbcategoria` (`idcategoria`, `nomcategoria`) VALUES
	(1, 'Nissan'),
	(2, 'Mitsubishi'),
	(3, 'Toyota');
/*!40000 ALTER TABLE `tbcategoria` ENABLE KEYS */;

-- Volcando estructura para tabla dbladitec.tbcomentario
CREATE TABLE IF NOT EXISTS `tbcomentario` (
  `idcomentario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria que sirve para identificar los registros siendo su tipo de datos int de longitud 11',
  `nombre` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar el nombre de los registros siendo su tipo de dato varchar de longitud 50',
  `descripcion` text DEFAULT NULL COMMENT 'sirve para identificar el comentario en los registros siendo su tipo de dato Text',
  `calificacion` int(11) DEFAULT NULL COMMENT 'sirve para identificar la calificación de los registros siendo su tipo de dato int de longitud 50',
  PRIMARY KEY (`idcomentario`) USING BTREE COMMENT 'Indica las llaves primarias'
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbcomentario: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `tbcomentario` DISABLE KEYS */;
INSERT INTO `tbcomentario` (`idcomentario`, `nombre`, `descripcion`, `calificacion`) VALUES
	(7, 'miguel', 'productos A1', 5),
	(8, 'James', 'Buen Servicio', 5),
	(9, 'James', 'Buen Servicios', 5),
	(11, 'pedro', 'buena seguridad', 3),
	(12, 'erick', 'estuvo muy divertido', 5),
	(13, 'asd', 'Buen Servicio', 4),
	(16, 'Elard', 'Buen Servicio', 4),
	(17, 'james', 'Buen Servicio', 4);
/*!40000 ALTER TABLE `tbcomentario` ENABLE KEYS */;

-- Volcando estructura para tabla dbladitec.tbdetalledeboleta
CREATE TABLE IF NOT EXISTS `tbdetalledeboleta` (
  `iddetalleboleta` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria que sirve para identificar los registros siendo su tipo de datos int de longitud 11',
  `fknroboleta` int(11) DEFAULT NULL COMMENT 'sirve para identificar los registros foraneos de la tabla tbboletaventa segun su numero siendo su tipo de datos int de longitud 11',
  `fkserieboleta` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar los registros foraneos de la tabla tbboletaventa segun su serie siendo su tipo de datos varchar de longitud 50',
  `fkidrepuesto` int(11) DEFAULT NULL COMMENT 'sirve para identificar los registros foraneos de la tabla tbrepuesto segun su id siendo su tipo de datos int de longitud 11',
  `cantidad` int(11) DEFAULT NULL COMMENT 'sirve para identificar las cantidades que compro en los registros siendo su tipo de datos int de longitud 11',
  `importe` double DEFAULT NULL COMMENT 'sirve para identificar el importe pagado por el producto que compro en los registros siendo su tipo de datos double',
  PRIMARY KEY (`iddetalleboleta`) USING BTREE COMMENT 'Indica las llaves primarias',
  KEY `FK_tbdetalledeboleta_tbboletaventa` (`fknroboleta`,`fkserieboleta`),
  KEY `FK_tbdetalledeboleta_tbrepuesto` (`fkidrepuesto`),
  CONSTRAINT `FK_tbdetalledeboleta_tbboletaventa` FOREIGN KEY (`fknroboleta`, `fkserieboleta`) REFERENCES `tbboletaventa` (`nroboleta`, `serieboleta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbdetalledeboleta_tbrepuesto` FOREIGN KEY (`fkidrepuesto`) REFERENCES `tbrepuesto` (`idrepuesto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbdetalledeboleta: ~30 rows (aproximadamente)
/*!40000 ALTER TABLE `tbdetalledeboleta` DISABLE KEYS */;
INSERT INTO `tbdetalledeboleta` (`iddetalleboleta`, `fknroboleta`, `fkserieboleta`, `fkidrepuesto`, `cantidad`, `importe`) VALUES
	(38, 29, 'EB-202211', 2, 1, 100),
	(39, 29, 'EB-202211', 1, 2, 82),
	(40, 30, 'EB-202211', 3, 2, 400),
	(41, 31, 'EB-202211', 1, 15, 615),
	(42, 32, 'EB-202211', 1, 1, 41),
	(43, 34, 'EB-202211', 3, 1, 200),
	(44, 34, 'EB-202211', 2, 1, 100),
	(45, 34, 'EB-202211', 5, 1, 100),
	(46, 35, 'EB-202211', 1, 4, 720),
	(47, 35, 'EB-202211', 5, 2, 200),
	(48, 35, 'EB-202211', 3, 1, 150),
	(49, 35, 'EB-202211', 6, 1, 50),
	(50, 35, 'EB-202211', 7, 1, 50),
	(51, 36, 'EB-202211', 1, 1, 180),
	(52, 36, 'EB-202211', 3, 1, 150),
	(53, 36, 'EB-202211', 2, 2, 200),
	(55, 39, 'EB-202211', 2, 3, 300),
	(56, 40, 'EB-202211', 2, 2, 200),
	(57, 41, 'EB-202211', 3, 2, 300),
	(58, 41, 'EB-202211', 2, 1, 100),
	(59, 41, 'EB-202211', 1, 1, 180),
	(60, 41, 'EB-202211', 8, 1, 45),
	(61, 42, 'EB-202211', 3, 2, 300),
	(62, 43, 'EB-202211', 5, 1, 100),
	(63, 43, 'EB-202211', 6, 1, 50),
	(68, 51, 'EB-202211', 3, 1, 150),
	(69, 52, 'EB-202211', 3, 1, 150),
	(70, 52, 'EB-202211', 2, 1, 100);
/*!40000 ALTER TABLE `tbdetalledeboleta` ENABLE KEYS */;

-- Volcando estructura para tabla dbladitec.tbestado
CREATE TABLE IF NOT EXISTS `tbestado` (
  `idestado` int(11) NOT NULL COMMENT 'llave primaria que sirve para identificar los registros siendo su tipo de datos int de longitud 11',
  `nomestado` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar el nombre de los registros siendo su tipo de datos varchar de longitud 50',
  PRIMARY KEY (`idestado`) USING BTREE COMMENT 'Indica las llaves primarias'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbestado: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `tbestado` DISABLE KEYS */;
INSERT INTO `tbestado` (`idestado`, `nomestado`) VALUES
	(1, 'bien'),
	(2, 'mal');
/*!40000 ALTER TABLE `tbestado` ENABLE KEYS */;

-- Volcando estructura para tabla dbladitec.tbpedidoventa
CREATE TABLE IF NOT EXISTS `tbpedidoventa` (
  `idpedidoventa` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria que sirve para identificar los registros siendo su tipo de datos int de longitud 11',
  `fkidusuario` int(11) DEFAULT NULL COMMENT 'sirve para identificar los registros foraneos de la tabla tbusuario segun el id siendo su tipo de datos int de longitud 11',
  `fecha` date DEFAULT NULL COMMENT 'sirve para identificar las fechas de creación de los registros siendo su tipo de datos date',
  `estado` varchar(1) DEFAULT NULL COMMENT 'sirve para identificar el estado de los registros siendo su tipo de datos varchar de longitud 1 (''A'' o ''I'')',
  `txrid` text DEFAULT NULL COMMENT 'sirve para identificar el txrid en la blockchain de los registros siendo su tipo de datos text',
  `lacchainid` text DEFAULT '0x' COMMENT 'sirve para identificar su chainid en la blockchain de los registros siendo su tipo de datos text',
  `hash` text DEFAULT NULL COMMENT 'sirve para identificar el hash en la blockchain de los registros siendo su tipo de datos text',
  PRIMARY KEY (`idpedidoventa`) USING BTREE COMMENT 'Indica las llaves primarias',
  KEY `FK_tbpedidoventa_tbusuario` (`fkidusuario`) USING BTREE COMMENT 'Indica la relacion con la tabla tbusuario',
  CONSTRAINT `FK_tbpedidoventa_tbusuario` FOREIGN KEY (`fkidusuario`) REFERENCES `tbusuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbpedidoventa: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `tbpedidoventa` DISABLE KEYS */;
INSERT INTO `tbpedidoventa` (`idpedidoventa`, `fkidusuario`, `fecha`, `estado`, `txrid`, `lacchainid`, `hash`) VALUES
	(36, 5, '2022-11-26', 'I', 'c310e623afed134e5a288add747b41fd351be5f5', '0x', '0xa833234bf6557d7298f709626b93269ca00bb4b8d6245b2ca3eec9aa06bd3bff'),
	(37, 5, '2022-11-26', 'A', '5c554c99a19e7b33babea600f9d1696d938528e2', '0x', '0x9aa57ecb3d3e817eef3663f2abac78c78048d22ee823086fed82edaf48207b0f'),
	(38, 4, '2022-11-26', 'A', '1b81e4c044d3ae1bd107a25f084bda12a587e266', '0x', '0x7bbe3f9a842e8b489388426680f0125e931ec96aff2f2fb678b5d9f51cac10b4'),
	(39, 5, '2022-11-26', 'A', 'e84ecd5ad5b2389060292249159fbd2c18a4261e', '0x', '0x288e6410c5f4f9991c77b16529155927d0baa291fb82bed6f14ed01688410b22'),
	(42, 5, '2022-11-27', 'A', 'f178730b863a8b5fb709ae836e3aa588b5751dfa', '0x', '0x8b9cec0e85b5844ede9b491e3ddfa72c90f06612e8bf52ed10376183714cb943'),
	(43, 5, '2022-11-28', 'A', '57190f7c5480067fcf3e826d1688a1807673bfaa', '0x', '0xba7f01c980eb3f10917a63e0f295f1f00683859ecfdea6bb1acaf195a7d2728d'),
	(44, 19, '2022-11-28', 'A', '53f2110a18d4e96975cbf826d68305c3a68759a1', '0x', '0xe158ebe4bf1027c95f279aa75b8129684abaa0b73715a29c30be503cb39d8d7e'),
	(48, 5, '2022-11-28', 'A', 'cc24773e0eb84b356bcaf9edfc208f08f3374ba5', '0x', '0xa9576191fc98ad5e18831b997bf2b1401d63df4eb780177575c6f01838a58212'),
	(49, 1, '2022-11-28', 'A', '48b4f65125d80c6782da0e99ba7d9d0a347725a6', '0x', '0xad52ea9e8a858c8a811a921dfdea4a127a35f54203e0ccce28bbf11304fc3393'),
	(50, 21, '2022-11-28', 'A', '9c86283cfb6fc704e70dacff2a1644d215ecd042', '0x', '0x3eaceffcb0d06c1d70b4ef19fae12b5fa7543c6a70a6992471c9c56edda60f2d'),
	(52, 5, '2022-11-30', 'A', '567db32dd8fe8074ed336d9bd1e21eb0b3ce2137', '0x', '0xfb6e3c07e39d33bb93f5c243b2bd9c30e67f2b15be21eb9fa57f9d9c2a979c63'),
	(53, 5, '2022-11-30', 'A', 'a5e2a5e40d354cd40667271e868781dc2e512e05', '0x', '0x686445b87979751ff7dba50ecb4b0ab0dc4679d12c32eab14cc0976bc7c0d15c'),
	(61, 5, '2022-11-30', 'A', '5c78623bc46a0493dfd00bfa9268895df1bcb827', '0x', '0x60eaa64a18b1a936f63493547176bdac7e57e15728ce84a91fbe0e17f4e568c0'),
	(62, 1, '2022-11-30', 'A', '20f85b65847ec738419b6aa2e0546b7d4a90861d', '0x', '0x3ce0916f16e454d146328c14a11d4a77237231802ceb88c0491f5fe621a262c0');
/*!40000 ALTER TABLE `tbpedidoventa` ENABLE KEYS */;

-- Volcando estructura para tabla dbladitec.tbrepuesto
CREATE TABLE IF NOT EXISTS `tbrepuesto` (
  `idrepuesto` int(11) NOT NULL COMMENT 'llave primaria que sirve para identificar los registros siendo su tipo de datos int de longitud 11',
  `fkidalmacen` int(11) DEFAULT NULL COMMENT 'sirve para identificar los registros que se conectan de manera foranea con la tabla tbalmacen siendo su tipo de datos int de longitud 11',
  `fkidestado` int(11) DEFAULT NULL COMMENT 'sirve para identificar los registros que se conectan de manera foranea con la tabla tbestado siendo su tipo de datos int de longitud 11',
  `nombre` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar los nombres de los registros siendo su tipo de datos varchar de longitud 50',
  `fkidcategoria` int(11) DEFAULT NULL COMMENT 'sirve para identificar los registros que se conectan de manera foranea con la tabla tbcategoria siendo su tipo de datos int de longitud 11',
  `imagen` text DEFAULT NULL COMMENT 'sirve para identificar el tipo de formato de imagen que tienen los registros siendo su tipo de datos text',
  `preciounitario` double DEFAULT NULL COMMENT 'sirve para identificar el preciounitario de  los registros siendo su tipo de datos double',
  `Cantidad` int(11) DEFAULT NULL COMMENT 'sirve para identificar el Cantidad de  los registros siendo su tipo de datos int con una longitud de 11',
  PRIMARY KEY (`idrepuesto`) USING BTREE COMMENT 'Indica las llaves primarias',
  KEY `FK_tbrepuesto_tb_almacen` (`fkidalmacen`) USING BTREE COMMENT 'Indica la relacion con la tabla tbalmacen',
  KEY `FK_tbrepuesto_tbestado` (`fkidestado`) USING BTREE COMMENT 'Indica la relacion con la tabla tbestado',
  KEY `FK_tbrepuesto_tbcategoria` (`fkidcategoria`) USING BTREE COMMENT 'Indica la relacion con la tabla tbcategoria',
  CONSTRAINT `FK_tbrepuesto_tb_almacen` FOREIGN KEY (`fkidalmacen`) REFERENCES `tbalmacen` (`idalmacen`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbrepuesto_tbcategoria` FOREIGN KEY (`fkidcategoria`) REFERENCES `tbcategoria` (`idcategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tbrepuesto_tbestado` FOREIGN KEY (`fkidestado`) REFERENCES `tbestado` (`idestado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbrepuesto: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `tbrepuesto` DISABLE KEYS */;
INSERT INTO `tbrepuesto` (`idrepuesto`, `fkidalmacen`, `fkidestado`, `nombre`, `fkidcategoria`, `imagen`, `preciounitario`, `Cantidad`) VALUES
	(1, 1, 1, 'Juego de 4 piezas de inyectores - Nissan', 1, 'png   ', 180, 9),
	(2, 1, 1, 'Bobina Byd F3 - Mitsubishi', 2, 'png', 100, 24),
	(3, 1, 1, 'Sensor de posición de pulso de cigüeñal - Nissan', 1, 'png ', 150, 16),
	(4, 1, 1, 'TEX-11-103 / BOBINA NISSAN VERSA X-TRAIL', 1, 'png', 70, 15),
	(5, 1, 1, 'valvula Para Inyector Mitsubishi L200 4d56 4m41,', 2, 'png ', 100, 17),
	(6, 2, 1, 'Manivela del motor del Sensor de posición del cigü', 2, 'png ', 50, 14),
	(7, 1, 1, 'inyectores de combustible 23250-75050 23209-79095 ', 3, 'png', 50, 14),
	(8, 1, 1, 'Sensor De Velocidad Toyota Corolla', 3, 'png', 45, 53);
/*!40000 ALTER TABLE `tbrepuesto` ENABLE KEYS */;

-- Volcando estructura para tabla dbladitec.tbrol
CREATE TABLE IF NOT EXISTS `tbrol` (
  `idrol` int(11) NOT NULL COMMENT 'llave primaria que sirve para identificar los registros siendo su tipo de datos int de longitud 11',
  `nomrol` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar los nombres de los registros siendo su tipo de datos varchar de longitud 50',
  PRIMARY KEY (`idrol`) USING BTREE COMMENT 'Indica las llaves primarias'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbrol: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tbrol` DISABLE KEYS */;
INSERT INTO `tbrol` (`idrol`, `nomrol`) VALUES
	(1, 'Visitante'),
	(2, 'admin');
/*!40000 ALTER TABLE `tbrol` ENABLE KEYS */;

-- Volcando estructura para tabla dbladitec.tbusuario
CREATE TABLE IF NOT EXISTS `tbusuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria que sirve para identificar los registros siendo su tipo de datos int de longitud 11',
  `nomusuario` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar los nombres de los registros siendo su tipo de datos varchar de longitud 50',
  `email` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar los emails de los registros siendo su tipo de datos varchar de longitud 50',
  `clave` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar las claves de los registros siendo su tipo de datos varchar de longitud 50',
  `fkidrol` int(11) DEFAULT NULL COMMENT 'sirve para identificar los registros que se conectan de manera foranea con la tabla tbrol siendo su tipo de datos int de longitud 11',
  `estado` varchar(50) DEFAULT NULL COMMENT 'sirve para identificar los estado de los registros siendo su tipo de datos varchar de longitud 50',
  `bloqueos` int(11) DEFAULT 0 COMMENT 'sirve para identificar los bloqueos de los registros siendo su tipo de datos int de longitud 11',
  `intentos` int(11) DEFAULT 0 COMMENT 'sirve para identificar los intentos de los registros siendo su tipo de datos int de longitud 11',
  PRIMARY KEY (`idusuario`) USING BTREE COMMENT 'Indica las llaves primarias',
  KEY `FK_tbusuario_tbrol` (`fkidrol`) USING BTREE COMMENT 'Indica la relacion con la tabla tbrol',
  CONSTRAINT `FK_tbusuario_tbrol` FOREIGN KEY (`fkidrol`) REFERENCES `tbrol` (`idrol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla dbladitec.tbusuario: ~17 rows (aproximadamente)
/*!40000 ALTER TABLE `tbusuario` DISABLE KEYS */;
INSERT INTO `tbusuario` (`idusuario`, `nomusuario`, `email`, `clave`, `fkidrol`, `estado`, `bloqueos`, `intentos`) VALUES
	(1, 'james', 'james123@gmail.com', 'james123', 1, 'A', 1, 1),
	(2, 'jorge', 'jorge123@gmail.com', 'jorge123', 2, 'A', 0, 2),
	(3, 'miguel', 'miguel1@gmail.com', '123', 2, 'A', 0, 1),
	(4, 'pedro', 'pedro1@gmail.com', 'pedro123', 2, 'A', 1, 1),
	(5, 'erick', 'erick@gmail.com', 'erick123', 1, 'A', 0, 0),
	(8, 'Justauser', 'Justauser123@hotmail.com', 'Justauser123', 1, 'I', 0, 2),
	(10, 'diego', 'diego12@gmail.com', '123', 2, 'A', 0, 1),
	(11, 'art', 'art12@gmail.com', 'art12', 1, 'I', 0, 1),
	(12, 'qwerty', 'qwerty@hotmail.com', 'qwerty123', 1, 'A', 0, 1),
	(13, 'ugu', 'amiwo@hotmail.com', 'amiwo123', 1, 'A', 0, 1),
	(14, 'testingnumber10', 'Justauser123@hotmail.com', 'qwerty123', 2, 'A', 0, 3),
	(17, 'nuevointento', 'nuevointento@gmail.com', 'nuevointento', 1, 'A', 0, 1),
	(18, 'nuevointento', 'nuevointento@gmail.com', 'nuevointento', 1, 'A', 0, 1),
	(19, 'asd', 'asd@hotmail.com', 'asd', 1, 'A', 0, 1),
	(20, 'nuevousuario', 'nuevousuario@hotmail.com', 'nuevousuario123', 1, 'I', 0, 1),
	(21, 'Elard', 'Elard@gmail.com', 'Elard', 1, 'A', 0, 1),
	(22, 'zxc', 'zxc@gmail.com', 'zxc', 2, 'A', 0, 1);
/*!40000 ALTER TABLE `tbusuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
