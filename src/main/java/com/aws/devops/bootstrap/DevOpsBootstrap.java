package com.aws.devops.bootstrap;

import com.aws.devops.bean.FundProfile;
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

    @Autowired
    public void setFundProfileRepository(FundProfileRepository fundProfileRepository) {
        this.fundProfileRepository = fundProfileRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(IteratorUtils.toList(fundProfileRepository.findAll().iterator()).size() == 0) {

            FundProfile profile = new FundProfile(new Date(),new Date(),"201","American Growth",new BigDecimal(17.89));
            fundProfileRepository.save(profile);
        }
    }
}
