DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`user_seq` INT NOT NULL AUTO_INCREMENT,
	`user_id` VARCHAR(30) NULL,
	`user_pwd` VARCHAR(30) NULL,
	`user_name` VARCHAR(30) NULL,
	`email_id` VARCHAR(30) NULL,
	`email_domain` VARCHAR(30) NULL,
	`phone` VARCHAR(30) NULL,
	`birth` DATETIME NULL,
	`gender` CHAR(1) NULL COMMENT 'F : 여자, M : 남자',
	`created_date` DATETIME NULL DEFAULT NOW(),
	`is_admin` BOOLEAN NULL DEFAULT FALSE,
	`is_valid` BOOLEAN NULL DEFAULT FALSE, 
	`token` VARCHAR(1000) NULL DEFAULT NULL,
	PRIMARY KEY (`user_seq`)
);

DROP TABLE IF EXISTS `integration`;

CREATE TABLE `integration` (
	`integ_seq` INT NOT NULL AUTO_INCREMENT,
	`user_seq` INT NULL,
	`recipe_seq` INT NULL,
	`product_seq` INT NULL, 
	PRIMARY KEY (`integ_seq`)
);

DROP TABLE IF EXISTS `image`;

CREATE TABLE `image` (
	`image_seq` INT NOT NULL AUTO_INCREMENT,
	`integ_seq` INT NOT NULL,
	`origin_name` VARCHAR(50) NULL,
	`save_name` VARCHAR(50) NULL,
	`save_folder` VARCHAR(45) NULL,
	`size` INT NULL,
	`created_date` DATETIME NULL DEFAULT NOW(),
	`is_deleted` BOOLEAN NULL  DEFAULT FALSE,
	`primary_image` BOOLEAN NULL DEFAULT FALSE, 
	PRIMARY KEY (`image_seq`)
);

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
	`company_seq` INT NOT NULL AUTO_INCREMENT,
	`company_name` VARCHAR(50) NULL, 
	PRIMARY KEY (`company_seq`)
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`product_seq` INT NOT NULL AUTO_INCREMENT,
	`product_name` VARCHAR(30) NULL,
	`company_seq` INT NOT NULL,
	`area_seq` INT NOT NULL,
	`weight` VARCHAR(10) NULL,
	`product_info` VARCHAR(500) NULL,
	`price` INT NULL,
	`discount_price` INT NULL,
	`discount_rate` FLOAT NULL DEFAULT 0,
	`stock` INT NULL,
	`is_deleted` BOOLEAN NULL DEFAULT FALSE, 
	PRIMARY KEY (`product_seq`)
);

DROP TABLE IF EXISTS `product_comment`;

CREATE TABLE `product_comment` (
	`product_comment_seq` INT NOT NULL AUTO_INCREMENT,
	`product_seq` INT NOT NULL,
	`user_seq` INT NOT NULL,
	`title` VARCHAR(50) NULL,
	`detail` VARCHAR(500) NULL,
	`star_point` FLOAT NULL COMMENT '0~5점/ 0.5간격',
	`created_date` DATETIME NULL DEFAULT NOW(),
	`updated_date` DATETIME NULL, 
	PRIMARY KEY (`product_comment_seq`)
);

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
	`area_seq` INT NOT NULL AUTO_INCREMENT,
	`area_name` VARCHAR(30) NULL,
	`area_x` SMALLINT NOT NULL, 
	`area_y` SMALLINT NOT NULL,
	PRIMARY KEY (`area_seq`)
);

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
	`cart_seq` INT NOT NULL AUTO_INCREMENT,
	`user_seq` INT NOT NULL,
	`cart_name` VARCHAR(30) NULL,
	`created_date` DATETIME NULL DEFAULT NOW(),
	`total_price` INT NULL DEFAULT 0, 
	PRIMARY KEY (`cart_seq`)
);

DROP TABLE IF EXISTS `cart_detail`;

CREATE TABLE `cart_detail` (
	`cart_detail_seq` INT NOT NULL AUTO_INCREMENT,
	`cart_seq` INT NOT NULL,
	`product_seq` INT NOT NULL,
	`cnt` SMALLINT NULL,
	`price` INT NULL, 
	`discount_price` INT NULL,
	PRIMARY KEY (`cart_detail_seq`)
);

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
	`purchase_seq` INT NOT NULL AUTO_INCREMENT,
	`user_seq` INT NOT NULL,
	`purchase_date` DATETIME NULL DEFAULT NOW(),
	`total_price` INT NULL DEFAULT 0, 
	PRIMARY KEY (`purchase_seq`)
);

