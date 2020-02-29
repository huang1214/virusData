package com.work.virus.dao;

import com.work.virus.pojo.News;
import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(String id);

    int insert(News record);

    News selectByPrimaryKey(String id);

    List<News> selectAll();

    int updateByPrimaryKey(News record);
}