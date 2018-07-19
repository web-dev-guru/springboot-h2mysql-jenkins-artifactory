package com.aws.devops.repositories;

import com.aws.devops.bean.EmailContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailContactInfo,Long> {

}
