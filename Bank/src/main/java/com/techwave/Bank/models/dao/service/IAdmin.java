package com.techwave.Bank.models.dao.service;
import java.util.List;
import com.techwave.Bank.models.pojo.Admin;
public interface IAdmin {
    List<Admin> getAll();
    Admin getByAdminId(String adminId);
    String insert(Admin a);
    String update(Admin a, String  adminId);
    String Delete( String  adminId);
}
