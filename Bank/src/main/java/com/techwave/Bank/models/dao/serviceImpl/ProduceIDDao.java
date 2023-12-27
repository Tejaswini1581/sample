package com.techwave.Bank.models.dao.serviceImpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.Bank.models.dao.service.IProduceID;
import com.techwave.Bank.models.pojo.ProduceID;
import com.techwave.Bank.models.repositories.ProduceIDRepository;

@Service
public class ProduceIDDao implements IProduceID{

    @Autowired
    ProduceIDRepository produceIDRepository;


    @Override
    public String getNextAccountId() {
    		ProduceID id = produceIDRepository.findById("Account").get();
            Long updatedId = id.getCurrentId() + 1;                  
            update(updatedId,"Account");
            return updatedId.toString();
        }
    @Override
    public String getNextTransactionId() {
    		ProduceID id = produceIDRepository.findById("Transaction").get();
            Long updatedId = id.getCurrentId() + 1;                  
            update(updatedId,"Transaction");
            return updatedId.toString();
        }
    @Override
    public String getNextTransferId() {
    		ProduceID id = produceIDRepository.findById("Transfer").get();
            Long updatedId = id.getCurrentId() + 1;                  
            update(updatedId,"Transfer");
            return updatedId.toString();
        }
    
    
    @Override
    public List<ProduceID> getAll() {
        return (List<ProduceID>) produceIDRepository.findAll();
    }
    @Override
    public ProduceID getByProduceIDId(String idType) {
        try {
            ProduceID v = produceIDRepository.findById(idType).get();
            return v;
        } catch (NoSuchElementException E) {
            return null;
        }
    }
    @Override
    public String insert(ProduceID V) {
        produceIDRepository.save(V);
       return "Inserted";
    }
    @Override
    public String update(Long V, String idType) {
        ProduceID old=produceIDRepository.findById(idType).get();
        old.setCurrentId(V);
        produceIDRepository.save(old);
        return "updated";
    }
    @Override
    public String Delete(String idType) {
        ProduceID old=produceIDRepository.findById(idType).get();
        produceIDRepository.delete(old);
        return "deleted";
    }

}