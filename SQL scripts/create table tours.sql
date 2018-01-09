create table if not exists`tours2` (
  `idtours` int not null auto_increment,
  `city` varchar(45) not null,
  `type` enum('tour', ' shopping', 'sanative') not null,
  PRIMARY KEY (`idtours`));
