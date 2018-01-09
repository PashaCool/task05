CREATE TABLE if not exists `details_tour` (
  `id_tour` int(11) NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `days` int(11) NOT NULL,
  `eat` boolean NOT NULL,
  `hotel` boolean NOT NULL,
  `visa` boolean DEFAULT NULL,
  `transport` enum('avia','bus') DEFAULT NULL,
  PRIMARY KEY (`id_tour`),
  UNIQUE KEY `id_tour_UNIQUE` (`id_tour`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8