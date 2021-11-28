-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: starwarsplanets
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `inhabitant`
--

DROP TABLE IF EXISTS `inhabitant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inhabitant` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `language` varchar(255) DEFAULT NULL,
  `race` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inhabitant`
--

LOCK TABLES `inhabitant` WRITE;
/*!40000 ALTER TABLE `inhabitant` DISABLE KEYS */;
INSERT INTO `inhabitant` VALUES (1,'Ewokese','Ewok'),(2,'Yuzzum','Yuzzum'),(3,'Dulok','Ewokese'),(4,'Skandit','Skandit'),(5,'Wistie','Wistie'),(6,'Shyriiwook','Wookiee'),(7,'Galactic Basic Standard','Human'),(8,'Unknown','Hepsalum Tash'),(9,'Gungan Basic','Gungan'),(10,'Galactic Basic Standard','Taung'),(11,'Drallish','Drall'),(12,'Mandaba','Selonian'),(13,'Drallish','Drall'),(14,'Mandaba','Selonian'),(15,'Uthuthma','Uthuthma'),(16,'Teedospeak','Teedo');
/*!40000 ALTER TABLE `inhabitant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `region` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `start_system` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (4,'Outer Rim Territories, Inner Zuma Region','Zuma sector','Endor system'),(5,'Mid Rim','Mytaranor','Kashyyyk'),(6,'Outer Rim Territories','Sluis','Dagobah'),(7,'Mid Rim','Chommell','Naboo'),(8,'Core Worlds','Corusca','Coruscant'),(9,'Core Worlds','Corellian','Corellian'),(10,'Core Worlds','Corellian','Corellian'),(11,'Core Worlds','Corusca','Coruscant'),(12,'Western Reaches, Inner Rim',NULL,'Jakku');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planet`
--

DROP TABLE IF EXISTS `planet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capital_city` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `planet_location` bigint DEFAULT NULL,
  `planet_publication` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrk75ketlbed8nct4m2jix340y` (`planet_location`),
  KEY `FK5g124477967cpi0jcuto1hbjv` (`planet_publication`),
  CONSTRAINT `FK5g124477967cpi0jcuto1hbjv` FOREIGN KEY (`planet_publication`) REFERENCES `publication` (`id`),
  CONSTRAINT `FKrk75ketlbed8nct4m2jix340y` FOREIGN KEY (`planet_location`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planet`
--

LOCK TABLES `planet` WRITE;
/*!40000 ALTER TABLE `planet` DISABLE KEYS */;
INSERT INTO `planet` VALUES (1,NULL,'Endor (Forest Moon of Endor / Sanctuary Moon)',4,1),(2,'Rwookrrorro','Kashyyyk',5,2),(3,NULL,'Dagobah',6,3),(4,'Otoh Gunga','Naboo',7,4),(5,'Galactic City','Coruscant',11,5),(6,'Coronet City','Corellia',10,6),(7,NULL,'Tatooine',NULL,7),(8,NULL,'Jakku',12,8);
/*!40000 ALTER TABLE `planet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planet_inhabitants`
--

DROP TABLE IF EXISTS `planet_inhabitants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planet_inhabitants` (
  `planet_id` bigint NOT NULL,
  `inhabitants_id` bigint NOT NULL,
  KEY `FKcth7kboy342mwme1glksms9nd` (`inhabitants_id`),
  KEY `FK1570jtiqis6c4luhpmktf4df9` (`planet_id`),
  CONSTRAINT `FK1570jtiqis6c4luhpmktf4df9` FOREIGN KEY (`planet_id`) REFERENCES `planet` (`id`),
  CONSTRAINT `FKcth7kboy342mwme1glksms9nd` FOREIGN KEY (`inhabitants_id`) REFERENCES `inhabitant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planet_inhabitants`
--

LOCK TABLES `planet_inhabitants` WRITE;
/*!40000 ALTER TABLE `planet_inhabitants` DISABLE KEYS */;
INSERT INTO `planet_inhabitants` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(2,6),(2,7),(3,8),(4,9),(4,7),(6,7),(6,13),(6,14),(5,7),(8,15),(8,16);
/*!40000 ALTER TABLE `planet_inhabitants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication`
--

DROP TABLE IF EXISTS `publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publication` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication`
--

LOCK TABLES `publication` WRITE;
/*!40000 ALTER TABLE `publication` DISABLE KEYS */;
INSERT INTO `publication` VALUES (1,'Star Wars: Episode VI - Return of the Jedi','FILM',NULL),(2,'Star Wars Holiday Special','TV_FILM',NULL),(3,'Star Wars: Episode V - The Empire Strikes Back','FILM',NULL),(4,'Star Wars: Episode I - The Phantom Menace','FILM',NULL),(5,'Heir to the Empire','BOOK',NULL),(6,'Star Wars: Episode IV – A New Hope','FILM',NULL),(7,'Star Wars: Episode IV – A New Hope','FILM',1977),(8,'Star Wars: Episodio VII - El despertar de la Fuerza','FILM',NULL);
/*!40000 ALTER TABLE `publication` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-25 21:29:13
