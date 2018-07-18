package com.aws.devops.bootstrap.profilesysout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/21/16.
 */
@Component
@Profile("default")
public class DefaultProfileSysOut {

    @Autowired
    public DefaultProfileSysOut(@Value("${web.dev.guru.profile.message}") String msg) {
        System.out.println("##################################");
        System.out.println("##################################");
        System.out.println("##            DEFAULT           ##");
        System.out.println(msg);
        System.out.println("##################################");
        System.out.println("##################################");
    }
}
