package com.techwave.Bank.models.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.Bank.models.pojo.Activity;
@Repository
public interface ActivityRepository extends CrudRepository<Activity, String>{
	 List<Activity> findByUserId(String id);
}
