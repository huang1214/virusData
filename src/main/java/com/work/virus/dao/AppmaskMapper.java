package com.work.virus.dao;

import com.work.virus.pojo.Appmask;
import java.util.List;

public interface AppmaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(Appmask record);

    Appmask selectByPrimaryKey(String id);

    List<Appmask> selectAll();

    int updateByPrimaryKey(Appmask record);
}