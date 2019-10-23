package cn.stt.service;

import cn.stt.config.PersonProperties;

/**
 * @ClassName PersonService
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/23 16:52
 * @Version 1.0
 */
public class PersonService {
    PersonProperties personProperties;

    public PersonService() {
    }

    public PersonService(PersonProperties personProperties) {
        this.personProperties = personProperties;
    }

    public String showPersonInfo(){
        return personProperties.toString();
    }
}
