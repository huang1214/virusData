/*
 Navicat Premium Data Transfer

 Source Server         : myroot
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : db_short_video

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 29/02/2020 20:35:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `face_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '我的头像，如果没有默认给一张',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `fans_counts` int(11) NULL DEFAULT 0 COMMENT '我的粉丝数量',
  `follow_counts` int(11) NULL DEFAULT 0 COMMENT '我关注的人总数',
  `receive_like_counts` int(11) NULL DEFAULT 0 COMMENT '我接受到的赞美/收藏 的数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('0.034997161214425976qq3', '56dsa', '123', NULL, 'xiaoli', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('0.23212913809555824qq3', '63dsa', '123', NULL, 'xiaoli', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('0.7735487392438776qq2', '8dsa', '123', NULL, 'xiaoli', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('1001', 'test-sea-1111', '9999', '/path000999', '倾心网好牛十分牛~', 123456, 111, 222);
INSERT INTO `users` VALUES ('123666', 'hwj556', '123', NULL, '222', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('180425B0B3N6B25P', 'sea11', 'wzNncBURtPYCDsYd7TUgWQ==', NULL, 'sea', 0, 0, 0);
INSERT INTO `users` VALUES ('180425BNSR1CG0H0', 'abc', '4QrcOUm6Wau+VuBX8g+IPg==', NULL, 'abc', 1, 0, 1);
INSERT INTO `users` VALUES ('180425CFA4RB6T0H', 'sea', 'kU8h64TG/bK2Y91vRT9lyg==', '/180425CFA4RB6T0H/face/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.W0eLNdT6MIvD3ba01f74ba779caa63d038c3c8200b4a.jpg', 'sea1', 0, 2, 6);
INSERT INTO `users` VALUES ('180426F55CZPA9YW', 'aaaa', 'R7zlx09Yn0hn29V+nKn4CA==', NULL, 'aaaa', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GA3SBB4DP0', '1001', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '1001', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GAK87AB0X4', '10401', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '10401', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GAWCC17KWH', '104701', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '104701', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GBDFKDG5D4', '10re4701', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '10re4701', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GBKN0YRFRP', '10rwee4701', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '10rwee4701', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GH49XRZHX4', '390213890', 'H9V/tnfgt6nniqH5bDZ0hQ==', NULL, '390213890', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GHH12WXPZC', '390ewqewq213890', 'H9V/tnfgt6nniqH5bDZ0hQ==', NULL, '390ewqewq213890', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GHHPZ7NTC0', '390ewqewq21ewqe3890', 'H9V/tnfgt6nniqH5bDZ0hQ==', NULL, '390ewqewq21ewqe3890', 0, 0, 0);
INSERT INTO `users` VALUES ('180426H0GWP0C3HH', 'jdiowqjodij', 'wEmTz54sy+StEzB+TrtGSQ==', NULL, 'jdiowqjodij', 0, 0, 0);
INSERT INTO `users` VALUES ('180518CHS7SXMCX4', 'aaaaa', 'WU+AOzgKQTlu1j3KOVA1Qg==', NULL, 'aaaaa', 0, 0, 0);
INSERT INTO `users` VALUES ('180930DRXM99CKKP', 'jack', '4QrcOUm6Wau+VuBX8g+IPg==', '/180930DRXM99CKKP/face/tmp_a05a3272ef51c3b724ab6d810b94d68c3c0d83c464f2792d.jpg', 'jack123', 11, 11, 36);
INSERT INTO `users` VALUES ('180930DTN8M0WP6W', 'Ticket', '123456', NULL, 'Luck', -1, 0, 0);
INSERT INTO `users` VALUES ('180930F65GTG1T7C', 'Luck', '4QrcOUm6Wau+VuBX8g+IPg==', NULL, NULL, 0, 0, 0);
INSERT INTO `users` VALUES ('180930HXSB796AK4', 'Daddy', '4QrcOUm6Wau+VuBX8g+IPg==', NULL, NULL, 1, 0, 0);
INSERT INTO `users` VALUES ('180930K19MAGGZ0H', 'tt', '4QrcOUm6Wau+VuBX8g+IPg==', NULL, NULL, 0, 0, 0);
INSERT INTO `users` VALUES ('180930K2WZ49D968', 'Angle', '4QrcOUm6Wau+VuBX8g+IPg==', NULL, NULL, 0, 0, 0);
INSERT INTO `users` VALUES ('180930K3D6W4B44H', 'Java', '4QrcOUm6Wau+VuBX8g+IPg==', NULL, NULL, 0, 0, 0);
INSERT INTO `users` VALUES ('1833541', '李刚', '22222', NULL, '一叶知秋i', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('19010493YR0BKZ54', 'wang', '4QrcOUm6Wau+VuBX8g+IPg==', NULL, 'ming', 0, 0, 0);
INSERT INTO `users` VALUES ('555', '555', '555', NULL, '555', NULL, NULL, NULL);
INSERT INTO `users` VALUES ('admin', 'admin', 'af85cc5d1ca28b1b788b953389a40d6f', NULL, 'aaa', 0, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
