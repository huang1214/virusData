package com.work.virus.service;

import com.work.virus.pojo.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPa();

    //删除学生数据
    int deletePatient(String id);

    public void  del(String[] ids);
}
