package cn.stt.config;

import cn.stt.service.RedissonService;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

/**
 * @ClassName RedissonAutoConfiguration
 * @Description Redisson自动配置
 * @Author shitt7
 * @Date 2019/10/23 15:41
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass({RedissonClient.class})
@ConditionalOnProperty(prefix = "redisson", name = "config-location")
@EnableConfigurationProperties({RedissonProperties.class})
public class RedissonAutoConfiguration {
    private final ResourceLoader resourceLoader;

    private final RedissonProperties properties;

    // 构造方法注入
    public RedissonAutoConfiguration(RedissonProperties properties, ResourceLoader resourceLoader) {
        this.properties = properties;
        this.resourceLoader = resourceLoader;
    }

    @Bean(destroyMethod = "shutdown")
    @ConditionalOnMissingBean
    public RedissonClient redissonClient() throws IOException {
        Resource resource = this.resourceLoader.getResource(this.properties.getConfigLocation());
        Config config = null;
        if (this.properties.getConfigLocation().endsWith(".yaml")) {
            config = Config.fromYAML(resource.getFile());
        } else if (this.properties.getConfigLocation().endsWith(".json")) {
            config = Config.fromJSON(resource.getFile());
        }
        return config != null ? Redisson.create(config) : Redisson.create();
    }

    @Bean
    public RedissonService redissonService() throws IOException {
        return new RedissonService(redissonClient());
    }
}
