/*
Navicat MySQL Data Transfer

Source Server         : 本地_root
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-04-01 16:03:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wxapp
-- ----------------------------
DROP TABLE IF EXISTS `wxapp`;
CREATE TABLE `wxapp` (
  `id` bigint(20) NOT NULL,
  `appname` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `appSerect` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `num` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wxapp
-- ----------------------------
INSERT INTO `wxapp` VALUES ('306130051106213888', '6666', 'appXXXXXXXXXXXXXXXXX', '90');
INSERT INTO `wxapp` VALUES ('306161225769816064', '999', 'appXXXXXXXXXXXXXXXXX', '20');
