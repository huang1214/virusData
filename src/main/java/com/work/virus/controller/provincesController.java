package com.work.virus.controller;

import com.work.virus.dao.ProvincesMapper;
import com.work.virus.pojo.Page;
import com.work.virus.pojo.Provinces;
import com.work.virus.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author LiGang
 * @Date 2020/2/29 10:52
 * @Version 1.0
 */

@Controller
@RequestMapping("/provinces")
public class provincesController {

    @Autowired
    ProvincesMapper provincesMapper;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Result selectAll(){
        List<Provinces> list = provincesMapper.selectAll();
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
        System.out.println("id"+id);
        System.out.println("filed"+field);
        System.out.println("value"+value);
        Result result = new Result();
        try {
            //将id field value 传递给mapper 中对应的方法
            int zhi = provincesMapper.update(id, field, value);
            System.out.println(zhi);
            if (zhi>0){
                result.setMessage("success");
            }else
            {
                result.setMessage("error");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("error");
        }
        return result;
    }

    @RequestMapping("/query")
    @ResponseBody
    public Result query(String proName,Integer page,Integer limit,HttpServletRequest request){
        System.out.println(proName+"--"+page+"--"+limit);
        //需要一个分页的类 Page 通过分页的算法算出从第几条开始，他就往后查多少条
        //pageTotal
        Page page1 = new Page(page,limit);
        Result result = new Result();
        try {
            //需要根据uderid查询的方法 根据userid查询符合条件的结果集
            List<Provinces> chaxun = provincesMapper.selectByproName(proName, page1.getPage(), page1.getPageTotal());
            if(chaxun == null){
                result.setMessage("没有数据");
                result.setStatus("200");
            }else{
                System.out.println(chaxun);
                result.setMessage("success");
                result.setItem(chaxun);
                result.setTotal(chaxun.size());
            }


        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("error");
        }
        return result;
    }
}
