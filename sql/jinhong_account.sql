/*
Navicat MySQL Data Transfer

Source Server         : 活动发布平台
Source Server Version : 50619
Source Host           : 127.0.0.1:3306
Source Database       : content

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2020-11-27 11:12:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jinhong_account
-- ----------------------------
DROP TABLE IF EXISTS `jinhong_account`;
CREATE TABLE `jinhong_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account` varchar(128) DEFAULT NULL COMMENT '账号名',
  `salt` varchar(255) DEFAULT NULL COMMENT '密码salt',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nick` varchar(255) DEFAULT NULL COMMENT '昵称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='账号表';

-- ----------------------------
-- Table structure for jinhong_history
-- ----------------------------
DROP TABLE IF EXISTS `jinhong_history`;
CREATE TABLE `jinhong_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(255) DEFAULT NULL COMMENT '页面地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=511 DEFAULT CHARSET=utf8mb4 COMMENT='网站页面地址';

-- ----------------------------
-- Table structure for jinhong_manage_log
-- ----------------------------
DROP TABLE IF EXISTS `jinhong_manage_log`;
CREATE TABLE `jinhong_manage_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `module` varchar(255) DEFAULT NULL COMMENT '模块：登录、关键词',
  `ip` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `operate` varchar(255) DEFAULT NULL COMMENT '操作：登录、注销、新增关键词、删除关键词、修改关键词',
  `msg` varchar(255) DEFAULT NULL COMMENT '具体操作消息：登录成功、账号或密码错误、注销成功、修改关键词、新增关键词、删除关键词',
  `result` int(11) DEFAULT NULL COMMENT '结果：0成功、1失败、2异常',
  `account` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `nick` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1217 DEFAULT CHARSET=utf8mb4 COMMENT='后台操作日志';

-- ----------------------------
-- Table structure for jinhong_user_visit
-- ----------------------------
DROP TABLE IF EXISTS `jinhong_user_visit`;
CREATE TABLE `jinhong_user_visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(255) DEFAULT NULL COMMENT '页面地址',
  `ip` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `account` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `nick` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3884 DEFAULT CHARSET=utf8mb4 COMMENT='用户访问日志';

-- ----------------------------
-- Table structure for jinhong_words
-- ----------------------------
DROP TABLE IF EXISTS `jinhong_words`;
CREATE TABLE `jinhong_words` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `word` varchar(255) DEFAULT NULL COMMENT '关键词',
  `op_account` varchar(255) DEFAULT NULL COMMENT '操作人',
  `op_nick` varchar(255) DEFAULT NULL COMMENT '操作昵称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=765 DEFAULT CHARSET=utf8mb4 COMMENT='关键词过滤';
