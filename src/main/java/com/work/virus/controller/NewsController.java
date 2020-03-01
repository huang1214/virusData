package com.work.virus.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.work.virus.dao.NewsMapper;
import com.work.virus.pojo.News;
import com.work.virus.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsMapper newsMapper;


    @RequestMapping("/getNews")
    @ResponseBody
    public void getNews(@RequestBody String res)
    {
        JSONObject jsonObject=JSONObject.parseObject(res);
        JSONArray jsonArray=(JSONArray)jsonObject.get("data");
        List<News> list = JSONObject.parseArray(jsonArray.toJSONString(), News.class);
        for(News news:list){
            newsMapper.insert(news);
        }
    }


    @RequestMapping("/update")
    @ResponseBody
    public Result update(String id,String field,String value)
    {
        Result result=new Result();
        try{
            int zhi= newsMapper.update(id,field,value);
            if(zhi>0){
                result.setMessage("success");

            }
            else {
                result.setMessage("error");
            }
        }catch (Exception e){
            result.setMessage("error");
        }
        return result;
    }



    @RequestMapping("/add")
    @ResponseBody
    public Result add(News news){
        Result result = new Result();
        //随机生成id
        Random random = new Random();
        int  id= 1;   //random.nextInt(30)+100;
        news.setId(String.valueOf(id));
        //获取系统当前时间
        Date days=new Date();
        news.setCreatetime(days);
        news.setPubdate(days);

        try{
            //将视频信息插入数据库中
            newsMapper.insert(news);
            result.setMessage("success");

        }catch (Exception e){
            result.setMessage("error");
            return result;
        }
        return result;
    }



    @RequestMapping("/query")
    @ResponseBody
    public Result Edit(String title){

        Result result=new Result();


        try{

            List<News> list=newsMapper.selectNews(title);
            if(list.size()>0) {
                result.setItem(list);
                result.setMessage("success");
                result.setTotal(list.size());
            }
            else {
                result.setMessage("没有数据");
                result.setStatus("200");
            }
        }catch (Exception e){
            result.setMessage("error");
        }
        return result;
    }



    @RequestMapping("/delete")
    @ResponseBody
    public  Result delete(String[] ids,HttpServletRequest request){
        Result  result = new Result();
        System.out.println("传过来的数组值是"+ Arrays.toString(ids));
        try{
                for (int i=0;i<ids.length;i++) {
                    newsMapper.deleteByPrimaryKey(ids[i]);
                }

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


}
