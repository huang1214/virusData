package com.work.virus.controller;

import com.work.virus.dao.StoreMapper;
import com.work.virus.pojo.Result;
import com.work.virus.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*口罩预约模块*/
@Controller
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreMapper storeMapper;


    @RequestMapping("/querry_store")
    @ResponseBody
    public Result queryStoreResult() {
        System.out.println("已经收到调用接口");
        Result result = new Result();
        try{
            List<Store> list = storeMapper.selectAll();
            result.setMessage("success");
            //把数据存到结果集类中：
            result.setItem(list);
            result.setTotal(list.size());
            return result;
        }catch(Exception e){
            result.setMessage("error");
        }


        return result;
    }
}
