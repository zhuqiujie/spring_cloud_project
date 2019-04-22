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

 Date: 11/04/2019 17:35:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qywx_dept_child
-- ----------------------------
DROP TABLE IF EXISTS `qywx_dept_child`;
CREATE TABLE `qywx_dept_child`  (
  `ID` bigint(20) NOT NULL,
  `DEPT_ID` bigint(20) NULL DEFAULT NULL,
  `CHILD_ID` bigint(20) NULL DEFAULT NULL,
  `CORP_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
