-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: lms
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `academic_history`
--

DROP TABLE IF EXISTS `academic_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic_history` (
  `Roll_No` int NOT NULL,
  `Class` varchar(35) NOT NULL,
  `Obtained_Number` int NOT NULL,
  `Total_Number` int NOT NULL,
  `School_Name` varchar(60) NOT NULL,
  `Student_ID` varchar(25) NOT NULL,
  PRIMARY KEY (`Roll_No`),
  UNIQUE KEY `Class` (`Class`),
  KEY `Student_ID` (`Student_ID`),
  CONSTRAINT `academic_history_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student_profile` (`Student_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_history`
--

LOCK TABLES `academic_history` WRITE;
/*!40000 ALTER TABLE `academic_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `academic_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `challen`
--

DROP TABLE IF EXISTS `challen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `challen` (
  `Student_ID` varchar(25) NOT NULL,
  `Challen_No` int NOT NULL,
  `Amount` int NOT NULL,
  `Fine` int NOT NULL,
  `Due_Date` varchar(30) NOT NULL,
  `Paid_Date` varchar(30) DEFAULT 'Not Paid Yet',
  `Status` varchar(40) DEFAULT 'NOT PAID',
  `Semester` varchar(20) NOT NULL,
  `Shift` varchar(20) NOT NULL,
  `Department` varchar(40) NOT NULL,
  PRIMARY KEY (`Challen_No`),
  KEY `Student_ID` (`Student_ID`),
  CONSTRAINT `challen_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student_profile` (`Student_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challen`
--

LOCK TABLES `challen` WRITE;
/*!40000 ALTER TABLE `challen` DISABLE KEYS */;
INSERT INTO `challen` VALUES ('bsf1905804',34234,2342,234,'243','24-03-20121','Paid','3rd','M','IT');
/*!40000 ALTER TABLE `challen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `Course_Code` varchar(18) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Credit_Hours` varchar(20) NOT NULL,
  PRIMARY KEY (`Course_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('COMP2114','Database','Database Design','3(3+0)'),('ENGL1114','Functional English','English','3(3+0)'),('ENGL1119','Communication Skills','English','3(3+0)');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_selection`
--

DROP TABLE IF EXISTS `course_selection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_selection` (
  `Student_ID` varchar(25) NOT NULL,
  `Course_Code` varchar(18) NOT NULL,
  `Course_Name` varchar(25) NOT NULL,
  `Teacher_ID` varchar(28) NOT NULL,
  `Obtained_Number` varchar(30) DEFAULT 'Progress',
  `Total_Number` varchar(30) DEFAULT 'Progress',
  KEY `Student_ID` (`Student_ID`),
  KEY `Course_ID` (`Course_Code`),
  KEY `Teacher_ID` (`Teacher_ID`),
  CONSTRAINT `course_selection_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student_profile` (`Student_ID`),
  CONSTRAINT `course_selection_ibfk_2` FOREIGN KEY (`Course_Code`) REFERENCES `course` (`Course_Code`),
  CONSTRAINT `course_selection_ibfk_3` FOREIGN KEY (`Teacher_ID`) REFERENCES `teacher` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_selection`
--

LOCK TABLES `course_selection` WRITE;
/*!40000 ALTER TABLE `course_selection` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_selection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_grade`
--

DROP TABLE IF EXISTS `detail_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_grade` (
  `Student_ID` varchar(25) NOT NULL,
  `Year` varchar(30) NOT NULL,
  `Course_Code` varchar(18) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `Subject_Name` varchar(30) NOT NULL,
  `Score` varchar(20) NOT NULL,
  `Obtained_CGPA` varchar(20) NOT NULL,
  `Total_CGPA` varchar(20) NOT NULL,
  `Grade` varchar(20) NOT NULL,
  `Semester` varchar(10) NOT NULL,
  KEY `Student_ID` (`Student_ID`),
  KEY `Course_Code` (`Course_Code`),
  CONSTRAINT `detail_grade_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student_profile` (`Student_ID`),
  CONSTRAINT `detail_grade_ibfk_2` FOREIGN KEY (`Course_Code`) REFERENCES `course` (`Course_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_grade`
--

LOCK TABLES `detail_grade` WRITE;
/*!40000 ALTER TABLE `detail_grade` DISABLE KEYS */;
INSERT INTO `detail_grade` VALUES ('bsf1905804','spring 2021','COMP2114','pass','Education','76','3.00','4.00','A','4');
/*!40000 ALTER TABLE `detail_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_address`
--

DROP TABLE IF EXISTS `student_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_address` (
  `Student_ID` varchar(25) NOT NULL,
  `Phone_Number` varchar(20) NOT NULL,
  `Mailing_Address` varchar(80) NOT NULL,
  `Parmanant_Address` varchar(80) NOT NULL,
  KEY `Student_ID` (`Student_ID`),
  CONSTRAINT `student_address_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student_profile` (`Student_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_address`
--

LOCK TABLES `student_address` WRITE;
/*!40000 ALTER TABLE `student_address` DISABLE KEYS */;
INSERT INTO `student_address` VALUES ('bsf1905804','030000000001','M.Garh','M.Garh');
/*!40000 ALTER TABLE `student_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_profile`
--

DROP TABLE IF EXISTS `student_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_profile` (
  `Student_ID` varchar(25) NOT NULL,
  `Registration_No` varchar(25) NOT NULL,
  `First_Name` varchar(35) NOT NULL,
  `Last_Name` varchar(35) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Father_Name` varchar(35) NOT NULL,
  `Email_Address` varchar(35) NOT NULL,
  `Age` int NOT NULL,
  PRIMARY KEY (`Student_ID`),
  UNIQUE KEY `Registration_No` (`Registration_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_profile`
--

LOCK TABLES `student_profile` WRITE;
/*!40000 ALTER TABLE `student_profile` DISABLE KEYS */;
INSERT INTO `student_profile` VALUES ('bsf190','eur3','ahmad','','ahmad ','fdf','af',23),('BSF1905804','UE1905804','Hassan Ali','Khan','Hassan Ali Khan','Riaz ul Hassan','hassan@gmail.com',18),('ue9782','9782','Hassan ali khan','balouch','Hassan ali khan balouch','riaz ul hassan','hassanalikhan417@gmail.com',18);
/*!40000 ALTER TABLE `student_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `Name` varchar(35) NOT NULL,
  `ID` varchar(28) NOT NULL,
  `Qualification` varchar(30) NOT NULL,
  `Department` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('Hassan Ali','1','IT','IT');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timetable` (
  `Days` varchar(50) NOT NULL,
  `Lecture_1` varchar(30) NOT NULL,
  PRIMARY KEY (`Days`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-10 15:15:24
