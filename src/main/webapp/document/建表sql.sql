/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : review

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2015-06-26 16:45:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` longtext,
  `marks` varchar(1024) DEFAULT NULL,
  `menuid` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '语法规范', '<b>测试数据嗖嗖嗖<i>xcvsdfs舒服-haha<br></i></b>', null, '6');
INSERT INTO `article` VALUES ('2', '测试页面', 'sdaf', null, '11');
INSERT INTO `article` VALUES ('4', 'html基础知识', '<br><blockquote style=\'margin: 0 0 0 40px; border: none; padding: 0px;\'><div style=\'text-align: center;\'><b><br></b></div><div style=\'text-align: center;\'><b><a href=\'http://www.cnblogs.com\'>先取个名字，等待完善</a></b></div></blockquote>', null, '15');
INSERT INTO `article` VALUES ('5', '学习链接整理', '<div style=\'text-align: left;\'><br></div><div style=\'text-align: left;\'><u><a href=\'http://www.csdn.net\'>CSDN</a></u></div><div style=\'text-align: left;\'><br></div><div style=\'text-align: left;\'><a href=\'http://www.cnblogs.com\'>博客园</a></div><div style=\'text-align: left;\'><br></div><div style=\'text-align: left;\'><a href=\'http://www.hjenglish.com\'>沪江英语</a></div>', null, '17');

-- ----------------------------
-- Table structure for `menus`
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `text` varchar(500) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `location` int(5) DEFAULT NULL,
  `isFolder` int(1) DEFAULT NULL,
  `parent` int(5) DEFAULT NULL,
  `template` varchar(100) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `opentype` int(1) DEFAULT NULL COMMENT '1：tab打开 2：新标签打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('1', '主菜单', null, '1', '1', '0', null, '1', '1');
INSERT INTO `menus` VALUES ('3', '系统设置', null, null, '1', '1', '', null, '1');
INSERT INTO `menus` VALUES ('4', '菜单管理', 'menu/manager.do', '2', '0', '3', '', '1', '1');
INSERT INTO `menus` VALUES ('5', 'JAVA基础', null, null, '1', '1', '', null, '1');
INSERT INTO `menus` VALUES ('6', '语法规范', 'article/common.do', null, '0', '5', 'views/article/iframe.jsp', null, '1');
INSERT INTO `menus` VALUES ('7', 'web前端', null, null, '1', '1', '', null, '1');
INSERT INTO `menus` VALUES ('8', '友情链接', null, null, '1', '1', '', null, '1');
INSERT INTO `menus` VALUES ('9', '百度', 'http://www.baidu.com', null, '0', '8', '', null, '2');
INSERT INTO `menus` VALUES ('11', '测试页面', 'article/common.do', null, '0', '5', 'views/article/iframe.jsp', null, '1');
INSERT INTO `menus` VALUES ('13', '登录日志', 'gethistory.do', '3', '0', '3', null, null, '1');
INSERT INTO `menus` VALUES ('14', '聊天室', 'chat/chatRoom.do', null, '0', '8', '', null, '2');
INSERT INTO `menus` VALUES ('15', 'html基础知识', 'article/common.do', null, '0', '7', 'views/article/iframe.jsp', null, '1');
INSERT INTO `menus` VALUES ('17', '学习链接整理', 'article/common.do', null, '0', '8', 'views/article/iframe.jsp', null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '升升', 'admin', 'hejinsheng', '123456', 'admin', '1');
INSERT INTO `user` VALUES ('2', '小帅帅', 'admin', 'hejinshuai', '123456', 'admin', '1');
