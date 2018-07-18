package com.aws.devops.config.intergrationruntime;

import com.aws.devops.bean.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootJavaConfig {
    @Value("${web.dev.guru.jms.server}")
    String jmsServer;

    @Value("${web.dev.guru.jms.port}")
    Integer jmsPort;

    @Value("${web.dev.guru.jms.user}")
    String jmsUser;

    @Value("${web.dev.guru.jms.password}")
    String jmsPassword;

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(jmsServer);
        fakeJmsBroker.setPort(jmsPort);
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        return fakeJmsBroker;
    }
}
