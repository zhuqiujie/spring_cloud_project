/*
 Navicat Premium Data Transfer

 Source Server         : 172.16.23.194
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 172.16.23.194:3306
 Source Schema         : cube_qywechat_dev

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 11/04/2019 17:36:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qywx_user
-- ----------------------------
DROP TABLE IF EXISTS `qywx_user`;
CREATE TABLE `qywx_user`  (
  `ID` bigint(20) NOT NULL,
  `TENANTS_ID` bigint(20) NULL DEFAULT NULL,
  `ORGANIZER_ID` bigint(20) NULL DEFAULT NULL,
  `CORP_USER_ID` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ALIAS` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `POSITION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GENDER` int(2) NULL DEFAULT NULL,
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ENABLE` int(2) NULL DEFAULT NULL,
  `AVATAR_MEDIAID` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXTATTR` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CORP_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TELEPHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATUS` int(2) NULL DEFAULT NULL,
  `QR_CODE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXTERNAL_PROFILE` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXTERNAL_POSITION` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
