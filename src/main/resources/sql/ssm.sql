/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2018-05-24 17:53:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  `modify_date` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `article` varchar(255) DEFAULT NULL,
  `auther` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '2018-03-05 11:28:06', null, '2018-03-05 11:28:06', 'photochainnode代码提交pull步骤！！！！.txt', 'chainnode代码提交pull步骤！！！！', 'admin');
INSERT INTO `article` VALUES ('2', '2018-03-05 11:29:42', null, '2018-03-05 11:29:42', 'photo\\chainnode代码提交pull步骤！！！！.txt', 'chainnode代码提交pull步骤！！！！', 'admin');
INSERT INTO `article` VALUES ('3', '2018-03-05 11:31:06', '\0', '2018-03-05 11:31:06', 'photo\\chainnode代码提交pull步骤！！！！.txt', 'chainnode代码提交pull步骤！！！！', 'admin');
INSERT INTO `article` VALUES ('4', '2018-03-05 11:38:10', '\0', '2018-03-05 11:38:10', 'photo\\chainnode代码提交pull步骤！！！！.txt', 'chainnode代码提交pull步骤！！！！', 'admin');
INSERT INTO `article` VALUES ('5', '2018-03-05 11:39:09', '', '2018-03-06 16:22:57', 'photo\\chainnode代码提交pull步骤！！！！.txt', 'chainnode代码提交pull步骤！！！！', 'admin');
INSERT INTO `article` VALUES ('6', '2018-03-05 11:53:45', '\0', '2018-03-05 11:53:45', 'photo\\admin\\centos.txt', 'centos', 'admin');
INSERT INTO `article` VALUES ('7', '2018-03-05 11:58:45', '', '2018-03-06 16:33:35', 'photo\\admin\\12省内涉旅企业数量变更.xlsx', '12省内涉旅企业数量变更', 'admin');
INSERT INTO `article` VALUES ('8', '2018-03-05 16:43:28', '', '2018-03-06 16:33:35', 'photo\\admin\\bbd软件流程说明.doc', 'bbd软件流程说明', 'admin');
INSERT INTO `article` VALUES ('9', '2018-03-06 16:08:22', '', '2018-03-06 16:33:35', 'D:\\\\photo\\\\\\发展指数-纵向.png', '发展指数-纵向', 'admin');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  `modify_date` datetime DEFAULT NULL,
  `permissioncn` varchar(255) DEFAULT NULL COMMENT '权限中文',
  `permissionen` varchar(255) DEFAULT NULL COMMENT '权限英文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', null, '\0', '2018-02-27 11:18:52', 'testPermission1', '测试权限1');
INSERT INTO `sys_permission` VALUES ('2', null, '\0', '2018-02-27 11:27:17', '权限2', 'quanxian2');
INSERT INTO `sys_permission` VALUES ('3', null, '\0', null, 'testPermission3', '测试权限3');
INSERT INTO `sys_permission` VALUES ('4', null, null, null, '权限测试4', 'test4');
INSERT INTO `sys_permission` VALUES ('5', '2018-02-26 18:24:03', '\0', '2018-02-26 18:24:03', '权限测试5', 'test5');
INSERT INTO `sys_permission` VALUES ('6', null, '\0', null, '权限测试6', 'test6');
INSERT INTO `sys_permission` VALUES ('7', '2018-02-27 11:17:13', '', '2018-02-27 11:30:50', '权限7', 'quan7');
INSERT INTO `sys_permission` VALUES ('8', '2018-04-19 14:53:31', null, '2018-04-19 14:53:31', '测试巴拉1', 'testbala1');
INSERT INTO `sys_permission` VALUES ('9', '2018-05-24 14:42:50', null, '2018-05-24 14:42:50', '测试9', 'test9');
INSERT INTO `sys_permission` VALUES ('10', '2018-05-24 14:44:10', '', '2018-05-24 14:44:10', '测试9', 'test9');
INSERT INTO `sys_permission` VALUES ('11', '2018-05-24 14:51:25', null, '2018-05-24 14:51:25', '测试9', 'test9');
INSERT INTO `sys_permission` VALUES ('12', '2018-05-24 14:54:28', null, '2018-05-24 14:54:28', 'string', 'string');
INSERT INTO `sys_permission` VALUES ('13', '2018-05-24 14:58:06', null, '2018-05-24 14:58:06', '测试9', 'test9');
INSERT INTO `sys_permission` VALUES ('14', '2018-05-24 15:00:37', null, '2018-05-24 15:00:37', '测试9', 'test9');
INSERT INTO `sys_permission` VALUES ('15', '2018-05-24 15:06:32', null, '2018-05-24 15:06:32', '测试9', 'test9');
INSERT INTO `sys_permission` VALUES ('16', '2018-05-24 15:07:56', null, '2018-05-24 15:07:56', '测试9', 'test9');
INSERT INTO `sys_permission` VALUES ('17', '2018-05-24 15:11:01', '\0', '2018-05-24 15:11:01', '测试9', 'test9');
INSERT INTO `sys_permission` VALUES ('18', '2018-05-24 16:10:04', '', '2018-05-24 16:37:25', 'test111', '测试1111');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `role_name` varchar(40) DEFAULT NULL COMMENT '角色名',
  `role_type` varchar(40) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('5', '2018-02-27 10:53:34', '\0', '2018-02-27 10:53:34', '角色1', 'common');
