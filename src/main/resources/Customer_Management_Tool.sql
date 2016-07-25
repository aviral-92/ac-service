/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  amittal
 * Created: Jun 10, 2016
 */



create database IF NOT EXISTS customer_mgmt_tool;

CREATE TABLE IF NOT EXISTS `customer_mgmt_tool`.`login` (
     `username` VARCHAR(45) NOT NULL,
       `password` VARCHAR(45) NOT NULL,
       `role` VARCHAR(45) NOT NULL,
       PRIMARY KEY (`username`) );

ALTER TABLE `customer_mgmt_tool`.`login` 
	ADD COLUMN `status` VARCHAR(5) NOT NULL DEFAULT 'a' AFTER `role`;
	
insert into `customer_mgmt_tool`.`login` values ('admin','admin','admin');

CREATE TABLE IF NOT EXISTS `customer_mgmt_tool`.`userdetail` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `mobile` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `registeredDate` DATETIME NOT NULL,
  PRIMARY KEY (`userId`),
  INDEX `Foreign_Key_Username_idx` (`username` ASC),
  CONSTRAINT `Foreign_Key_Username`
    FOREIGN KEY (`username`)
    REFERENCES `customer_mgmt_tool`.`login` (`username`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
    
ALTER TABLE `customer_mgmt_tool`.`userdetail` 
	ADD COLUMN `status` VARCHAR(5) NOT NULL DEFAULT 'a' AFTER `registeredDate`;

-- Create User Detail History Table
 CREATE TABLE IF NOT EXISTS `customer_mgmt_tool`.`user_detail_history` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `mobile` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `registeredDate` DATETIME NOT NULL,
  `lastUpdated` DATETIME NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `Foreign_Key_UserId_idx` (`userId` ASC),
  CONSTRAINT `Foreign_Key_UserId`
    FOREIGN KEY (`userId`)
    REFERENCES `customer_mgmt_tool`.`userdetail` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
    
--Alter table to add Foreign key
ALTER TABLE `customer_mgmt_tool`.`user_detail_history` 
ADD INDEX `Foreign_Key_Username_idx` (`username` ASC);
ALTER TABLE `customer_mgmt_tool`.`user_detail_history` 
ADD CONSTRAINT `Foreign_Key_Username`
  FOREIGN KEY (`username`)
  REFERENCES `customer_mgmt_tool`.`login` (`username`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;
  
  ALTER TABLE `customer_mgmt_tool`.`user_detail_history` 
ADD COLUMN `status` VARCHAR(5) NOT NULL DEFAULT 'a' AFTER `description`;

CREATE  TABLE IF NOT EXISTS `customer_mgmt_tool`.`jobwork` (
  `jobId` INT NOT NULL AUTO_INCREMENT ,
  `job_type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`jobId`) );


CREATE  TABLE IF NOT EXISTS `customer_mgmt_tool`.`customer` (
  `customerId` INT NOT NULL AUTO_INCREMENT ,
  `jobId` INT(11) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `mobile` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(55) NOT NULL ,
  `RegisteredDate` DATETIME  NOT NULL ,
  PRIMARY KEY (`customerId`) 
);

ALTER TABLE `customer_mgmt_tool`.`customer` AUTO_INCREMENT = 1000;

--CREATE  TABLE IF NOT EXISTS `customer_mgmt_tool`.`customer_repairing_detail` (
--  `repairId` INT NOT NULL AUTO_INCREMENT,
--  `job_Id` INT(11) NOT NULL ,
--  `customer_Id` INT(11) NOT NULL ,
--  `description` VARCHAR(95) NOT NULL ,
--  `actual_amount` VARCHAR(45) NOT NULL ,
--  `paid_amount` VARCHAR(45) NOT NULL ,
--  `updated_date` DATE NOT NULL ,
--  `status` VARCHAR(5) NOT NULL DEFAULT 'a' ,
--  `warranty` DATE NOT NULL ,
--   `model_vehicle_no` VARCHAR(45) NOT NULL ,
--  PRIMARY KEY (`repairId`) ,
--  INDEX `New_Ac_ID` (`job_Id` ASC) ,
--  INDEX `New_Customer_ID` (`customer_Id` ASC) ,
--  CONSTRAINT `New_Ac_ID`
--    FOREIGN KEY (`job_Id` )
--    REFERENCES `customer_mgmt_tool`.`job_type` (`jobId` )
--    ON DELETE CASCADE
--    ON UPDATE NO ACTION,
--  CONSTRAINT `New_Customer_ID`
--    FOREIGN KEY (`customer_Id` )
--    REFERENCES `customer_mgmt_tool`.`customer` (`customerId` )
--    ON DELETE CASCADE
--    ON UPDATE NO ACTION);

CREATE  TABLE IF NOT EXISTS `customer_mgmt_tool`.`customer_repairing_detail` (
  `repairId` INT NOT NULL AUTO_INCREMENT ,
  `job_Id` INT NOT NULL ,
  `customer_Id` INT NOT NULL ,
  `description` VARCHAR(95) NOT NULL ,
  `actual_amount` VARCHAR(45) NOT NULL ,
  `paid_amount` VARCHAR(45) NOT NULL ,
  `updated_date` DATETIME NOT NULL ,
  `warranty` DATE NOT NULL ,
  `jobcode` VARCHAR(45) NOT NULL ,
  `status` VARCHAR(4) NOT NULL ,
  PRIMARY KEY (`repairId`) );
  
  
    
-- ALTER TABLE `customer_mgmt_tool`.`customer` DROP COLUMN `amount` , DROP COLUMN `description` , 
-- DROP COLUMN `model/vehicle no` ;

-- ALTER TABLE `customer_mgmt_tool`.`customer` DROP COLUMN `acId` , DROP FOREIGN KEY `ac` 
-- , DROP INDEX `ac` ;

--   CREATE  TABLE IF NOT EXISTS `customer_mgmt_tool`.`customerhistory` (
--  `id` INT NOT NULL AUTO_INCREMENT ,
--  `customerId` INT NOT NULL ,
--  `customer_emal` VARCHAR(45) NOT NULL ,
--  `customer_mobile` VARCHAR(45) NOT NULL ,
--  `RegisteredDate` DATETIME NOT NULL ,
--  `DeletedDate` DATETIME NOT NULL ,
--  PRIMARY KEY (`id`) );
--  
--  ALTER TABLE `customer_mgmt_tool`.`customerhistory` 
--  ADD CONSTRAINT `Foreign_key`
--  FOREIGN KEY (`customerId` )
--  REFERENCES `customer_mgmt_tool`.`customer` (`customerId` )
--  ON DELETE CASCADE
--  ON UPDATE CASCADE
--, ADD INDEX `Foreign_key` (`customerId` ASC) ;
--


