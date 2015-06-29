/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : bakreview

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2015-06-29 08:59:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `logon_history`
-- ----------------------------
DROP TABLE IF EXISTS `logon_history`;
CREATE TABLE `logon_history` (
  `id` int(11) NOT NULL,
  `loginname` varchar(255) DEFAULT NULL,
  `lastlogintime` varchar(255) DEFAULT NULL,
  `ipadd` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logon_history
-- ----------------------------
INSERT INTO `logon_history` VALUES ('1', 'hejinsheng', '2015-10-10 00:12:01', '192.168.1.132', '正常');
INSERT INTO `logon_history` VALUES ('2', 'admin', '2015-10-10 00:12:01', '192.168.1.22', '正常');
INSERT INTO `logon_history` VALUES ('3', 'hejinsheng', '2015-06-12', null, '异常');
