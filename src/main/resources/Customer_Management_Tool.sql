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


CREATE  TABLE IF NOT EXISTS `customer_mgmt_tool`.`customer` (
  `customerId` INT NOT NULL AUTO_INCREMENT ,
--  `jobId` INT(11) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `mobile` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(55) NOT NULL ,
  `RegisteredDate` DATETIME  NOT NULL ,
  PRIMARY KEY (`customerId`) 
);

ALTER TABLE `customer_mgmt_tool`.`customer` ADD COLUMN `status` VARCHAR(4) NOT NULL  AFTER `RegisteredDate` ;
ALTER TABLE `customer_mgmt_tool`.`customer` AUTO_INCREMENT = 1000;


CREATE TABLE IF NOT EXISTS `customer_mgmt_tool`.`unique_detail` (
  `unique_id` INT NOT NULL,
  `unique_description` VARCHAR(45) NOT NULL,
  `status` VARCHAR(4) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`unique_id`))
ENGINE = InnoDB;

  CREATE TABLE IF NOT EXISTS`customer_mgmt_tool`.`customer_job_detail` (
  `job_id` INT NOT NULL AUTO_INCREMENT,
  `unique_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `actual_amount` VARCHAR(45) NOT NULL,
  `paid_amount` VARCHAR(45) NOT NULL,
  `description` VARCHAR(95) NOT NULL,
  `updated_date` DATETIME NOT NULL,
  `warranty` DATE NOT NULL,
  `status` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`job_id`),
  INDEX `UniqueIDKey_idx` (`unique_id` ASC),
  INDEX `CustomerIDKey_idx` (`customer_id` ASC),
  CONSTRAINT `UniqueIDKey`
    FOREIGN KEY (`unique_id`)
    REFERENCES `customer_mgmt_tool`.`unique_detail` (`unique_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `CustomerIDKey`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customer_mgmt_tool`.`customer` (`customerId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ProductIDKey`
  	 FOREIGN KEY (`product_id`)
    REFERENCES `customer_mgmt_tool`.`product` (`productId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
 ALTER TABLE `customer_mgmt_tool`.`customer_job_detail` DROP COLUMN `product_id` , DROP FOREIGN KEY `ProductIDKey` 
  , DROP INDEX `ProductIDKey` ;
 
  ALTER TABLE `customer_mgmt_tool`.`customer_job_detail` ADD COLUMN `category_id` INT NOT NULL  AFTER `customer_id` ;
  
  ALTER TABLE `customer_mgmt_tool`.`customer_job_detail` 
  ADD CONSTRAINT `CategoryIDKey`
  FOREIGN KEY (`category_id` )
  REFERENCES `customer_mgmt_tool`.`category` (`categoryId` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `CategoryIDKey` (`category_id` ASC) ;

  CREATE  TABLE IF NOT EXISTS `customer_mgmt_tool`.`category` (
  `categoryId` INT NOT NULL AUTO_INCREMENT ,
  `category_name` VARCHAR(45) NOT NULL ,
  `status` VARCHAR(4) NOT NULL DEFAULT 'A' ,
  PRIMARY KEY (`categoryId`) );

 CREATE  TABLE IF NOT EXISTS `customer_mgmt_tool`.`product` (
  `productId` INT NOT NULL AUTO_INCREMENT ,
  `product_name` VARCHAR(45) NOT NULL ,
  `product_description` VARCHAR(95) NOT NULL ,
  `status` VARCHAR(4) NOT NULL ,
 PRIMARY KEY (`productId`) )
	AUTO_INCREMENT = 1000;