INSERT INTO `sys_role` VALUES ('6', '2018-02-27 10:54:01', '', '2018-02-27 11:07:34', '角色2', 'common');
INSERT INTO `sys_role` VALUES ('7', '2018-02-27 10:54:29', '\0', '2018-02-27 10:54:29', '角色3', 'superadmin');
INSERT INTO `sys_role` VALUES ('8', '2018-05-24 16:42:46', '\0', '2018-05-24 16:42:46', '橘色10', '管理员啊');
INSERT INTO `sys_role` VALUES ('9', null, '', '2018-05-24 17:10:47', '尽快', 'string');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`),
  CONSTRAINT `FK9q28ewrhntqeipl1t04kh1be7` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKomxrs8a388bknvhjokh440waq` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('5', '1');
INSERT INTO `sys_role_permission` VALUES ('7', '1');
INSERT INTO `sys_role_permission` VALUES ('8', '1');
INSERT INTO `sys_role_permission` VALUES ('7', '2');
INSERT INTO `sys_role_permission` VALUES ('8', '2');
INSERT INTO `sys_role_permission` VALUES ('7', '3');
INSERT INTO `sys_role_permission` VALUES ('8', '3');
INSERT INTO `sys_role_permission` VALUES ('5', '5');
INSERT INTO `sys_role_permission` VALUES ('7', '5');
INSERT INTO `sys_role_permission` VALUES ('8', '5');
INSERT INTO `sys_role_permission` VALUES ('7', '6');
INSERT INTO `sys_role_permission` VALUES ('8', '6');
INSERT INTO `sys_role_permission` VALUES ('8', '17');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `account` varchar(40) DEFAULT NULL COMMENT '帐户名，唯一',
  `address` varchar(40) DEFAULT NULL COMMENT '地址',
  `class_name` varchar(40) DEFAULT NULL COMMENT '班级',
  `email` varchar(40) DEFAULT NULL COMMENT '邮箱',
  `grade` varchar(40) DEFAULT NULL COMMENT '年级',
  `password` varchar(40) DEFAULT NULL COMMENT '密码',
  `remark` longtext,
  `sex` int(2) DEFAULT NULL COMMENT '性别',
  `telephone` varchar(40) DEFAULT NULL COMMENT '电话',
  `username` varchar(40) DEFAULT NULL COMMENT '用户名',
  `role_id` bigint(20) DEFAULT NULL,
  `user_state` int(11) DEFAULT NULL,
  `salt` varchar(20) DEFAULT NULL,
  `photo_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4dm5kxn3potpfgdigehw7pdyu` (`role_id`),
  CONSTRAINT `FK4dm5kxn3potpfgdigehw7pdyu` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('42', '2018-02-27 10:58:47', '', '2018-02-27 11:05:59', '曹曦啊', '水浒', '3班', '14480@qq.com', '高三', '39112297736632422e5dc0d04aa36af7', 'string', '1', '15325784578', '曹曦啊', '6', '1', '2018-02-27 10:58:46', null);
