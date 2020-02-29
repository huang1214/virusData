package java;

import com.work.virus.dao.DxyareaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Description:本类用户测试 mybatis 接口的增删该查方法 通过单元测试
 * User:黄文俊
 * Date:2020-02-18 3:26
 */

@RunWith(SpringJUnit4ClassRunner.class)
//加载spring  配置文件
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MyTest {
    @Autowired
    DxyareaMapper dxyareaMapper;

    @Test
    public void test(){
        System.out.println(dxyareaMapper.sumByProvince());
    }
}
