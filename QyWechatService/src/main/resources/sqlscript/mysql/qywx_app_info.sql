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

 Date: 11/04/2019 17:35:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qywx_app_info
-- ----------------------------
DROP TABLE IF EXISTS `qywx_app_info`;
CREATE TABLE `qywx_app_info`  (
  `ID` bigint(20) NOT NULL,
  `TENANTS_ID` bigint(20) NULL DEFAULT NULL,
  `ORGANIZER_ID` bigint(20) NULL DEFAULT NULL,
  `SECRET` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `APP_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `AGENT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CORP_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
