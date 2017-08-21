package sy.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sy.service.EhCacheTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml",
        "classpath:spring-ehcache.xml" })
public class TestCache {

    private static final Logger logger = Logger.getLogger(TestCache.class);

    @Autowired
    private EhCacheTestService ehCacheTestService;

    @Test
    public void getTimestampTest() throws InterruptedException {
        System.out.println("第一次调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheTestService.getTimestamp("param1"));
        Thread.sleep(2000);
        ehCacheTestService.delUserRole("param1");
        System.out.println("再过11秒之后调用：" + ehCacheTestService.getTimestamp("param"));
    }

}
