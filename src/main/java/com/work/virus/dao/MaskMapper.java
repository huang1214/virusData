package com.work.virus.dao;

import com.work.virus.pojo.Mask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaskMapper {
    int deleteByPrimaryKey(String aid);

    int insert(Mask record);

    Mask selectByPrimaryKey(String aid);

    List<Mask> selectAll();

    int updateByPrimaryKey(Mask record);

    List<Mask> selectQueryResult(@Param("userId") String userId , @Param("phone") String phone);
}