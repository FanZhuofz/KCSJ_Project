/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50712
Source Host           : 127.0.0.1:3306
Source Database       : ch04

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-01-04 23:22:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` char(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `course_name` varchar(40) NOT NULL,
  `teacher` varchar(40) NOT NULL,
  `point` int(11) NOT NULL,
  `time_1` char(2) NOT NULL,
  `time_2` char(2) NOT NULL,
  `limited` int(11) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('000001', '数据库', '高峰', '4', '13', '52', '100');
INSERT INTO `course` VALUES ('000002', 'JavaWeb', '刘彩红', '4', '34', '44', '100');
INSERT INTO `course` VALUES ('000003', '操作系统', '魏少华', '4', '22', '41', '100');
INSERT INTO `course` VALUES ('000004', '微机原理与接口技术', '孟锐', '4', '42', '51', '100');
INSERT INTO `course` VALUES ('000005', '计算机网络基础', '王飞', '4', '32', '33', '100');
INSERT INTO `course` VALUES ('000006', '网页设计基础', '吴国敏', '2', '24', '25', '70');
INSERT INTO `course` VALUES ('000007', 'aaaaa', 'bb', '2', '11', '21', '2');
INSERT INTO `course` VALUES ('000008', '1111', '00', '3', '14', '21', '2');
INSERT INTO `course` VALUES ('000009', '11111', '00', '3', '21', '31', '2');
INSERT INTO `course` VALUES ('000010', '123123', '456', '2', '31', '11', '2');
INSERT INTO `course` VALUES ('000011', 'mmmmmmmmmm', 'hhh', '2', '13', '12', '3');
INSERT INTO `course` VALUES ('111110', '122', '111', '2', '21', '31', '2');
INSERT INTO `course` VALUES ('122222', '22', '22', '2', '21', '31', '2');
INSERT INTO `course` VALUES ('123123', '111', '111', '2', '21', '11', '2');

-- ----------------------------
-- Table structure for `elective`
-- ----------------------------
DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective` (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `course_id` char(6) NOT NULL,
  PRIMARY KEY (`username`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elective
-- ----------------------------
INSERT INTO `elective` VALUES ('stu1', '000001');
INSERT INTO `elective` VALUES ('stu1', '000002');
INSERT INTO `elective` VALUES ('stu1', '000003');
INSERT INTO `elective` VALUES ('stu1', '000004');
INSERT INTO `elective` VALUES ('stu1', '000005');
INSERT INTO `elective` VALUES ('stu1', '000006');
INSERT INTO `elective` VALUES ('stu1', '000007');
INSERT INTO `elective` VALUES ('stu1', '000009');
INSERT INTO `elective` VALUES ('stu1', '000011');
INSERT INTO `elective` VALUES ('stu1', '122222');
INSERT INTO `elective` VALUES ('stu1', '123123');
INSERT INTO `elective` VALUES ('stu2', '000001');
INSERT INTO `elective` VALUES ('stu2', '000002');
INSERT INTO `elective` VALUES ('stu2', '000007');
INSERT INTO `elective` VALUES ('stu2', '000008');
INSERT INTO `elective` VALUES ('stu2', '000009');
INSERT INTO `elective` VALUES ('stu2', '000010');
INSERT INTO `elective` VALUES ('stu2', '123123');
INSERT INTO `elective` VALUES ('stu3', '000004');
INSERT INTO `elective` VALUES ('stu3', '000005');
INSERT INTO `elective` VALUES ('stu3', '000008');
INSERT INTO `elective` VALUES ('stu3', '000010');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(20) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `role` char(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin', '范卓', '1');
INSERT INTO `user` VALUES ('stu1', 'stu1', 'student1', '0');
INSERT INTO `user` VALUES ('stu2', 'stu2', 'student2', '0');
INSERT INTO `user` VALUES ('stu3', 'stu3', 'student3', '0');
INSERT INTO `user` VALUES ('stu4', 'stu4', 'student4', '0');
