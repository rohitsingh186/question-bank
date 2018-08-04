-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: question_bank
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `question_bank`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `question_bank` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `question_bank`;

--
-- Table structure for table `qb_level`
--

DROP TABLE IF EXISTS `qb_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qb_level` (
  `id` varchar(255) NOT NULL,
  `added_date` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qb_level`
--

LOCK TABLES `qb_level` WRITE;
/*!40000 ALTER TABLE `qb_level` DISABLE KEYS */;
INSERT INTO `qb_level` VALUES ('5ccdc296-f6ed-44d8-98a4-853c406a2b6b','2018-08-04 16:29:24','Easy');
/*!40000 ALTER TABLE `qb_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qb_option`
--

DROP TABLE IF EXISTS `qb_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qb_option` (
  `id` varchar(255) NOT NULL,
  `added_date` datetime DEFAULT NULL,
  `correct_option` bit(1) NOT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `question_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5gymee17vnx062xgba9uqn2a0` (`question_id`),
  CONSTRAINT `FK5gymee17vnx062xgba9uqn2a0` FOREIGN KEY (`question_id`) REFERENCES `qb_question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qb_option`
--

LOCK TABLES `qb_option` WRITE;
/*!40000 ALTER TABLE `qb_option` DISABLE KEYS */;
INSERT INTO `qb_option` VALUES ('2f876f69-d75c-4d05-ad25-412674d7dbb0','2018-08-04 16:34:23','','2018-08-04 16:34:23','No','79d13a61-7e64-4d2a-a65d-08d86becdb09'),('7c5da41e-29f2-4784-b884-bea202d26a8a','2018-08-04 16:34:23','\0','2018-08-04 16:34:23','Yes','79d13a61-7e64-4d2a-a65d-08d86becdb09');
/*!40000 ALTER TABLE `qb_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qb_question`
--

DROP TABLE IF EXISTS `qb_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qb_question` (
  `id` varchar(255) NOT NULL,
  `added_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `level_id` varchar(255) NOT NULL,
  `topic_id` varchar(255) NOT NULL,
  `submitter_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7o7yx6et9eu8a3x54wg7c27v6` (`level_id`),
  KEY `FK42dafurwqr69h0u4rtehjutd6` (`topic_id`),
  KEY `FKtegtgt8g5xbs5qexnuhfjriye` (`submitter_id`),
  CONSTRAINT `FK42dafurwqr69h0u4rtehjutd6` FOREIGN KEY (`topic_id`) REFERENCES `qb_topic` (`id`),
  CONSTRAINT `FK7o7yx6et9eu8a3x54wg7c27v6` FOREIGN KEY (`level_id`) REFERENCES `qb_level` (`id`),
  CONSTRAINT `FKtegtgt8g5xbs5qexnuhfjriye` FOREIGN KEY (`submitter_id`) REFERENCES `qb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qb_question`
--

LOCK TABLES `qb_question` WRITE;
/*!40000 ALTER TABLE `qb_question` DISABLE KEYS */;
INSERT INTO `qb_question` VALUES ('79d13a61-7e64-4d2a-a65d-08d86becdb09','2018-08-04 16:34:23','2018-08-04 16:34:23','Is Map a part of collections framework ?','5ccdc296-f6ed-44d8-98a4-853c406a2b6b','1272f321-ebe4-461c-8d80-98fada7b1271','423d5d55-4148-4523-a00b-296574e16ec6');
/*!40000 ALTER TABLE `qb_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qb_topic`
--

DROP TABLE IF EXISTS `qb_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qb_topic` (
  `id` varchar(255) NOT NULL,
  `added_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qb_topic`
--

LOCK TABLES `qb_topic` WRITE;
/*!40000 ALTER TABLE `qb_topic` DISABLE KEYS */;
INSERT INTO `qb_topic` VALUES ('1272f321-ebe4-461c-8d80-98fada7b1271','2018-08-04 16:29:59','Collections Framework');
/*!40000 ALTER TABLE `qb_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qb_user`
--

DROP TABLE IF EXISTS `qb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qb_user` (
  `id` varchar(255) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qb_user`
--

LOCK TABLES `qb_user` WRITE;
/*!40000 ALTER TABLE `qb_user` DISABLE KEYS */;
INSERT INTO `qb_user` VALUES ('423d5d55-4148-4523-a00b-296574e16ec6','Rohit Kumar Singh','rkumarsingh');
/*!40000 ALTER TABLE `qb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-04 16:44:47
