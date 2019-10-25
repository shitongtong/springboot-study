package cn.stt.service;

import cn.stt.entity.User;
import cn.stt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName CustomUserDetailsService
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/25 13:59
 * @Version 1.0
 */
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // 1. 查询用户
        User userFromDatabase = userRepository.findOneByLogin(login);
        if (userFromDatabase == null) {
            //log.warn("User: {} not found", login);
            throw new UsernameNotFoundException("User " + login + " was not found in db");
            //这里找不到必须抛异常
        }
        // 2. 设置角色
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userFromDatabase.getRole());
        grantedAuthorities.add(grantedAuthority);

        return new org.springframework.security.core.userdetails.User(login,
                userFromDatabase.getPassword(), grantedAuthorities);
    }
}
