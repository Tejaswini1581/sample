package com.techwave.Bank.models.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.techwave.Bank.models.pojo.Admin;
@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {

}