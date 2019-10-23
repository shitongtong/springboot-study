package cn.stt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName Application
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/23 16:25
 * @Version 1.0
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        /*System.out.println(context.getBean("redissonClient"));

        RedissonClient redissonClient = context.getBean(RedissonClient.class);

        System.out.println(redissonClient);

        RBucket<String> bucket1 = redissonClient.getBucket("redisson-v");
        bucket1.set("lushwe1");
        System.out.println(bucket1.get());

        RBucket<String> bucket2 = redissonClient.getBucket("redisson-v");
        bucket2.set("lushwe2");
        System.out.println(bucket2.get());

        RBucket<String> bucket3 = redissonClient.getBucket("redisson-v");
        System.out.println(bucket3.get());*/
    }
}
