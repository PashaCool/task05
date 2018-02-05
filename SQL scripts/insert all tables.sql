INSERT INTO `clients` (name, surname, phone) VALUES ("Corry", "Shmidt", "8(029)155-25-43");
INSERT INTO `clients` (name, surname, phone) VALUES ("Sam", "Sidney", "8(029)637-46-42");
INSERT INTO `clients` (name, surname, phone) VALUES ("John", "Horn", "8(029)764-64-56");
INSERT INTO `clients` (name, surname, phone) VALUES ("Sveta", "Kovina", "8(029)750-46-11");
INSERT INTO `clients` (name, surname, phone) VALUES ("Tanya", "Belaya", "8(029)821-42-73");
INSERT INTO `clients` (name, surname, phone) VALUES ("Oleg", "Cor", "8(029)990-73-65");
INSERT INTO `clients` (name, surname, phone) VALUES ("Alexander", "Raddle", "8(029)093-21-43");
INSERT INTO `clients` (name, surname, phone) VALUES ("Scott", "Malkin", "8(029)742-22-72");
INSERT INTO `clients` (name, surname, phone) VALUES ("Stan", "Marsh", "8(029)285-11-77");
INSERT INTO `clients` (name, surname, phone) VALUES ("Victoria", "Burda", "8(029)130-32-11");
INSERT INTO `clients` (name, surname, phone) VALUES ("Pam", "Swam", "8(029)153-67-43");
INSERT INTO `clients` (name, surname, phone) VALUES ("Radoslav", "Kovac", "8(029)109-21-86");
INSERT INTO `clients` (name, surname, phone) VALUES ("Martin", "Valdes", "8(029)632-57-64");
INSERT INTO `clients` (name, surname, phone) VALUES ("Tom", "Trapp", "8(029)603-43-34");

INSERT INTO `passangers` VALUES (1, 1, 1);
INSERT INTO `passangers` VALUES (1, 1, 2);
INSERT INTO `passangers` VALUES (1, 1, 3);
INSERT INTO `passangers` VALUES (1, 1, 5);
INSERT INTO `passangers` VALUES (1, 1, 6);
INSERT INTO `passangers` VALUES (1, 1, 7);
INSERT INTO `passangers` VALUES (1, 1, 8);
INSERT INTO `passangers` VALUES (1, 1, 9);
INSERT INTO `passangers` VALUES (1, 1, 11);
INSERT INTO `passangers` VALUES (1, 1, 12);
INSERT INTO `passangers` VALUES (2, 2, 1);
INSERT INTO `passangers` VALUES (2, 2, 2);
INSERT INTO `passangers` VALUES (2, 2, 3);
INSERT INTO `passangers` VALUES (2, 2, 4);
INSERT INTO `passangers` VALUES (2, 2, 5);
INSERT INTO `passangers` VALUES (2, 2, 6);
INSERT INTO `passangers` VALUES (2, 2, 7);
INSERT INTO `passangers` VALUES (2, 2, 8);
INSERT INTO `passangers` VALUES (2, 2, 9);
INSERT INTO `passangers` VALUES (2, 2, 11);
INSERT INTO `passangers` VALUES (2, 2, 12);
INSERT INTO `passangers` VALUES (2, 2, 15);

INSERT INTO `sales` (title, size) VALUES ("mini", 5);
INSERT INTO `sales` (title, size) VALUES ("ten", 10);
INSERT INTO `sales` (title, size) VALUES ("medium", 15);
INSERT INTO `sales` (title, size) VALUES ("friendly", 20);
INSERT INTO `sales` (title, size) VALUES ("premium", 25);

INSERT INTO `tours_list` (city, type, days, price, eat, hotel, visa, transport) 
VALUES ("Budapest", "tour", 5, 350.46, false, true, true, "bus");

INSERT INTO `tours_list` (city, type, days, price, eat, hotel, visa, transport) 
VALUES ("Prague", "tour", 5, 333.54, false, true, true, "bus");

INSERT INTO `tours_list` (city, type, days, price, eat, hotel, visa, transport) 
VALUES ("Bukovel", "sanative", 5, 210.90, true, true, false, "bus");

INSERT INTO `tours_list` (city, type, days, price, eat, hotel, visa, transport) 
VALUES ("Rome", "tour", 7, 555.90, false, true, true, "bus");

INSERT INTO `tours_list` (city, type, days, price, eat, hotel, visa, transport) 
VALUES ("Krakov", "tour", 4, 128.10, false, true, true, "bus");

INSERT INTO `trips` (id_tour, id_group) VALUES (5, 1);
INSERT INTO `trips` (id_tour, id_group) VALUES (7, 2);
