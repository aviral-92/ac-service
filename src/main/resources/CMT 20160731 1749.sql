-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.17-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema customer_mgmt_tool
--

CREATE DATABASE IF NOT EXISTS customer_mgmt_tool;
USE customer_mgmt_tool;

--
-- Definition of table `ac_type`
--

DROP TABLE IF EXISTS `ac_type`;
CREATE TABLE `ac_type` (
  `acId` int(11) NOT NULL auto_increment,
  `ac_type` varchar(45) NOT NULL,
  PRIMARY KEY  (`acId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ac_type`
--

/*!40000 ALTER TABLE `ac_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `ac_type` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL auto_increment,
  `category_name` varchar(45) NOT NULL,
  `category_status` varchar(4) NOT NULL default 'A',
  PRIMARY KEY  (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`categoryId`,`category_name`,`category_status`) VALUES 
 (1,'Aviral','A'),
 (2,'ccc','A'),
 (3,'ugg','A');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `address` varchar(55) NOT NULL,
  `RegisteredDate` datetime NOT NULL,
  `customerStatus` varchar(4) NOT NULL default 'A',
  `last_updated` varchar(45) default NULL,
  PRIMARY KEY  (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customerId`,`name`,`email`,`mobile`,`address`,`RegisteredDate`,`customerStatus`,`last_updated`) VALUES 
 (1,'a','aa','333','sss','2016-07-29 23:29:25','A',NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `customer_job_detail`
--

DROP TABLE IF EXISTS `customer_job_detail`;
CREATE TABLE `customer_job_detail` (
  `job_id` int(11) NOT NULL auto_increment,
  `customer_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `unique_id` varchar(45) default NULL,
  `actual_amount` varchar(45) NOT NULL,
  `paid_amount` varchar(45) NOT NULL,
  `description` varchar(95) default NULL,
  `due_date` varchar(45) NOT NULL,
  `warranty` varchar(45) default NULL,
  `status` varchar(5) NOT NULL default 'A',
  `reason` varchar(95) default NULL,
  PRIMARY KEY  (`job_id`),
  KEY `CustomerIDKey_idx` (`customer_id`),
  KEY `CategoryIDKey` (`category_id`),
  KEY `OrderIDKey_idx` (`order_id`),
  CONSTRAINT `CategoryIDKey` FOREIGN KEY (`category_id`) REFERENCES `category` (`categoryId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `CustomerIDKey` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `OrderIDKey` FOREIGN KEY (`order_id`) REFERENCES `order_mgmt` (`orderId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_job_detail`
--

/*!40000 ALTER TABLE `customer_job_detail` DISABLE KEYS */;
INSERT INTO `customer_job_detail` (`job_id`,`customer_id`,`category_id`,`order_id`,`unique_id`,`actual_amount`,`paid_amount`,`description`,`due_date`,`warranty`,`status`,`reason`) VALUES 
 (1,1,2,3,'www','455','455','wwww','Sat Jul 30 19:57:55 IST 2016',NULL,'A',NULL),
 (2,1,1,2,'uuu','555','555','desc','due','2016-07-30','A',NULL),
 (3,1,1,2,'uuu','555','555','desc','due','2016-07-30','A',NULL),
 (4,1,1,2,'uuu','555','555','desc','due','2016-07-30','A',NULL),
 (5,1,1,2,'uuu','555','555','desc','due','2016-07-30','A',NULL),
 (6,1,1,2,'uuu','555','555','desc','Fri Aug 05 01:23:13 IST 2016','Fri Nov 25 01:23:00 IST 2016','A','Service'),
 (7,1,2,9,'sssss','55','55','sss','Sun Jul 31 01:34:00 IST 2016',NULL,'A',NULL),
 (8,1,2,10,'sssss','55','55','sss','Sun Aug 07 01:34:56 IST 2016','Wed Aug 31 01:34:48 IST 2016','A','reason');
/*!40000 ALTER TABLE `customer_job_detail` ENABLE KEYS */;


--
-- Definition of table `customer_order_status`
--

DROP TABLE IF EXISTS `customer_order_status`;
CREATE TABLE `customer_order_status` (
  `order_status` varchar(4) NOT NULL,
  `order_value` varchar(45) NOT NULL,
  PRIMARY KEY  (`order_status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_order_status`
--

/*!40000 ALTER TABLE `customer_order_status` DISABLE KEYS */;
INSERT INTO `customer_order_status` (`order_status`,`order_value`) VALUES 
 ('C','Completed'),
 ('P','Pending'),
 ('R','Reopen');
 ('UP','Under Process');
/*!40000 ALTER TABLE `customer_order_status` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `status` varchar(5) NOT NULL default 'a',
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`username`,`password`,`role`,`status`) VALUES 
 ('a','YQ==','user','A'),
 ('admin','admin','admin','a'),
 ('amittal','YXZp','user','A'),
 ('amittal01','YXZpcmFs','user','A'),
 ('amittal02','YWFhYQ==','user','DE'),
 ('amittal03','YWFhYQ==','user','A'),
 ('amittal99','NTY5','user','a'),
 ('avi','NTY4NQ==','user','a'),
 ('l','YQ==','Select','A'),
 ('lll','dWlv','user','A');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `order_mgmt`
--

DROP TABLE IF EXISTS `order_mgmt`;
CREATE TABLE `order_mgmt` (
  `orderId` int(11) NOT NULL auto_increment,
  `customer_id` int(11) NOT NULL,
  `order_status` varchar(15) NOT NULL,
  `order_description` varchar(95) default NULL,
  `order_date` datetime NOT NULL,
  `order_completion` varchar(45) NOT NULL,
  `status` varchar(4) NOT NULL default 'A',
  PRIMARY KEY  (`orderId`),
  KEY `CustomerIDKey_idx` (`customer_id`),
  KEY `OrderStatusKey_idx` (`order_status`),
  CONSTRAINT `OrderStatusKey` FOREIGN KEY (`order_status`) REFERENCES `customer_order_status` (`order_status`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_mgmt`
--

/*!40000 ALTER TABLE `order_mgmt` DISABLE KEYS */;
INSERT INTO `order_mgmt` (`orderId`,`customer_id`,`order_status`,`order_description`,`order_date`,`order_completion`,`status`) VALUES 
 (1,1,'C','Abc','2016-07-30 16:16:27','Sat Jul 30 16:16:27 IST 2016','A'),
 (2,1,'C','ww','2016-07-30 19:53:54','Sat Jul 30 19:53:54 IST 2016','A'),
 (3,1,'C','wwww','2016-07-30 19:58:02','Sat Jul 30 19:57:55 IST 2016','A'),
 (4,1,'P','hhh','2016-07-31 01:18:44','Fri Aug 05 01:18:21 IST 2016','A'),
 (5,1,'P','jgfhh','2016-07-31 01:23:29','Fri Aug 05 01:23:13 IST 2016','A'),
 (6,1,'P','jgfhh','2016-07-31 01:25:04','Fri Aug 05 01:23:13 IST 2016','A'),
 (7,1,'P','jgfhh','2016-07-31 01:25:23','Fri Aug 05 01:23:13 IST 2016','A'),
 (8,1,'P','jgfhh','2016-07-31 01:26:37','Fri Aug 05 01:23:13 IST 2016','A'),
 (9,1,'C','sss','2016-07-31 01:34:01','Sun Jul 31 01:34:00 IST 2016','A'),
 (10,1,'P','sss','2016-07-31 01:35:08','Sun Aug 07 01:34:56 IST 2016','A');
/*!40000 ALTER TABLE `order_mgmt` ENABLE KEYS */;


--
-- Definition of table `user_detail_history`
--

DROP TABLE IF EXISTS `user_detail_history`;
CREATE TABLE `user_detail_history` (
  `Id` int(11) NOT NULL auto_increment,
  `userId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `registeredDate` datetime NOT NULL,
  `lastUpdated` datetime NOT NULL,
  `description` varchar(100) NOT NULL,
  `status` varchar(5) NOT NULL default 'a',
  PRIMARY KEY  (`Id`),
  KEY `Foreign_Key_UserId_idx` (`userId`),
  CONSTRAINT `Foreign_Key_UserId` FOREIGN KEY (`userId`) REFERENCES `userdetail` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_detail_history`
--

/*!40000 ALTER TABLE `user_detail_history` DISABLE KEYS */;
INSERT INTO `user_detail_history` (`Id`,`userId`,`name`,`email`,`mobile`,`username`,`registeredDate`,`lastUpdated`,`description`,`status`) VALUES 
 (1,1,'Aviral','amittal@xavient.com','8527701990','amittal','2016-07-20 07:11:28','2016-07-20 07:11:28','User Successfully Added','a'),
 (2,1,'Aviral','amittal@xavient.com','8527701991','amittal','2016-07-20 07:11:28','2016-07-21 07:01:23','User Successfully Updated','a'),
 (3,1,'Aviral','amittal@xavient.com','8527701991','amittal','2016-07-20 07:11:28','2016-07-21 07:01:41','User Successfully deleted','d'),
 (4,1,'Aviral','amittal@xavient.com','8527701991','amittal','2016-07-20 07:11:28','2016-07-22 06:43:24','User Successfully Added','d'),
 (5,2,'Aviral','amittal@live.com','8527701991','amittal01','2016-07-22 06:43:17','2016-07-22 06:51:25','User Successfully Added','a'),
 (6,2,'Aviral','amittal@live.com','8527701991','amittal01','2016-07-22 06:43:17','2016-07-22 06:52:57','User Successfully Added','a'),
 (7,2,'Aviral','amittal@live.com','8527701922','amittal01','2016-07-22 06:43:17','2016-07-24 14:26:57','User Successfully Updated','A'),
 (8,5,'Aviral','amittal99@mail.com','852770199','amittal99','2016-07-24 20:25:36','2016-07-24 20:31:26','User Successfully Added','a'),
 (9,6,'Avi','amital@mail.com','8521478903','avi','2016-07-24 20:34:44','2016-07-24 20:34:44','User Successfully Added','a'),
 (10,7,'a','a@.','a','a','2016-07-24 21:08:25','2016-07-24 21:08:25','User Successfully Added','a'),
 (11,8,'k','k@.com','8888526930','l','2016-07-24 21:22:24','2016-07-24 21:22:24','User Successfully Added','a'),
 (12,9,'Avi','hhh@mail.com','8523697410','lll','2016-07-28 07:37:48','2016-07-28 07:37:48','User Successfully Added','a');
/*!40000 ALTER TABLE `user_detail_history` ENABLE KEYS */;


--
-- Definition of table `userdetail`
--

DROP TABLE IF EXISTS `userdetail`;
CREATE TABLE `userdetail` (
  `userId` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `registeredDate` datetime NOT NULL,
  `status` varchar(5) NOT NULL default 'a',
  PRIMARY KEY  (`userId`),
  KEY `Foreign_Key_Username_idx` (`username`),
  CONSTRAINT `Foreign_Key_Username` FOREIGN KEY (`username`) REFERENCES `login` (`username`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetail`
--

/*!40000 ALTER TABLE `userdetail` DISABLE KEYS */;
INSERT INTO `userdetail` (`userId`,`name`,`email`,`mobile`,`username`,`registeredDate`,`status`) VALUES 
 (1,'Aviral','amittal@xavient.com','8527701993','amittal','2016-07-20 07:11:28','A'),
 (2,'Aviral','amittal@live.com','8527701923','amittal01','2016-07-22 06:43:17','A'),
 (3,'Aviral','aviral','8527701990','amittal02','2016-07-22 06:51:25','DE'),
 (4,'Aviral Mittal','aviral@gmail.com','8527701992','amittal03','2016-07-22 06:52:57','A'),
 (5,'Aviral','amittal99@mail.com','852770199','amittal99','2016-07-24 20:25:36','a'),
 (6,'Avi','amital@mail.com','8521478903','avi','2016-07-24 20:34:44','a'),
 (7,'a','a@.','a','a','2016-07-24 21:08:25','A'),
 (8,'k','k@.com','8888526930','l','2016-07-24 21:22:24','A'),
 (9,'Avi','hhh@mail.com','8523697410','lll','2016-07-28 07:37:48','A');
/*!40000 ALTER TABLE `userdetail` ENABLE KEYS */;

ALTER TABLE `customer_mgmt_tool`.`customer_job_detail` 
CHANGE COLUMN `unique_id` `unique_id` VARCHAR(45) NULL DEFAULT 'Not Specified'  
, CHANGE COLUMN `description` `description` VARCHAR(95) NULL DEFAULT 'Not Specified'  
, CHANGE COLUMN `due_date` `due_date` DATE NOT NULL  
, CHANGE COLUMN `warranty` `warranty` VARCHAR(45) NULL DEFAULT 'Not Specified'  
, CHANGE COLUMN `reason` `reason` VARCHAR(95) NULL DEFAULT 'Not Specified'  ;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