INSERT INTO `sys_user` VALUES ('43', '2018-02-27 11:03:26', '', '2018-02-27 11:39:19', '曹曦的', '水浒', '3班', '14480@qq.com', '高三', '123123', null, '1', '15525784578', '曹曦啊', '7', '1', '2018-02-27 11:03:26', null);
INSERT INTO `sys_user` VALUES ('44', '2018-02-27 11:52:53', '', '2018-02-27 11:56:22', '曹曦', null, null, '135435@qq.com', null, '7b2e14bcfca977b9d853342312a269c9', null, '1', '15513635436', '我的AA', '5', '1', '2018-02-27 11:52:53', null);
INSERT INTO `sys_user` VALUES ('45', '2018-02-28 13:43:38', '', '2018-02-28 13:43:48', 'chenyal', null, null, '14480731311@qq.com', null, '8b5c5094321c44bf700f94f0754bce13', null, null, null, null, '7', '1', '2018-02-28 13:43:38', null);
INSERT INTO `sys_user` VALUES ('46', '2018-03-05 11:00:40', '', '2018-03-05 11:00:40', 'acc1', null, null, '134545@qq.com', null, 'e4d722dd4b5fd16bf5cf58b754883685', null, '1', '15435645345', '账号1', '7', '1', '2018-03-05 11:00:40', null);
INSERT INTO `sys_user` VALUES ('47', '2018-03-06 17:22:20', '', '2018-03-06 17:22:36', 'chenchen', null, null, '1448073111@qq.com', null, '9f95466c18be461647024609e7cb460d', null, null, null, null, null, '1', '2018-03-06 17:22:20', null);
INSERT INTO `sys_user` VALUES ('48', null, '', null, 'chenyalan', null, null, '1448073111@qq.com', null, '34174d2fc0df89602cdece510ef73ea6', null, null, null, null, '5', '0', '?V\'a', null);
INSERT INTO `sys_user` VALUES ('49', '2018-04-19 03:08:12', '', '2018-04-19 03:08:31', 'chenyalan', null, null, '1448073111@qq.com', null, '56b011be29907d206a336341aa24d9b1', null, null, null, null, '5', '1', '$6ea', null);
INSERT INTO `sys_user` VALUES ('50', '2018-04-19 14:12:09', '', '2018-04-19 14:12:55', 'leeaoyuan', null, null, 'sharp_94free@163.com', null, '042b1b7f6514ab5b729bce06a37fc658', null, null, null, null, null, '1', '?F;C', null);
INSERT INTO `sys_user` VALUES ('51', '2018-04-19 14:20:40', '', '2018-04-19 14:20:57', 'leeaoyuan', null, null, 'sharp_94free@163.com', null, '4884aecefabaeca40ac299cef9cc1756', null, null, null, null, null, '1', '|-qP', null);
INSERT INTO `sys_user` VALUES ('52', '2018-04-20 10:39:12', '\0', '2018-05-18 11:53:07', 'leeaoyuan', '首尔顶顶顶', '首尔大学', 'sharp_94free@163.com', null, 'd343367543146c9523f0c5d39a894278', null, '1', null, '李袄原', '5', '1', '4hJc', null);
INSERT INTO `sys_user` VALUES ('53', '2018-04-20 10:19:20', '', '2018-04-20 10:21:32', 'chenyalan', null, null, '2333@qq.com', null, '5476c4308c5426608a5d683a8c368d31', null, '1', '15343434343', '陈亚兰', '5', '1', 't{m9', null);
INSERT INTO `sys_user` VALUES ('54', '2018-05-24 17:14:56', '', '2018-05-24 17:52:00', 'chen', null, null, 'qwert6750@126.com', null, '75fba71d520c423f58a7c5f1eb1dbf54', null, null, null, 'string', null, '0', 'Qc\\|', null);

-- ----------------------------
-- Table structure for tbl_book
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book`;
CREATE TABLE `tbl_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_book
-- ----------------------------
