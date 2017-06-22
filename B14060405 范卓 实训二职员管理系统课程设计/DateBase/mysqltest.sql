/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50712
Source Host           : 127.0.0.1:3306
Source Database       : mysqltest

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-11-30 09:57:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(10) COLLATE utf8_bin NOT NULL,
  `name` varchar(10) COLLATE utf8_bin NOT NULL,
  `age` int(4) NOT NULL,
  `sex` varchar(6) COLLATE utf8_bin NOT NULL,
  `tel` varchar(11) COLLATE utf8_bin NOT NULL,
  `work` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('B14060324', '岳昌坤', '22', '男', '13673090911', '计算机');
INSERT INTO `user` VALUES ('B14060401', '陈浩', '22', '男', '15249245775', '计算机');
INSERT INTO `user` VALUES ('B14060405', '范卓', '21', '男', '15891300969', '计算机');
INSERT INTO `user` VALUES ('B14060406', '耿亚超', '22', '男', '15529277162', '计算机');
INSERT INTO `user` VALUES ('B14060408', '韩海东', '21', '男', '17792316130', '计算机');
INSERT INTO `user` VALUES ('B14060420', '王高成', '22', '男', '15249274844', '计算机');
INSERT INTO `user` VALUES ('B14060421', '王怿', '21', '男', '15035293450', '计算机');
