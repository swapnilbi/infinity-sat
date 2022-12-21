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
-- Table structure for table `floor`
--

DROP TABLE IF EXISTS `floor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `floor` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `office_id` bigint NOT NULL,
  `floor_layout` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhm1rbq8hp6d83gpxrfxw642v6` (`office_id`),
  CONSTRAINT `FKhm1rbq8hp6d83gpxrfxw642v6` FOREIGN KEY (`office_id`) REFERENCES `office` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floor`
--

LOCK TABLES `floor` WRITE;
/*!40000 ALTER TABLE `floor` DISABLE KEYS */;
INSERT INTO `floor` VALUES (1,'L1',1,'{\n	\"layout\" : [\n	{\n		\"zones\" : [\n		{\n			\"zoneId\": 1,\n			\"seats\" : [[1,2,3,4,0,0,5,6,7,8],\n						 [16,15,14,13,0,0,12,11,10,9],\n						 [17,18,19,20,0,0,21,22,23,24],\n						 [32,31,30,29,0,0,28,27,26,25],\n						 [33,34,35,36,0,0,37,38,39,40],\n						 [48,47,46,45,0,0,44,43,42,41],\n						 [49,50,51,52,0,0,53,54,55,56]						 \n						]\n		},\n		{\n			\"zoneId\": 2,\n			\"seats\" : [[1,2,0,3,4,5,6,0,7,8],\n						 [16,15,0,14,13,12,11,0,10,9],\n						 [17,18,0,19,20,21,22,0,23,24],\n						 [32,31,0,30,29,28,27,0,26,25],\n						 [33,34,0,35,36,37,38,0,39,40],\n						 [48,47,0,46,45,44,43,0,42,41],\n						 [49,50,0,51,52,53,54,0,55,56]						 \n						]\n		}\n		]	\n	},\n	{\n		\"zones\" : [\n		{\n			\"zoneId\": 3,\n			\"seats\" : [[1,2,3,4,5,6,0,7,8],\n						 [16,15,14,13,12,11,0,10,9],\n						 [17,18,19,20,21,22,0,23,24],\n						 [0,0,0,0,0,0,0,0,0,0],\n						 [32,31,30,29,28,27,0,26,25],\n						 [33,34,35,36,37,38,0,39,40],\n						 [48,47,46,45,44,43,0,42,41]						 \n						]\n		},\n		{		\n			\"zoneId\": 4,\n			\"seats\" : [[1,2,3,4,5,6,0,7,8],\n						 [16,15,14,13,12,11,0,10,9],\n						 [17,18,19,20,21,22,0,23,24],\n						 [0,0,0,0,0,0,0,0,0,0],\n						 [32,31,30,29,28,27,0,26,25],\n						 [33,34,35,36,37,38,0,39,40],\n						 [48,47,46,45,44,43,0,42,41]						 \n						]\n		}	\n		]					\n	}	\n	]\n}\n'),(2,'L2',1,'{\n	\"layout\" : [\n	{\n		\"zones\" : [{\n			\"zoneId\": 5,\n			\"seats\" : [[1,2,3,4,5,6,7,8,9,10],\n					 [11,12,13,14,15,16,17,18,19,20],\n					 [31,32,33,34,35,36,37,38,39,40],\n					 [41,44,43,44,45,46,47,48,49,50],\n					 [51,55,53,54,55,56,57,58,0,0]]\n		},\n		{\n			\"zoneId\": 6,\n			\"seats\" : [[1,2,3,4,5,6,7,8,9,10],\n					 [0,0,13,14,15,16,17,18,19,20],\n					 [31,32,33,34,35,36,37,38,39,40],\n					 [41,44,43,44,45,46,47,48,49,50],\n					 [51,55,53,54,55,56,57,58,59,60]]\n		}\n		]	\n	}	\n	]\n}\n'),(3,'L3',1,'{\n	\"layout\" : [\n	{\n		\"zones\" : [{\n			\"zoneId\": 7,\n			\"seats\" : [[1,2,3,4,5,6,7,8,9,10],\n					 [11,12,13,14,15,16,17,18,19,20],\n					 [31,32,33,34,35,36,37,38,39,40],\n					 [41,44,43,44,45,46,47,48,49,50],\n					 [51,55,53,54,55,56,57,58,0,0]]\n		},\n		{\n			\"zoneId\": 8,\n			\"seats\" : [[1,2,3,4,5,6,7,8,9,10],\n					 [0,0,13,14,15,16,17,18,19,20],\n					 [31,32,33,34,35,36,37,38,39,40],\n					 [41,44,43,44,45,46,47,48,49,50],\n					 [51,55,53,54,55,56,57,58,59,60]]\n		}\n		]	\n	},\n	{\n		\"zones\" : [{\n			\"zoneId\": 9,\n			\"seats\" : [[1,2,3,4,5,6,7,8,9,10],\n					 [11,12,13,14,15,16,17,18,19,20],\n					 [31,32,0,0,35,36,37,38,39,40],\n					 [41,44,43,44,45,0,0,48,49,50],\n					 [51,55,53,54,55,56,57,58,0,0]]\n		}		\n		]	\n	}\n	]\n}\n'),(4,'L4',1,'{\n	\"layout\" : [\n	{\n		\"zones\" : [{\n			\"zoneId\": 10,\n			\"seats\" : [[1,2,3,4,5,6,7,8,9,10],\n					 [11,12,13,14,15,16,17,18,19,20],\n					 [31,32,33,34,35,36,37,38,39,40],\n					 [41,44,43,44,45,46,47,48,49,50],\n					 [51,55,53,54,55,56,57,58,0,0]]\n		}\n		]	\n	}	\n	]\n}\n');
/*!40000 ALTER TABLE `floor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-07 14:02:15
