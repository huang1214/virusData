package com.work.virus.dao;

import com.work.virus.pojo.Store;
import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer storeId);

    int insert(Store record);

    Store selectByPrimaryKey(Integer storeId);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);
}