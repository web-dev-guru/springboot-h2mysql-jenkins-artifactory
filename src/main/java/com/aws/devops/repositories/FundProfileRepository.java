package com.aws.devops.repositories;

import com.aws.devops.bean.FundProfile;
import org.springframework.data.repository.CrudRepository;

public interface FundProfileRepository  extends CrudRepository<FundProfile, Integer> {
}
