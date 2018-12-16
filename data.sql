-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: GradeA
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assist_course`
--

DROP TABLE IF EXISTS `assist_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assist_course` (
  `cid` int(11) NOT NULL,
  `tfname` varchar(45) NOT NULL,
  PRIMARY KEY (`cid`,`tfname`),
  KEY `fk_tfname_idx` (`tfname`),
  CONSTRAINT `fk_assist_cid` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE CASCADE,
  CONSTRAINT `fk_assist_tfname` FOREIGN KEY (`tfname`) REFERENCES `teaching_fellow` (`tfname`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assist_course`
--

LOCK TABLES `assist_course` WRITE;
/*!40000 ALTER TABLE `assist_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `assist_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assist_lab`
--

DROP TABLE IF EXISTS `assist_lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assist_lab` (
  `labname` varchar(45) NOT NULL,
  `tfname` varchar(45) NOT NULL,
  PRIMARY KEY (`labname`,`tfname`),
  KEY `fk_tfrelation_idx` (`tfname`),
  CONSTRAINT `fk_labrelation` FOREIGN KEY (`labname`) REFERENCES `lab` (`labname`) ON DELETE CASCADE,
  CONSTRAINT `fk_tfrelation` FOREIGN KEY (`tfname`) REFERENCES `teaching_fellow` (`tfname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assist_lab`
--

LOCK TABLES `assist_lab` WRITE;
/*!40000 ALTER TABLE `assist_lab` DISABLE KEYS */;
/*!40000 ALTER TABLE `assist_lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attend_course`
--

DROP TABLE IF EXISTS `attend_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attend_course` (
  `cid` int(11) NOT NULL,
  `sid` varchar(45) NOT NULL,
  KEY `fk_sid_idx` (`sid`),
  KEY `fk_cid_idx` (`cid`),
  CONSTRAINT `fk_cid` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE CASCADE,
  CONSTRAINT `fk_sid` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attend_course`
--

LOCK TABLES `attend_course` WRITE;
/*!40000 ALTER TABLE `attend_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `attend_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attend_lab`
--

DROP TABLE IF EXISTS `attend_lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attend_lab` (
  `sid` varchar(45) NOT NULL,
  `labname` varchar(45) NOT NULL,
  PRIMARY KEY (`sid`,`labname`),
  KEY `fk2_idx` (`labname`),
  CONSTRAINT `fk1` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`labname`) REFERENCES `lab` (`labname`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attend_lab`
--

LOCK TABLES `attend_lab` WRITE;
/*!40000 ALTER TABLE `attend_lab` DISABLE KEYS */;
/*!40000 ALTER TABLE `attend_lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(45) NOT NULL,
  `startTime` time DEFAULT NULL,
  `endTime` time DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `weekDay` varchar(45) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `cid_UNIQUE` (`cid`),
  KEY `cname` (`cname`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Coursework`
--

DROP TABLE IF EXISTS `Coursework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Coursework` (
  `cwid` int(11) NOT NULL AUTO_INCREMENT,
  `cwname` varchar(45) NOT NULL,
  `totalpoint` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `gradPercentage` int(11) DEFAULT NULL,
  `gradTypePercentage` int(11) DEFAULT NULL,
  `undergradPercentage` int(11) DEFAULT NULL,
  `undergradTypePercentage` int(11) DEFAULT NULL,
  `courseName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cwid`),
  UNIQUE KEY `gradeId_UNIQUE` (`cwid`)
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Coursework`
--

LOCK TABLES `Coursework` WRITE;
/*!40000 ALTER TABLE `Coursework` DISABLE KEYS */;
/*!40000 ALTER TABLE `Coursework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gradeBreakDown`
--

DROP TABLE IF EXISTS `gradeBreakDown`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gradeBreakDown` (
  `gbdid` int(11) NOT NULL AUTO_INCREMENT,
  `cwname` varchar(45) DEFAULT NULL,
  `coursename` varchar(45) DEFAULT NULL,
  `typePercentage` float DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `totalPoint` int(11) DEFAULT NULL,
  `pointLost` int(11) DEFAULT NULL,
  `sid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gbdid`),
  KEY `sidfk` (`sid`),
  CONSTRAINT `sidfk` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=360 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradeBreakDown`
--

LOCK TABLES `gradeBreakDown` WRITE;
/*!40000 ALTER TABLE `gradeBreakDown` DISABLE KEYS */;
/*!40000 ALTER TABLE `gradeBreakDown` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lab`
--

DROP TABLE IF EXISTS `Lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Lab` (
  `labname` varchar(45) NOT NULL,
  `startTime` time DEFAULT NULL,
  `endTime` time DEFAULT NULL,
  `weekDay` varchar(45) DEFAULT NULL,
  `courseName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`labname`),
  KEY `fk_toCourse_idx` (`courseName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lab`
--

LOCK TABLES `Lab` WRITE;
/*!40000 ALTER TABLE `Lab` DISABLE KEYS */;
/*!40000 ALTER TABLE `Lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Student` (
  `sid` varchar(45) NOT NULL,
  `sname` varchar(45) NOT NULL,
  `stype` varchar(45) DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `syear` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sid_UNIQUE` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teaching_fellow`
--

DROP TABLE IF EXISTS `Teaching_fellow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Teaching_fellow` (
  `tfname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`tfname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teaching_fellow`
--

LOCK TABLES `Teaching_fellow` WRITE;
/*!40000 ALTER TABLE `Teaching_fellow` DISABLE KEYS */;
/*!40000 ALTER TABLE `Teaching_fellow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `User` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `question1` varchar(45) DEFAULT NULL,
  `question2` varchar(45) DEFAULT NULL,
  `question3` varchar(45) DEFAULT NULL,
  `answer1` varchar(45) DEFAULT NULL,
  `answer2` varchar(45) DEFAULT NULL,
  `answer3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'GradeA'
--

--
-- Dumping routines for database 'GradeA'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-16 14:30:12
