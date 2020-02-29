/*
 Navicat Premium Data Transfer

 Source Server         : myroot
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : virus_data

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 29/02/2020 17:54:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `city_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名',
  `add_num` int(11) NULL DEFAULT NULL COMMENT '新增确诊',
  `confirmed_num` int(11) NULL DEFAULT NULL COMMENT '现有确诊',
  `cure_num` int(11) NULL DEFAULT NULL COMMENT '治愈人数',
  `death_num` int(11) NULL DEFAULT NULL COMMENT '死亡人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1.0', '武汉', 420, 28836, 17552, 2169);
INSERT INTO `city` VALUES ('10.0', '荆门', 1, 324, 563, 37);
INSERT INTO `city` VALUES ('11.0', '咸宁', 0, 148, 677, 11);
INSERT INTO `city` VALUES ('12.0', '十堰', 0, 243, 421, 7);
INSERT INTO `city` VALUES ('13.0', '仙桃', 0, 148, 408, 19);
INSERT INTO `city` VALUES ('14.0', '天门', 0, 121, 362, 13);
INSERT INTO `city` VALUES ('15.0', '恩施', 1, 67, 181, 4);
INSERT INTO `city` VALUES ('16.0', '潜江', 0, 82, 107, 9);
INSERT INTO `city` VALUES ('17.0', '神农架林区', 0, 1, 10, 0);
INSERT INTO `city` VALUES ('2.0', '孝感', 1, 1356, 2047, 115);
INSERT INTO `city` VALUES ('3.0', '黄冈', 0, 670, 2119, 115);
INSERT INTO `city` VALUES ('4.0', '荆州', 0, 568, 965, 46);
INSERT INTO `city` VALUES ('4d33d91a-cc18-4fbd-887d-1142a8e7ff37', '平遥', 1, 1, 1, 1);
INSERT INTO `city` VALUES ('5.0', '鄂州', 1, 599, 747, 44);
INSERT INTO `city` VALUES ('6.0', '随州', 0, 470, 797, 40);
INSERT INTO `city` VALUES ('7.0', '襄阳', 0, 340, 802, 33);
INSERT INTO `city` VALUES ('8.0', '黄石', 0, 304, 675, 34);
INSERT INTO `city` VALUES ('9.0', '宜昌', 0, 438, 462, 31);

SET FOREIGN_KEY_CHECKS = 1;