DROP TABLE IF EXISTS `purchase_detail`;

CREATE TABLE `purchase_detail` (
	`purchase_detail_seq` INT NOT NULL AUTO_INCREMENT,
	`purchase_seq` INT NOT NULL,
	`product_seq` INT NOT NULL,
	`cnt` SMALLINT NULL,
	`price` INT NULL,
	`discount_price` INT NULL, 
	PRIMARY KEY (`purchase_detail_seq`)
);

DROP TABLE IF EXISTS `theme`;

CREATE TABLE `theme` (
	`theme_seq` INT NOT NULL AUTO_INCREMENT,
	`theme_name` VARCHAR(30) NULL, 
	PRIMARY KEY (`theme_seq`)
);

DROP TABLE IF EXISTS `recipe`;

CREATE TABLE `recipe` (
	`recipe_seq` INT NOT NULL AUTO_INCREMENT,
	`theme_seq` INT NOT NULL,
	`user_seq` INT NULL,
	`recipe_name` VARCHAR(30) NULL,
	`detail` TEXT NULL,
	`recipe_like_cnt` INT NULL DEFAULT 0,
	`admin_chk` BOOLEAN NULL DEFAULT FALSE,
	`is_deleted` BOOLEAN NULL DEFAULT FALSE,
	`created_date` DATETIME NULL DEFAULT NOW(),
	`updated_date` DATETIME NULL, 
	PRIMARY KEY (`recipe_seq`)
);

DROP TABLE IF EXISTS `recipe_detail`;

CREATE TABLE `recipe_detail` (
	`recipe_detail_seq` INT NOT NULL AUTO_INCREMENT,
	`recipe_seq` INT NOT NULL, 
	`product_seq` INT NOT NULL,
	`cnt` INT NULL,
	PRIMARY KEY (`recipe_detail_seq`)
);

DROP TABLE IF EXISTS `recipe_comment`;

CREATE TABLE `recipe_comment` (
	`recipe_comment_seq` INT NOT NULL AUTO_INCREMENT,
	`recipe_seq` INT NOT NULL,
	`user_seq` INT NOT NULL,
	`recipe_content` VARCHAR(500) NULL,
	`created_date` DATETIME NULL DEFAULT NOW(),
	`updated_date` DATETIME NULL,
	`is_deleted` BOOLEAN NULL DEFAULT FALSE, 
	PRIMARY KEY (`recipe_comment_seq`)
);

DROP TABLE IF EXISTS `recipe_like`;

CREATE TABLE `recipe_like` (
	`user_seq` INT NOT NULL,
	`recipe_seq` INT NOT NULL
);

DROP TABLE IF EXISTS `follow`;

CREATE TABLE `follow` (
	`follow_seq` INT NOT NULL AUTO_INCREMENT,
	`following_id_seq` INT NOT NULL,
	`follower_id_seq` INT NOT NULL, 
	PRIMARY KEY (`follow_seq`)
);

DROP TABLE IF EXISTS `card`;

CREATE TABLE `card` (
	`card_seq` INT NOT NULL AUTO_INCREMENT,
	`user_seq` INT NOT NULL,
	`card_number` VARCHAR(20) NOT NULL,
	`card_pwd` INT NOT NULL,
	`valid_date` DATE NOT NULL, 
	PRIMARY KEY (`card_seq`)
);

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
	`car_seq` INT NOT NULL AUTO_INCREMENT,
	`user_seq` INT NOT NULL,
	`car_number` VARCHAR(10) NULL, 
	PRIMARY KEY (`car_seq`)
);

DROP TABLE IF EXISTS `parking`;

CREATE TABLE `parking` (
	`parking_seq` INT NOT NULL AUTO_INCREMENT,
	`car_seq` INT NOT NULL,
	`in_time` DATETIME NULL,
	`out_time` DATETIME NULL,
	`parking_time` INT NULL,
	`price` INT NULL, 
	PRIMARY KEY (`parking_seq`)
);

DROP TABLE IF EXISTS `location_log`;

CREATE TABLE `location_log` (
	`log_seq` INT NOT NULL AUTO_INCREMENT,
	`user_seq` INT NOT NULL,
	`date` DATETIME NULL, 
	`log_x` SMALLINT NULL,
	`log_y` SMALLINT NULL, 
	PRIMARY KEY (`log_seq`)
);

