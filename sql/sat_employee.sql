CREATE DATABASE  IF NOT EXISTS `sat` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sat`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 35.200.218.44    Database: sat
-- ------------------------------------------------------
-- Server version	8.0.26-google

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint NOT NULL,
  `department_id` bigint DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `oe_id` bigint DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `reporting_to` bigint DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,'admin@gmail.com','Admin',_binary '',1,'$2a$10$V9acOfAo7FC3KbuV/3vj0Or/OMOGV13x326U81bnafM/VG6lUE7Pm',NULL,'admin'),(2,2,'swapnil@gmail.com','Swapnil',_binary '',1,'$2a$10$V9acOfAo7FC3KbuV/3vj0Or/OMOGV13x326U81bnafM/VG6lUE7Pm',NULL,'swapnil'),(3,2,'shivam@gmail.com','Shivam',_binary '',6,'$2a$10$V9acOfAo7FC3KbuV/3vj0Or/OMOGV13x326U81bnafM/VG6lUE7Pm',2,'shivam'),(4,2,'rupali@gmail.com','Rupali',_binary '',6,'$2a$10$V9acOfAo7FC3KbuV/3vj0Or/OMOGV13x326U81bnafM/VG6lUE7Pm',3,'rupali'),(5,2,'santosh@gmail.com','Santosh',_binary '',8,'$2a$10$V9acOfAo7FC3KbuV/3vj0Or/OMOGV13x326U81bnafM/VG6lUE7Pm',4,'santosh'),(6,2,'sagar@gmail.com','Sagar',_binary '',8,'$2a$10$V9acOfAo7FC3KbuV/3vj0Or/OMOGV13x326U81bnafM/VG6lUE7Pm',4,'sagar');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-07 14:02:16
