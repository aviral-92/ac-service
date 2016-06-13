/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  amittal
 * Created: Jun 10, 2016
 */

CREATE  TABLE IF NOT EXISTS `ac_service`.`ac_type` (
  `acId` INT NOT NULL AUTO_INCREMENT ,
  `ac_type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`acId`) );


CREATE TABLE IF NOT EXISTS `ac_service`.`customer` (
  `customerId` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `acId` INTEGER UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `address` VARCHAR(95) NOT NULL,
  `mobile` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `model_vehicle_no` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customerId`),
  CONSTRAINT `FK_customer_1` FOREIGN KEY `FK_customer_1` (`acId`)
    REFERENCES `ac_type` (`acId`)

ALTER TABLE `ac_service`.`customer` DROP COLUMN `amount` , DROP COLUMN `description` , DROP COLUMN `model_vehicle_no` ;


ALTER TABLE `ac_service`.`customer` AUTO_INCREMENT = 1000;


CREATE  TABLE IF NOT EXISTS `ac_service`.`customer_repairing_detail` (
  `repairId` INT NOT NULL ,
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

-- CREATE  TABLE IF NOT EXISTS `shop`.`customer` (
--   `customerId` INT NOT NULL AUTO_INCREMENT ,
--   `acId` INT(11) NOT NULL ,
--   `name` VARCHAR(45) NOT NULL ,
--   `email` VARCHAR(45) NOT NULL ,
--   `mobile` VARCHAR(45) NOT NULL ,
--   `address` VARCHAR(55) NOT NULL ,
--   `description` VARCHAR(95) NOT NULL ,
--   `amount` DOUBLE NOT NULL ,
--   `model/vehicle no` VARCHAR(45) NOT NULL ,
--   PRIMARY KEY (`customerId`) ,
--   INDEX `ac` (`acId` ASC) ,
--   CONSTRAINT `ac`
--     FOREIGN KEY (`acId` )
--     REFERENCES `ac_service`.`ac_type` (`acId` )
--     ON DELETE CASCADE
--     ON UPDATE CASCADE);