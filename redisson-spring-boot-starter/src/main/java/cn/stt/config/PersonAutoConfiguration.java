package cn.stt.config;

import cn.stt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName PersonAutoConfiguration
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/23 17:35
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass({PersonService.class})
@EnableConfigurationProperties({PersonProperties.class})
public class PersonAutoConfiguration {

    @Autowired
    private PersonProperties personProperties;

    @Bean
    public PersonService personService(){
        return new PersonService(personProperties);
    }
}
