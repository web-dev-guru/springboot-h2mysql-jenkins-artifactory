package com.aws.devops.bootstrap;

import com.aws.devops.bean.EmailContactInfo;
import com.aws.devops.bean.FundProfile;
import com.aws.devops.repositories.EmailRepository;
import com.aws.devops.repositories.FundProfileRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jt on 5/6/16.
 */
@Component
public class DevOpsBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private FundProfileRepository fundProfileRepository;
    private EmailRepository emailRepository;

    @Autowired
    public void setFundProfileRepository(FundProfileRepository fundProfileRepository) {
        this.fundProfileRepository = fundProfileRepository;
    }
    @Autowired
    public void setEmailRepository(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(IteratorUtils.toList(fundProfileRepository.findAll().iterator()).size() == 0) {

            FundProfile profile = new FundProfile(new Date(),new Date(),"201","American Growth",new BigDecimal(17.89));
            fundProfileRepository.save(profile);

        }
        if(IteratorUtils.toList(emailRepository.findAll().iterator()).size() <10) {
            EmailContactInfo email = new EmailContactInfo();
            email.setEmailAddress("abc@example.com");
            email.setFirstName("sherry");
            email.setLastName("he");
            email.setCreatedOn(new Date());
            emailRepository.save(email);
        }
    }
}
