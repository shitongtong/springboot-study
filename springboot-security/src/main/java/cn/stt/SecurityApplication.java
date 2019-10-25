package cn.stt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SecurityApplication
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/24 15:17
 * @Version 1.0
 */
//取消security验证
//@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
@Slf4j
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
        log.info("容器启动成功!");
    }
}
