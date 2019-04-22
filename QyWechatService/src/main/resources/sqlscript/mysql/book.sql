/*
Navicat MySQL Data Transfer

Source Server         : 本地_root
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-04-01 16:03:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bookName` varchar(50) NOT NULL COMMENT '书名',
  `bookNumber` int(11) NOT NULL COMMENT '数目',
  `userId` int(8) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=306066707674435585 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('252151217386557440', 'think in py', '15', null);
INSERT INTO `book` VALUES ('295257554836131840', 'test', '20', null);
INSERT INTO `book` VALUES ('295257753226711040', 'test321', '49', null);
INSERT INTO `book` VALUES ('295271781911105536', 'test', '27', null);
INSERT INTO `book` VALUES ('295271856301281280', 'test', '28', null);
INSERT INTO `book` VALUES ('305340668853751808', 'test', '20', null);
INSERT INTO `book` VALUES ('305448912544731136', 'test', '20', null);
INSERT INTO `book` VALUES ('305449333631881216', 'test', '20', null);
INSERT INTO `book` VALUES ('305692572351860736', 'test666', '20', null);
INSERT INTO `book` VALUES ('305692748747509760', 'test666', '20', null);
INSERT INTO `book` VALUES ('305744775280201728', 'test666', '20', null);
INSERT INTO `book` VALUES ('305779296377638912', 'test666', '20', null);
INSERT INTO `book` VALUES ('305790765802590208', 'test666', '20', null);
INSERT INTO `book` VALUES ('305791101632122880', 'test666', '20', null);
INSERT INTO `book` VALUES ('305795154487414784', 'test666', '20', null);
INSERT INTO `book` VALUES ('305796847639859200', 'test666', '20', null);
INSERT INTO `book` VALUES ('305797408258920448', 'test777', '20', null);
INSERT INTO `book` VALUES ('306065741642338304', 'test888', '20', null);
INSERT INTO `book` VALUES ('306066707674435584', 'test888', '20', null);
