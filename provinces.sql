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

 Date: 29/02/2020 17:54:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for provinces
-- ----------------------------
DROP TABLE IF EXISTS `provinces`;
CREATE TABLE `provinces`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `pro_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份名',
  `confirmed_num` int(20) NULL DEFAULT NULL COMMENT '确诊人数',
  `cure_num` int(20) NULL DEFAULT NULL COMMENT '治愈人数',
  `death_num` int(11) NULL DEFAULT NULL COMMENT '死亡人数',
  `fabu_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of provinces
-- ----------------------------
INSERT INTO `provinces` VALUES ('1.0', '湖北', 34715, 28895, 2727, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('10.0', '重庆', 147, 422, 6, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('11.0', '四川', 185, 350, 3, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('12.0', '黑龙江', 168, 299, 13, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('13.0', '北京', 146, 257, 7, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('14.0', '上海', 47, 287, 3, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('15.0', '河北', 35, 277, 6, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('16.0', '福建', 54, 241, 1, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('17.0', '广西', 78, 172, 2, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('18.0', '陕西', 44, 200, 1, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('19.0', '云南', 16, 156, 2, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('2.0', '广东', 370, 972, 7, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('20.0', '海南', 27, 136, 5, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('21.0', '贵州', 32, 112, 2, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('22.0', '天津', 28, 105, 3, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('23.0', '山西', 21, 112, 0, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('24.0', '辽宁', 26, 94, 1, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('25.0', '香港', 62, 30, 2, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('26.0', '吉林', 19, 73, 1, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('27.0', '甘肃', 7, 82, 2, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('28.0', '新疆', 21, 52, 3, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('29.0', '内蒙古', 29, 46, 0, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('3.0', '河南', 89, 1162, 21, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('30.0', '宁夏', 5, 68, 0, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('31.0', '台湾', 24, 9, 1, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('32.0', '青海', 0, 18, 0, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('33.0', '澳门', 2, 8, 0, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('34.0', '西藏', 0, 1, 0, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('4.0', '浙江', 217, 987, 1, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('5.0', '湖南', 173, 841, 4, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('6.0', '安徽', 138, 846, 6, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('7.0', '江西', 123, 811, 1, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('8.0', '山东', 339, 411, 6, '2020-02-29 13:55:28');
INSERT INTO `provinces` VALUES ('9.0', '江苏', 112, 519, 0, '2020-02-29 13:55:28');

SET FOREIGN_KEY_CHECKS = 1;
