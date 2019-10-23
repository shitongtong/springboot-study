package cn.stt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName RedissonProperties
 * @Description Redisson的配置属性
 * @Author shitt7
 * @Date 2019/10/23 15:39
 * @Version 1.0
 */
@ConfigurationProperties(prefix = RedissonProperties.REDISSON_PREFIX)
public class RedissonProperties {
    /**
     * 配置文件前缀
     */
    public static final String REDISSON_PREFIX = "redisson";

    /**
     * 配置文件路径
     */
    private String configLocation;

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }
}
