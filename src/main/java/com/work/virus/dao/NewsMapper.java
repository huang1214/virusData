package com.work.virus.dao;

import com.work.virus.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(String id);

    int insert(News record);

    int rep(News record);

    News selectByPrimaryKey(String id);

    List<News> selectAll();

    int updateByPrimaryKey(News record);

    List<News> selectNews(@Param("title") String title);

    int update(@Param("id") String id, @Param("field") String field, @Param("value") String value);
}