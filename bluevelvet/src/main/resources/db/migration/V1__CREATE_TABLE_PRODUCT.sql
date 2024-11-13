CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `brand` varchar(128) DEFAULT NULL,
  `category` varchar(128) DEFAULT NULL,
  `price` double NOT NULL
  PRIMARY KEY (`id`)
)