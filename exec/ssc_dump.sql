/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `smartshoppingcart`;
CREATE DATABASE IF NOT EXISTS `smartshoppingcart` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `smartshoppingcart`;

DROP TABLE IF EXISTS `area`;
CREATE TABLE IF NOT EXISTS `area` (
  `area_seq` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(30) DEFAULT NULL,
  `area_x` smallint(6) NOT NULL,
  `area_y` smallint(6) NOT NULL,
  PRIMARY KEY (`area_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` (`area_seq`, `area_name`, `area_x`, `area_y`) VALUES
	(1, '채소', 4, 12),
	(2, '과일', 8, 12),
	(3, '쌀/잡곡', 2, 16),
	(4, '견과', 5, 16),
	(5, '수산물/건어물', 1, 10),
	(6, '정육/계란', 1, 3),
	(7, '우유/유제품', 4, 1),
	(8, '통조림', 4, 4),
	(9, '냉동/밀키트', 8, 4),
	(10, '장류/양념', 5, 8),
	(11, '라면/즉석식품', 4, 4),
	(12, '커피/차', 7, 1),
	(13, '생수/음료', 6, 1),
	(14, '과자/시리얼', 6, 7);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;

DROP TABLE IF EXISTS `car`;
CREATE TABLE IF NOT EXISTS `car` (
  `car_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_seq` int(11) NOT NULL,
  `car_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`car_seq`),
  KEY `FK_user_TO_car_1` (`user_seq`),
  CONSTRAINT `FK_user_TO_car_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `car` DISABLE KEYS */;
/*!40000 ALTER TABLE `car` ENABLE KEYS */;

DROP TABLE IF EXISTS `card`;
CREATE TABLE IF NOT EXISTS `card` (
  `card_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_seq` int(11) NOT NULL,
  `card_number` varchar(20) NOT NULL,
  `card_pwd` int(11) NOT NULL,
  `valid_date` date NOT NULL,
  PRIMARY KEY (`card_seq`),
  KEY `FK_user_TO_card_1` (`user_seq`),
  CONSTRAINT `FK_user_TO_card_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `card` DISABLE KEYS */;
/*!40000 ALTER TABLE `card` ENABLE KEYS */;

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `cart_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_seq` int(11) NOT NULL,
  `cart_name` varchar(30) DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  `total_price` int(11) DEFAULT 0,
  PRIMARY KEY (`cart_seq`),
  KEY `FK_user_TO_cart_1` (`user_seq`),
  CONSTRAINT `FK_user_TO_cart_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` (`cart_seq`, `user_seq`, `cart_name`, `created_date`, `total_price`) VALUES
	(7, 1, '이번주 장바구니', '2023-02-13 13:16:28', 13900),
	(9, 2, '저녁 장바구니', '2023-02-13 13:45:39', 12500),
	(10, 1, '백종원 찜닭 장바구니', '2023-02-14 17:30:28', 27000),
	(11, 1, '백종원 오징어볶음 장바구니', '2023-02-14 17:31:38', 17900),
	(30, 1, '금요일 저녁 메뉴', '2023-02-15 16:14:28', 10900),
	(33, 1, '[레시피 장바구니]대패삼겹콩불 ', '2023-02-15 22:58:42', 19490),
	(34, 1, '[레시피 장바구니]대패삼겹콩불 ', '2023-02-15 22:59:10', 5000),
	(35, 1, '[레시피 장바구니]시금치무침 ', '2023-02-15 23:01:31', 1500),
	(62, 1, '[레시피 장바구니]들기름계란후라이 ', '2023-02-16 08:46:51', 17570),
	(63, 1, '[레시피 장바구니]la양념갈비 ', '2023-02-16 08:47:12', NULL),
	(65, 1, '자취인 필수 재료', '2023-02-16 08:48:41', 3900),
	(70, 2, '[레시피 장바구니]대패삼겹콩불 ', '2023-02-16 09:32:16', 19490),
	(71, 2, '[레시피 장바구니]시금치무침 ', '2023-02-16 09:32:47', 1500),
	(77, 1, '[레시피 장바구니]참치감자조림 ', '2023-02-16 13:06:55', 2000),
	(78, 1, 'dd', '2023-02-16 14:43:31', 8900),
	(94, 1, '[레시피 장바구니]오징어 볶음 ', '2023-02-16 18:15:11', 9500),
	(95, 2, '[레시피 장바구니]대패삼겹콩불 ', '2023-02-16 21:28:00', 16490),
	(96, 1, '[레시피 장바구니]시금치무침 ', '2023-02-16 21:39:11', 1500),
	(97, 1, '2/18일 장볼 것', '2023-02-16 21:40:25', 18990),
	(98, 1, '[레시피 장바구니]호박볶음 ', '2023-02-16 21:46:40', 4500),
	(99, 1, '찜닭 재료', '2023-02-16 21:47:53', 12000),
	(100, 2, '[레시피 장바구니]호박볶음 ', '2023-02-16 21:53:34', 11500),
	(101, 2, '찜닭재료', '2023-02-16 21:54:35', 12000),
	(102, 2, '[레시피 장바구니]스크램블에그 ', '2023-02-16 21:55:05', 9500),
	(103, 2, '[레시피 장바구니]시금치무침 ', '2023-02-16 22:26:27', 1500),
	(104, 2, '[레시피 장바구니]오징어 볶음 ', '2023-02-16 22:30:52', 12900),
	(105, 2, '찜닭', '2023-02-16 22:31:42', 17000);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;

DROP TABLE IF EXISTS `cart_detail`;
CREATE TABLE IF NOT EXISTS `cart_detail` (
  `cart_detail_seq` int(11) NOT NULL AUTO_INCREMENT,
  `cart_seq` int(11) NOT NULL,
  `product_seq` int(11) NOT NULL,
  `cnt` smallint(6) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `discount_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_detail_seq`),
  KEY `FK_product_TO_cart_detail_1` (`product_seq`),
  KEY `FK_cart_TO_cart_detail_1` (`cart_seq`),
  CONSTRAINT `FK_cart_TO_cart_detail_1` FOREIGN KEY (`cart_seq`) REFERENCES `cart` (`cart_seq`) ON DELETE CASCADE,
  CONSTRAINT `FK_product_TO_cart_detail_1` FOREIGN KEY (`product_seq`) REFERENCES `product` (`product_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `cart_detail` DISABLE KEYS */;
INSERT INTO `cart_detail` (`cart_detail_seq`, `cart_seq`, `product_seq`, `cnt`, `price`, `discount_price`) VALUES
	(1, 7, 3, 1, 3900, 0),
	(2, 7, 5, 1, 10000, 0),
	(3, 9, 7, 2, 3000, 0),
	(4, 9, 8, 1, 1500, 0),
	(5, 9, 10, 1, 5000, 0),
	(6, 10, 5, 1, 10000, 0),
	(7, 10, 1, 1, 5000, 0),
	(8, 10, 8, 1, 1500, 0),
	(9, 10, 9, 1, 2000, 0),
	(10, 10, 10, 1, 5000, 0),
	(11, 11, 19, 1, 9900, 0),
	(13, 11, 49, 1, 1500, 0),
	(14, 11, 53, 1, 1500, 0),
	(15, 11, 10, 1, 5000, 0),
	(22, 30, 1, 1, 5000, 0),
	(24, 30, 4, 1, 5900, 0),
	(25, 10, 14, 1, 2000, 0),
	(26, 10, 16, 1, 1500, 0),
	(27, 33, 10, 1, 5000, 0),
	(28, 33, 45, 1, 9990, 0),
	(29, 33, 46, 1, 1500, 0),
	(30, 33, 49, 1, 1500, 0),
	(31, 33, 53, 1, 1500, 0),
	(32, 34, 10, 1, 5000, 0),
	(35, 35, 8, 1, 1500, 0),
	(40, 62, 3, 1, 3900, 0),
	(42, 62, 95, 1, 13670, 0),
	(47, 65, 3, 1, 3900, 0),
	(50, 70, 10, 1, 5000, 0),
	(51, 70, 45, 1, 9990, 0),
	(52, 70, 46, 1, 1500, 0),
	(53, 70, 49, 1, 1500, 0),
	(54, 70, 53, 1, 1500, 0),
	(55, 71, 47, 1, 1500, 0),
	(57, 77, 6, 1, 2000, 0),
	(59, 78, 1, 1, 5000, 0),
	(60, 78, 3, 1, 3900, 0),
	(61, 94, 10, 1, 5000, 0),
	(63, 94, 46, 1, 1500, 0),
	(64, 94, 49, 1, 1500, 0),
	(65, 94, 53, 1, 1500, 0),
	(66, 95, 10, 1, 5000, 0),
	(67, 95, 45, 1, 9990, 0),
	(68, 95, 53, 1, 1500, 0),
	(69, 96, 47, 1, 1500, 0),
	(70, 97, 5, 1, 10000, 0),
	(71, 97, 69, 1, 8990, 0),
	(72, 98, 8, 1, 1500, 0),
	(73, 98, 16, 1, 1500, 0),
	(74, 98, 48, 1, 1500, 0),
	(75, 99, 5, 1, 10000, 0),
	(76, 99, 14, 1, 2000, 0),
	(77, 100, 8, 1, 1500, 0),
	(78, 100, 9, 1, 2000, 0),
	(79, 100, 10, 1, 5000, 0),
	(80, 100, 16, 1, 1500, 0),
	(81, 100, 48, 1, 1500, 0),
	(82, 101, 5, 1, 10000, 0),
	(83, 101, 14, 1, 2000, 0),
	(84, 102, 6, 1, 2000, 0),
	(85, 102, 11, 1, 7500, 0),
	(86, 103, 47, 1, 1500, 0),
	(87, 104, 19, 1, 9900, 0),
	(88, 104, 49, 1, 1500, 0),
	(89, 104, 53, 1, 1500, 0),
	(90, 105, 1, 1, 5000, 0),
	(91, 105, 5, 1, 10000, 0),
	(92, 105, 14, 1, 2000, 0);
/*!40000 ALTER TABLE `cart_detail` ENABLE KEYS */;

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `company_seq` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`company_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`company_seq`, `company_name`) VALUES
	(1, 'CJ'),
	(2, '하림'),
	(3, '풀무원'),
	(4, '동원'),
	(5, '태성식품'),
	(6, '롯데'),
	(7, '삼립'),
	(8, '오뚜기'),
	(9, '청정원'),
	(10, '해표'),
	(11, '샘표'),
	(12, '농협'),
	(13, '남양'),
	(14, '빙그레');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

DROP TABLE IF EXISTS `follow`;
CREATE TABLE IF NOT EXISTS `follow` (
  `follow_seq` int(11) NOT NULL AUTO_INCREMENT,
  `following_id_seq` int(11) NOT NULL,
  `follower_id_seq` int(11) NOT NULL,
  PRIMARY KEY (`follow_seq`),
  KEY `FK_user_TO_follow_1` (`following_id_seq`),
  KEY `FK_user_TO_follow_2` (`follower_id_seq`),
  CONSTRAINT `FK_user_TO_follow_1` FOREIGN KEY (`following_id_seq`) REFERENCES `user` (`user_seq`),
  CONSTRAINT `FK_user_TO_follow_2` FOREIGN KEY (`follower_id_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;

DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `image_seq` int(11) NOT NULL AUTO_INCREMENT,
  `integ_seq` int(11) NOT NULL,
  `origin_name` varchar(50) DEFAULT NULL,
  `save_name` varchar(50) DEFAULT NULL,
  `save_folder` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  `is_deleted` tinyint(1) DEFAULT 0,
  `primary_image` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`image_seq`),
  KEY `FK_integration_TO_image_1` (`integ_seq`),
  CONSTRAINT `FK_integration_TO_image_1` FOREIGN KEY (`integ_seq`) REFERENCES `integration` (`integ_seq`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` (`image_seq`, `integ_seq`, `origin_name`, `save_name`, `save_folder`, `size`, `created_date`, `is_deleted`, `primary_image`) VALUES
	(1, 1, 'intp.png', 'ssafy.png', '/home/ubuntu/Image/User', NULL, '2023-02-09 13:39:54', 0, 0),
	(2, 2, 'estp.png', 'ssafy2.png', '/home/ubuntu/Image/User', NULL, '2023-02-09 13:40:17', 0, 0),
	(3, 3, '간장.png', '간장.png', '/home/ubuntu/Image/Product', NULL, '2023-02-09 15:38:25', 0, 0),
	(5, 5, '계란 한 판.jpg', '계란.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-09 16:09:48', 0, 0),
	(6, 6, '김밥김.jpg', '김밥김.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-10 11:25:23', 0, 0),
	(7, 7, '닭.png', '생닭.png', '/home/ubuntu/Image/Product', NULL, '2023-02-10 11:28:58', 0, 0),
	(8, 8, '동원참치.jpg', '참치 통조림.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-10 11:30:47', 0, 0),
	(9, 9, '스팸.jpg', '스팸.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-10 11:32:57', 0, 0),
	(10, 10, '마늘.png', '마늘.png', '/home/ubuntu/Image/Product', NULL, '2023-02-10 11:34:59', 0, 0),
	(11, 11, '양파.jpg', '양파.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-10 11:36:02', 0, 0),
	(12, 12, '대파.png', '대파.png', '/home/ubuntu/Image/Product', NULL, '2023-02-10 11:38:28', 0, 0),
	(13, 13, '올리브유.jpg', '올리브유.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-10 11:40:53', 0, 0),
	(14, 14, '닭2.jpg', '생닭(팩).jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-10 11:47:56', 0, 0),
	(19, 20, 'esfj.png', 'ssafy3.png', '/home/ubuntu/Image/User', NULL, '2023-02-13 15:17:34', 0, 0),
	(20, 22, '백종원_간장계란밥.jpg', '간장계란밥1.jpg', '/home/ubuntu/Image/Recipe/간장계란밥', NULL, '2023-02-13 15:21:40', 0, 1),
	(21, 22, '6.jpg', '간장계란밥2.jpg', '/home/ubuntu/Image/Recipe/간장계란밥', NULL, '2023-02-13 15:21:40', 0, 0),
	(25, 25, 'main.jpg', '백종원의 찜닭 레시피1.jpg', '/home/ubuntu/Image/Recipe/백종원의 찜닭 레시피', NULL, '2023-02-14 16:00:49', 0, 1),
	(26, 25, 'main2.jpg', '백종원의 찜닭 레시피2.jpg', '/home/ubuntu/Image/Recipe/백종원의 찜닭 레시피', NULL, '2023-02-14 16:00:49', 0, 0),
	(27, 26, '감자.png', '감자.png', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:07:43', 0, 0),
	(28, 27, '낙지.jpg', '낙지.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:08:43', 0, 0),
	(29, 28, '당근.png', '싱싱한 당근.png', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:09:47', 0, 0),
	(30, 29, '블랙타이거새우.jpg', '블랙타이거새우.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:11:09', 0, 0),
	(31, 30, '당면.jpg', '납짝 당면.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:13:46', 0, 0),
	(32, 31, '오징어2.jpg', '손질 오징어.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:15:01', 0, 0),
	(33, 32, '오징어1.jpg', '손질오징어 .jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:17:49', 0, 0),
	(34, 33, '흰다리새우.jpg', '흰다리새우.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:20:12', 0, 0),
	(35, 34, '손질왕새우.jpg', '손질왕새우.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:21:52', 0, 0),
	(36, 35, '손질왕새우2.jpg', '손질왕새우 100g.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:22:19', 0, 0),
	(37, 36, '제주은갈치.jpg', '제주은갈치.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:24:18', 0, 0),
	(38, 37, '제주은갈치2.jpg', '제주 생물 갈치.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:24:42', 0, 0),
	(39, 38, '생연어.jpg', '항공직송 생연어.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:26:10', 0, 0),
	(40, 39, '훈제연어.jpg', '훈제 연어.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:26:46', 0, 0),
	(41, 40, '국산고등어.jpg', '고등어.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:28:53', 0, 0),
	(42, 41, '국산고등어2.jpg', '국산고등어.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:29:13', 0, 0),
	(43, 42, '뽀로로 순살 연어구이.jpg', '어린이 뽀로로 순살 연어구이.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:30:15', 0, 0),
	(44, 43, '영광참굴비.jpg', '영광참굴비.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:31:16', 0, 0),
	(45, 44, '안심한우 부채살.jpg', '안심한우 부채살.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:33:56', 0, 0),
	(46, 45, '안심한우 사태.jpg', '안심한우 사태.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:34:11', 0, 0),
	(47, 46, '안심한우 안심.jpg', '안심한우 안심.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:34:25', 0, 0),
	(48, 47, '냉동 농협안심 한우 차돌박이.jpg', '안심 한우 차돌박이.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:35:45', 0, 0),
	(49, 48, '안심한우 양지.jpg', '안심한우 양지.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:36:53', 0, 0),
	(50, 49, '안심한우 바로구이.jpg', '안심한우 바로구이.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:37:13', 0, 0),
	(51, 50, '냉동닭가슴살.jpg', '냉동닭가슴살.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:38:26', 0, 0),
	(52, 51, '황금닭 볶음탕용.jpg', '황금닭 볶음탕용.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:38:59', 0, 0),
	(53, 52, '냉동 닭안심.jpg', '냉동 닭안심.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:40:47', 0, 0),
	(54, 53, '온가족 닭볶음탕용.jpg', '온가족 닭볶음탕용.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:41:12', 0, 0),
	(55, 54, '돼지목심.jpg', '일품포크 돼지목심.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:42:51', 0, 0),
	(56, 55, '돼지삼겹살.jpg', '일품포크 돼지삼겹살.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:43:13', 0, 0),
	(57, 56, '당근2.jpg', '당근당근.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:44:46', 0, 0),
	(58, 57, '시금치.jpg', '해풍맞은 남해 시금치.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:45:06', 0, 0),
	(59, 58, '애호박.jpg', '애호박.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:45:39', 0, 0),
	(60, 59, '깐마늘.jpg', '깐마늘.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:47:19', 0, 0),
	(61, 60, '다다기오이.jpg', '다다기오이.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:47:34', 0, 0),
	(62, 61, '제주무.jpg', '제주무.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:47:48', 0, 0),
	(63, 62, '단단파프리카.jpg', '단단파프리카.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:48:42', 0, 0),
	(64, 63, '양송이버섯.jpg', '양송이버섯.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-14 16:48:58', 0, 0),
	(65, 65, 'main1.jpg', '오징어 볶음1.jpg', '/home/ubuntu/Image/Recipe/오징어 볶음', NULL, '2023-02-14 16:54:03', 0, 1),
	(66, 65, 'main2.jpg', '오징어 볶음2.jpg', '/home/ubuntu/Image/Recipe/오징어 볶음', NULL, '2023-02-14 16:54:03', 0, 0),
	(67, 66, '대패삼겹살콩불.jpg', '대패삼겹콩불1.jpg', '/home/ubuntu/Image/Recipe/대패삼겹콩불', NULL, '2023-02-14 16:59:18', 0, 1),
	(68, 67, '시금치나물.jpg', '시금치무침1.jpg', '/home/ubuntu/Image/Recipe/시금치무침', NULL, '2023-02-14 17:03:23', 0, 1),
	(69, 68, '참치감자조림.jpg', '참치감자조림1.jpg', '/home/ubuntu/Image/Recipe/참치감자조림', NULL, '2023-02-14 17:18:22', 0, 1),
	(70, 69, '스크램블에그.jpg', '스크램블에그1.jpg', '/home/ubuntu/Image/Recipe/스크램블에그', NULL, '2023-02-14 17:20:29', 0, 1),
	(71, 71, '서울우유.jpg', '서울우유.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:06:32', 0, 0),
	(72, 72, '맛있는우유GT.png', '맛있는우유 GT.png', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:08:38', 0, 0),
	(73, 73, '저지방우유.jpg', '저지방우유.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:09:41', 0, 0),
	(74, 74, '떠먹는불가리스.jpg', '떠먹는불가리스.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:10:43', 0, 0),
	(75, 75, '바나나우유.jpg', '바나나맛 우유.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:12:59', 0, 0),
	(76, 76, '요플레살구맛.jpg', '요플레살구맛.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:13:56', 0, 0),
	(77, 77, '요플레망고스틴.jpg', '요플레망고스틴.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:14:57', 0, 0),
	(78, 78, '팝콘치킨.jpg', '팝콘 치킨.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:18:25', 0, 0),
	(79, 79, '치킨너겟.jpg', '치킨 너겟.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:19:20', 0, 0),
	(80, 80, '쫄깃한 탕수육.jpg', '바삭 쫄깃한 탕수육.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:20:15', 0, 0),
	(81, 81, '떡갈비.jpg', '떡갈비.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:21:19', 0, 0),
	(82, 82, '하림치킨너겟.jpg', '하림 치킨 너겟.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:22:16', 0, 0),
	(83, 83, '피카츄 돈까스.jpg', '피카츄 돈까스.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:23:16', 0, 0),
	(84, 84, '밀감.jpg', '밀감.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:25:01', 0, 0),
	(85, 85, '딸기.jpg', '새벽 겨울 딸기.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:26:07', 0, 0),
	(86, 86, '알큰딸기.jpg', '알큰딸기.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:26:55', 0, 0),
	(87, 87, '체리.jpg', '체리.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:27:34', 0, 0),
	(88, 88, '방울토마토.jpg', '대추방울토마토.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:28:19', 0, 0),
	(89, 89, '바나나.jpg', '바나나.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:29:14', 0, 0),
	(90, 90, '블루베리.jpg', '블루베리.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:33:11', 0, 0),
	(91, 91, '사과.jpg', '실속 플러스 사과.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:37:34', 0, 0),
	(92, 92, '샤인머스켓.jpg', '알큰 샤인머스캣.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:38:35', 0, 0),
	(93, 93, '바나나 송이.jpg', '바나나송이.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:39:18', 0, 0),
	(94, 94, '골드키위.jpg', '골드키위.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:45:35', 0, 0),
	(95, 95, '샘표진간장.jpg', '진간장 금.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:49:15', 0, 0),
	(96, 96, '샘표양조간장.jpg', '양조간장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:50:10', 0, 0),
	(97, 97, '더진한진간장.jpg', '더진한 진간장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:51:17', 0, 0),
	(98, 98, '샘표진간장2.jpg', '진간장 금F.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:52:31', 0, 0),
	(99, 99, '고기전용쌈장.jpg', '고기전용쌈장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:53:35', 0, 0),
	(100, 100, '사계절쌈장.jpg', '사계절 쌈장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:54:20', 0, 0),
	(101, 101, '재래식 된장.jpg', '재래식 된장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:55:01', 0, 0),
	(102, 102, '고추장.jpg', '대양초고추장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:55:41', 0, 0),
	(103, 103, '국산된장.jpg', '국산 된장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:56:29', 0, 0),
	(104, 104, '양념듬뿍쌈장.jpg', '양념듬뿍쌈장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:57:29', 0, 0),
	(105, 105, '태양초찰고추장.jpg', '찰고추장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:58:22', 0, 0),
	(106, 106, '계란이맛있어지는간장.jpg', '계란이맛있어지는 간장.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 15:59:13', 0, 0),
	(107, 107, '참기름.jpg', '참기름.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 16:02:57', 0, 0),
	(108, 108, '오뚜기옛날참기름.jpg', '옛날참기름.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 16:03:56', 0, 0),
	(109, 109, '고소한참기름.jpg', '고소한참기름.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 16:04:39', 0, 0),
	(110, 110, '식용유.jpg', '식용유.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 16:05:24', 0, 0),
	(111, 111, '고추맛기름.jpg', '고추맛 기름.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 16:06:14', 0, 0),
	(112, 112, '들기름.jpg', '들기름.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 16:07:22', 0, 0),
	(113, 113, '진한참기름.jpg', '진한 참기름.jpg', '/home/ubuntu/Image/Product', NULL, '2023-02-15 16:08:28', 0, 0),
	(114, 121, '소갈비.jpeg', '소갈비.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 00:34:24', 0, 0),
	(115, 122, '소갈비찜.jpg', '소갈비찜1.jpg', '/home/ubuntu/Image/Recipe/소갈비찜', NULL, '2023-02-16 00:37:32', 0, 1),
	(116, 123, '들기름계란후라이.jpg', '들기름계란후라이1.jpg', '/home/ubuntu/Image/Recipe/들기름계란후라이', NULL, '2023-02-16 00:42:29', 0, 1),
	(117, 124, 'la양념갈비.jpg', 'la양념갈비1.jpg', '/home/ubuntu/Image/Recipe/la양념갈비', NULL, '2023-02-16 00:46:42', 0, 1),
	(118, 125, '돈까스덮밥.jpg', '돈까스덮밥1.jpg', '/home/ubuntu/Image/Recipe/돈까스덮밥', NULL, '2023-02-16 00:50:02', 0, 1),
	(119, 126, '호박볶음.jpg', '호박볶음1.jpg', '/home/ubuntu/Image/Recipe/호박볶음', NULL, '2023-02-16 01:02:54', 0, 1),
	(120, 127, '마늘쫑볶음.jpg', '마늘쫑볶음1.jpg', '/home/ubuntu/Image/Recipe/마늘쫑볶음', NULL, '2023-02-16 01:06:22', 0, 1),
	(121, 128, '차돌박이찜.jpg', '차돌박이찜1.jpg', '/home/ubuntu/Image/Recipe/차돌박이찜', NULL, '2023-02-16 01:09:49', 0, 1),
	(122, 129, '소세지강정.jpg', '소세지강정1.jpg', '/home/ubuntu/Image/Recipe/소세지강정', NULL, '2023-02-16 01:11:07', 0, 1),
	(123, 130, '소세지.jpeg', '소세지.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:13:13', 0, 0),
	(124, 131, '후랑크소세지.jpeg', '후랑크소세지.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:14:33', 0, 0),
	(125, 132, '통그릴비엔나소세지.jpeg', '통그릴비엔나소세지.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:15:27', 0, 0),
	(126, 133, '후랑크소세지2.jpeg', '스페셜 후랑크 소세지.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:18:49', 0, 0),
	(127, 134, '케찹1.jpeg', '케찹.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:20:22', 0, 0),
	(128, 135, '하인즈케찹.jpeg', '하인즈 케찹.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:21:39', 0, 0),
	(129, 136, '진한토마토케찹.jpeg', '진한토마토케찹.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:22:30', 0, 0),
	(130, 137, '우리아이케찹.jpeg', '우리아이케찹.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:23:19', 0, 0),
	(131, 138, '하얀설탕.jpeg', '하얀설탕.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:24:31', 0, 0),
	(132, 139, '갈색설탕.jpeg', '갈색설탕.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:25:05', 0, 0),
	(133, 140, '허브맛솔트.jpeg', '허브맛 솔트.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:25:46', 0, 0),
	(134, 141, '허브맛솔트2.jpeg', '허브맛 솔트2.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:26:21', 0, 0),
	(135, 142, '허브맛솔트3.jpeg', '허브맛 솔트3.jpeg', '/home/ubuntu/Image/Product', NULL, '2023-02-16 01:27:12', 0, 0);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;

DROP TABLE IF EXISTS `integration`;
CREATE TABLE IF NOT EXISTS `integration` (
  `integ_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_seq` int(11) DEFAULT NULL,
  `recipe_seq` int(11) DEFAULT NULL,
  `product_seq` int(11) DEFAULT NULL,
  PRIMARY KEY (`integ_seq`),
  KEY `FK_user_TO_integration_1` (`user_seq`),
  KEY `FK_recipe_TO_integration_1` (`recipe_seq`),
  KEY `FK_product_TO_integration_1` (`product_seq`),
  CONSTRAINT `FK_product_TO_integration_1` FOREIGN KEY (`product_seq`) REFERENCES `product` (`product_seq`),
  CONSTRAINT `FK_recipe_TO_integration_1` FOREIGN KEY (`recipe_seq`) REFERENCES `recipe` (`recipe_seq`),
  CONSTRAINT `FK_user_TO_integration_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `integration` DISABLE KEYS */;
INSERT INTO `integration` (`integ_seq`, `user_seq`, `recipe_seq`, `product_seq`) VALUES
	(1, 1, NULL, NULL),
	(2, 2, NULL, NULL),
	(3, NULL, NULL, 1),
	(5, NULL, NULL, 3),
	(6, NULL, NULL, 4),
	(7, NULL, NULL, 5),
	(8, NULL, NULL, 6),
	(9, NULL, NULL, 7),
	(10, NULL, NULL, 8),
	(11, NULL, NULL, 9),
	(12, NULL, NULL, 10),
	(13, NULL, NULL, 11),
	(14, NULL, NULL, 13),
	(20, 3, NULL, NULL),
	(22, NULL, 7, NULL),
	(25, NULL, 11, NULL),
	(26, NULL, NULL, 14),
	(27, NULL, NULL, 15),
	(28, NULL, NULL, 16),
	(29, NULL, NULL, 17),
	(30, NULL, NULL, 18),
	(31, NULL, NULL, 19),
	(32, NULL, NULL, 22),
	(33, NULL, NULL, 23),
	(34, NULL, NULL, 24),
	(35, NULL, NULL, 25),
	(36, NULL, NULL, 26),
	(37, NULL, NULL, 27),
	(38, NULL, NULL, 28),
	(39, NULL, NULL, 29),
	(40, NULL, NULL, 30),
	(41, NULL, NULL, 31),
	(42, NULL, NULL, 32),
	(43, NULL, NULL, 33),
	(44, NULL, NULL, 34),
	(45, NULL, NULL, 35),
	(46, NULL, NULL, 36),
	(47, NULL, NULL, 37),
	(48, NULL, NULL, 38),
	(49, NULL, NULL, 39),
	(50, NULL, NULL, 40),
	(51, NULL, NULL, 41),
	(52, NULL, NULL, 42),
	(53, NULL, NULL, 43),
	(54, NULL, NULL, 44),
	(55, NULL, NULL, 45),
	(56, NULL, NULL, 46),
	(57, NULL, NULL, 47),
	(58, NULL, NULL, 48),
	(59, NULL, NULL, 49),
	(60, NULL, NULL, 50),
	(61, NULL, NULL, 51),
	(62, NULL, NULL, 52),
	(63, NULL, NULL, 53),
	(65, NULL, 13, NULL),
	(66, NULL, 14, NULL),
	(67, NULL, 15, NULL),
	(68, NULL, 16, NULL),
	(69, NULL, 17, NULL),
	(71, NULL, NULL, 54),
	(72, NULL, NULL, 55),
	(73, NULL, NULL, 56),
	(74, NULL, NULL, 57),
	(75, NULL, NULL, 58),
	(76, NULL, NULL, 59),
	(77, NULL, NULL, 60),
	(78, NULL, NULL, 61),
	(79, NULL, NULL, 62),
	(80, NULL, NULL, 63),
	(81, NULL, NULL, 64),
	(82, NULL, NULL, 65),
	(83, NULL, NULL, 66),
	(84, NULL, NULL, 67),
	(85, NULL, NULL, 68),
	(86, NULL, NULL, 69),
	(87, NULL, NULL, 70),
	(88, NULL, NULL, 71),
	(89, NULL, NULL, 72),
	(90, NULL, NULL, 73),
	(91, NULL, NULL, 74),
	(92, NULL, NULL, 75),
	(93, NULL, NULL, 76),
	(94, NULL, NULL, 77),
	(95, NULL, NULL, 78),
	(96, NULL, NULL, 79),
	(97, NULL, NULL, 80),
	(98, NULL, NULL, 81),
	(99, NULL, NULL, 82),
	(100, NULL, NULL, 83),
	(101, NULL, NULL, 84),
	(102, NULL, NULL, 85),
	(103, NULL, NULL, 86),
	(104, NULL, NULL, 87),
	(105, NULL, NULL, 88),
	(106, NULL, NULL, 89),
	(107, NULL, NULL, 90),
	(108, NULL, NULL, 91),
	(109, NULL, NULL, 92),
	(110, NULL, NULL, 93),
	(111, NULL, NULL, 94),
	(112, NULL, NULL, 95),
	(113, NULL, NULL, 96),
	(114, 4, NULL, NULL),
	(115, 5, NULL, NULL),
	(116, 6, NULL, NULL),
	(117, 7, NULL, NULL),
	(118, 8, NULL, NULL),
	(119, 9, NULL, NULL),
	(120, 10, NULL, NULL),
	(121, NULL, NULL, 97),
	(122, NULL, 18, NULL),
	(123, NULL, 19, NULL),
	(124, NULL, 20, NULL),
	(125, NULL, 21, NULL),
	(126, NULL, 22, NULL),
	(127, NULL, 23, NULL),
	(128, NULL, 24, NULL),
	(129, NULL, 25, NULL),
	(130, NULL, NULL, 98),
	(131, NULL, NULL, 99),
	(132, NULL, NULL, 100),
	(133, NULL, NULL, 101),
	(134, NULL, NULL, 102),
	(135, NULL, NULL, 103),
	(136, NULL, NULL, 104),
	(137, NULL, NULL, 105),
	(138, NULL, NULL, 106),
	(139, NULL, NULL, 107),
	(140, NULL, NULL, 108),
	(141, NULL, NULL, 109),
	(142, NULL, NULL, 110);
/*!40000 ALTER TABLE `integration` ENABLE KEYS */;

DROP TABLE IF EXISTS `location_log`;
CREATE TABLE IF NOT EXISTS `location_log` (
  `log_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_seq` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `log_x` smallint(6) DEFAULT NULL,
  `log_y` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`log_seq`),
  KEY `FK_user_TO_location_log_1` (`user_seq`),
  CONSTRAINT `FK_user_TO_location_log_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `location_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_log` ENABLE KEYS */;

DROP TABLE IF EXISTS `parking`;
CREATE TABLE IF NOT EXISTS `parking` (
  `parking_seq` int(11) NOT NULL AUTO_INCREMENT,
  `car_seq` int(11) NOT NULL,
  `in_time` datetime DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  `parking_time` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`parking_seq`),
  KEY `FK_car_TO_parking_1` (`car_seq`),
  CONSTRAINT `FK_car_TO_parking_1` FOREIGN KEY (`car_seq`) REFERENCES `car` (`car_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `parking` DISABLE KEYS */;
/*!40000 ALTER TABLE `parking` ENABLE KEYS */;

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_seq` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(30) DEFAULT NULL,
  `company_seq` int(11) NOT NULL,
  `area_seq` int(11) NOT NULL,
  `weight` varchar(10) DEFAULT NULL,
  `product_info` varchar(500) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `discount_price` int(11) DEFAULT NULL,
  `discount_rate` float DEFAULT 0,
  `stock` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`product_seq`),
  KEY `FK_company_TO_product_1` (`company_seq`),
  KEY `FK_area_TO_product_1` (`area_seq`),
  CONSTRAINT `FK_area_TO_product_1` FOREIGN KEY (`area_seq`) REFERENCES `area` (`area_seq`),
  CONSTRAINT `FK_company_TO_product_1` FOREIGN KEY (`company_seq`) REFERENCES `company` (`company_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_seq`, `product_name`, `company_seq`, `area_seq`, `weight`, `product_info`, `price`, `discount_price`, `discount_rate`, `stock`, `is_deleted`) VALUES
	(1, '간장', 11, 10, '1L', '간장 1L', 5000, 0, 0, 10, 0),
	(3, '계란', 1, 6, '1판', '계란 1판', 3900, 0, 0, 50, 0),
	(4, '김밥김', 4, 5, '1봉지', '동원 김밥김 1봉지', 5900, 0, 0, 100, 0),
	(5, '생닭', 2, 6, '1000g', '하림 생닭 1마리 (대)', 10000, 0, 0, 20, 0),
	(6, '참치 통조림', 4, 8, '200g', '동원 살코기 참치 200g', 2000, 0, 0, 25, 0),
	(7, '스팸', 6, 8, '340g', '롯데 스팸 클래식 340g', 3000, 0, 0, 55, 0),
	(8, '마늘', 1, 1, '200g', 'CJ 마늘 200g', 1500, 0, 0, 100, 0),
	(9, '양파', 1, 1, '100g', 'CJ 양파 100g', 2000, 0, 0, 100, 0),
	(10, '대파', 1, 1, '1 묶음', 'CJ 대파 1 묶음', 5000, 0, 0, 100, 0),
	(11, '올리브유', 1, 10, '900ml', 'CJ 올리브유 900ml', 7500, 0, 0, 100, 0),
	(13, '생닭(팩)', 2, 6, '900g', '하림 무항생제 닭볶음탕용 900g(팩)', 8990, 0, 0, 20, 0),
	(14, '감자', 1, 1, '5 개', '감자', 2000, 0, 0, 50, 0),
	(15, '낙지', 6, 5, '3 마리', '낙지', 5000, 0, 0, 50, 0),
	(16, '싱싱한 당근', 1, 1, '2 개', '당근', 1500, 0, 0, 50, 0),
	(17, '블랙타이거새우', 8, 5, '1 마리', '블랙타이거새우', 15000, 0, 0, 10, 0),
	(18, '납짝 당면', 1, 11, '500g', '백설 납짝 당면', 9900, 0, 0, 10, 0),
	(19, '손질 오징어', 6, 5, '4마리 ', '손질 당면', 9900, 0, 0, 10, 0),
	(22, '손질오징어 ', 5, 5, '4마리', '손질 오징어 4마리', 15600, 0, 0, 10, 0),
	(23, '흰다리새우', 6, 5, '100g', '흰다리새우', 1909, 0, 0, 10, 0),
	(24, '손질왕새우', 6, 5, '100g', '손질 왕새우', 2790, 0, 0, 10, 0),
	(25, '손질왕새우 100g', 1, 5, '100g', '손질 왕새우', 3500, 0, 0, 10, 0),
	(26, '제주은갈치', 7, 5, '1마리', '제주은갈치', 5000, 0, 0, 10, 0),
	(27, '제주 생물 갈치', 1, 5, '1마리', '제주 생물 은갈치', 6800, 0, 0, 10, 0),
	(28, '항공직송 생연어', 1, 5, '1마리', '항공직송 생연어(횟감용)', 4950, 0, 0, 10, 0),
	(29, '훈제 연어', 6, 5, '300g', '훈제연어 300g', 14320, 0, 0, 10, 0),
	(30, '고등어', 6, 5, '1마리', '국산고등어', 3900, 0, 0, 10, 0),
	(31, '국산고등어', 2, 5, '1마리', '국산고등어', 5000, 0, 0, 10, 0),
	(32, '어린이 뽀로로 순살 연어구이', 1, 5, '240g', '어린이 뽀로로 순살 연어구이 240g', 16900, 0, 0, 10, 0),
	(33, '영광참굴비', 1, 5, '20마리', '영광참굴비', 30000, 0, 0, 10, 0),
	(34, '안심한우 부채살', 1, 6, '100g', '안심한우 부채살', 14000, 0, 0, 10, 0),
	(35, '안심한우 사태', 1, 6, '100g', '안심한우 사태', 14000, 0, 0, 10, 0),
	(36, '안심한우 안심', 1, 6, '100g', '안심한우 안심', 14000, 0, 0, 10, 0),
	(37, '안심 한우 차돌박이', 12, 6, '100g', '냉동 농협안심 한우 차돌박이', 27900, 0, 0, 10, 0),
	(38, '안심한우 양지', 12, 6, '100g', '안심한우 양지', 21000, 0, 0, 10, 0),
	(39, '안심한우 바로구이', 12, 6, '100g', '안심한우 바로구이', 21990, 0, 0, 10, 0),
	(40, '냉동닭가슴살', 2, 6, '1kg', '냉동닭가슴살', 1000, 0, 0, 10, 0),
	(41, '황금닭 볶음탕용', 2, 6, '1kg', '무항생제 황금닭 볶음탕용 1KG', 7590, 0, 0, 20, 0),
	(42, '냉동 닭안심', 2, 6, '1kg', '냉동 닭안심', 7590, 0, 0, 20, 0),
	(43, '온가족 닭볶음탕용', 2, 6, '1kg', '온가족 닭볶음탕용 1kg', 9990, 0, 0, 20, 0),
	(44, '일품포크 돼지목심', 9, 6, '100g', '일품포크 돼지목심 100g', 9990, 0, 0, 20, 0),
	(45, '일품포크 돼지삼겹살', 9, 6, '100g', '일품포크 돼지삼겹살 100g', 9990, 0, 0, 20, 0),
	(46, '당근당근', 1, 1, '1개', '당근', 1500, 0, 0, 20, 0),
	(47, '해풍맞은 남해 시금치', 1, 1, '100g', '해풍맞은 남해 시금치', 1500, 0, 0, 20, 0),
	(48, '애호박', 1, 1, '1개', '애호박', 1500, 0, 0, 20, 0),
	(49, '깐마늘', 12, 1, '100g', '깐마늘', 1500, 0, 0, 20, 0),
	(50, '다다기오이', 12, 1, '1개', '다다기오이', 1500, 0, 0, 20, 0),
	(51, '제주무', 12, 1, '1개', '제주무', 1500, 0, 0, 20, 0),
	(52, '단단파프리카', 12, 1, '1개', '단단파프리카', 1500, 0, 0, 20, 0),
	(53, '양송이버섯', 12, 1, '1개', '양송이버섯', 1500, 0, 0, 20, 0),
	(54, '서울우유', 1, 7, '2.3L', '서울우유 2.3L', 5980, 0, 0, 20, 0),
	(55, '맛있는우유 GT', 13, 7, '1.8L', '맛있는우유 GT 900ML*2', 4680, 0, 0, 20, 0),
	(56, '저지방우유', 1, 7, '2L', '서울 저지방우유 1L*2', 4780, 0, 0, 20, 0),
	(57, '떠먹는불가리스', 13, 7, '85g * 4', '떠먹는 불가리스딸기 85G*4', 3080, 0, 0, 20, 0),
	(58, '바나나맛 우유', 14, 7, '240ml * 4', '바나나맛 우유 240ML*4', 5480, 0, 0, 20, 0),
	(59, '요플레살구맛', 14, 7, '85g * 4', '요플레 살구맛 85G*4', 3480, 0, 0, 20, 0),
	(60, '요플레망고스틴', 14, 7, '85g * 4', '요플레 망고스틴 80G*4', 3480, 0, 0, 20, 0),
	(61, '팝콘 치킨', 2, 9, '650g', '하림 팝콘 치킨 650G', 10490, 0, 0, 20, 0),
	(62, '치킨 너겟', 1, 9, '450g', '씨제이 고메 크리스피 치킨너겟 450G', 9990, 0, 0, 20, 0),
	(63, '바삭 쫄깃한 탕수육', 1, 9, '450g', '씨제이 고메 바삭 쫄깃한 탕수육 450G', 7990, 0, 0, 20, 0),
	(64, '떡갈비', 12, 9, '480g', '주부9단 오븐구이 떡갈비 480G', 6990, 0, 0, 20, 0),
	(65, '하림 치킨 너겟', 2, 9, '480g', '하림 치킨 너겟 480G', 9990, 0, 0, 20, 0),
	(66, '피카츄 돈까스', 2, 9, '500g', '하림 포켓몬 피카츄 돈까스 500G', 7490, 0, 0, 20, 0),
	(67, '밀감', 12, 2, '1.5kg', '제주 하우스 밀감 1.5KG(박스)', 8990, 0, 0, 20, 0),
	(68, '새벽 겨울 딸기', 12, 2, '500g', '새벽 겨울 딸기 500G(팩)', 7990, 0, 0, 20, 0),
	(69, '알큰딸기', 12, 2, '700g', '알큰딸기 700G(박스)', 8990, 0, 0, 20, 0),
	(70, '체리', 12, 2, '700g', '체리(칠레) 700G(박스)', 19980, 0, 0, 20, 0),
	(71, '대추방울토마토', 12, 2, '1.2kg', '대추방울토마토 1.2KG(박스)', 11990, 0, 0, 20, 0),
	(72, '바나나', 12, 2, '1송이', '스위티오 바나나(필리핀) 송이', 4990, 0, 0, 20, 0),
	(73, '블루베리', 12, 2, '310g', '슈퍼푸드 블루베리(칠레) 310G(팩)', 9990, 0, 0, 20, 0),
	(74, '실속 플러스 사과', 12, 2, '3kg', '실속 플러스 사과 3kg(봉)', 14990, 0, 0, 20, 0),
	(75, '알큰 샤인머스캣', 12, 2, '2kg', '알큰 샤인머스캣 2KG(박스)', 24990, 0, 0, 20, 0),
	(76, '바나나송이', 12, 2, '1송이', 'Dole 바나나(필리핀) 송이', 3490, 0, 0, 20, 0),
	(77, '골드키위', 12, 2, '1팩', '제스프리 골드키위(제주) 7-10입(팩)', 14990, 0, 0, 20, 0),
	(78, '진간장 금', 11, 10, '1.7L', '샘표 진간장 금 S 1.7L', 4450, 0, 0, 20, 0),
	(79, '양조간장', 11, 10, '1.7L', '샘표 양조간장 501 1.7L', 10900, 0, 0, 20, 0),
	(80, '더진한 진간장', 9, 10, '1.7L', '대상 청정원 두번달여 더 진한 진간장 골드 1.7L', 7980, 0, 0, 20, 0),
	(81, '진간장 금F', 11, 10, '860ml', '샘표 진간장 금F-3 860ML', 6100, 0, 0, 20, 0),
	(82, '고기전용쌈장', 1, 10, '450g', 'CJ 해찬들 고기 전용 쌈장 450G', 4130, 0, 0, 20, 0),
	(83, '사계절 쌈장', 1, 10, '1kg', 'CJ 해찬들 사계절 쌈장 1KG', 5450, 0, 0, 20, 0),
	(84, '재래식 된장', 1, 10, '2kg', 'CJ 해찬들 재래식 된장 2KG', 8290, 0, 0, 20, 0),
	(85, '대양초고추장', 1, 10, '2kg', 'CJ 100% 우리 쌀 태양초고추장 2KG', 12950, 0, 0, 20, 0),
	(86, '국산 된장', 1, 10, '900g', 'CJ 해찬들 100% 국산 된장 900G', 14690, 0, 0, 20, 0),
	(87, '양념듬뿍쌈장', 9, 10, '500g', '대상 청정원 순창 양념듬뿍 쌈장 500G', 4860, 0, 0, 20, 0),
	(88, '찰고추장', 9, 10, '500g', '대상 청정원 순창 찰고추장 500G', 10530, 0, 0, 20, 0),
	(89, '계란이맛있어지는 간장', 11, 10, '200ml', '샘표 계란이맛있어지는 간장 200ML', 4430, 0, 0, 20, 0),
	(90, '참기름', 1, 10, '430ml', 'CJ 백설 고소함 가득 참기름 430ML', 7680, 0, 0, 20, 0),
	(91, '옛날참기름', 8, 10, '500ml', '오뚜기 옛날 참기름 500ML', 7120, 0, 0, 20, 0),
	(92, '고소한참기름', 8, 10, '500ml', '오뚜기 고소한 참기름 500ML', 14400, 0, 0, 20, 0),
	(93, '식용유', 1, 10, '1.8L', 'CJ 백설 식용유 1.8L', 8480, 0, 0, 20, 0),
	(94, '고추맛 기름', 8, 10, '80ml', '오뚜기 고추맛 기름 80ML', 2180, 0, 0, 20, 0),
	(95, '들기름', 8, 10, '320ml', '오뚜기 들기름 320ML', 13670, 0, 0, 20, 0),
	(96, '진한 참기름', 1, 10, '160ml', 'CJ 진한 참기름 160ML', 6450, 0, 0, 20, 0),
	(97, '소갈비', 12, 6, '1kg', '지방 완벽제거 소갈비 찜갈비 탕갈비 1kg 찜용 탕용 호주산', 31000, 0, 0, 20, 0),
	(98, '소세지', 4, 9, '260g * 2', '동원 스페셜 비엔나 260G*2', 7490, 0, 0, 90, 0),
	(99, '후랑크소세지', 1, 9, '300g * 2', '씨제이 백설 그릴후랑크 칼집 300G*2', 8990, 0, 0, 90, 0),
	(100, '통그릴비엔나소세지', 4, 9, '180g * 2', '동원 통그릴 비엔나 180G*2', 5990, 0, 0, 90, 0),
	(101, '스페셜 후랑크 소세지', 4, 9, '250g * 2', '동원 스페셜 후랑크 250G*2', 7490, 0, 0, 90, 0),
	(102, '케찹', 8, 10, '500g', '오뚜기 케찹 500G', 2880, 0, 0, 90, 0),
	(103, '하인즈 케찹', 1, 10, '570g', '하인즈 토마토 케찹 570G', 4480, 0, 0, 90, 0),
	(104, '진한토마토케찹', 8, 10, '500g', '진한 케챂 토마토 케찹 500g', 3460, 0, 0, 90, 0),
	(105, '우리아이케찹', 9, 10, '410g', '대상 청정원 우리 아이케찹 410G', 3000, 0, 0, 90, 0),
	(106, '하얀설탕', 1, 10, '1kg', 'CJ 하얀설탕 1KG', 1980, 0, 0, 90, 0),
	(107, '갈색설탕', 1, 10, '1kg', 'CJ 백설 갈색설탕 1KG', 2480, 0, 0, 90, 0),
	(108, '허브맛 솔트', 1, 10, '50g', 'CJ 허브맛 솔트 순한맛 50G', 2280, 0, 0, 90, 0),
	(109, '허브맛 솔트2', 1, 10, '50g', 'CJ 허브맛 솔트 매콤한맛 50G', 2280, 0, 0, 90, 0),
	(110, '허브맛 솔트3', 9, 10, '52g', '대상 청정원 허브맛솔트 마늘 & 양파 52G', 2800, 0, 0, 90, 0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

DROP TABLE IF EXISTS `product_comment`;
CREATE TABLE IF NOT EXISTS `product_comment` (
  `product_comment_seq` int(11) NOT NULL AUTO_INCREMENT,
  `product_seq` int(11) NOT NULL,
  `user_seq` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `star_point` float DEFAULT NULL COMMENT '0~5점/ 0.5간격',
  `created_date` datetime DEFAULT current_timestamp(),
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`product_comment_seq`),
  KEY `FK_product_TO_product_comment_1` (`product_seq`),
  KEY `FK_user_TO_product_comment_1` (`user_seq`),
  CONSTRAINT `FK_product_TO_product_comment_1` FOREIGN KEY (`product_seq`) REFERENCES `product` (`product_seq`),
  CONSTRAINT `FK_user_TO_product_comment_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `product_comment` DISABLE KEYS */;
INSERT INTO `product_comment` (`product_comment_seq`, `product_seq`, `user_seq`, `title`, `detail`, `star_point`, `created_date`, `updated_date`) VALUES
	(1, 8, 1, '굳굳', '굳굳', 3, '2023-02-14 14:37:10', NULL),
	(2, 1, 1, '맛있어요.', '품질이 만족스럽습니다.', 5, '2023-02-15 10:32:30', NULL),
	(3, 3, 2, '품질이 좋아요.', '아주 만족스럽습니다.', 5, '2023-02-15 10:32:30', NULL),
	(4, 1, 3, '맛있어요.', '만족스럽습니다.', 5, '2023-02-15 10:32:30', NULL),
	(5, 3, 4, '품질이 좋아요.', '아주 만족스럽습니다.', 5, '2023-02-15 10:32:30', NULL),
	(6, 5, 1, 'Good', 'Good! 만족스럽습니다.', 5, '2023-02-15 10:32:30', NULL),
	(7, 5, 2, '품질이 좋아요.', '아주 만족스럽습니다.', 5, '2023-02-15 10:32:30', NULL),
	(8, 5, 6, '할인할 때 구매했어요', '할인할 때 싸게 구매했어요!', 5, '2023-02-15 10:32:30', NULL),
	(9, 5, 7, '닭 저렴하게 구매했어요', '닭 저렴하게 구매했어요!!!! 아주 만족스럽습니다.', 5, '2023-02-15 10:32:30', NULL),
	(10, 5, 1, '맛있어서 구매했어요', '맛있어서 구매했어요 아주 만족스럽습니다.', 5, '2023-02-15 10:32:30', NULL),
	(11, 5, 1, '닭볶음탕 찜닭 해먹었어요', '닭볶음탕 찜닭 해먹었어요', 5, '2023-02-15 10:32:30', NULL),
	(12, 5, 10, '닭은 항상 정답입니다!!', '닭은 항상 정답입니다!!', 5, '2023-02-15 10:32:30', NULL),
	(13, 41, 7, '닭 저렴하게 구매했어요', '닭 저렴하게 구매했어요!!!! 아주 만족스럽습니다.', 5, '2023-02-15 10:33:51', NULL),
	(14, 41, 1, '맛있어서 구매했어요', '맛있어서 구매했어요 아주 만족스럽습니다.', 5, '2023-02-15 10:33:51', NULL),
	(15, 41, 1, '닭볶음탕 찜닭 해먹었어요', '닭볶음탕 찜닭 해먹었어요', 5, '2023-02-15 10:33:51', NULL),
	(16, 41, 10, '닭은 항상 정답입니다!!', '닭은 항상 정답입니다!!', 5, '2023-02-15 10:33:51', NULL),
	(17, 41, 1, '맛있어요.', '품질이 만족스럽습니다.', 5, '2023-02-15 10:33:51', NULL),
	(18, 41, 2, '품질이 좋아요.', '아주 만족스럽습니다.', 5, '2023-02-15 10:33:51', NULL),
	(19, 41, 3, '맛있어요.', '만족스럽습니다.', 5, '2023-02-15 10:33:51', NULL),
	(20, 41, 4, '품질이 좋아요.', '아주 만족스럽습니다.', 5, '2023-02-15 10:33:51', NULL),
	(21, 41, 1, 'Good', 'Good! 만족스럽습니다.', 5, '2023-02-15 10:33:51', NULL),
	(22, 41, 2, '품질이 좋아요.', '아주 만족스럽습니다.', 5, '2023-02-15 10:33:51', NULL),
	(23, 41, 6, '할인할 때 구매했어요', '할인할 때 싸게 구매했어요!', 5, '2023-02-15 10:33:51', NULL);
/*!40000 ALTER TABLE `product_comment` ENABLE KEYS */;

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE IF NOT EXISTS `purchase` (
  `purchase_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_seq` int(11) NOT NULL,
  `purchase_date` datetime DEFAULT current_timestamp(),
  `total_price` int(11) DEFAULT 0,
  PRIMARY KEY (`purchase_seq`),
  KEY `FK_user_TO_purchase_1` (`user_seq`),
  CONSTRAINT `FK_user_TO_purchase_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` (`purchase_seq`, `user_seq`, `purchase_date`, `total_price`) VALUES
	(1, 1, '2023-02-14 17:34:21', 16500),
	(2, 2, '2023-02-14 17:34:21', 7900);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;

DROP TABLE IF EXISTS `purchase_detail`;
CREATE TABLE IF NOT EXISTS `purchase_detail` (
  `purchase_detail_seq` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_seq` int(11) NOT NULL,
  `product_seq` int(11) NOT NULL,
  `cnt` smallint(6) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `discount_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`purchase_detail_seq`),
  KEY `FK_purchase_TO_purchase_detail_1` (`purchase_seq`),
  KEY `FK_product_TO_purchase_detail_1` (`product_seq`),
  CONSTRAINT `FK_product_TO_purchase_detail_1` FOREIGN KEY (`product_seq`) REFERENCES `product` (`product_seq`),
  CONSTRAINT `FK_purchase_TO_purchase_detail_1` FOREIGN KEY (`purchase_seq`) REFERENCES `purchase` (`purchase_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `purchase_detail` DISABLE KEYS */;
INSERT INTO `purchase_detail` (`purchase_detail_seq`, `purchase_seq`, `product_seq`, `cnt`, `price`, `discount_price`) VALUES
	(1, 1, 1, 1, 5000, 0),
	(2, 2, 3, 1, 3900, 0),
	(3, 1, 5, 1, 10000, 0),
	(4, 2, 6, 1, 2000, 0),
	(5, 1, 8, 1, 1500, 0),
	(6, 2, 9, 1, 2000, 0);
/*!40000 ALTER TABLE `purchase_detail` ENABLE KEYS */;

DROP TABLE IF EXISTS `recipe`;
CREATE TABLE IF NOT EXISTS `recipe` (
  `recipe_seq` int(11) NOT NULL AUTO_INCREMENT,
  `theme_seq` int(11) NOT NULL,
  `user_seq` int(11) DEFAULT NULL,
  `recipe_name` varchar(30) DEFAULT NULL,
  `detail` text DEFAULT NULL,
  `recipe_like_cnt` int(11) DEFAULT 0,
  `admin_chk` tinyint(1) DEFAULT 0,
  `is_deleted` tinyint(1) DEFAULT 0,
  `created_date` datetime DEFAULT current_timestamp(),
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`recipe_seq`),
  KEY `FK_theme_TO_recipe_1` (`theme_seq`),
  KEY `FK_user_TO_recipe_1` (`user_seq`),
  CONSTRAINT `FK_theme_TO_recipe_1` FOREIGN KEY (`theme_seq`) REFERENCES `theme` (`theme_seq`),
  CONSTRAINT `FK_user_TO_recipe_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` (`recipe_seq`, `theme_seq`, `user_seq`, `recipe_name`, `detail`, `recipe_like_cnt`, `admin_chk`, `is_deleted`, `created_date`, `updated_date`) VALUES
	(7, 2, 1, '간장계란밥', '맛있는 간장계란밥', 0, 0, 0, '2023-02-13 15:21:40', NULL),
	(11, 2, 1, '백종원의 찜닭 레시피', '백종원의 맛있는 찜닭 레시피\n1. 양념장으로 간장한컵, 물한컵, 설탕반컵, 맛술반컵, 다진마늘 한큰술, 다진파한줌, 청양고추2개, 참기름약간을 넣어 만든다.\n2. 팬에 밑간한 닭을 넣고 닭이 익으면 감자와 당근을 넣어준다.\n3. 감자와 당근이 어느정도 익으면 불린 당면과 양파를 넣어준다.\n4. 조금 더 익히면 완성!!!', 0, 0, 0, '2023-02-14 16:00:49', NULL),
	(13, 2, 1, '오징어 볶음', '오징어 볶음, 향과 맛이 일품! 백종원 오징어 볶음\n백종원님의 레시피중에 간혹 감탄이 나오는\n레시피가 있는데 바로 오징어볶음입니다.\n살짝 불향까지 나는것이 아주 일품이네요.\n쉬운 레시피로 따라하기도 쉽습니다.\n오늘 메뉴로 해 보세요~', 0, 0, 0, '2023-02-14 16:54:03', NULL),
	(14, 2, 1, '대패삼겹콩불', '백종원 대패삼겹살 콩나물 불고기\n1. 양념 재료인 고추장 3, 고춧가루 3, 간장 3, 맛술 3, 다진 마늘 2, 설탕 2를 모두 한데 넣어 고루 섞어 양념장을 만들어 주세요.\n2. 양념 비율은 1:1:1:1:1:1로 해주심 된답니다. 저는 다진 마늘, 설탕량만 1숟가락씩 줄였어요.\n3. 콩나물 300g을 씻어 체에 밭쳐 물기를 제거하고 준비합니다.\n4. 삼겹살 500g을 준비하고 양파 1/2는 굵게 채 썰어주고, 깻잎 10장은 씻어 2~3등분 하고 청양고추 1개, 대파 1대는 송송 썰어주고 새송이버섯 1개는 큼직하게 썰어 준비합니다.\n5. 넓은 팬에 씻어 놓은 콩나물을 깔고 그 위에 대파, 양파, 새송이버섯을 모두 올리고 그 위에 대패삼겹살을 올리고 고기 위에 깻잎, 청양고추를 올린 다음 만들어 놓은 양념장을 모두 넣고 달달 볶아주면 콩나물에서 수분이 나와 물을 넣지 않아도 보글보글 국물이 생긴답니다.\n6. 백종원 콩나물 불고기 완성 ^^', 0, 0, 0, '2023-02-14 16:59:18', NULL),
	(15, 2, 1, '시금치무침', '백종원 시금치무침 저녁 반찬으로 추천해요\n야채시장에서 데려온 시금치를 금방 무쳐서 저녁 상에 올려놓으니 순식간에 사라지더라고요^^;;\n1. 시금치는 뿌리 끝을 깨끗이 다듬고 적당한 크기로 잘라주세요.\n2. 넉넉한 양의 물을 끓인 뒤 끓는 물에 소금 1/2스푼을 넣고 세척한 시금치를 넣어주세요\n3. 딱 1분만 삶으시면 충분해요. 오래 삶으면 질겨져서 맛이 없고 식감도 없어져요. 곧바로 차가운 물에 샤워시켜 주세요 아삭한 맛이 더 좋아집니다.\n4. 시금치를 한주먹 들고 양손으로 물기를 짜주세요.\n5. 간장 1 큰 술, 다진 마늘 1/2 큰 술, 꽃소금 1/3 큰 술, 참기름 2스푼, 통깨 1 작은 술까지 넣은 뒤 조물조물 무치면 고소한 냄새가 솔솔~~\n6. 시금치 무침이 완성되었습니다.', 0, 0, 0, '2023-02-14 17:03:23', NULL),
	(16, 1, 4, '참치감자조림', '참치캔을 활용해서 밥도둑 반찬인 참치감자조림을 만들어봤어요. 부드러운 감자와 담백한 참치에 매콤한 양념을 넣어 보글보글 끓여냈답니다. 따끈한 밥에 딱 어울리는 반찬이에요.', 0, 0, 0, '2023-02-14 17:18:22', NULL),
	(17, 1, 6, '스크램블에그', '느긋한 주말 아침, 호텔 조식에서 먹었던 그 스크램블 에그가 떠오른다면 주목해 주세요. 입에 넣자마자 부드럽게 살살 녹아버리는 스크램블 에그를 간단하게 만들 수 있어요. 볶음밥에 올려 오므라이스로 먹거나 베이컨, 빵과 함께 아침 식사로 즐겨도 좋아요.', 0, 0, 0, '2023-02-14 17:20:29', NULL),
	(18, 2, 2, '소갈비찜', '백종원 소갈비찜 야들야들하니 맛있어요\n1. 갈비는 일단 핏물을 빼주세요\n   저는 물을 번갈아가며 1시간 반정도 빼줬어요	\n2. 분량의 양념은 미리 한곳에 섞어서 준비해주세요\n   설탕 1/2컵, 맛술 1/2컵, 물 1컵, 진간장 1컵, 다진마늘 2큰술, 생강 1/2큰술, 참기름 2큰술\n   대파도 1대 송송 썰어서 같이 넣어주시고 가라앉은 설탕이 녹을정도로 저어주세요 ~	\n3. 그리고 어느정도 핏물을 빼준 갈비위에 양념을 넣고	\n4. 바로 조리해 주시면 되는데요, 여기에 생수 한병을 같이 넣어서\n   센불로 팔팔 먼저 끓여주시면 된답니다 ~\n   따로 재워두는 시간이 필요없기 때문에 시간이 훨씬 절약된답니다 ~	\n5. 갈비가 팔팔 끓어오를동안 같이 넣어줄 야채도 썰어서 준비해주세요\n   저는 감자 2개랑 당근 1/2개만 사용했는데 야채를 좀 더 푸짐하게 넣어도 좋을것 같아요 ~	\n6. 양념이 팔팔 끓어오르면 위쪽으로 뜬 거품은 국자나 수저를 이용해\n   살짝 걷어내 주시구요,	\n7. 준비해둔 당근이랑 감자를 넣어 국물이 어느정도 \n   졸아들때까지 푹~ 끓여주세요 ~ 오래끓여줘야 고기가 더 연하고 맛있거든요	\n8. 양념 국물이 제법 많이 줄어들면 완성이랍니다 ~~!!\n   오랜시간동안 푹~ 익혀줘야 고기가 질기지 않으니깐\n   오랜시간 익혀주시는게 뽀인트 !!\n   여기에 청양고추 송송 썰어넣으면 살짝 매콤하니 참 좋은데\n   아이들과 먹을꺼라 청양고추는 과감히 포기했어요 ㅎ	\n9. 주말 저녁 푸짐하게 먹은 백종원소갈비찜 !\n   만드는 방법도 간단했고, 오랜시간동안 푹~ 익혀줬더니 뼈에서 쏙쏙 살이 발라져서 \n   아이들도 아주 맛있게 먹었답니다 ^^', 0, 0, 0, '2023-02-16 00:37:32', NULL),
	(19, 2, 2, '들기름계란후라이', '1. 먼저 대파를 잘게 썰어 줍니다.	\n2. 달궈진 팬에 들기름3스푼 둘러 주세요\n   * 들기름 양은 사용하는 계란 갯수만큼 맞쳐 주시면 적당할것 같아요 (예:계란5개-들기름5T)\n3. 들기름에 대파를 달달 볶아 줍니다. 대파향이 어느 정도 나게 볶아 주세요	\n4. 대파위에 계란3개를 깨서 반숙으로 익혀 주셔요\n   * 반숙 싫으시면 노른자 톡 터트려 주세요\n5. 계란후라이 담을 접시에 국간장 1/2스푼 뿌려 주시구요. 이제 접시 위에 계란 후라이 담아주고 통깨 솔솔 뿌려주심 끝!\n   * 국간장을 계란후라이 위에 뿌리셔도 되는데 깔끔한게 좋아 아래에 뿌렸어요\n6. 고소함이 남다른 밥도둑 반찬 백주부님 \'들기름계란후라이\'완성입니다. 한입 먹어보니 고소한 들기름에 대파향이 쏴악 감돌면서 넘 맛있어요. 김가루 좀 넣고 슥슥 비벼도 고소함 가득하니 꿀맛입니다', 0, 0, 0, '2023-02-16 00:42:29', NULL),
	(20, 2, 2, 'la양념갈비', '1. *냉동된 갈비는 찬물에 2~3시간 담가 해동하면서 핏물을 빼 주세요.\n2. *중간에 3번 정도 물을 갈아 주세요.	\n3. 위의 분량의 양념을 넣고 고루 저어 주세요.	\n4. la 갈비는 물에 헹궈 준후 물기를 제거 해주세요.	\n5. 양념장에 넣고 섞어 준 후 보관 용기에 담아 주세요. 반나절 정도 재워 주세요. (냉장보관)	\n6. 팬에 갈비를 올리고 구워 주세요.	\n7. 뒤집어서 구워 주세요.	\n8. 완성 그릇에 담아 주세요', 0, 0, 0, '2023-02-16 00:46:42', NULL),
	(21, 2, 2, '돈까스덮밥', '백종원 돈까스덮밥, 가츠동 만들기\n밥 위에 바삭바삭하게 튀긴 돈까스와 달콤한 소스를 얹은 돈까스덮밥은 든든하면서도 맛있는 한그릇요리죠.\n이 맛있는 돈까스덮밥, 즉 가츠동을 집에서 만들 수 있는 방법이 없을까 찾아보다 예전에 집밥백선생 시즌2에서 백종원이 돈까스양파덮밥을 만든 걸 보았어요!\n그래서 똑같이 따라 만들어 보았는데 일식집에서 파는 가츠동과 정말 똑-같은 맛이 나더라고요.\n1. 양파를 적당한 두께로 채 썹니다. 저는 양파의 아삭한 식감을 좋아해서 조금 도톰하게 썰었어요.\n2. 쪽파를 쫑쫑쫑 썹니다.	\n3. 볼에 달걀 두 알을 깨트려 넣고 대충 휘휘 저어서 풀어 줍니다. 너무 완벽하게 풀지 않아도 되니, 그냥 적당히 저어서 풀어 주세요.	\n4. 간장 3큰술, 맛술 3큰술, 설탕 2큰술, 물 9큰술을 섞어서 소스를 만듭니다.	\n5. 돈까스를 바삭바삭하게 튀긴 다음 먹기 좋은 크기로 잘라 주세요.	\n6. 작은 크기의 프라이팬에 만들어 둔 소스를 모두 부어요.	\n7. 그리고 양파를 넣은 다음 센 불로 불을 켭니다.	\n8. 그 위에 썰어 둔 돈까스를 올려 주세요.	\n9. 소스가 보글보글 끓어오르면 계란물을 붓고, 쪽파를 올린 뒤 계란이 살짝 익으면 불을 꺼 주세요.	\n10. 이제 밥 위에 얹으면 돈까스덮밥 완성입니다!', 0, 0, 0, '2023-02-16 00:50:02', NULL),
	(22, 2, 2, '호박볶음', '백종원 호박볶음, 실패없는 맛있는 밑반찬, 나물반찬\n백선생의 실패없는 맛있는 나물 레시피! 기가 막히게 맛있는 호박볶음 :)\n\n호박은 반달썰기, 당근도 반달썰기, 양파는 반개를 다시 가로로 반 잘라 두께감이 있게 썰어주세요.\n백선생 레시피엔 당근은 없고요, 당근이나 고추 등 원하는 채소 추가해도 됩니다.\n불 올린 팬에 들기름 2큰술, 다진마늘 1큰술을 넣어 마늘향을 내어주고, 들기름이 끓으며 마늘향이 나면 양파를 넣고 살짝 아줍니다.\n양파를 한 두번 뒤적이며 볶다가 호박과 당근을 넣고 볶아 주세요. 볶는중에 호박은 아직 안 익었는데 물기가 없다,싶으면 물을 조금 부어 볶아주면 됩니다. \n호박이 익어가면 새우젓 1큰술 넣고 잘 볶아줍니다. \n간을 보고 약간 싱거우면 새우젓 국물을 더 넣거나 소금을 한 두 꼬집 넣으세요.	\n호박이 다 익었으면 파 넣고 마무리하면 맛있는 호박볶음이 완성! 되었습니다.	\n깨소금+통깨 솔솔~ 뿌려서 맛있게 드세요 :D', 0, 0, 0, '2023-02-16 01:02:54', NULL),
	(23, 1, 1, '마늘쫑볶음', '[마늘종볶음]단짠단짠 자꾸만 손이가요~\n알토란에서 소개된 이보은님의 레시피 입니다~\n중요한 3가지 양념의 순서만 지켜주면 누가 해도 똑 같은 맛을 낼수 있답니다^^\n아삭하고 푸릇푸릇한 마늘종볶음 간단하게 만들어 보세요~\n1. 마늘종 300g을 4cm길이로 썰어주세요	\n2. 달궈진 마른팬에 건새우 50g을 넣고 중간불에서 1분간 볶아주세요.\n   *마른팬에서 건새우를 볶으면 잡내는 사라지고 단맛은 올라갑니다.\n3. 볶은 새우를 체에 올려 잔 가루를 털어 내주세요.	\n4. 팬에 불을 (센불)켜고 물 1/4컵을 넣고 끓여 줍니다.	\n5. 물이 끓어 오르면 마늘종 300g과 소금 1/3큰술을 넣고 수분이 없어질때까지 볶아줍니다.\n   * 마늘종을 물에 볶으면 데치는 효과를 내서 아린맛은 날아가고 색감은 살아 납니다.\n6. 수분이 없어 졌을 때 볶아 놓은 건새우를 넣어주세요.	\n7. 설탕 2큰술을 넣고 살짝 볶아주고 설탕 입자가 있을때 간장4큰술을 넣어 줍니다.	\n8. 식용유 4큰술을 건새우쪽으로 넣고 볶아줍니다.	\n9. 불을 끄고 참기름 2큰술, 물엿 1큰술반, 통깨 1큰술을 넣고 잘 어우러지게 섞어서 맛있게 드시면 되세요~', 0, 0, 0, '2023-02-16 01:06:22', NULL),
	(24, 1, 1, '차돌박이찜', '완전맛있는 차돌박이찜! 미소된장마요소스도 함께~\n손님상차림으로도 좋은 차돌박이찜 입니다\n만들기도 너무쉽고 모양도 예뻐서 추천하는 메뉴에요\n미소된장마요소스를 찍어먹으니 한층 맛이 더 업그레이드!! \n정말 강력추천하는 메뉴랍니다\n1. 팽이버섯은 밑둥을 잘라내고 씻어주시고 깻잎도 흐르는물에 씻어주세요\n   * 저는 깻잎이 커서 반으로 잘라서 사용! 작으면 1장을 통채로 쓰시면됩니다\n2. 차돌박이 위에깻잎을 올리고	그위에 팽이버섯을 올려준뒤	돌돌 말아주기만하면 완성이에요 만드는 방법 완전 간단하죠?	\n3. 냄비에 숙주나물을 한주먹 깔고 차돌박이를 올려 10분간 쪄주면 끝 차돌박이 말린이음새 부분이 아래로 가게 두고 찌면 풀어지지않아요\n4. 차돌박이찜이 완성되는 사이 소스를 만들어볼게요!\n5. 처음엔 된장이랑 마요네즈? 하실텐데 드셔보시면 고기랑 정말 잘어울리는 소스!	\n6. 분량의 재료들을 잘섞어주시면되구요\n7. 미소된장이 없으시다면 집된장 말고 시판된장 싱거운걸 사용하셔도 됩니다	\n8. 차돌박이 찜기에 넣고 소스만들면 그사이 차돌박이찜 완성입니다\n9. 금새 익기때문에 정말 초스피드로 완성할수있는 요리에요	\n10. 예쁘게 그릇에 담아주면 끝!	 된장마요소스에 콕 찍어먹으면 정말 맛있답니다 강력추천!', 0, 0, 0, '2023-02-16 01:09:49', NULL),
	(25, 1, 1, '소세지강정', '#최애반찬#소세지강정\n아이들의 최애반찬!\n저 또한 소세지 반찬만 있으면 \n밥 뚝딱이랍니다.\n밥도둑 도시락 반찬이자 \n술안주로도 최고 최고ㅋㅋ', 0, 0, 0, '2023-02-16 01:11:07', NULL);
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;

DROP TABLE IF EXISTS `recipe_comment`;
CREATE TABLE IF NOT EXISTS `recipe_comment` (
  `recipe_comment_seq` int(11) NOT NULL AUTO_INCREMENT,
  `recipe_seq` int(11) NOT NULL,
  `user_seq` int(11) NOT NULL,
  `recipe_content` varchar(500) DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  `updated_date` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`recipe_comment_seq`),
  KEY `FK_recipe_TO_comment_recipe_1` (`recipe_seq`),
  KEY `FK_user_TO_comment_recipe_1` (`user_seq`),
  CONSTRAINT `FK_recipe_TO_comment_recipe_1` FOREIGN KEY (`recipe_seq`) REFERENCES `recipe` (`recipe_seq`),
  CONSTRAINT `FK_user_TO_comment_recipe_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `recipe_comment` DISABLE KEYS */;
INSERT INTO `recipe_comment` (`recipe_comment_seq`, `recipe_seq`, `user_seq`, `recipe_content`, `created_date`, `updated_date`, `is_deleted`) VALUES
	(1, 11, 2, '맛있어요.', '2023-02-14 17:05:26', NULL, 0),
	(2, 11, 6, '신이나요!!다음에 해볼까?.', '2023-02-14 17:05:59', NULL, 0),
	(3, 11, 4, '창용이 저녁식사 메뉴?', '2023-02-14 17:06:21', NULL, 0),
	(4, 13, 2, '최곱니다.', '2023-02-14 17:06:51', NULL, 0),
	(5, 13, 2, '국간장인가요?진간장인가요?', '2023-02-14 17:07:07', NULL, 0),
	(6, 13, 3, '다른 곳에서 한거 보니 대부분 국간장이더라구요.', '2023-02-14 17:07:46', NULL, 0),
	(7, 13, 4, '시금치 무침 처음 해보는데 맛있게 한거 같아요..? ㅋㅋ 전 짠게 넘 싫어서 들짜게 한거 같은데 남편이 맛을 보고 얘기해 줄거 같아요 저 개인적으로는 맛있어요 ㅋ 레시피 감사합니다~ ㅋ ', '2023-02-14 17:09:57', NULL, 0),
	(8, 13, 8, '무난하게 맛있어요. 300g은 보통 한단보다 양이 많은것같아요 양념을 살짝 줄여서 하니까 괜찮아오ㅡ ', '2023-02-14 17:12:16', NULL, 0),
	(9, 13, 10, '쉽고 간단하고 맛있어요!!! 시금치 양이 적어서 소금이랑 간장 살짝 줄였어요~~  ', '2023-02-14 17:12:34', NULL, 0),
	(10, 14, 10, '여기서 간을보며 소금추가햇어요 맛잇네요  ', '2023-02-14 17:12:55', NULL, 0),
	(11, 14, 9, '너무 맛있어 보이네요:) 맛있게 드세요!!', '2023-02-14 17:13:15', NULL, 0),
	(12, 14, 4, '너무 짜요. 꽃소금이 아니라서 그런건지~ ㅎㅎ 소금은 간 봐가면서 넣어야겠어요~ 잘해먹었어요^^ ', '2023-02-14 17:13:49', NULL, 0),
	(13, 14, 4, '굳굳굳! ', '2023-02-14 17:14:37', NULL, 0),
	(14, 14, 6, '처음 도전했는데 대성공ㅠㅠㅠㅠ 불패의 레시피 너무 감사합니다ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ! ', '2023-02-14 17:14:49', NULL, 0),
	(15, 15, 6, '최곱니다', '2023-02-14 17:15:30', NULL, 0),
	(16, 15, 7, '끓는물에 시금치담그다가 디었네여 완전 요알못이라ㅜㅜ 그래도 다만들고나니 정말맛있어요ㅎㅎ', '2023-02-14 17:15:43', NULL, 0),
	(17, 15, 8, '감사합니다!', '2023-02-14 17:15:54', NULL, 0),
	(18, 15, 9, '감사합니다!', '2023-02-14 17:15:58', NULL, 0),
	(19, 15, 10, '감사합니다!!!!!!!!!!!!!!!!!!!', '2023-02-14 17:16:07', NULL, 0),
	(36, 11, 1, '찜닭', '2023-02-16 02:27:39', NULL, 0),
	(38, 7, 1, '배고플 때 후루룩 해먹기 좋아요', '2023-02-16 02:31:47', NULL, 0),
	(39, 19, 1, '들기름에 계란후라이 해봐야겠어요!', '2023-02-16 02:39:57', NULL, 0),
	(40, 11, 1, '간장 많이 넣으면 짜요!', '2023-02-16 17:38:07', NULL, 0);
/*!40000 ALTER TABLE `recipe_comment` ENABLE KEYS */;

DROP TABLE IF EXISTS `recipe_detail`;
CREATE TABLE IF NOT EXISTS `recipe_detail` (
  `recipe_detail_seq` int(11) NOT NULL AUTO_INCREMENT,
  `recipe_seq` int(11) NOT NULL,
  `product_seq` int(11) NOT NULL,
  `cnt` int(11) DEFAULT NULL,
  PRIMARY KEY (`recipe_detail_seq`),
  KEY `FK_product_TO_recipe_detail_1` (`product_seq`),
  KEY `FK_recipe_TO_recipe_detail_1` (`recipe_seq`),
  CONSTRAINT `FK_product_TO_recipe_detail_1` FOREIGN KEY (`product_seq`) REFERENCES `product` (`product_seq`),
  CONSTRAINT `FK_recipe_TO_recipe_detail_1` FOREIGN KEY (`recipe_seq`) REFERENCES `recipe` (`recipe_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `recipe_detail` DISABLE KEYS */;
INSERT INTO `recipe_detail` (`recipe_detail_seq`, `recipe_seq`, `product_seq`, `cnt`) VALUES
	(13, 7, 1, 1),
	(14, 7, 3, 2),
	(19, 11, 5, 1),
	(20, 11, 1, 1),
	(21, 11, 8, 1),
	(22, 11, 9, 1),
	(23, 11, 10, 1),
	(29, 13, 19, 1),
	(30, 13, 46, 1),
	(31, 13, 49, 1),
	(32, 13, 53, 1),
	(33, 13, 10, 1),
	(34, 14, 45, 1),
	(35, 14, 46, 1),
	(36, 14, 49, 1),
	(37, 14, 53, 1),
	(38, 14, 10, 1),
	(39, 15, 47, 1),
	(40, 15, 8, 1),
	(41, 16, 6, 1),
	(42, 16, 14, 1),
	(43, 17, 6, 1),
	(44, 17, 11, 1),
	(45, 11, 14, 1),
	(46, 11, 16, 1),
	(47, 18, 97, 1),
	(48, 18, 14, 1),
	(49, 18, 16, 1),
	(50, 18, 10, 1),
	(51, 18, 80, 1),
	(52, 18, 49, 1),
	(53, 19, 3, 1),
	(54, 19, 1, 1),
	(55, 19, 10, 1),
	(56, 19, 95, 1),
	(57, 20, 8, 1),
	(58, 20, 1, 1),
	(59, 20, 10, 1),
	(60, 20, 90, 1),
	(61, 21, 36, 1),
	(62, 21, 1, 1),
	(63, 21, 10, 1),
	(64, 21, 3, 1),
	(65, 21, 9, 1),
	(66, 22, 48, 1),
	(67, 22, 9, 1),
	(68, 22, 16, 1),
	(69, 22, 10, 1),
	(70, 22, 8, 1),
	(71, 22, 95, 1),
	(72, 23, 1, 1),
	(73, 23, 93, 1),
	(74, 23, 90, 1),
	(75, 24, 37, 1),
	(76, 24, 8, 1),
	(77, 25, 9, 1),
	(78, 25, 1, 1),
	(79, 25, 100, 1),
	(80, 25, 102, 1);
/*!40000 ALTER TABLE `recipe_detail` ENABLE KEYS */;

DROP TABLE IF EXISTS `recipe_like`;
CREATE TABLE IF NOT EXISTS `recipe_like` (
  `user_seq` int(11) NOT NULL,
  `recipe_seq` int(11) NOT NULL,
  KEY `FK_user_TO_recipe_like_1` (`user_seq`),
  KEY `FK_recipe_TO_recipe_like_1` (`recipe_seq`),
  CONSTRAINT `FK_recipe_TO_recipe_like_1` FOREIGN KEY (`recipe_seq`) REFERENCES `recipe` (`recipe_seq`),
  CONSTRAINT `FK_user_TO_recipe_like_1` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `recipe_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipe_like` ENABLE KEYS */;

DROP TABLE IF EXISTS `theme`;
CREATE TABLE IF NOT EXISTS `theme` (
  `theme_seq` int(11) NOT NULL AUTO_INCREMENT,
  `theme_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`theme_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` (`theme_seq`, `theme_name`) VALUES
	(1, 'Cookstagram'),
	(2, '백종원'),
	(3, '홈파티'),
	(4, '명절'),
	(5, '생일파티'),
	(6, '다이어트'),
	(7, '보양식'),
	(8, '도시락'),
	(9, '집들이'),
	(10, '술상'),
	(11, '이유식'),
	(12, '브런치'),
	(13, '디저트');
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(30) DEFAULT NULL,
  `user_pwd` varchar(30) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `email_domain` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `gender` char(1) DEFAULT NULL COMMENT 'F : 여자, M : 남자',
  `created_date` datetime DEFAULT current_timestamp(),
  `is_admin` tinyint(1) DEFAULT 0,
  `is_valid` tinyint(1) DEFAULT 0,
  `token` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_seq`, `user_id`, `user_pwd`, `user_name`, `email_id`, `email_domain`, `phone`, `birth`, `gender`, `created_date`, `is_admin`, `is_valid`, `token`) VALUES
	(1, 'ssafy', '1234', '창용이', 'ssafy', 'naver.com', '010-0000-0000', '1000-09-24 00:00:00', 'M', '2023-02-09 13:39:54', 0, 0, 'eyJ0eXAiOiJKV1QiLCJyZWdEYXRlIjoxNjc2NTk2NDE5NTg1LCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzY1OTY2NTksInN1YiI6InJlZnJlc2gtdG9rZW4iLCJ1c2VyX2lkIjoic3NhZnkifQ.SX7uqnCS8yEhvAKfVy26AlzYQ-EaD5J77Kts8m3-o4Q'),
	(2, 'ssafy2', '5678', '사오정', 'ssafy', 'ssafy.com', '010-2232-1241', '1996-09-10 00:00:00', 'M', '2023-02-09 13:40:17', 0, 0, NULL),
	(3, 'ssafy3', '1111', '홍길동', 'ssafy', 'ssafy.com', '010-2232-1241', '1996-09-10 00:00:00', 'M', '2023-02-13 15:17:34', 0, 0, NULL),
	(4, 'ssafy4', '1234', '창용', 'ch', 'ssafy.com', '010-0000-1113', '1999-03-11 00:00:00', 'M', '2023-02-14 17:09:16', 0, 0, NULL),
	(5, 'admin', 'admin', '김관리', 'admin', 'ssafy.com', '010-1111-1111', '1990-12-24 00:00:00', 'M', '2023-02-14 17:09:16', 1, 0, NULL),
	(6, 'ssafy5', '1234', '영바비', 'ssafy', 'ssafy.com', '010-0000-1113', '1999-03-11 00:00:00', 'M', '2023-02-14 17:11:43', 0, 0, 'eyJ0eXAiOiJKV1QiLCJyZWdEYXRlIjoxNjc2NDMyOTk4MjQ4LCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzY0MzMyMzgsInN1YiI6InJlZnJlc2gtdG9rZW4iLCJ1c2VyX2lkIjoic3NhZnk1In0.AiSm-ltYILQI66xexGJjg2hLn6yax6Oe73ZsCYpo8vA'),
	(7, 'ssafy6', '1234', '백종원', 'ssafy', 'ssafy.com', '010-0000-1113', '1999-03-11 00:00:00', 'M', '2023-02-14 17:11:43', 0, 0, NULL),
	(8, 'ssafy7', '1234', '코알라', 'ssafy', 'ssafy.com', '010-0000-1113', '1999-03-11 00:00:00', 'M', '2023-02-14 17:11:43', 0, 0, NULL),
	(9, 'ssafy8', '1234', '라이언', 'ssafy', 'ssafy.com', '010-0000-1113', '1999-03-11 00:00:00', 'M', '2023-02-14 17:11:43', 0, 0, NULL),
	(10, 'ssafy9', '1234', '춘식이', 'ssafy', 'ssafy.com', '010-0000-1113', '1999-03-11 00:00:00', 'M', '2023-02-14 17:11:43', 0, 0, 'eyJ0eXAiOiJKV1QiLCJyZWdEYXRlIjoxNjc2NDcxNTM4ODQ0LCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzY0NzE3NzgsInN1YiI6InJlZnJlc2gtdG9rZW4iLCJ1c2VyX2lkIjoic3NhZnk5In0.gEsj7QQxWvenBre_uRe3u1uh3xpoQVnnERRAHvpETFI');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
