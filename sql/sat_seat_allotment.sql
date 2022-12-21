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
-- Table structure for table `seat_allotment`
--

DROP TABLE IF EXISTS `seat_allotment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_allotment` (
  `id` bigint NOT NULL,
  `division_id` bigint DEFAULT NULL,
  `floor_id` bigint DEFAULT NULL,
  `from_date` datetime DEFAULT NULL,
  `max_no_seats` int DEFAULT NULL,
  `to_date` datetime DEFAULT NULL,
  `zone_id` bigint DEFAULT NULL,
  `parent_allotment_id` bigint DEFAULT NULL,
  `end_seat_no` int DEFAULT NULL,
  `start_seat_no` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_allotment`
--

LOCK TABLES `seat_allotment` WRITE;
/*!40000 ALTER TABLE `seat_allotment` DISABLE KEYS */;
INSERT INTO `seat_allotment` VALUES (333,1,1,NULL,50,NULL,1,NULL,50,1),(338,6,1,NULL,30,NULL,1,333,30,1),(339,7,1,NULL,20,NULL,1,333,50,31),(341,8,1,NULL,25,NULL,1,338,25,1),(358,9,1,NULL,5,NULL,1,338,30,26),(367,1,1,NULL,50,NULL,2,NULL,50,1),(368,1,1,NULL,40,NULL,3,NULL,40,1),(370,6,1,NULL,25,NULL,2,367,25,1),(371,7,1,NULL,25,NULL,2,367,50,26),(394,6,1,NULL,40,NULL,3,368,40,1),(396,9,1,NULL,25,NULL,2,370,25,1),(397,8,1,NULL,40,NULL,3,394,40,1),(409,4,2,NULL,50,NULL,5,NULL,50,1),(413,2,3,NULL,40,NULL,8,NULL,40,1);
/*!40000 ALTER TABLE `seat_allotment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-07 14:02:14