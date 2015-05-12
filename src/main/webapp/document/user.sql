/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : review

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2015-05-12 17:11:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `role` varchar(200) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `desc` varchar(1024) DEFAULT NULL,
  `isEnable` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'hejinsheng', 'admin', 'hejinsheng', '123456', 'admin', '1');
