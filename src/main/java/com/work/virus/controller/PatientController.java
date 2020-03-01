package com.work.virus.controller;


import com.work.virus.dao.PatientMapper;
import com.work.virus.pojo.Patient;
import com.work.virus.pojo.Result;
import com.work.virus.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    PatientService patientService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Result patientAll() {
        Result result = new Result();
        try {
            List<Patient> list = patientMapper.selectAll();
            System.out.println(list);
            if (list.size() > 0) {
                result.setItem(list);
                result.setMessage("success");
                result.setTotal(list.size());
            } else {
                result.setMessage("error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("error");
        }
        return result;
    }


    @RequestMapping("/update")
    @ResponseBody
    public Result Update(String id, String field, String value, HttpServletRequest request) {
        // patientTable.js里的单元格编辑的ajax 传过来的属性值id field value

        Result result = new Result();
        try {
            int update = patientMapper.update(id, field, value);
            int zhi = update;
            if (zhi > 0) {
                result.setMessage("success");
            } else {
                result.setMessage("error");
            }
        } catch (Exception e) {
            result.setMessage("error");
        }
        return result;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Result Eidt(Patient patient, HttpServletRequest request) {
        // patientTable.js里的单元格编辑的ajax 传过来的属性值id field value

        Result result = new Result();
        try {
            int edit = patientMapper.updateByPrimaryKey(patient);
            int zhi = edit;
            if (zhi > 0) {
                result.setMessage("success");
            } else {
                result.setMessage("error");
            }
        } catch (Exception e) {
            result.setMessage("error");
        }
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public  Result add(Patient patient  ,HttpServletRequest request){
        System.out.println(patient);
        Result  result = new Result();
        try{
            patientMapper.insert(patient);
            result.setMessage("success");
            result.setStatus("200");
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
            result.setMessage("error");
            return result;
        }
    }


    @RequestMapping("/delete")
    @ResponseBody
    public  Result delete(@RequestParam("id") String id){
        Result  result = new Result();
        System.out.println("传过来的id值是"+id);
        try{
            patientService.deletePatient(id);
            // 删除成功
            result.setMessage("success");
            result.setStatus("200");
        }
        catch(Exception e){
            result.setMessage("数据操作异常");
            result.setStatus("500");
            // z打印一下异常
            e.printStackTrace();

        }
        return result;
    }

    @RequestMapping("/deleteA")
    @ResponseBody
    public  Result delete(String[] ids,HttpServletRequest request){
        Result  result = new Result();
        System.out.println("传过来的数组值是"+ Arrays.toString(ids));
        try{
            patientService.del(ids);
            // 删除成功
            result.setMessage("success");
            result.setStatus("200");
        }
        catch(Exception e){
            result.setMessage("数据操作异常");
            result.setStatus("500");
            // z打印一下异常
            e.printStackTrace();

        }
        return result;
    }

    @RequestMapping("/query")
    @ResponseBody
    public Result Eidt(String patientId){
        Result result = new Result();
        try{
            //  Patient里   根据  patientId查询  符合条件的结果集
            List<Patient> patients = patientMapper.selectById(patientId);
            System.out.println("查询的数据是"+patients);
            if(patients == null){
                result.setMessage("没有数据");
                result.setStatus("200");
            }
            else{
                result.setMessage("success");
                // 把数据存到  结果集类中
                result.setItem(patients);
                result.setTotal(patients.size());
            }
        }
        catch (Exception e){
            result.setMessage("error");
        }
        return result;
    }


}