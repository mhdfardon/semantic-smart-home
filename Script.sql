-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema smarthome
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema smarthome
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `smarthome` DEFAULT CHARACTER SET utf8 ;
USE `smarthome` ;

-- -----------------------------------------------------
-- Table `smarthome`.`SENSOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smarthome`.`SENSOR` (
  `SENSOR_ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NULL,
  `TYPE` VARCHAR(45) NULL,
  `MEASURE` VARCHAR(45) NULL,
  `UNIT` VARCHAR(45) NULL,
  `VALUE` DOUBLE NULL,
  PRIMARY KEY (`SENSOR_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smarthome`.`RULE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smarthome`.`RULE` (
  `RULE_ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NULL,
  `INFERENCE_TYPE` VARCHAR(45) NULL,
  `DEDUCE` VARCHAR(45) NULL,
  `SUGGEST` VARCHAR(45) NULL,
  `UNIT` VARCHAR(45) NULL,
  `VALUE` DOUBLE NULL,
  `SENSOR_SENSOR_ID` INT NOT NULL,
  PRIMARY KEY (`RULE_ID`, `SENSOR_SENSOR_ID`),
  INDEX `fk_RULE_SENSOR_idx` (`SENSOR_SENSOR_ID` ASC),
  CONSTRAINT `fk_RULE_SENSOR`
    FOREIGN KEY (`SENSOR_SENSOR_ID`)
    REFERENCES `smarthome`.`SENSOR` (`SENSOR_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smarthome`.`RULE_ACTION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smarthome`.`RULE_ACTION` (
  `RULE_ACTION_ID` INT NOT NULL AUTO_INCREMENT,
  `LABEL` VARCHAR(100) NULL,
  `STATUS` VARCHAR(45) NULL,
  `VALUE` DOUBLE NULL,
  `RULE_RULE_ID` INT NOT NULL,
  `RULE_SENSOR_SENSOR_ID` INT NOT NULL,
  PRIMARY KEY (`RULE_ACTION_ID`, `RULE_RULE_ID`, `RULE_SENSOR_SENSOR_ID`),
  INDEX `fk_RULE_ACTION_RULE1_idx` (`RULE_RULE_ID` ASC, `RULE_SENSOR_SENSOR_ID` ASC),
  CONSTRAINT `fk_RULE_ACTION_RULE1`
    FOREIGN KEY (`RULE_RULE_ID` , `RULE_SENSOR_SENSOR_ID`)
    REFERENCES `smarthome`.`RULE` (`RULE_ID` , `SENSOR_SENSOR_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smarthome`.`ACTUATOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smarthome`.`ACTUATOR` (
  `ACTUATOR_ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NULL,
  `DESCRIPTION` VARCHAR(45) NULL,
  `RULE_ACTION_RULE_ACTION_ID` INT NOT NULL,
  `RULE_ACTION_RULE_RULE_ID` INT NOT NULL,
  `RULE_ACTION_RULE_SENSOR_SENSOR_ID` INT NOT NULL,
  PRIMARY KEY (`ACTUATOR_ID`, `RULE_ACTION_RULE_ACTION_ID`, `RULE_ACTION_RULE_RULE_ID`, `RULE_ACTION_RULE_SENSOR_SENSOR_ID`),
  INDEX `fk_ACTUATOR_RULE_ACTION1_idx` (`RULE_ACTION_RULE_ACTION_ID` ASC, `RULE_ACTION_RULE_RULE_ID` ASC, `RULE_ACTION_RULE_SENSOR_SENSOR_ID` ASC),
  CONSTRAINT `fk_ACTUATOR_RULE_ACTION1`
    FOREIGN KEY (`RULE_ACTION_RULE_ACTION_ID` , `RULE_ACTION_RULE_RULE_ID` , `RULE_ACTION_RULE_SENSOR_SENSOR_ID`)
    REFERENCES `smarthome`.`RULE_ACTION` (`RULE_ACTION_ID` , `RULE_RULE_ID` , `RULE_SENSOR_SENSOR_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
