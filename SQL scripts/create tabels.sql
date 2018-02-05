CREATE TABLE IF NOT EXISTS `tours_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) NOT NULL,
  `type` enum('tour','shopping','sanative') NOT NULL,
  `days` int(11) NOT NULL,
  `price` double NOT NULL,
  `eat` tinyint(1) DEFAULT NULL,
  `hotel` tinyint(1) DEFAULT NULL,
  `visa` tinyint(1) DEFAULT NULL,
  `transport` varchar(45) DEFAULT NULL,
  `burning` tinyint(1) DEFAULT '0',
  `size` double DEFAULT '0',
  PRIMARY KEY (`id`,`trips_id_trip`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `passangers` (
  `id_group` int(11) NOT NULL,
  `id_trip` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  KEY `fk_group_client_idx` (`id_client`),
  CONSTRAINT `fk_group_client` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sales` (
  `id_sale` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `size` double DEFAULT '0',
  PRIMARY KEY (`id_sale`),
  UNIQUE KEY `size_UNIQUE` (`size`),
  UNIQUE KEY `name_UNIQUE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT '8(029)999-99-99',
  `sales_id_sale` int(11) NOT NULL DEFAULT '1',
  `trips` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_clients_sales_idx` (`sales_id_sale`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `userdb`.`trips` (
  `id_trip` INT(11) NOT NULL AUTO_INCREMENT,
  `id_tour` INT(11) NOT NULL,
  `id_group` INT(11) NOT NULL,
  PRIMARY KEY (`id_trip`),
  INDEX `fk_trip_group_idx` (`id_group` ASC),
  INDEX `fk_trip_tour_idx` (`id_tour` ASC),
  CONSTRAINT `fk_trip_group`
    FOREIGN KEY (`id_group`)
    REFERENCES `userdb`.`passangers` (`id_group`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trip_tour`
    FOREIGN KEY (`id_tour`)
    REFERENCES `userdb`.`tours_list` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
