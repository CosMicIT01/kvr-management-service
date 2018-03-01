
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table db_registration_management_service.tbl_agent
CREATE TABLE `tbl_address` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`address_linkregistrationid` INT(10) UNSIGNED NULL DEFAULT NULL,
	`street` VARCHAR(50) NULL DEFAULT NULL,
	`housenumber` INT(11) NULL DEFAULT NULL,
	`zip` VARCHAR(10) NULL DEFAULT NULL,
	`city` VARCHAR(20) NULL DEFAULT NULL,
	`state` VARCHAR(10) NULL DEFAULT NULL,
	`country` VARCHAR(20) NULL DEFAULT NULL,
	`countrycode` VARCHAR(3) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `address_id_uindex` (`id`),
	INDEX `fk_address_linkregistrationid` (`address_linkregistrationid`),
	CONSTRAINT `fk_address_linkregistrationid` FOREIGN KEY (`address_linkregistrationid`) REFERENCES `tbl_registration` (`id`) ON UPDATE CASCADE ON DELETE SET NULL
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;


-- Data exporting was unselected.
-- Dumping structure for table db_registration_management_service.tbl_document
CREATE TABLE `tbl_registration` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`registrationdate` DATETIME NULL DEFAULT NULL,
	`lastregistrationdate` DATETIME NULL DEFAULT NULL,
	`createdby` VARCHAR(20) NULL DEFAULT NULL,
	`modifiedby` VARCHAR(20) NULL DEFAULT NULL,
	`createddate` DATE NULL DEFAULT NULL,
	`modifieddate` DATE NULL DEFAULT NULL,
	`currentaddress` INT(10) UNSIGNED NULL DEFAULT NULL,
	`previousaddress` INT(10) UNSIGNED NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `registration_id_uindex` (`id`),
	INDEX `fk_registration_currentaddress` (`currentaddress`),
	INDEX `fk_registration_previousaddress` (`previousaddress`),
	CONSTRAINT `fk_registration_currentaddress` FOREIGN KEY (`currentaddress`) REFERENCES `tbl_address` (`id`) ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT `fk_registration_previousaddress` FOREIGN KEY (`previousaddress`) REFERENCES `tbl_address` (`id`) ON UPDATE CASCADE ON DELETE SET NULL
) ENGINE=InnoDB;



-- Data exporting was unselected.
-- Dumping structure for table db_registration_management_service.tbl_document
CREATE TABLE IF NOT EXISTS `tbl_person` (
  `id`  INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `gender` VARCHAR(8) DEFAULT NULL,
  `countryoforigin` VARCHAR(20) DEFAULT NULL,
  `createdby` varchar(20) DEFAULT NULL,
  `modifiedby` varchar(20) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  `person_link_registration_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `person_id_uindex` (`id`),
  KEY `fk_person_registration` (`person_link_registration_id`),
  CONSTRAINT `fk_person_registration` FOREIGN KEY (`person_link_registration_id`) REFERENCES `tbl_registration` (`id`)
) ENGINE=InnoDB;

-- Data exporting was unselected.
-- Dumping structure for table db_registration_management_service..tbl_user
CREATE TABLE IF NOT EXISTS `tbl_user` (
  `id`  INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- Data exporting was unselected.
-- Dumping structure for table db_registration_management_service.tbl_transaction
CREATE TABLE IF NOT EXISTS `tbl_transaction` (
  `id`  INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `transactiondate` datetime DEFAULT NULL,
  `createdby` varchar(20) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `transaction_id_uindex` (`id`)
) ENGINE=InnoDB;


-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;