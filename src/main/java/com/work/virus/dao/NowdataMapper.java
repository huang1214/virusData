package com.work.virus.dao;

import com.work.virus.pojo.Nowdata;
import java.util.List;

public interface NowdataMapper {
    int deleteByPrimaryKey(String id);

    int insert(Nowdata record);

    Nowdata selectByPrimaryKey(String id);

    List<Nowdata> selectAll();

    int updateByPrimaryKey(Nowdata record);
}