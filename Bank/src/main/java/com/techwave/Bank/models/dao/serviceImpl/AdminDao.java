package com.techwave.Bank.models.dao.serviceImpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.Bank.models.dao.service.IAdmin;
import com.techwave.Bank.models.pojo.Admin;
import com.techwave.Bank.models.repositories.AdminRepository;

@Service
public class AdminDao implements IAdmin{

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Admin> getAll() {
        return (List<Admin>) adminRepository.findAll();
    }
    @Override
    public Admin getByAdminId(String AdminNo) {
        try {
            return adminRepository.findById(AdminNo).get();
        } catch (NoSuchElementException E) {
            return null;
        }
    }
    @Override
    public String insert(Admin V) {
        adminRepository.save(V);
       return "Inserted";
    }
    @Override
    public String update(Admin V, String AdminNo) {
        Admin old=adminRepository.findById(AdminNo).get();
        old.setAdminName(V.getAdminName());
        old.setPassword(V.getPassword());
        adminRepository.save(old);
        return "updated";
    }
    @Override
    public String Delete(String AdminNo) {
        Admin old=adminRepository.findById(AdminNo).get();
        adminRepository.delete(old);
        return "deleted";
    }

}