package com.aws.devops.execute;

import com.aws.devops.bean.FakeJmsBroker;
import com.aws.devops.config.ExternalPropsPropertySourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = ExternalPropsPropertySourceConfig.class)
public class ExternalPropsPropertySourceConfigTest {
    @Autowired
    FakeJmsBroker fakeJmsBroker;
    @Test
    public void testLoadProperties() {
        System.out.println(fakeJmsBroker.getUrl());
        assertEquals("192.168.0.123", fakeJmsBroker.getUrl());
        assertEquals(3330, fakeJmsBroker.getPort().intValue());
        assertEquals("wesley", fakeJmsBroker.getUser());
        assertEquals("wei", fakeJmsBroker.getPassword());
    }

}