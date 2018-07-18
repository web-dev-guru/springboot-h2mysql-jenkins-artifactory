package com.aws.devops.config;

import com.aws.devops.bean.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:testing.properties")
public class ExternalPropsEnvironmentConfig {

    @Autowired
    Environment env;

    @Bean
    public FakeJmsBroker fakeJmsBrokerEnv(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(env.getProperty("web.dev.guru.jms.server"));
        fakeJmsBroker.setPort(env.getRequiredProperty("web.dev.guru.jms.port", Integer.class));
        fakeJmsBroker.setUser(env.getProperty("web.dev.guru.jms.user"));
        fakeJmsBroker.setPassword(env.getProperty("web.dev.guru.jms.password"));
        return fakeJmsBroker;
    }
}
