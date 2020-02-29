package com.work.virus.dao;

import com.work.virus.pojo.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(String id);

    int insert(City record);

    City selectByPrimaryKey(String id);

    List<City> selectAll();
    int update(@Param("id") String id, @Param("field") String field, @Param("value") String value);
    int updateByPrimaryKey(City record);
}