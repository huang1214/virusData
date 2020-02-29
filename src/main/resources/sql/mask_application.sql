CREATE TABLE `mask_application` (
  `aid` varchar(64) NOT NULL COMMENT '口罩预约单号',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `name` varchar(64) DEFAULT NULL COMMENT '预约者姓名',
  `province` varchar(64) DEFAULT NULL COMMENT '所在省',
  `city` varchar(64) DEFAULT NULL COMMENT '所在城市',
  `area` varchar(64) DEFAULT NULL COMMENT '所在地区',
  `street` varchar(64) DEFAULT NULL COMMENT '隶属街道',
  `store_id` varchar(64) DEFAULT NULL COMMENT '附近药店id',
  `certificate` varchar(1) DEFAULT NULL COMMENT '证件类型',
  `identity` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `nums` int(6) DEFAULT NULL COMMENT '预约口罩数量',
  `result` int(1) DEFAULT NULL COMMENT '申请结果',
  `date` datetime DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mask_application`(`aid`, `user_id`, `name`, `province`, `city`, `area`, `street`, `store_id`, `certificate`, `identity`, `phone`, `nums`, `result`, `date`) VALUES ('0dbc53bb-c162-41dc-b113-4ef68c94f1b3', '001', '滕梓荆', '110000_2_0', '110100_14_0', '110101', '你工作的第一个城市', NULL, '0', '123633466672836746', '836746', 2, NULL, '2020-02-29 19:32:47');
INSERT INTO `mask_application`(`aid`, `user_id`, `name`, `province`, `city`, `area`, `street`, `store_id`, `certificate`, `identity`, `phone`, `nums`, `result`, `date`) VALUES ('1a5aaa86-6771-4d12-b018-c0ec113b2d4b', '001', '叶轻眉', '110000_2_0', '110100_14_0', '110101', '你工作的第一个城市', NULL, '1', '123633466672836746', '836746', 2, NULL, '2020-02-29 19:31:27');
INSERT INTO `mask_application`(`aid`, `user_id`, `name`, `province`, `city`, `area`, `street`, `store_id`, `certificate`, `identity`, `phone`, `nums`, `result`, `date`) VALUES ('1b827690-8c7b-4829-b694-0fccd240e46a', '001', '庆余年', '110000_2_0', '110100_14_0', '你工作的第一个城市', NULL, NULL, '0', '123633466672836746', '12635465367', 1, NULL, '2020-02-29 15:04:31');
INSERT INTO `mask_application`(`aid`, `user_id`, `name`, `province`, `city`, `area`, `street`, `store_id`, `certificate`, `identity`, `phone`, `nums`, `result`, `date`) VALUES ('53e9b5c3-43a3-4484-95d4-fd9e3ae50bf8', '001', '海棠朵朵', '110000_2_0', '110100_14_0', '你工作的第一个城市', NULL, NULL, '0', '142733199907190324', '15180457781', 2, NULL, '2020-02-29 17:12:08');
INSERT INTO `mask_application`(`aid`, `user_id`, `name`, `province`, `city`, `area`, `street`, `store_id`, `certificate`, `identity`, `phone`, `nums`, `result`, `date`) VALUES ('65409687-7649-4e11-91f2-21f6f6c22a75', '001', '叶轻眉', '110000_2_0', '110100_14_0', '110101', '你工作的第一个城市', NULL, '1', '123633466672836746', '836746', 2, NULL, '2020-02-29 19:31:42');
