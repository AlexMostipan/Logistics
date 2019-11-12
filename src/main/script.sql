SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
create database niko_logistics;
use niko_logistics;
CREATE TABLE IF NOT EXISTS `niko_logistics`.`client` (
    `client_id` INT NOT NULL AUTO_INCREMENT,
    `fullName` VARCHAR(255),
    `email` VARCHAR(255),
    `phone` VARCHAR(255),
	PRIMARY KEY (`client_id`))
    ENGINE = InnoDB CHARACTER SET=UTF8;
    


CREATE TABLE IF NOT EXISTS `niko_logistics`.`cargo` (
    `cargo_id` INT NOT NULL AUTO_INCREMENT,
    `weight` INT NOT NULL,
    `cargo_type` VARCHAR(255),
	`client_id` INT NOT NULL,
    `container_id` INT NOT NULL,
	PRIMARY KEY (`cargo_id`),
    FOREIGN KEY (client_id)  REFERENCES client (client_id) 
	ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (container_id)  REFERENCES container (container_id) 
	ON DELETE CASCADE ON UPDATE CASCADE)
    ENGINE = InnoDB CHARACTER SET=UTF8;
    
CREATE TABLE IF NOT EXISTS `niko_logistics`.`port` (
    `port_id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
    `city_id` INT NOT NULL,
    `country` VARCHAR(255),
	PRIMARY KEY (`port_id`) ,
    FOREIGN KEY (city_id)  REFERENCES city (city_id) 
	ON DELETE CASCADE ON UPDATE CASCADE )
    ENGINE = InnoDB CHARACTER SET=UTF8;

CREATE TABLE IF NOT EXISTS `niko_logistics`.`container` (
    `container_id` INT NOT NULL AUTO_INCREMENT,
    `container_type` VARCHAR(255),
    `max_weight` INT NOT NULL,
    PRIMARY KEY (`container_id`))
    ENGINE = InnoDB CHARACTER SET=UTF8;
    
CREATE TABLE IF NOT EXISTS `niko_logistics`.`company` (
    `company_id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
    `company_type` VARCHAR(255),
    `cost_perkm` INT NOT NULL,
    PRIMARY KEY (`company_id`))
    ENGINE = InnoDB CHARACTER SET=UTF8;
INSERT INTO company (company_id, name, company_type, cost_perkm)
VALUES (1 , 'Ukrainian land logistics','Land delivery', 2),
(2 , 'DELPOST','Land delivery', 3),
(3 , 'Fair Logics','Land delivery', 4),
(4 , 'Global Ocean Link','Sea delivery', 2),
(5 , 'Лоджистик Технолоджис','Sea delivery', 3),
(6 , 'Raben','Sea delivery', 4)
;
    
CREATE TABLE IF NOT EXISTS `niko_logistics`.`delivery_land` (
    `delivery_land_id` INT NOT NULL AUTO_INCREMENT,
    `company_id` INT NOT NULL,
    `cost_perkm` INT NOT NULL,
    PRIMARY KEY (`delivery_land_id`) ,
    FOREIGN KEY (company_id)  REFERENCES company (company_id) 
	ON DELETE CASCADE ON UPDATE CASCADE )
    ENGINE = InnoDB CHARACTER SET=UTF8;
CREATE TABLE IF NOT EXISTS `niko_logistics`.`delivery_sea` (
    `delivery_sea_id` INT NOT NULL AUTO_INCREMENT,
    `company_id` INT NOT NULL,
    `cost_perkm` INT NOT NULL,
    PRIMARY KEY (`delivery_sea_id`),
    FOREIGN KEY (company_id)  REFERENCES company (company_id) 
	ON DELETE CASCADE ON UPDATE CASCADE )
    ENGINE = InnoDB CHARACTER SET=UTF8;
    
    CREATE TABLE IF NOT EXISTS `niko_logistics`.`loading` (
    `loading_id` INT NOT NULL AUTO_INCREMENT,
    `port_id` INT NOT NULL,
    `cost` INT NOT NULL,
    PRIMARY KEY (`loading_id`),
    FOREIGN KEY (port_id)  REFERENCES port (port_id) 
	ON DELETE CASCADE ON UPDATE CASCADE )
    ENGINE = InnoDB CHARACTER SET=UTF8;
    
  CREATE TABLE IF NOT EXISTS `niko_logistics`.`unloading` (
    `unloading_id` INT NOT NULL AUTO_INCREMENT,
    `port_id` INT NOT NULL,
    `cost` INT NOT NULL,
    PRIMARY KEY (`unloading_id`),
    FOREIGN KEY (port_id)  REFERENCES port (port_id) 
	ON DELETE CASCADE ON UPDATE CASCADE )
    ENGINE = InnoDB CHARACTER SET=UTF8;
CREATE TABLE IF NOT EXISTS `niko_logistics`.`order` (
    `order_id` INT NOT NULL AUTO_INCREMENT,
    `client_id` INT NOT NULL,
    `cargo_id` INT NOT NULL,
    `city_from_id` INT ,
    `city_to_id` INT ,
    `unloading_id` INT NOT NULL ,
    `loading_id` INT NOT NULL,
    `delivery_land_id` INT ,
    `delivery_sea_id` INT NOT NULL,
    `all_cost` INT NOT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (client_id)  REFERENCES client (client_id)
	ON DELETE CASCADE ON UPDATE CASCADE, 
     FOREIGN KEY (cargo_id)  REFERENCES cargo (cargo_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (city_from_id)  REFERENCES city (city_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (city_to_id)  REFERENCES city (city_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (unloading_id)  REFERENCES unloading (unloading_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (loading_id)  REFERENCES loading (loading_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (delivery_land_id)  REFERENCES delivery_land (delivery_land_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (delivery_sea_id)  REFERENCES delivery_sea (delivery_sea_id)
	ON DELETE CASCADE ON UPDATE CASCADE
    )
    ENGINE = InnoDB CHARACTER SET=UTF8;
	
    CREATE TABLE IF NOT EXISTS `niko_logistics`.`city` (
    `city_id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR (255),
    PRIMARY KEY (`city_id`))
    ENGINE = InnoDB CHARACTER SET=UTF8;


INSERT INTO port (port_id, name, city_id, country)
VALUES (1 , 'Порт ОДЕССА',1, 'UA'),
(2 , ' Порт Ильечевск',2, 'UA'),
(3 , ' Порт Токио ',3, 'JP');


SET FOREIGN_KEY_CHECKS = 1;


