package cn.stt.config;

/**
 * @ClassName PersonProperties
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/23 16:50
 * @Version 1.0
 */

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "person")
public class PersonProperties {
    private String name = "xx";
    private String sex = "男";
    private Integer age = 18;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonProperties{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
