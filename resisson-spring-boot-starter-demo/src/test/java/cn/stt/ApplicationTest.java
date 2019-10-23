package cn.stt;

import cn.stt.service.PersonService;
import cn.stt.service.RedissonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName ApplicationTest
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/23 16:30
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTest {
    @Autowired
    private RedissonService redissonService;
    @Autowired
    private PersonService personService;

    @Test
    public void test1() {
        String test = redissonService.test();
        System.out.println(test);
        redissonService.set("aa", "aa");
        System.out.println(redissonService.get("aa"));
    }

    @Test
    public void test2() {
        System.out.println(personService.showPersonInfo());
    }
}
