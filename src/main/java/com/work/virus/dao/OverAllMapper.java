package com.work.virus.dao;

import com.work.virus.pojo.OverAll;
import java.util.List;

public interface OverAllMapper {
    int deleteByPrimaryKey(String id);

    int insert(OverAll record);

    OverAll selectByPrimaryKey(String id);

    List<OverAll> selectAll();

    int updateByPrimaryKey(OverAll record);
}