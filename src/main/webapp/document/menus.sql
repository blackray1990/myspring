/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : review

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2015-05-12 17:11:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `menus`
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `text` varchar(500) DEFAULT NULL,
  `urltent` varchar(100) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `location` int(5) DEFAULT NULL,
  `isFolder` int(1) DEFAULT NULL,
  `parent` int(5) DEFAULT NULL,
  `template` varchar(100) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('1', '主菜单', '0', null, '1', '1', '0', null, '1');
INSERT INTO `menus` VALUES ('3', '系统设置', '', null, null, '1', '1', '', null);
INSERT INTO `menus` VALUES ('4', '菜单管理', 'menu/manager.do', 'menu/manager.do', '2', '0', '3', '', '1');
INSERT INTO `menus` VALUES ('5', 'JAVA基础', '', null, null, '1', '1', '', null);
INSERT INTO `menus` VALUES ('6', '语法规范', 'article/common.do', 'article/common.do', null, '0', '5', 'views/article/iframe.jsp', null);
INSERT INTO `menus` VALUES ('7', 'web前端', '', null, null, '1', '1', '', null);
INSERT INTO `menus` VALUES ('8', '友情链接', '', null, null, '1', '1', '', null);
INSERT INTO `menus` VALUES ('9', '百度', 'http://www.baidu.com', null, null, '0', '8', '', null);
INSERT INTO `menus` VALUES ('10', 'lofter', 'http://www.lofter.com', null, null, '0', '8', '', null);
INSERT INTO `menus` VALUES ('11', '测试页面', 'article/common.do', 'article/common.do', null, '0', '5', 'views/article/iframe.jsp', null);
INSERT INTO `menus` VALUES ('12', '接口', 'article/common.do', 'article/common.do', null, '0', '5', 'article/iframe.jsp', null);

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
