CREATE TABLE `news` (
  `id` varchar(255) NOT NULL COMMENT '新闻主键',
  `pubDate` datetime DEFAULT NULL COMMENT '发布时间',
  `pubDateStr` varchar(0) DEFAULT NULL COMMENT '时间描述',
  `title` varchar(255) DEFAULT NULL COMMENT '新闻标题',
  `summary` varchar(600) DEFAULT NULL COMMENT '内容简述',
  `infoSource` varchar(255) DEFAULT NULL COMMENT '新闻来源',
  `sourceUrl` varchar(255) DEFAULT NULL COMMENT '新闻链接',
  `provinceName` varchar(255) DEFAULT NULL COMMENT '省份',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;