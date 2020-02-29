package com.work.virus.dao;

import com.work.virus.pojo.Provinces;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProvincesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Provinces record);

    Provinces selectByPrimaryKey(String id);

    List<Provinces> selectAll();

    int updateByPrimaryKey(Provinces record);

    int update(@Param("id")String id, @Param("field")String field, @Param("value")String value);

    //搜索 函数，根据userid查询的方法  通过模糊查询
    List<Provinces> selectByproName(@Param("pro_name")String pro_name,@Param("page")Integer page, @Param("pageTotal")Integer pageTotal);
}