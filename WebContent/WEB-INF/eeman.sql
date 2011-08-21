/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50510
Source Host           : localhost:3306
Source Database       : eeman

Target Server Type    : MYSQL
Target Server Version : 50510
File Encoding         : 65001

Date: 2011-06-03 12:21:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_department`
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buildTime` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
INSERT INTO `tb_department` VALUES ('1', '2011-05-20 22:14:50', '人事部', '公司人事系统');
INSERT INTO `tb_department` VALUES ('5', '2011-05-20 22:14:50', '开发部', '开发部门');
INSERT INTO `tb_department` VALUES ('6', '2011-05-24 00:00:00', '销售部', '销售部');
INSERT INTO `tb_department` VALUES ('7', '2011-05-27 00:00:00', '测试部', '系统测试');
INSERT INTO `tb_department` VALUES ('8', '2011-05-15 00:00:00', '国内事业部', '国内事业');
INSERT INTO `tb_department` VALUES ('9', '2011-05-15 00:00:00', '安全部', '公司安全');
INSERT INTO `tb_department` VALUES ('12', '2011-05-24 00:00:00', '国外事业部', '管理国外');

-- ----------------------------
-- Table structure for `tb_document`
-- ----------------------------
DROP TABLE IF EXISTS `tb_document`;
CREATE TABLE `tb_document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filepath` varchar(255) DEFAULT NULL,
  `filetype` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK34804FCC116DEF26` (`employee_id`),
  CONSTRAINT `FK34804FCC116DEF26` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_document
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_employee`
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `birthplace` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `firstWorkTime` datetime DEFAULT NULL,
  `graduatedSchool` varchar(255) DEFAULT NULL,
  `identifycation` varchar(255) DEFAULT NULL,
  `isMarried` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `politics` varchar(255) DEFAULT NULL,
  `regedisTtime` datetime DEFAULT NULL,
  `regedistName` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `specialize` varchar(255) DEFAULT NULL,
  `telphone` varchar(255) DEFAULT NULL,
  `workType` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `bankacc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4846655F4872A1A6` (`department_id`),
  CONSTRAINT `FK4846655F4872A1A6` FOREIGN KEY (`department_id`) REFERENCES `tb_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
INSERT INTO `tb_employee` VALUES ('3', '徐州', '1987-11-18 00:00:00', '江苏', '硕士', '2011-05-25 00:00:00', '徐州工程', '330323198803093330', '1', '张三', '汉', '团员', '2011-05-09 00:00:00', '管理员', '不是管理员', '男', '计算机科学与技术', '1000002', '技术', '1', '12345678910121');
INSERT INTO `tb_employee` VALUES ('5', '南京', '1988-03-14 00:00:00', '南京', '高中以下', '2011-05-17 01:12:30', '南京大学', '3203231988031331', '0', '王晓龙', '汉', '无', '2011-05-09 01:14:17', '管理员', '', '男', '计算机可与技术', '1000004', '文职', '7', '3333333333333');
INSERT INTO `tb_employee` VALUES ('8', '北京三环内', '2000-07-20 01:17:56', 'asd', '硕士', '2011-04-22 01:18:40', '1000007', '320323198803133311', '0', '李三水', '汉', '党员', '2011-05-18 01:19:02', 'adf', '', '男', '1000007', '1000007', '技术', '8', '6226656532695412');
INSERT INTO `tb_employee` VALUES ('9', '北京三环内', '2000-07-20 01:17:56', '', '本科', null, '', '', '0', '王涛', '', '', null, '', '', '女', '', '1000008', '技术', '1', null);
INSERT INTO `tb_employee` VALUES ('12', '北京三环内', '2000-07-20 01:17:56', '', '专科', null, '', '', '1', '李美丽', '', '党员', null, '', '', '女', '', '', '', '1', null);

-- ----------------------------
-- Table structure for `tb_invitejob`
-- ----------------------------
DROP TABLE IF EXISTS `tb_invitejob`;
CREATE TABLE `tb_invitejob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `graduatedsSchool` varchar(255) DEFAULT NULL,
  `isEmploied` int(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `registTime` datetime DEFAULT NULL,
  `remark` longtext,
  `sex` varchar(255) DEFAULT NULL,
  `telphone` varchar(255) DEFAULT NULL,
  `verfifyNote` varchar(255) DEFAULT NULL,
  `verfifyName` varchar(255) DEFAULT '',
  `verfifyOperateName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_invitejob
-- ----------------------------
INSERT INTO `tb_invitejob` VALUES ('20', '', '1989-05-24 00:00:00', '高中', '无', '', '-1', '王雪', '开发', '历史', '2011-05-07 22:46:09', '', '女', '', null, null, null);
INSERT INTO `tb_invitejob` VALUES ('21', '', null, '硕士', '5年开发', '', '0', '蒋馨', '测试', '计算机', '2011-05-07 22:46:17', '', '女', '', null, null, null);
INSERT INTO `tb_invitejob` VALUES ('22', '啊斯蒂芬', '2011-05-17 00:00:00', '专科', '20', '啊斯蒂芬', '-1', '蒋玉龙', '测试', '计算机科学与技术', '2011-05-19 01:48:39', '啊斯蒂芬', '男', '15255', null, null, null);
INSERT INTO `tb_invitejob` VALUES ('24', 'asdf', '2011-05-10 00:00:00', '高中', 'asdf', 'dsf', '-1', 'nihao', '测试', 'dsf', '2011-05-27 01:42:18', '', '男', '111111', null, null, null);

-- ----------------------------
-- Table structure for `tb_notice`
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contant` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_notice
-- ----------------------------
INSERT INTO `tb_notice` VALUES ('2', '系统定期维护系统定期维护系统定期维护', '系统定期维护', '2011-05-25 00:00:00');
INSERT INTO `tb_notice` VALUES ('3', '今日进行数据库维护', '系统数据库维护', '2011-05-24 00:00:00');
INSERT INTO `tb_notice` VALUES ('4', '今日将更新系统。更新系统期间系统无法访问。', '系统更新', '2011-05-26 00:00:00');
INSERT INTO `tb_notice` VALUES ('5', '今日系统例行安全检查', '系统检查维护', '2011-03-15 00:00:00');

-- ----------------------------
-- Table structure for `tb_pay`
-- ----------------------------
DROP TABLE IF EXISTS `tb_pay`;
CREATE TABLE `tb_pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `absentPay` bigint(20) DEFAULT NULL,
  `account` int(11) DEFAULT NULL,
  `attendPay` bigint(20) DEFAULT NULL,
  `basePay` bigint(20) DEFAULT NULL,
  `extraPay` bigint(20) DEFAULT NULL,
  `insurancePay` bigint(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `workAge` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCB840757116DEF26` (`employee_id`),
  CONSTRAINT `FKCB840757116DEF26` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pay
-- ----------------------------
INSERT INTO `tb_pay` VALUES ('23', '0', '0', '100', '1000', '200', '0', '2011-05-25 00:00:00', '1', '9');
INSERT INTO `tb_pay` VALUES ('24', '0', '0', '10', '2000', '1000', '0', '2011-05-17 00:00:00', '0', '8');
INSERT INTO `tb_pay` VALUES ('25', '0', '0', '100', '3000', '0', '0', '2011-05-24 00:00:00', '2', '5');
INSERT INTO `tb_pay` VALUES ('27', '0', '0', '10', '2500', '0', '0', '2011-05-24 00:00:00', '0', '5');
INSERT INTO `tb_pay` VALUES ('30', '0', '0', '10', '1000', '0', '0', '2011-05-17 00:00:00', '0', '3');
INSERT INTO `tb_pay` VALUES ('43', '0', '0', '0', '1000', '0', '0', '2011-05-12 00:00:00', '0', '3');

-- ----------------------------
-- Table structure for `tb_res`
-- ----------------------------
DROP TABLE IF EXISTS `tb_res`;
CREATE TABLE `tb_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_res
-- ----------------------------
INSERT INTO `tb_res` VALUES ('1', '修改员工培训', null, 'EmployeeActionitrain');
INSERT INTO `tb_res` VALUES ('2', '修改增加员工信息', null, 'EmployeeActionsave');
INSERT INTO `tb_res` VALUES ('3', '删除员工信息', null, 'EmployeeActiondelete');
INSERT INTO `tb_res` VALUES ('4', '查询所有员工信息', null, 'EmployeeActionemPageList');
INSERT INTO `tb_res` VALUES ('5', '删除多个员工', null, 'EmployeeActiondeletese');
INSERT INTO `tb_res` VALUES ('6', '通过id查找员工', null, 'EmployeeActionsearchById');
INSERT INTO `tb_res` VALUES ('7', '通过姓名查找员工', null, 'EmployeeActionsearchByName');
INSERT INTO `tb_res` VALUES ('8', '保存员工培训', null, 'EmployeeActionsaveTrain');
INSERT INTO `tb_res` VALUES ('9', '通过部门查找员工', null, 'EmployeeActionsearchByDept');
INSERT INTO `tb_res` VALUES ('10', '搜索员工', null, 'EmSearchActionsearch');
INSERT INTO `tb_res` VALUES ('11', '删除部门', null, 'DepartmentActiondelete');
INSERT INTO `tb_res` VALUES ('12', '增加编辑部门', null, 'DepartmentActionsave');
INSERT INTO `tb_res` VALUES ('13', '通过id查找部门', null, 'DepartmentActionget');
INSERT INTO `tb_res` VALUES ('14', '通过名字查找部门', null, 'DepartmentActionfindByName');
INSERT INTO `tb_res` VALUES ('15', '查看所有部门', null, 'DepartmentActionfindAll');
INSERT INTO `tb_res` VALUES ('16', '增加修改招聘', null, 'InviteJobActionsave');
INSERT INTO `tb_res` VALUES ('17', '审核招聘', null, 'InviteJobActiondoVefify');
INSERT INTO `tb_res` VALUES ('18', '通过id查找招聘', null, 'InviteJobActionfindById');
INSERT INTO `tb_res` VALUES ('19', '删除招聘', null, 'InviteJobActiondelete');
INSERT INTO `tb_res` VALUES ('20', '招聘人员录用', null, 'InviteJobActionchange');
INSERT INTO `tb_res` VALUES ('21', '通过审核过滤招聘', null, 'InviteJobActiongetByVer');
INSERT INTO `tb_res` VALUES ('22', '招聘查找', null, 'InviteJobActionsearch');
INSERT INTO `tb_res` VALUES ('23', '删除多个招聘', null, 'InviteJobActiondeletese');
INSERT INTO `tb_res` VALUES ('24', '查看所有招聘信息', null, 'InviteJobActiongetAll');
INSERT INTO `tb_res` VALUES ('25', '删除资源', null, 'ResourseServicedelete');
INSERT INTO `tb_res` VALUES ('26', '增加或编辑资源', null, 'ResourseServicesaveOrUpdate');
INSERT INTO `tb_res` VALUES ('27', '通过id获取资源', null, 'ResourseServicegetById');
INSERT INTO `tb_res` VALUES ('28', '查看所有资源', null, 'ResourseServicegetAll');
INSERT INTO `tb_res` VALUES ('29', '通过资源查看角色（不包含）', null, 'ResourseServicegetByRoleNot');
INSERT INTO `tb_res` VALUES ('31', '通过资源名查找资源', null, 'ResourseServicegetByName');
INSERT INTO `tb_res` VALUES ('33', '查看多有通知', null, 'NoticeActiongetAll');
INSERT INTO `tb_res` VALUES ('34', '通过id获取通知', null, 'NoticeActionget');
INSERT INTO `tb_res` VALUES ('35', '增加编辑通知', null, 'NoticeActionsave');
INSERT INTO `tb_res` VALUES ('37', '删除通知', null, 'NoticeActiondelete');
INSERT INTO `tb_res` VALUES ('38', '通过id查找奖惩', null, 'RewardActionsearchById');
INSERT INTO `tb_res` VALUES ('39', '通过id获取奖惩', null, 'RewardActionfind');
INSERT INTO `tb_res` VALUES ('40', '删除奖惩', null, 'RewardActiondelete');
INSERT INTO `tb_res` VALUES ('41', '删除多个奖惩', null, 'RewardActiondeletese');
INSERT INTO `tb_res` VALUES ('42', '修改奖惩', null, 'RewardActionsave');
INSERT INTO `tb_res` VALUES ('43', '查看所有奖惩', null, 'RewardActionfindAll');
INSERT INTO `tb_res` VALUES ('44', '通过标题查找奖惩', null, 'RewardActionsearchByTitle');
INSERT INTO `tb_res` VALUES ('45', '搜索奖惩', null, 'RewardActionsearch');
INSERT INTO `tb_res` VALUES ('46', '修改角色权限', null, 'RoleActionsavesavePermission');
INSERT INTO `tb_res` VALUES ('47', '保存角色', null, 'RoleActionsave');
INSERT INTO `tb_res` VALUES ('48', '通过id获取角色', null, 'RoleActionget');
INSERT INTO `tb_res` VALUES ('49', '所有角色显示', null, 'RoleActiongetAll');
INSERT INTO `tb_res` VALUES ('50', '查看角色资源', null, 'RoleActiongetAllRes');
INSERT INTO `tb_res` VALUES ('51', '查看所有资源', null, 'RoleActiongetResByRole');
INSERT INTO `tb_res` VALUES ('52', '输出资源json数据', null, 'RoleActiongetAllResJson');
INSERT INTO `tb_res` VALUES ('53', '查看所有工资信息', null, 'SalaryActionfindAll');
INSERT INTO `tb_res` VALUES ('54', '删除工资信息', null, 'SalaryActiondelete');
INSERT INTO `tb_res` VALUES ('55', '删除多个工资信息', null, 'SalaryActiondeletese');
INSERT INTO `tb_res` VALUES ('56', '增加修改工资信息', null, 'SalaryActionsave');
INSERT INTO `tb_res` VALUES ('57', '通过id查找工资信息', null, 'SalaryActionfindById');
INSERT INTO `tb_res` VALUES ('58', '搜索工资信息', null, 'SalaryActionsearch');
INSERT INTO `tb_res` VALUES ('59', '通过员工id查找工资信息', null, 'SalaryActionsearchByEmId');
INSERT INTO `tb_res` VALUES ('60', '通过员工名查找工资信息', null, 'SalaryActionsearchByEmName');
INSERT INTO `tb_res` VALUES ('61', '增加修改培训', null, 'TrainActionsave');
INSERT INTO `tb_res` VALUES ('62', '通过id查找培训', null, 'TrainActionget');
INSERT INTO `tb_res` VALUES ('63', '删除多个培训', null, 'TrainActiondeleteMore');
INSERT INTO `tb_res` VALUES ('64', '删除培训', null, 'TrainActiondelete');
INSERT INTO `tb_res` VALUES ('65', '搜索培训', null, 'TrainActionsearch');
INSERT INTO `tb_res` VALUES ('66', '通过标题查找培训', null, 'TrainActiongetByTitle');
INSERT INTO `tb_res` VALUES ('67', '删除用户', null, 'UserActiondelete');
INSERT INTO `tb_res` VALUES ('68', '查看所有用户', null, 'UserActiongetAll');
INSERT INTO `tb_res` VALUES ('69', '保存用户', null, 'UserActionaddsave');
INSERT INTO `tb_res` VALUES ('70', '保存增加用户', null, 'UserActionsave');
INSERT INTO `tb_res` VALUES ('71', '通过id查找用户', null, 'UserActionget');
INSERT INTO `tb_res` VALUES ('72', '修改密码', null, 'UserActionchangepw');
INSERT INTO `tb_res` VALUES ('73', '修改用户状态', null, 'UserActionchangesu');
INSERT INTO `tb_res` VALUES ('74', '查看所有培训', null, 'TrainActionfindAll');
INSERT INTO `tb_res` VALUES ('76', '修改培训员工人员', null, 'TrainActionsaveEm');
INSERT INTO `tb_res` VALUES ('77', '查看参加培训的人员', null, 'TrainActiongetEms');
INSERT INTO `tb_res` VALUES ('78', '用户获取角色信息', null, 'UserActiongetRole');
INSERT INTO `tb_res` VALUES ('79', '用户保存角色信息', null, 'UserActionsetRole');

-- ----------------------------
-- Table structure for `tb_reward`
-- ----------------------------
DROP TABLE IF EXISTS `tb_reward`;
CREATE TABLE `tb_reward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `penalty` float NOT NULL,
  `time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reward
-- ----------------------------
INSERT INTO `tb_reward` VALUES ('3', '年终奖励', '5000', '2011-05-03 00:00:00', '年终奖励', '奖励');
INSERT INTO `tb_reward` VALUES ('4', '迟到扣款', '10', '2011-05-24 00:00:00', '迟到扣款', '惩罚');
INSERT INTO `tb_reward` VALUES ('6', '奖金200', '200', '2011-05-04 00:00:00', '全勤奖', '奖励');

-- ----------------------------
-- Table structure for `tb_reward_em`
-- ----------------------------
DROP TABLE IF EXISTS `tb_reward_em`;
CREATE TABLE `tb_reward_em` (
  `reward_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  PRIMARY KEY (`reward_id`,`employee_id`),
  KEY `FK689D7727F102AE86` (`reward_id`),
  KEY `FK689D7727116DEF26` (`employee_id`),
  CONSTRAINT `FK689D7727116DEF26` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`),
  CONSTRAINT `FK689D7727F102AE86` FOREIGN KEY (`reward_id`) REFERENCES `tb_reward` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reward_em
-- ----------------------------
INSERT INTO `tb_reward_em` VALUES ('3', '8');
INSERT INTO `tb_reward_em` VALUES ('4', '5');
INSERT INTO `tb_reward_em` VALUES ('6', '3');

-- ----------------------------
-- Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '员工模块管理角色', null, 'EMPLOYEE_ADMIN');
INSERT INTO `tb_role` VALUES ('2', '通知模块管理角色', null, 'NOTICE_ADMIN');
INSERT INTO `tb_role` VALUES ('3', '部门模块管理角色', null, 'DEPT_ADMIN');
INSERT INTO `tb_role` VALUES ('4', '工资模块管理角色', null, 'SALARY_ADMIN');
INSERT INTO `tb_role` VALUES ('5', '超级管理员', null, 'SUPER_ADMINISTRATOR');
INSERT INTO `tb_role` VALUES ('6', '奖惩模块管理角色', null, 'REWARD_ADMIN');
INSERT INTO `tb_role` VALUES ('7', '招聘模块管理角色', null, 'INVITE_ADMIN');
INSERT INTO `tb_role` VALUES ('8', '培训模块管理角色', null, 'TRAIN_ADMIN');
INSERT INTO `tb_role` VALUES ('9', '用户模块管理角色', null, 'USER_ADMIN');
INSERT INTO `tb_role` VALUES ('10', '角色模块管理角色', null, 'ROLE_ADMIN');
INSERT INTO `tb_role` VALUES ('11', '部门经理', null, 'DEPT_MANGE');
INSERT INTO `tb_role` VALUES ('12', '只读用户', null, 'READ_USER');

-- ----------------------------
-- Table structure for `tb_role_res`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_res`;
CREATE TABLE `tb_role_res` (
  `role_id` int(11) NOT NULL,
  `res_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`res_id`),
  KEY `FKF144BC0847C85F44` (`res_id`),
  KEY `FKF144BC08F5473026` (`role_id`),
  CONSTRAINT `FKF144BC0847C85F44` FOREIGN KEY (`res_id`) REFERENCES `tb_res` (`id`),
  CONSTRAINT `FKF144BC08F5473026` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_res
-- ----------------------------
INSERT INTO `tb_role_res` VALUES ('1', '1');
INSERT INTO `tb_role_res` VALUES ('5', '1');
INSERT INTO `tb_role_res` VALUES ('11', '1');
INSERT INTO `tb_role_res` VALUES ('1', '2');
INSERT INTO `tb_role_res` VALUES ('5', '2');
INSERT INTO `tb_role_res` VALUES ('11', '2');
INSERT INTO `tb_role_res` VALUES ('1', '3');
INSERT INTO `tb_role_res` VALUES ('5', '3');
INSERT INTO `tb_role_res` VALUES ('11', '3');
INSERT INTO `tb_role_res` VALUES ('1', '4');
INSERT INTO `tb_role_res` VALUES ('5', '4');
INSERT INTO `tb_role_res` VALUES ('11', '4');
INSERT INTO `tb_role_res` VALUES ('12', '4');
INSERT INTO `tb_role_res` VALUES ('1', '5');
INSERT INTO `tb_role_res` VALUES ('5', '5');
INSERT INTO `tb_role_res` VALUES ('11', '5');
INSERT INTO `tb_role_res` VALUES ('1', '6');
INSERT INTO `tb_role_res` VALUES ('5', '6');
INSERT INTO `tb_role_res` VALUES ('11', '6');
INSERT INTO `tb_role_res` VALUES ('1', '7');
INSERT INTO `tb_role_res` VALUES ('5', '7');
INSERT INTO `tb_role_res` VALUES ('11', '7');
INSERT INTO `tb_role_res` VALUES ('1', '8');
INSERT INTO `tb_role_res` VALUES ('5', '8');
INSERT INTO `tb_role_res` VALUES ('11', '8');
INSERT INTO `tb_role_res` VALUES ('1', '9');
INSERT INTO `tb_role_res` VALUES ('3', '9');
INSERT INTO `tb_role_res` VALUES ('5', '9');
INSERT INTO `tb_role_res` VALUES ('11', '9');
INSERT INTO `tb_role_res` VALUES ('1', '10');
INSERT INTO `tb_role_res` VALUES ('3', '10');
INSERT INTO `tb_role_res` VALUES ('5', '10');
INSERT INTO `tb_role_res` VALUES ('11', '10');
INSERT INTO `tb_role_res` VALUES ('3', '11');
INSERT INTO `tb_role_res` VALUES ('5', '11');
INSERT INTO `tb_role_res` VALUES ('11', '11');
INSERT INTO `tb_role_res` VALUES ('3', '12');
INSERT INTO `tb_role_res` VALUES ('5', '12');
INSERT INTO `tb_role_res` VALUES ('11', '12');
INSERT INTO `tb_role_res` VALUES ('3', '13');
INSERT INTO `tb_role_res` VALUES ('5', '13');
INSERT INTO `tb_role_res` VALUES ('11', '13');
INSERT INTO `tb_role_res` VALUES ('3', '14');
INSERT INTO `tb_role_res` VALUES ('5', '14');
INSERT INTO `tb_role_res` VALUES ('11', '14');
INSERT INTO `tb_role_res` VALUES ('3', '15');
INSERT INTO `tb_role_res` VALUES ('5', '15');
INSERT INTO `tb_role_res` VALUES ('11', '15');
INSERT INTO `tb_role_res` VALUES ('12', '15');
INSERT INTO `tb_role_res` VALUES ('5', '16');
INSERT INTO `tb_role_res` VALUES ('7', '16');
INSERT INTO `tb_role_res` VALUES ('5', '17');
INSERT INTO `tb_role_res` VALUES ('7', '17');
INSERT INTO `tb_role_res` VALUES ('5', '18');
INSERT INTO `tb_role_res` VALUES ('7', '18');
INSERT INTO `tb_role_res` VALUES ('5', '19');
INSERT INTO `tb_role_res` VALUES ('7', '19');
INSERT INTO `tb_role_res` VALUES ('5', '20');
INSERT INTO `tb_role_res` VALUES ('7', '20');
INSERT INTO `tb_role_res` VALUES ('5', '21');
INSERT INTO `tb_role_res` VALUES ('7', '21');
INSERT INTO `tb_role_res` VALUES ('5', '22');
INSERT INTO `tb_role_res` VALUES ('7', '22');
INSERT INTO `tb_role_res` VALUES ('5', '23');
INSERT INTO `tb_role_res` VALUES ('7', '23');
INSERT INTO `tb_role_res` VALUES ('5', '24');
INSERT INTO `tb_role_res` VALUES ('7', '24');
INSERT INTO `tb_role_res` VALUES ('12', '24');
INSERT INTO `tb_role_res` VALUES ('5', '25');
INSERT INTO `tb_role_res` VALUES ('10', '25');
INSERT INTO `tb_role_res` VALUES ('5', '26');
INSERT INTO `tb_role_res` VALUES ('10', '26');
INSERT INTO `tb_role_res` VALUES ('5', '27');
INSERT INTO `tb_role_res` VALUES ('10', '27');
INSERT INTO `tb_role_res` VALUES ('5', '28');
INSERT INTO `tb_role_res` VALUES ('10', '28');
INSERT INTO `tb_role_res` VALUES ('12', '28');
INSERT INTO `tb_role_res` VALUES ('5', '29');
INSERT INTO `tb_role_res` VALUES ('10', '29');
INSERT INTO `tb_role_res` VALUES ('5', '31');
INSERT INTO `tb_role_res` VALUES ('10', '31');
INSERT INTO `tb_role_res` VALUES ('2', '33');
INSERT INTO `tb_role_res` VALUES ('5', '33');
INSERT INTO `tb_role_res` VALUES ('2', '34');
INSERT INTO `tb_role_res` VALUES ('5', '34');
INSERT INTO `tb_role_res` VALUES ('2', '35');
INSERT INTO `tb_role_res` VALUES ('5', '35');
INSERT INTO `tb_role_res` VALUES ('2', '37');
INSERT INTO `tb_role_res` VALUES ('5', '37');
INSERT INTO `tb_role_res` VALUES ('5', '38');
INSERT INTO `tb_role_res` VALUES ('5', '39');
INSERT INTO `tb_role_res` VALUES ('10', '39');
INSERT INTO `tb_role_res` VALUES ('5', '40');
INSERT INTO `tb_role_res` VALUES ('6', '40');
INSERT INTO `tb_role_res` VALUES ('5', '41');
INSERT INTO `tb_role_res` VALUES ('6', '41');
INSERT INTO `tb_role_res` VALUES ('5', '42');
INSERT INTO `tb_role_res` VALUES ('6', '42');
INSERT INTO `tb_role_res` VALUES ('5', '43');
INSERT INTO `tb_role_res` VALUES ('6', '43');
INSERT INTO `tb_role_res` VALUES ('12', '43');
INSERT INTO `tb_role_res` VALUES ('5', '44');
INSERT INTO `tb_role_res` VALUES ('6', '44');
INSERT INTO `tb_role_res` VALUES ('5', '45');
INSERT INTO `tb_role_res` VALUES ('6', '45');
INSERT INTO `tb_role_res` VALUES ('5', '46');
INSERT INTO `tb_role_res` VALUES ('10', '46');
INSERT INTO `tb_role_res` VALUES ('5', '47');
INSERT INTO `tb_role_res` VALUES ('10', '47');
INSERT INTO `tb_role_res` VALUES ('5', '48');
INSERT INTO `tb_role_res` VALUES ('10', '48');
INSERT INTO `tb_role_res` VALUES ('5', '49');
INSERT INTO `tb_role_res` VALUES ('10', '49');
INSERT INTO `tb_role_res` VALUES ('12', '49');
INSERT INTO `tb_role_res` VALUES ('5', '50');
INSERT INTO `tb_role_res` VALUES ('10', '50');
INSERT INTO `tb_role_res` VALUES ('5', '51');
INSERT INTO `tb_role_res` VALUES ('10', '51');
INSERT INTO `tb_role_res` VALUES ('5', '52');
INSERT INTO `tb_role_res` VALUES ('10', '52');
INSERT INTO `tb_role_res` VALUES ('4', '53');
INSERT INTO `tb_role_res` VALUES ('5', '53');
INSERT INTO `tb_role_res` VALUES ('12', '53');
INSERT INTO `tb_role_res` VALUES ('4', '54');
INSERT INTO `tb_role_res` VALUES ('5', '54');
INSERT INTO `tb_role_res` VALUES ('4', '55');
INSERT INTO `tb_role_res` VALUES ('5', '55');
INSERT INTO `tb_role_res` VALUES ('4', '56');
INSERT INTO `tb_role_res` VALUES ('5', '56');
INSERT INTO `tb_role_res` VALUES ('4', '57');
INSERT INTO `tb_role_res` VALUES ('5', '57');
INSERT INTO `tb_role_res` VALUES ('4', '58');
INSERT INTO `tb_role_res` VALUES ('5', '58');
INSERT INTO `tb_role_res` VALUES ('4', '59');
INSERT INTO `tb_role_res` VALUES ('5', '59');
INSERT INTO `tb_role_res` VALUES ('4', '60');
INSERT INTO `tb_role_res` VALUES ('5', '60');
INSERT INTO `tb_role_res` VALUES ('5', '61');
INSERT INTO `tb_role_res` VALUES ('8', '61');
INSERT INTO `tb_role_res` VALUES ('5', '62');
INSERT INTO `tb_role_res` VALUES ('8', '62');
INSERT INTO `tb_role_res` VALUES ('5', '63');
INSERT INTO `tb_role_res` VALUES ('8', '63');
INSERT INTO `tb_role_res` VALUES ('5', '64');
INSERT INTO `tb_role_res` VALUES ('8', '64');
INSERT INTO `tb_role_res` VALUES ('5', '65');
INSERT INTO `tb_role_res` VALUES ('8', '65');
INSERT INTO `tb_role_res` VALUES ('5', '66');
INSERT INTO `tb_role_res` VALUES ('8', '66');
INSERT INTO `tb_role_res` VALUES ('5', '67');
INSERT INTO `tb_role_res` VALUES ('9', '67');
INSERT INTO `tb_role_res` VALUES ('5', '68');
INSERT INTO `tb_role_res` VALUES ('9', '68');
INSERT INTO `tb_role_res` VALUES ('12', '68');
INSERT INTO `tb_role_res` VALUES ('5', '69');
INSERT INTO `tb_role_res` VALUES ('9', '69');
INSERT INTO `tb_role_res` VALUES ('5', '70');
INSERT INTO `tb_role_res` VALUES ('9', '70');
INSERT INTO `tb_role_res` VALUES ('5', '71');
INSERT INTO `tb_role_res` VALUES ('9', '71');
INSERT INTO `tb_role_res` VALUES ('5', '72');
INSERT INTO `tb_role_res` VALUES ('9', '72');
INSERT INTO `tb_role_res` VALUES ('5', '73');
INSERT INTO `tb_role_res` VALUES ('9', '73');
INSERT INTO `tb_role_res` VALUES ('5', '74');
INSERT INTO `tb_role_res` VALUES ('8', '74');
INSERT INTO `tb_role_res` VALUES ('12', '74');
INSERT INTO `tb_role_res` VALUES ('5', '76');
INSERT INTO `tb_role_res` VALUES ('5', '77');
INSERT INTO `tb_role_res` VALUES ('5', '78');
INSERT INTO `tb_role_res` VALUES ('9', '78');
INSERT INTO `tb_role_res` VALUES ('5', '79');
INSERT INTO `tb_role_res` VALUES ('9', '79');

-- ----------------------------
-- Table structure for `tb_score`
-- ----------------------------
DROP TABLE IF EXISTS `tb_score`;
CREATE TABLE `tb_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFACAA581116DEF26` (`employee_id`),
  CONSTRAINT `FKFACAA581116DEF26` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_score
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_train`
-- ----------------------------
DROP TABLE IF EXISTS `tb_train`;
CREATE TABLE `tb_train` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_train
-- ----------------------------
INSERT INTO `tb_train` VALUES ('8', '徐州工程学院', '讲解注解在ssh上的使用', '马士兵', '2011-05-24 00:00:00', '注解');
INSERT INTO `tb_train` VALUES ('11', '南京', 'spring中aop的详细应用', '蒋云龙', '2011-04-03 00:00:00', 'Spring AOP的秘密');
INSERT INTO `tb_train` VALUES ('12', '徐州', '学习niaho adsfasdfasdfdas', '郭晓', '2011-04-07 00:00:00', '毕业设计');
INSERT INTO `tb_train` VALUES ('13', '徐州', '先装vs。。。', 'TOM（专家）', '2011-04-17 00:00:00', '毕业设计');
INSERT INTO `tb_train` VALUES ('14', '南京', '电子销售兴趣班', '张云', '2011-05-17 00:00:00', '电子销售');

-- ----------------------------
-- Table structure for `tb_train_employee`
-- ----------------------------
DROP TABLE IF EXISTS `tb_train_employee`;
CREATE TABLE `tb_train_employee` (
  `train_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  PRIMARY KEY (`train_id`,`employee_id`),
  KEY `FKE47E4F6FAB000E` (`train_id`),
  KEY `FKE47E4F6116DEF26` (`employee_id`),
  CONSTRAINT `FKE47E4F6116DEF26` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`),
  CONSTRAINT `FKE47E4F6FAB000E` FOREIGN KEY (`train_id`) REFERENCES `tb_train` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_train_employee
-- ----------------------------
INSERT INTO `tb_train_employee` VALUES ('11', '5');
INSERT INTO `tb_train_employee` VALUES ('13', '3');
INSERT INTO `tb_train_employee` VALUES ('13', '8');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `enable` int(10) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA4FF6AFC116DEF26` (`employee_id`),
  CONSTRAINT `FKA4FF6AFC116DEF26` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '系统管理员', '1', 'a', 'a', '3');
INSERT INTO `tb_user` VALUES ('2', '管理员', '1', 'admin', 'admin', '5');
INSERT INTO `tb_user` VALUES ('7', '一般用户', '1', 'f', 'adminuser', '5');
INSERT INTO `tb_user` VALUES ('14', '', '0', '1111111', '111111', null);

-- ----------------------------
-- Table structure for `tb_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`userid`,`roleid`),
  KEY `FK37884BD96C0CE2B3` (`roleid`),
  KEY `FK37884BD97162381D` (`userid`),
  CONSTRAINT `FK37884BD96C0CE2B3` FOREIGN KEY (`roleid`) REFERENCES `tb_role` (`id`),
  CONSTRAINT `FK37884BD97162381D` FOREIGN KEY (`userid`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1', '1');
INSERT INTO `tb_user_role` VALUES ('14', '1');
INSERT INTO `tb_user_role` VALUES ('1', '2');
INSERT INTO `tb_user_role` VALUES ('14', '2');
INSERT INTO `tb_user_role` VALUES ('14', '3');
INSERT INTO `tb_user_role` VALUES ('14', '4');
INSERT INTO `tb_user_role` VALUES ('2', '12');
