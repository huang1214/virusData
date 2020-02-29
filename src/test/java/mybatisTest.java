import com.work.virus.dao.CityMapper;
import com.work.virus.dao.ProvincesMapper;
import com.work.virus.pojo.City;
import com.work.virus.pojo.Provinces;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author LiGang
 * @Date 2020/2/28 20:57
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
//加载spring  配置文件
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class mybatisTest {
    @Autowired
    ProvincesMapper provincesMapper;
    @Autowired
    CityMapper citymapper;
    @Test
    public void test1(){
        List<Provinces> provinces = provincesMapper.selectAll();
        System.out.println("1+"+provinces);
    }
    @Test
    public void test2() {
        List<City> cities = citymapper.selectAll();
        System.out.println(cities);
    }

}
