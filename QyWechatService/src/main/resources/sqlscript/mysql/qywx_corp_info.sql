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

 Date: 11/04/2019 17:35:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qywx_corp_info
-- ----------------------------
DROP TABLE IF EXISTS `qywx_corp_info`;
CREATE TABLE `qywx_corp_info`  (
  `ID` bigint(20) NOT NULL,
  `TENANTS_ID` bigint(20) NULL DEFAULT NULL,
  `ORGANIZER_ID` bigint(20) NULL DEFAULT NULL,
  `CORP_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CORP_LOGO` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FULL_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SHORT_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CORP_TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CORP_ADRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TELEPHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CORP_DNS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STAFF_NUM` bigint(20) NULL DEFAULT NULL,
  `DEPT_NUM` bigint(10) NULL DEFAULT NULL,
  `LIMIT_NUM` bigint(10) NULL DEFAULT NULL,
  `INVOICE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TRADE_TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STAF_SCALE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_DATE` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
