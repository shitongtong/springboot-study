package cn.stt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/24 17:43
 * @Version 1.0
 */
@Entity
@Data
public class User implements Serializable {
    @Id
    @Column
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String role;
}
