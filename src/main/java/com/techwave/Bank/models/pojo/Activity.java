package com.techwave.Bank.models.pojo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Activity {
	@Id
	private String sessionId;
	private String userId;
	private Timestamp loginTime;
	private Timestamp logoutTime;
	public Activity() {
		super();
	}
	public Activity(String sessionId, String userId, Timestamp loginTime, Timestamp logoutTime) {
		super();
		this.sessionId = sessionId;
		this.userId = userId;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	public Timestamp getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
	}
}
