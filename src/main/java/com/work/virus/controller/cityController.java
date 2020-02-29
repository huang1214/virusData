package com.work.virus.controller;

import com.work.virus.dao.CityMapper;
import com.work.virus.pojo.City;
import com.work.virus.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @Author LiGang
 * @Date 2020/2/29 15:54
 * @Version 1.0
 */
@Controller
@RequestMapping("/city")
public class cityController {

    @Autowired
    CityMapper cityMapper;
    @RequestMapping("/city")
    public String index(){
        return "city";
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public Result selectAll(){
        List<City> list = cityMapper.selectAll();
        System.out.println(list);
        Result res =  new Result();
        if(list.size()>0)
        {
            res.setItem(list);
            res.setMessage("success");
            res.setTotal(list.size());
        }
        return res;
    }

    @RequestMapping("/update")
    @ResponseBody
    public  Result update(String id,String field,String value, HttpServletRequest request){
        //把前端js 单元格编辑 ajax 传过来的属性值 id field value
        System.out.println("id"+id+"filed"+field+"value"+value);

        Result result = new Result();
        try {
            //将id field value 传递给mapper 中对应的方法
            int zhi = cityMapper.update(id, field, value);
            System.out.println(zhi);
            result.setMessage("success");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("error");
        }
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(City city,HttpServletRequest request){
        Result result = new Result();
        String id = UUID.randomUUID().toString();

        try {
            city.setId(id);
            int insert = cityMapper.insert(city);
            if(insert != 0){
                System.out.println("success");
                result.setMessage("成功");
            }else{
                result.setMessage("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("添加失败");
            result.setStatus("500");
        }
        return result;
    }
}

