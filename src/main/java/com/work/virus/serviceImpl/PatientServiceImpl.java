package com.work.virus.serviceImpl;

import com.work.virus.dao.PatientMapper;
import com.work.virus.pojo.Patient;
import com.work.virus.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service  // @Service 服务层的注解
@Transactional   // 管理事物的注解
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper patientMapper;

    @Override
    public List<Patient> getAllPa() {
        return patientMapper.selectAll();
    }

    @Override
    public int deletePatient(String id) {
        return patientMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void del(String[] ids) {
        for (int i=0;i<ids.length;i++) {
            patientMapper.deleteByPrimaryKey(ids[i]);
        }
    }

}
