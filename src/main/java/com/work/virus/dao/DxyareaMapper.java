package com.work.virus.dao;

import com.work.virus.pojo.Dxyarea;
import java.util.List;

public interface DxyareaMapper {
    int insert(Dxyarea record);

    List<Dxyarea> selectAll();

    // 按照省份汇总 各个项目的人数
    List<Dxyarea> sumByProvince();
}