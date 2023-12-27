package com.techwave.Bank.models.dao.serviceImpl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.Bank.models.dao.service.IActivity;
import com.techwave.Bank.models.pojo.Activity;
import com.techwave.Bank.models.repositories.ActivityRepository;

@Service
public class ActivityDao implements IActivity{

    @Autowired
    ActivityRepository activityRepository;

    @Override
    public List<Activity> getAll() {
        return (List<Activity>) activityRepository.findAll();
    }
    @Override
    public Activity getByActivityId(String activityNo) {
        try {
            Activity v = activityRepository.findById(activityNo).get();
            return v;
        } catch (NoSuchElementException E) {
            return null;
        }
    }
    @Override
    public String insert(Activity V) {
        activityRepository.save(V);
       return "Inserted";
    }
    @Override
    public String update(Activity V, String activityNo) {
        Activity old=activityRepository.findById(activityNo).get();
        old.setLogoutTime(Timestamp.from(Instant.now()));
        activityRepository.save(old);
        return "updated";
    }
    @Override
    public String Delete(String activityNo) {
        Activity old=activityRepository.findById(activityNo).get();
        activityRepository.delete(old);
        return "deleted";
    }
	@Override
	public List<Activity> findByUserId(String id) {
		// TODO Auto-generated method stub
		return activityRepository.findByUserId(id);
	}

}
