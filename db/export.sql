CREATE SCHEMA IF NOT EXISTS `question_bank` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `question_bank` ;

-- -----------------------------------------------------
-- Table `question_bank`.`qb_topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `question_bank`.`qb_topic` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(63) NOT NULL,
  `added_date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `question_bank`.`qb_level`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `question_bank`.`qb_level` (
  `id` VARCHAR(45) NOT NULL,
  `code` VARCHAR(15) NOT NULL,
  `added_date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`code` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `question_bank`.`qb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `question_bank`.`qb_user` (
  `id` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(31) NOT NULL,
  `full_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`user_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `question_bank`.`qb_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `question_bank`.`qb_question` (
  `id` VARCHAR(45) NOT NULL,
  `text` VARCHAR(5000) NOT NULL,
  `added_date` TIMESTAMP NOT NULL,
  `last_updated_date` TIMESTAMP NOT NULL,
  `topic_id` VARCHAR(45) NOT NULL,
  `level_id` VARCHAR(45) NOT NULL,
  `submitter_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_question_topic1_idx` (`topic_id` ASC),
  INDEX `fk_question_level1_idx` (`level_id` ASC),
  INDEX `fk_question_user1_idx` (`submitter_id` ASC),
  CONSTRAINT `fk_question_topic1`
    FOREIGN KEY (`topic_id`)
    REFERENCES `question_bank`.`qb_topic` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_question_level1`
    FOREIGN KEY (`level_id`)
    REFERENCES `question_bank`.`qb_level` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_question_user1`
    FOREIGN KEY (`submitter_id`)
    REFERENCES `question_bank`.`qb_user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `question_bank`.`qb_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `question_bank`.`qb_option` (
  `id` VARCHAR(45) NOT NULL,
  `text` VARCHAR(1000) NOT NULL,
  `added_date` TIMESTAMP NOT NULL,
  `last_updated_date` TIMESTAMP NOT NULL,
  `question_id` VARCHAR(45) NOT NULL,
  `correct_option` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_option_question1_idx` (`question_id` ASC),
  CONSTRAINT `fk_option_question1`
    FOREIGN KEY (`question_id`)
    REFERENCES `question_bank`.`qb_question` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;