CREATE TABLE `book` (
  `ISBN` varchar(40) NOT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `Author` varchar(45) DEFAULT NULL,
  `Copies owned` int DEFAULT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `member` (
  `idmember` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmember`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `loan` (
  `bookisbn` varchar(40) NOT NULL,
  `idmember` int NOT NULL,
  `duedate` datetime DEFAULT NULL,
  PRIMARY KEY (`bookisbn`,`idmember`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
