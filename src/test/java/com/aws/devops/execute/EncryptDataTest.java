package com.aws.devops.execute;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptDataTest {
    @Test
    public void TestEncrypt(){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("password");
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("hadoop");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }
}
