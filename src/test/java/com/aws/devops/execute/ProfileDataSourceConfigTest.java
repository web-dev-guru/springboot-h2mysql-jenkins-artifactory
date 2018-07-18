package com.aws.devops.execute;

import com.aws.devops.config.ExternalPropsPropertySourceConfig;
import com.aws.devops.config.ProfileDataSourceConfig;
import com.aws.devops.datasource.FakeDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = ProfileDataSourceConfig.class)
@ActiveProfiles("prod")
public class ProfileDataSourceConfigTest {

    private FakeDataSource fakeDataSource;
    @Autowired
    public void setFakeDataSource(FakeDataSource fakeDataSource) {
        this.fakeDataSource = fakeDataSource;
    }

    @Test
    public void testActiveProfile() {
        System.out.println(fakeDataSource.getConnectionInfo());
    }
}