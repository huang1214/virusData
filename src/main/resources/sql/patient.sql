CREATE TABLE `patient`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `temperate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


INSERT INTO `patient` VALUES ('001', '张三', '湖北武汉', '重', '40');
INSERT INTO `patient` VALUES ('002', '张四', '湖北武汉', '重', '39');
INSERT INTO `patient` VALUES ('003', '张七', '湖北武汉', '中', '38.7');
INSERT INTO `patient` VALUES ('004', '王三', '湖北武汉', '重', '39.8');
INSERT INTO `patient` VALUES ('005', '李三', '湖南长沙', '轻', '38.3');
INSERT INTO `patient` VALUES ('112', '刘六', '湖南长沙', '重', '39.4');
INSERT INTO `patient` VALUES ('123', '王五', '河南郑州', '中', '38.7');
INSERT INTO `patient` VALUES ('145', '李七', '河南郑州', '重', '39.7');
INSERT INTO `patient` VALUES ('177', '牛八', '河南郑州', '轻', '37.9');
INSERT INTO `patient` VALUES ('776', '黄二', '江西南昌', '轻', '37.8');
INSERT INTO `patient` VALUES ('543', '黄三', '广东广州', '重', '39.9');
INSERT INTO `patient` VALUES ('999', '红牛', '四川成都', '中', '38.2');