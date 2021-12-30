CREATE DATABASE  IF NOT EXISTS `realt_agency` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `realt_agency`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: realt_agency
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fio` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `fio_UNIQUE` (`fio`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (2,'Бакунович Е.И.'),(1,'Власова А.Л.'),(4,'Дрозд Е.И.'),(5,'Пилипчук И.А.'),(3,'Семененя В.Н.');
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fio` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fio_UNIQUE` (`fio`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (6,'Волотович А.Р.'),(3,'Девочко Н.А.'),(7,'Дзюрич Р.А.'),(2,'Дудорга Е.И.'),(4,'Козлова П.И.'),(11,'Кулаков А.Л.'),(8,'Мороз П.Д.'),(12,'Мясников А.Д.'),(9,'Попкова А.В.'),(13,'Рысевец Д.А.'),(10,'Турбан А.А.'),(5,'Ушакова Н.В.'),(1,'Хващевская М.Г.');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation`
--

DROP TABLE IF EXISTS `operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation`
--

LOCK TABLES `operation` WRITE;
/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
INSERT INTO `operation` VALUES (3,'Поиск арендного жилья'),(2,'Поиск арендного жилья на сутки'),(6,'Поиск коттеджа на месяц'),(5,'Поиск коттеджа на сутки'),(4,'Покупка дома'),(1,'Покупка квартиры');
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client` varchar(100) NOT NULL,
  `operation` varchar(150) NOT NULL,
  `agent` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `cl_idx` (`client`),
  KEY `ag_idx` (`agent`),
  KEY `op_idx` (`operation`),
  CONSTRAINT `ag` FOREIGN KEY (`agent`) REFERENCES `agent` (`fio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cl` FOREIGN KEY (`client`) REFERENCES `client` (`fio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `op` FOREIGN KEY (`operation`) REFERENCES `operation` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'Волотович А.Р.','Поиск коттеджа на сутки','Бакунович Е.И.'),(2,'Дзюрич Р.А.','Поиск арендного жилья на сутки','Семененя В.Н.'),(3,'Дудорга Е.И.','Покупка дома','Семененя В.Н.'),(4,'Мороз П.Д.','Покупка дома','Бакунович Е.И.'),(5,'Попкова А.В.','Покупка квартиры','Дрозд Е.И.'),(6,'Турбан А.А.','Поиск арендного жилья на сутки','Бакунович Е.И.'),(7,'Хващевская М.Г.','Покупка квартиры','Пилипчук И.А.'),(8,'Кулаков А.Л.','Поиск арендного жилья на сутки','Власова А.Л.'),(9,'Мороз П.Д.','Поиск коттеджа на месяц','Семененя В.Н.'),(10,'Мороз П.Д.','Поиск арендного жилья на сутки','Пилипчук И.А.'),(15,'Мясников А.Д.','Покупка квартиры','Власова А.Л.'),(16,'Дзюрич Р.А.','Поиск арендного жилья','Дрозд Е.И.'),(23,'Девочко Н.А.','Поиск коттеджа на месяц','Семененя В.Н.');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-30 17:36:27
