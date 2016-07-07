/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  amittal
 * Created: Jun 10, 2016
 */



create database IF NOT EXISTS ac_Service;

CREATE TABLE IF NOT EXISTS `ac_Service`.`login` (
     `username` VARCHAR(45) NOT NULL,
       `password` VARCHAR(45) NOT NULL,
       `role` VARCHAR(45) NOT NULL,
       PRIMARY KEY (`username`) );

insert into `ac_Service`.`login` values ('admin','admin','admin');

CREATE TABLE IF NOT EXISTS `ac_service`.`userdetail` (
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
    REFERENCES `ac_service`.`login` (`username`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
    
ALTER TABLE `ac_service`.`userdetail` 
	ADD COLUMN `status` VARCHAR(5) NOT NULL DEFAULT 'a' AFTER `registeredDate`;

-- Create User Detail History Table
 CREATE TABLE IF NOT EXISTS `ac_service`.`user_detail_history` (
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
    REFERENCES `ac_service`.`userdetail` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
    
--Alter table to add Foreign key
ALTER TABLE `ac_service`.`user_detail_history` 
ADD INDEX `Foreign_Key_Username_idx` (`username` ASC);
ALTER TABLE `ac_service`.`user_detail_history` 
ADD CONSTRAINT `Foreign_Key_Username`
  FOREIGN KEY (`username`)
  REFERENCES `ac_service`.`login` (`username`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;
  
  ALTER TABLE `ac_service`.`user_detail_history` 
ADD COLUMN `status` VARCHAR(5) NOT NULL DEFAULT 'a' AFTER `description`;

CREATE  TABLE IF NOT EXISTS `ac_service`.`ac_type` (
  `acId` INT NOT NULL AUTO_INCREMENT ,
  `ac_type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`acId`) );


CREATE  TABLE IF NOT EXISTS `ac_service`.`customer` (
  `customerId` INT NOT NULL AUTO_INCREMENT ,
  `acId` INT(11) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `mobile` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(55) NOT NULL ,
  `RegisteredDate` DATETIME  NOT NULL ,
  PRIMARY KEY (`customerId`) 
);

ALTER TABLE `ac_service`.`customer` AUTO_INCREMENT = 1000;

CREATE  TABLE IF NOT EXISTS `ac_service`.`customer_repairing_detail` (
  `repairId` INT NOT NULL AUTO_INCREMENT,
  `ac_Id` INT(11) NOT NULL ,
  `customer_Id` INT(11) NOT NULL ,
  `description` VARCHAR(95) NOT NULL ,
  `actual_amount` VARCHAR(45) NOT NULL ,
  `paid_amount` VARCHAR(45) NOT NULL ,
  `updated_date` DATE NOT NULL ,
  `status` VARCHAR(5) NOT NULL DEFAULT 'a' ,
  `warranty` DATE NOT NULL ,
   `model_vehicle_no` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`repairId`) ,
  INDEX `New_Ac_ID` (`ac_Id` ASC) ,
  INDEX `New_Customer_ID` (`customer_Id` ASC) ,
  CONSTRAINT `New_Ac_ID`
    FOREIGN KEY (`ac_Id` )
    REFERENCES `ac_service`.`ac_type` (`acId` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `New_Customer_ID`
    FOREIGN KEY (`customer_Id` )
    REFERENCES `ac_service`.`customer` (`customerId` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
    
-- ALTER TABLE `ac_service`.`customer` DROP COLUMN `amount` , DROP COLUMN `description` , 
-- DROP COLUMN `model/vehicle no` ;

-- ALTER TABLE `ac_service`.`customer` DROP COLUMN `acId` , DROP FOREIGN KEY `ac` 
-- , DROP INDEX `ac` ;

--   CREATE  TABLE IF NOT EXISTS `ac_service`.`customerhistory` (
--  `id` INT NOT NULL AUTO_INCREMENT ,
--  `customerId` INT NOT NULL ,
--  `customer_emal` VARCHAR(45) NOT NULL ,
--  `customer_mobile` VARCHAR(45) NOT NULL ,
--  `RegisteredDate` DATETIME NOT NULL ,
--  `DeletedDate` DATETIME NOT NULL ,
--  PRIMARY KEY (`id`) );
--  
--  ALTER TABLE `ac_service`.`customerhistory` 
--  ADD CONSTRAINT `Foreign_key`
--  FOREIGN KEY (`customerId` )
--  REFERENCES `ac_service`.`customer` (`customerId` )
--  ON DELETE CASCADE
--  ON UPDATE CASCADE
--, ADD INDEX `Foreign_key` (`customerId` ASC) ;
--


