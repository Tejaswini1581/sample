package com.techwave.Bank.models.dao.service;

import java.util.List;

import com.techwave.Bank.models.pojo.Activity;

public interface IActivity {
	List<Activity> getAll();
	Activity getByActivityId(String activityId);
	String insert(Activity a);
	String update(Activity a , String  activityId);
	String Delete( String  activityId);
	 List<Activity> findByUserId(String id);

}
