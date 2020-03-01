/*
 Navicat Premium Data Transfer

 Source Server         : nky_java
 Source Server Type    : MySQL
 Source Server Version : 50541
 Source Host           : localhost:3306
 Source Schema         : virus_data

 Target Server Type    : MySQL
 Target Server Version : 50541
 File Encoding         : 65001

 Date: 01/03/2020 10:57:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appmask
-- ----------------------------
DROP TABLE IF EXISTS `appmask`;
CREATE TABLE `appmask`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `shopname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺名称',
  `appname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app',
  `masktype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '口罩类型',
  `buytype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抢购方式',
  `price` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '价格',
  `time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买时间',
  `notice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注意事项',
  `cover_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购买封面图',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of appmask
-- ----------------------------
INSERT INTO `appmask` VALUES ('01', '3Q自营旗舰店', '京东', '医用口罩', '预约-抢购', '￥18/10', 'PM: 03:00', '准点预约，记得实名', './img/app_Img_1.jpg');
INSERT INTO `appmask` VALUES ('02', '防疫特供物资预约', '网易严选', '一次性平面口罩', '摇号', '￥6.9/3', 'AM: 10:00', '中签机会不大', './img/app_Img_2.jpg');
INSERT INTO `appmask` VALUES ('03', '小mi有品', '小米有品', 'KF94防护口罩', '抢购', '￥199/10', 'PM: 04:00', '价格有点贵', './img/app_Img_3.jpg');
INSERT INTO `appmask` VALUES ('04', '全棉时代旗舰店', '网易kaola', '护理口罩', '抢购', '￥2.5/1', 'PM: 08:00', '蹲点的人很多', './img/app_Img_4.jpg');
INSERT INTO `appmask` VALUES ('05', '全棉时代甄选品专卖店', '天猫', '护理口罩', '抢购', '￥2.5/1', 'PM: 09:00', '非旗舰店，谨慎哦', './img/app_Img_5.jpg');
INSERT INTO `appmask` VALUES ('06', 'Honeywell个人防护', '天猫', '儿童款', '抢购', '￥99/5', 'AM: 09:00', '脸小的成人也可以考虑哦', './img/app_Img_6.jpg');
INSERT INTO `appmask` VALUES ('07', '全棉时代旗舰店', '小红书商城', '护理口罩', '抢购', '￥2.5/1', 'AM: 09:00', '不准时，9点后多刷', './img/app_Img_4.jpg');
INSERT INTO `appmask` VALUES ('08', '伊藤良品', '京东', 'N99', '预约-抢购', '￥16.9/1', 'AM: 10:00', '需预约，人少，相对难度低', './img/app_Img_8.jpg');
INSERT INTO `appmask` VALUES ('09', 'ZD振德旗舰店', '淘宝', '医用口罩', '抢购', '￥39-￥49/10', 'PM: 09:00', '店铺首页没有链接需要找客服要链接', './img/app_Img_9.jpg');

SET FOREIGN_KEY_CHECKS = 1;
