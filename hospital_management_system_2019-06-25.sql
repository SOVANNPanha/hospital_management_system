-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital_management_system
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Current Database: `hospital_management_system`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hospital_management_system` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hospital_management_system`;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctors` (
  `id` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `skill` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES ('D001','James','Moriarty','Male',45,'Doctor','active'),('D002','Change','Name','Female',49,'Dentist','Stop working'),('D003','Nhem','Thay Heng','Female',50,'Breast Surgery','active');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_records`
--

DROP TABLE IF EXISTS `patient_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `doctor_id` varchar(50) NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `room` varchar(50) DEFAULT NULL,
  `description` mediumtext,
  `date_out` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_records`
--

LOCK TABLES `patient_records` WRITE;
/*!40000 ALTER TABLE `patient_records` DISABLE KEYS */;
INSERT INTO `patient_records` VALUES (1,1000,'D001','2019-06-21 18:11:44','R001','','2019-06-23 09:41:28'),(2,1000,'D001','2019-06-21 18:25:02','R002','','2019-06-23 09:41:28'),(3,1000,'D001','2019-06-21 18:25:22','R003','','2019-06-23 09:41:28'),(4,1000,'D004','2019-06-21 18:25:37','R002','','2019-06-23 09:41:28'),(5,1000,'D003','2019-06-21 18:26:43','R002','','2019-06-23 09:41:28'),(6,1000,'D002','2019-06-21 18:38:11','R003','','2019-06-23 09:41:28'),(7,1000,'D001','2019-06-21 18:39:15','R002','','2019-06-23 09:41:28'),(8,1001,'D003','2019-06-21 18:40:35','R002','','2019-06-23 09:41:28'),(9,1001,'D002','2019-06-21 18:48:58','R003','','2019-06-23 09:41:28'),(10,1000,'D001','2019-06-21 18:49:22','R002','','2019-06-23 09:41:28'),(11,1001,'D003','2019-06-21 18:49:45','R003','','2019-06-23 09:41:28'),(12,1001,'D001','2019-06-21 18:50:22','R002','','2019-06-23 09:41:28'),(13,1003,'D002','2019-06-21 18:50:52','R001','','2019-06-23 09:41:28'),(14,1003,'D003','2019-06-21 18:51:06','R002','','2019-06-23 09:41:28'),(15,1002,'D003','2019-06-21 18:53:29','R002','','2019-06-23 09:41:28'),(16,1003,'D002','2019-06-21 19:01:58','R003','','2019-06-23 09:41:28'),(17,1002,'D003','2019-06-21 19:04:39','R002','','2019-06-23 09:41:28'),(18,1003,'D002','2019-06-21 19:07:56','R003','','2019-06-23 09:41:28'),(19,1003,'D001','2019-06-21 19:08:35','R003','','2019-06-23 10:28:46'),(20,1000,'D003','2019-06-21 19:09:45','R002','','2019-06-23 09:41:28'),(21,1001,'D001','2019-06-21 19:13:38','ACU','Dach Kbal','2019-06-23 09:41:28'),(22,1004,'D001','2019-06-21 19:17:03','R003','','2019-06-23 09:41:28'),(23,1008,'D003','2019-06-23 11:26:36','R002','','2019-06-23 11:31:41'),(24,1005,'D003','2019-06-23 11:26:36','R003','','2019-06-24 05:38:02'),(25,1006,'D003','2019-06-23 11:26:36','R003','','2019-06-24 05:32:46'),(26,1007,'D003','2019-06-23 11:28:36','R003','','2019-06-23 11:46:24'),(27,1005,'D002','2019-06-24 05:38:18','R002','This is the description of ...','2019-06-24 07:40:15'),(28,1004,'D003','2019-06-24 05:38:49','R001','JTextArea. JTextArea is a part of java Swing package . It represents a multi \nline area that displays text. It is used to edit the text.','2019-06-24 05:40:10'),(29,1005,'D003','2019-06-24 07:42:41','R002','','2019-06-25 06:24:32'),(30,1009,'D001','2019-06-24 07:43:44','R001','Fuck you Thy Meng','2019-06-24 07:44:39'),(31,1008,'D001','2019-06-25 06:23:37','R003','',NULL),(32,1003,'D001','2019-06-25 08:09:19','ACU','',NULL);
/*!40000 ALTER TABLE `patient_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `gender` varchar(11) NOT NULL,
  `age` int(11) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `villege` varchar(50) DEFAULT NULL,
  `commune` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1000,'SOVANN','Panha','Male',52,'1234567890','','','','','','curing'),(1001,'Srey3Sach','Sokhom','Male',56,'123456789','','','','','','curing'),(1002,'Hello','World','Female',26,'1234567890','','','','','','cured'),(1003,'Chep','Chanseyha','Male',26,'1234567890','','','','','','curing'),(1004,'Srey','Bopha','Male',25,'1234567890','','','','','','cured'),(1005,'Dourn','Phalin','Female',26,'1234567890','','','','','','cured'),(1006,'Jame','Bond','Female',26,'0987654321','','','','','','cured'),(1007,'AhAh','Bourn','Female',90,'1234567890','','','','','','cured'),(1008,'Srey3Sach','Dane','Female',25,'1234567890','','','','','','curing'),(1009,'Thy','Meng','Female',56,'123456789','','','','','','cured');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipts`
--

DROP TABLE IF EXISTS `receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receipts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(50) NOT NULL,
  `date_in` timestamp NOT NULL,
  `date_out` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `price` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipts`
--

LOCK TABLES `receipts` WRITE;
/*!40000 ALTER TABLE `receipts` DISABLE KEYS */;
INSERT INTO `receipts` VALUES (3,'1000','2019-06-20 01:21:23','2019-06-21 18:12:13','10$'),(4,'1000','2019-06-10 17:00:00','2019-06-21 18:25:09','10$'),(5,'1000','2019-06-21 18:12:13','2019-06-21 18:38:54','10$'),(6,'1000','2019-06-21 18:12:13','2019-06-21 18:39:58','10$'),(7,'1001','2019-06-21 18:12:13','2019-06-21 18:40:58','10$'),(8,'1001','2019-06-21 18:12:13','2019-06-21 18:49:33','10$'),(9,'1001','2019-06-21 18:12:13','2019-06-21 18:50:13','10$'),(10,'1003','2019-06-21 18:12:13','2019-06-21 18:50:56','10$'),(11,'1003','2019-06-21 18:12:13','2019-06-21 18:54:09','10$'),(12,'1002','2019-06-21 18:12:13','2019-06-21 19:04:17','10$'),(13,'1002','2019-06-21 18:12:13','2019-06-21 19:04:59','10$'),(14,'1003','2019-06-21 18:12:13','2019-06-21 19:07:33','10$'),(15,'1003','2019-06-21 18:12:13','2019-06-21 19:08:20','10$'),(16,'1000','2019-06-21 18:12:13','2019-06-21 19:09:16','10$'),(17,'1001','2019-06-21 18:12:13','2019-06-21 19:13:07','10$'),(18,'1004','2019-06-21 18:12:13','2019-06-21 19:17:32','10$'),(19,'1003','2019-06-21 19:08:35','2019-06-23 10:28:46','10$'),(20,'1008','2019-06-23 11:26:36','2019-06-23 11:31:41','10$'),(21,'1007','2019-06-23 11:28:36','2019-06-23 11:46:24','10$'),(22,'1006','2019-06-23 11:26:36','2019-06-24 05:32:46','10$'),(23,'1005','2019-06-23 11:26:36','2019-06-24 05:38:02','10$'),(24,'1004','2019-06-24 05:38:49','2019-06-24 05:40:10','10$'),(25,'1005','2019-06-24 05:38:18','2019-06-24 07:40:15','10$'),(26,'1009','2019-06-24 07:43:44','2019-06-24 07:44:39','10$'),(27,'1005','2019-06-24 07:42:41','2019-06-25 06:24:32','10$');
/*!40000 ALTER TABLE `receipts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-25 15:12:19
