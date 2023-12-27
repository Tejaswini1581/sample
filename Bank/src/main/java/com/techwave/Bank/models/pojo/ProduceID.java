package com.techwave.Bank.models.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class ProduceID {
	@Id
    private String idType;
	private Long currentId;
    public ProduceID() {
		super();
	}
	public ProduceID(String idType, Long currentId) {
		super();
		this.idType = idType;
		this.currentId = currentId;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public Long getCurrentId() {
		return currentId;
	}
	public void setCurrentId(Long currentId) {
		this.currentId = currentId;
	}

}
