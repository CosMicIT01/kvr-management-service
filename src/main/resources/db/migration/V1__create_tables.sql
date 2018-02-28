
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table db_registration_management_service.tbl_agent
CREATE TABLE IF NOT EXISTS `tbl_address` (
  `id`  INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `street` varchar(50) DEFAULT NULL,
  `housenumber` int(11) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `countrycode` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `address_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table db_registration_management_service.tbl_document
CREATE TABLE `tbl_registration` (
	`id`  INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`registrationdate` DATETIME NULL DEFAULT NULL,
	`lastregistrationdate` DATETIME NULL DEFAULT NULL,
	`createdby` VARCHAR(20) NULL DEFAULT NULL,
	`modifiedby` VARCHAR(20) NULL DEFAULT NULL,
	`createddate` DATE NULL DEFAULT NULL,
	`modifieddate` DATE NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `registration_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table db_registration_management_service..tbl_user
CREATE TABLE IF NOT EXISTS `tbl_user` (
  `id`  INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table db_registration_management_service.tbl_transaction
CREATE TABLE IF NOT EXISTS `tbl_transaction` (
  `id`  INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `transactiondate` datetime DEFAULT NULL,
  `createdby` varchar(20) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `transaction_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;