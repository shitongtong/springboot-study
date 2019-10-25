package cn.stt.config;

import cn.stt.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityConfiguration
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/24 15:51
 * @Version 1.0
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/product/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码需密文输入
//        auth.inMemoryAuthentication()
//                // 管理员，同事具有 ADMIN,USER权限，可以访问所有资源
//                .withUser("admin1").password("admin1").roles("ADMIN","USER")
//                .and()
//                // 普通用户，只能访问 /product/**
//                .withUser("user1").password("user1").roles("USER");
        //这样，页面提交时候，密码以明文的方式进行匹配。
        /*auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("admin1").password("admin1").roles("ADMIN", "USER")
                .and()
                .withUser("user1").password("user1").roles("USER");*/
        //使用数据库验证用户及权限
        //设置自定义userDetailsService
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }
}