ALTER TABLE `integration` ADD CONSTRAINT `FK_user_TO_integration_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `integration` ADD CONSTRAINT `FK_recipe_TO_integration_1` FOREIGN KEY (`recipe_seq`)
REFERENCES `recipe` (`recipe_seq`);

ALTER TABLE `integration` ADD CONSTRAINT `FK_product_TO_integration_1` FOREIGN KEY (`product_seq`)
REFERENCES `product` (`product_seq`);

ALTER TABLE `image` ADD CONSTRAINT `FK_integration_TO_image_1` FOREIGN KEY (`integ_seq`)
REFERENCES `integration` (`integ_seq`) ON DELETE CASCADE;

ALTER TABLE `product` ADD CONSTRAINT `FK_company_TO_product_1` FOREIGN KEY (`company_seq`)
REFERENCES `company` (`company_seq`);

ALTER TABLE `product` ADD CONSTRAINT `FK_area_TO_product_1` FOREIGN KEY (`area_seq`)
REFERENCES `area` (`area_seq`);

ALTER TABLE `product_comment` ADD CONSTRAINT `FK_product_TO_product_comment_1` FOREIGN KEY (`product_seq`)
REFERENCES `product` (`product_seq`);

ALTER TABLE `product_comment` ADD CONSTRAINT `FK_user_TO_product_comment_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `cart` ADD CONSTRAINT `FK_user_TO_cart_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `cart_detail` ADD CONSTRAINT `FK_cart_TO_cart_detail_1` FOREIGN KEY (`cart_seq`)
REFERENCES `cart` (`cart_seq`);

ALTER TABLE `cart_detail` ADD CONSTRAINT `FK_product_TO_cart_detail_1` FOREIGN KEY (`product_seq`)
REFERENCES `product` (`product_seq`);

ALTER TABLE `purchase` ADD CONSTRAINT `FK_user_TO_purchase_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `purchase_detail` ADD CONSTRAINT `FK_purchase_TO_purchase_detail_1` FOREIGN KEY (`purchase_seq`)
REFERENCES `purchase` (`purchase_seq`);

ALTER TABLE `purchase_detail` ADD CONSTRAINT `FK_product_TO_purchase_detail_1` FOREIGN KEY (`product_seq`)
REFERENCES `product` (`product_seq`);

ALTER TABLE `recipe` ADD CONSTRAINT `FK_theme_TO_recipe_1` FOREIGN KEY (`theme_seq`)
REFERENCES `theme` (`theme_seq`);

ALTER TABLE `recipe` ADD CONSTRAINT `FK_user_TO_recipe_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `recipe_comment` ADD CONSTRAINT `FK_recipe_TO_comment_recipe_1` FOREIGN KEY (`recipe_seq`)
REFERENCES `recipe` (`recipe_seq`);

ALTER TABLE `recipe_comment` ADD CONSTRAINT `FK_user_TO_comment_recipe_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `recipe_detail` ADD CONSTRAINT `FK_product_TO_recipe_detail_1` FOREIGN KEY (`product_seq`)
REFERENCES `product` (`product_seq`);

ALTER TABLE `recipe_detail` ADD CONSTRAINT `FK_recipe_TO_recipe_detail_1` FOREIGN KEY (`recipe_seq`)
REFERENCES `recipe` (`recipe_seq`);

ALTER TABLE `recipe_like` ADD CONSTRAINT `FK_user_TO_recipe_like_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `recipe_like` ADD CONSTRAINT `FK_recipe_TO_recipe_like_1` FOREIGN KEY (`recipe_seq`)
REFERENCES `recipe` (`recipe_seq`);

ALTER TABLE `follow` ADD CONSTRAINT `FK_user_TO_follow_1` FOREIGN KEY (`following_id_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `follow` ADD CONSTRAINT `FK_user_TO_follow_2` FOREIGN KEY (`follower_id_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `card` ADD CONSTRAINT `FK_user_TO_card_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `car` ADD CONSTRAINT `FK_user_TO_car_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` (`user_seq`);

ALTER TABLE `parking` ADD CONSTRAINT `FK_car_TO_parking_1` FOREIGN KEY (`car_seq`)
REFERENCES `car` (`car_seq`);

ALTER TABLE `location_log` ADD CONSTRAINT `FK_user_TO_location_log_1` FOREIGN KEY (`user_seq`)
REFERENCES `user` ( `user_seq`);