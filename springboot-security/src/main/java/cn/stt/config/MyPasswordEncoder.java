package cn.stt.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName MyPasswordEncoder
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/24 16:32
 * @Version 1.0
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
