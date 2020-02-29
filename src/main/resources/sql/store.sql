CREATE TABLE `store` (
  `store_id` int(11) NOT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `storename` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `store`(`store_id`, `province`, `city`, `area`, `storename`, `location`) VALUES (1, '110000_2_0', '110100_14_0', '110101', '东城国药健众药店', '东城市罗莎社区罗莎路金沙大厦');
INSERT INTO `store`(`store_id`, `province`, `city`, `area`, `storename`, `location`) VALUES (2, '110000_2_0', '110100_14_0', '110101', '东城国药万达药店', '东城市万达广场西侧');
INSERT INTO `store`(`store_id`, `province`, `city`, `area`, `storename`, `location`) VALUES (3, '110000_2_0', '110100_14_0', '110101', '东城国药森林药店', '东城市城区新风路');
INSERT INTO `store`(`store_id`, `province`, `city`, `area`, `storename`, `location`) VALUES (4, '110000_2_0', '110100_14_0', '110101', '东城国药华安药店', '东城市南城区岭路1号水韵公园');
INSERT INTO `store`(`store_id`, `province`, `city`, `area`, `storename`, `location`) VALUES (5, '110000_2_0', '110100_14_0', '110101', '东城国药红山第二药店', '东城市新城石竹花园B座18号铺');
INSERT INTO `store`(`store_id`, `province`, `city`, `area`, `storename`, `location`) VALUES (6, '110000_2_0', '110100_14_0', '110101', '东城国药恒大华都药店', '东城市南城区雅园社区嘉荣大厦一楼6-7号');
INSERT INTO `store`(`store_id`, `province`, `city`, `area`, `storename`, `location`) VALUES (7, '110000_2_0', '110100_14_0', '110101', '东城国药康悦药店', '东城市东郡路5号未来花园汇龙湾235号');
