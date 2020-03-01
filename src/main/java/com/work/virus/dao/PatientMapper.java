package com.work.virus.dao;

import com.work.virus.pojo.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {
    // 查询所有学生数据
    //List<student> getStudent(@Param("start") int start, @Param("limit") int limit);

    int deleteByPrimaryKey(String id);

    int insert(Patient record);

   Patient selectByPrimaryKey(String id);

    List<Patient> selectAll();

    int updateByPrimaryKey(Patient record);

    // 单元格编辑函数
    int update(@Param("id") String id,@Param("field") String  field,@Param("value") String value);
    List<Patient> selectById(String id);

}
