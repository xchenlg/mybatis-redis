package sy.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sy.model.User;
import sy.service.UserServiceI;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml"
      })
public class TestMybatis {

    private static final Logger logger = Logger.getLogger(TestMybatis.class);
    @Autowired
    private UserServiceI userService;

    @Test
    public void test1() {
        User u = userService.getUserById("1");
        System.out.println(u.getName());
        userService.update();
//        logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User u1 = userService.getUserById("1");
        System.out.println(u1.getName());
    }

    @Test
    public void test2() {
        List<User> l = userService.getAll();
        logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test3() {
        List<User> l = userService.getAll2();
        logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test4() {
        List<User> l = userService.getAll3();
        logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test5() {
        List<User> l = userService.getAll4();
        logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test6() {
        System.out.println(userService.insert());
    }
    @Test
    public void test7() {
        System.out.println(userService.getContents().size());
    }
    
    
}
