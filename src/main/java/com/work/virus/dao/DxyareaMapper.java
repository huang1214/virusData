package com.work.virus.dao;

import com.work.virus.pojo.Dxyarea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DxyareaMapper {
    int insert(Dxyarea record);

    List<Dxyarea> selectAll();

    // 按照省份汇总 各个项目的人数
    List<Dxyarea> sumByProvince();

    // 按照省份查询数据
    List<Dxyarea> selectByProvinceId(@Param("province_zipCode") String province_zipCode);
}