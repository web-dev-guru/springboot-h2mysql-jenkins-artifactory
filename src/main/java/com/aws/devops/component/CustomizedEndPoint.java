package com.aws.devops.component;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id="customized")
@Component
public class CustomizedEndPoint {
    @ReadOperation
    @Bean
    public String hi() {
        return "Hi from custom endpoint";
    }
}
