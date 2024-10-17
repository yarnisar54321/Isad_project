CREATE DATABASE  IF NOT EXISTS `inv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `inv`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: inv
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `productID` varchar(100) NOT NULL,
  `productName` varchar(100) NOT NULL,
  `productQuantity` int DEFAULT NULL,
  `productPrice` varchar(45) DEFAULT NULL,
  `productType` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES ('002','Water',82,'13','Beverages'),('003','Tea',0,'14','Beverages'),('003','Cookware',100,'34','General merchandise'),('005','Home decor',65,'7','General merchandise'),('006','fried rice',91,'34','Food items'),('007','shampoo',93,'54','Personal care products'),('001','Hutdog',26,'15','Food items'),('008','milk',981,'27','Beverages'),('009','yogurt',913,'15','Beverages'),('010','Meat and poultry',912,'100','Food items'),('011','Seafood',63,'400','Food items'),('012','soap',90,'40','Personal care products'),('013','skincare ',83,'99','Personal care products'),('014','creams',94,'89','Personal care products'),('015','cosmetics',84,'99','Personal care products'),('016','fragrances',84,'88','Personal care products'),('017','Coffee',87,'76','Beverages'),('018','Juices',191,'20','Beverages'),('019','Alcoholic Beverages',292,'30','Beverages'),('020','Energy Drinks',72,'14','Beverages'),('021','Sports Drinks',92,'30','Beverages'),('023','Footwear',78,'300','General merchandise'),('024','Toys and Games',87,'500','General merchandise'),('025','Cleaning Supplies',983,'100','General merchandise'),('101','Nojf',4,'5','Food items');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'inv'
--

--
-- Dumping routines for database 'inv'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-17 21:45:28
