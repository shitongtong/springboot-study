package cn.stt.repository;

import cn.stt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/25 14:09
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByLogin(String login);
}
