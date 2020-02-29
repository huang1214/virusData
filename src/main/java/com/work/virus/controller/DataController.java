package com.work.virus.controller;

import com.work.virus.dao.DxyareaMapper;
import com.work.virus.pojo.Dxyarea;
import com.work.virus.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    DxyareaMapper dxyareaMapper;

    /**
     * 按省查询各项数据汇总
     * @return
     */
    @RequestMapping("/sum")
    @ResponseBody
    public Result sum(){
        Result result = new Result();
        try {
            List<Dxyarea> dxyareaList = dxyareaMapper.sumByProvince();
            System.out.println(dxyareaList);
            if (dxyareaList.size() > 0){
                result.setItem(dxyareaList);
                result.setMessage("查询成功");
            }else{
                result.setStatus("201");
                result.setMessage("数据不足");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
