package com.yzy.mysecurity;
import com.yzy.mysecurity.utils.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootTest
class MySecurityApplicationTests {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test01() {
        String yzy = passwordEncoder.encode("123");
        System.out.println(yzy);
    }

    @Test
    public void test02(){
        String yzy = JWTUtil.createJWT("yzy");
        System.out.println(yzy);
        try {
            System.out.println(JWTUtil.parseJWT(yzy).getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
