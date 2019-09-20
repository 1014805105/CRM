/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : hr

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-08-21 13:29:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `admin_id` int(20) NOT NULL AUTO_INCREMENT,
  `admin_password` varchar(20) DEFAULT NULL,
  `admin_username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', '12345', 'admin');

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `notification_id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notification
-- ----------------------------
INSERT INTO `notification` VALUES ('2', 'hello');
INSERT INTO `notification` VALUES ('5', '2018-5-14\r\n莫愁前路无知己');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(20) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '李宁', '男', '本科', '董事会', '董事长', '在职', 'allen1', '001');
INSERT INTO `staff` VALUES ('2', '科比', '男', '高中', '体育部', '教练', '在职', 'allen2', '002');
INSERT INTO `staff` VALUES ('4', '姚明', '男', '本科', '董事会', '总经理', '在职', 'allen3', '003');
INSERT INTO `staff` VALUES ('10', '众旺', '男', '本科', '董事会', '副总', '在职', 'allen6', '006');
INSERT INTO `staff` VALUES ('11', null, null, null, null, null, null, 'user1', '001');
INSERT INTO `staff` VALUES ('12', null, null, null, null, null, null, 'allen', 'allen');
INSERT INTO `staff` VALUES ('16', null, null, null, null, null, null, 'admin', 'null');
INSERT INTO `staff` VALUES ('17', null, null, null, null, null, null, 'allen111', 'null');

-- ----------------------------
-- Table structure for staffagreement
-- ----------------------------
DROP TABLE IF EXISTS `staffagreement`;
CREATE TABLE `staffagreement` (
  `agreement_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `agreement_btime` varchar(20) DEFAULT NULL,
  `agreement_etime` varchar(20) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `agreement_content` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`agreement_id`),
  KEY `FK_Relationship_4` (`p_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`p_id`) REFERENCES `staff` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staffagreement
-- ----------------------------
INSERT INTO `staffagreement` VALUES ('2', '2', '20180808', '20880808', '教练', '8k/month');
INSERT INTO `staffagreement` VALUES ('3', '10', '20180501', '20180601', '副总', '10k');

-- ----------------------------
-- Table structure for staffalter
-- ----------------------------
DROP TABLE IF EXISTS `staffalter`;
CREATE TABLE `staffalter` (
  `alter_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `p_name` varchar(20) DEFAULT NULL,
  `alter_time` varchar(20) DEFAULT NULL,
  `alter_bstate` varchar(20) DEFAULT NULL,
  `alter_estate` varchar(20) DEFAULT NULL,
  `alter_type` varchar(20) DEFAULT NULL,
  `alter_content` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`alter_id`),
  KEY `FK_Relationship_5` (`p_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`p_id`) REFERENCES `staff` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staffalter
-- ----------------------------
INSERT INTO `staffalter` VALUES ('1', '1', '李宁', '2018-5-12', '体育部教练', '董事会体育主管', '甲', '1222');

-- ----------------------------
-- Table structure for staffcert
-- ----------------------------
DROP TABLE IF EXISTS `staffcert`;
CREATE TABLE `staffcert` (
  `cer_id` int(11) NOT NULL AUTO_INCREMENT,
  `grade_id` int(11) DEFAULT NULL,
  `cer_name` varchar(20) DEFAULT NULL,
  `cer_date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cer_id`),
  KEY `FK_Relationship_10` (`grade_id`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`grade_id`) REFERENCES `traingrade` (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staffcert
-- ----------------------------
INSERT INTO `staffcert` VALUES ('1', '1', '合格证', '20180501');

-- ----------------------------
-- Table structure for stafffile
-- ----------------------------
DROP TABLE IF EXISTS `stafffile`;
CREATE TABLE `stafffile` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `file_name` varchar(20) DEFAULT NULL,
  `file_abstract` varchar(100) DEFAULT NULL,
  `reward_note` varchar(500) DEFAULT NULL,
  `experience` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`file_id`),
  KEY `FK_Relationship_6` (`p_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`p_id`) REFERENCES `staff` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stafffile
-- ----------------------------
INSERT INTO `stafffile` VALUES ('2', '1', '入职档案', '普通档案acd\r\n', '无asdfasd', 'ixxiixxii');
INSERT INTO `stafffile` VALUES ('3', '10', '入职档案', 'abcde嘻嘻嘻', '一个包子\r\n一杯可乐\r\n一个三级头\r\n一瓶止痛药\r\n一只98K', '无');

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `train_name` varchar(40) DEFAULT NULL,
  `train_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(20) DEFAULT NULL,
  `train_btime` varchar(20) DEFAULT NULL,
  `train_etime` varchar(20) DEFAULT NULL,
  `train_expense` varchar(20) DEFAULT NULL,
  `train_location` varchar(20) DEFAULT NULL,
  `train_host` varchar(20) DEFAULT NULL,
  `train_master` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`train_id`),
  KEY `FK_Relationship_9` (`type_code`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`type_code`) REFERENCES `traintype` (`type_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('管理层培训', '1', '001', '20180101', '20180201', '1', '北京', '1', '1');

-- ----------------------------
-- Table structure for traingrade
-- ----------------------------
DROP TABLE IF EXISTS `traingrade`;
CREATE TABLE `traingrade` (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `train_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  `grade` int(11) DEFAULT NULL,
  `subject` varchar(20) DEFAULT NULL,
  `get_cer` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`grade_id`),
  KEY `FK_Relationship_7` (`p_id`),
  KEY `FK_Relationship_8` (`train_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`p_id`) REFERENCES `staff` (`p_id`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traingrade
-- ----------------------------
INSERT INTO `traingrade` VALUES ('1', '1', '1', '100', '管理', 'Yes');

-- ----------------------------
-- Table structure for traintype
-- ----------------------------
DROP TABLE IF EXISTS `traintype`;
CREATE TABLE `traintype` (
  `type_name` varchar(10) DEFAULT NULL,
  `type_code` varchar(20) NOT NULL,
  `type_info` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traintype
-- ----------------------------
INSERT INTO `traintype` VALUES ('管理培训', '001', '222555');
INSERT INTO `traintype` VALUES ('dsf ', '1', 'vfdaaa');
DROP TRIGGER IF EXISTS `addcert`;
DELIMITER ;;
CREATE TRIGGER `addcert` AFTER INSERT ON `staffcert` FOR EACH ROW update traingrade set get_cer ="Yes" where traingrade.grade_id = new.grade_id;
;;
DELIMITER ;
