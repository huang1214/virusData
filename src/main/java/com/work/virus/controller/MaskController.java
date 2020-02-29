package com.work.virus.controller;

import com.work.virus.dao.MaskMapper;
import com.work.virus.pojo.Mask;
import com.work.virus.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/*口罩预约模块*/
@Controller
@RequestMapping("/mask")
public class MaskController {
    @Autowired
    MaskMapper maskMapper;

    @RequestMapping("/application_add")
    @ResponseBody
    public Result application_add(String name, String province, String city, String area, String street, String storeid, String certificate, String identity, String phone, String nums, HttpServletResponse response){
    Result result = new Result();
        Mask ma = new Mask();
    System.out.println("name"+name
            +"province"+province
            +"city"+city
            +"area"+area
            +"street"+street
            +"store"+storeid
            +"certificate"+certificate
            +"identity"+identity
            +"phone"+phone
            +"nums"+nums);

        try{
            String aid = UUID.randomUUID().toString();
            String userid = "001";
            Date date = new Date();

            ma.setAid(aid);
            ma.setUserId(userid);
            ma.setName(name);
            ma.setProvince(province);
            ma.setCity(city);
            ma.setArea(area);
            ma.setStreet(street);
            ma.setStoreId(storeid);
            ma.setCertificate(certificate);
            ma.setIdentity(identity);
            ma.setPhone(phone);
            ma.setNums( Integer.valueOf(nums));
            ma.setDate(date);

            maskMapper.insert(ma);
            result.setMessage("success");
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("error");
        }

    return result;
    }
    //查询结果，判断用户输入是否正确
    @RequestMapping("/query_result")
    @ResponseBody
    public Result queryResult(String phone, String identity,Integer page,Integer limit, HttpServletRequest request){
        Result result = new Result();
        System.out.println("查询结果，判断用户输入是否正确");
        System.out.println(phone+"...."+identity+"....");
        try{
            //调用查询方法 传入手机号和身份证后六位
            String userId = "001";
            List<Mask> masks = maskMapper.selectQueryResult(userId,phone);
            //遍历集合
            System.out.println("这里执行了");
            System.out.println("masks得到的集合"+masks);
            for(Mask m: masks){
                System.out.println(m.getIdentity());
            }
            List<Mask> newmasks = new ArrayList<Mask>();
            System.out.println("新建立的集合newmasks"+newmasks);
            for(Mask m: masks){
                System.out.println(m.getIdentity());
                String s = m.getIdentity();
                //获取字符串的后六位
                String str = s.substring(s.length()-6,s.length());
                System.out.println(str);
                if(str.equals(identity)){
                    System.out.println("我送你离开千里之外");
                    newmasks.add(m);
                }
            }
            System.out.println("问题是不是在这里"+newmasks);
            if (newmasks==null){
                result.setMessage("没有数据");
                result.setStatus("200");
            }
            else{
                System.out.println("====================================================");

                result.setMessage("success");
                //把数据存到结果集类中：
                result.setItem(newmasks);
                result.setTotal(newmasks.size());
                for(Mask m: newmasks){
                    System.out.println(m);
                }
            }

            return result;
        }catch(Exception e){
            result.setMessage("error");
        }
        return result;
    }
}
